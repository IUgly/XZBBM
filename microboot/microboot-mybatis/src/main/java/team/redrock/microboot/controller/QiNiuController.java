package team.redrock.microboot.controller;


import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import team.redrock.microboot.config.qiniu.QiNiuProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by sungang on 2017/6/1.
 */
@Controller

public class QiNiuController {

    @Autowired
    private QiNiuProperties qiNiuProperties;

    @RequestMapping("/home")
    public String home(){
        return "homepage";
    }

    @PostMapping("/pic_upload.do")
    @ResponseBody
    public String uploadImg(HttpServletRequest request) throws Exception {
        String filePath = "";
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                String fileName = file.getOriginalFilename();
                String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
                DefaultPutRet putRet = upload(file.getBytes(), newFileName);
                filePath += qiNiuProperties.getBucketUrl() + putRet.key + ",";
            }
            if (filePath.endsWith(",")) {
                filePath = filePath.substring(0, filePath.length() - 1);
            }
        }
        return filePath;
    }

    public DefaultPutRet upload(byte[] file, String key) throws Exception {
        Auth auth = Auth.create(qiNiuProperties.getAccessKey(), qiNiuProperties.getSecretKey());
        //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
        Zone z = Zone.autoZone();
        Configuration c = new Configuration(z);
        //创建上传对象
        UploadManager uploadManager = new UploadManager(c);
        Response res = uploadManager.put(file, key, getUpToken(auth, qiNiuProperties.getBucket()));
        //打印返回的信息
        System.out.println(res.bodyString());
        //解析上传成功的结果
        DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);
        return putRet;
    }

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken(Auth auth, String bucketname) {
        return auth.uploadToken(bucketname);
    }

}
