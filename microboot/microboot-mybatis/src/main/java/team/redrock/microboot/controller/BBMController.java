package team.redrock.microboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import team.redrock.microboot.dao.Dao;
import team.redrock.microboot.page.PageInfo;
import team.redrock.microboot.service.impl.ServiceImp;
import team.redrock.microboot.util.WebFileUtils;
import team.redrock.microboot.util.qiNiu.QiNiu;
import team.redrock.microboot.vo.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ugly
 */
@EnableAutoConfiguration
@RestController
//@RequestMapping("/XZBBM/bbm")
public class BBMController {
    @Autowired
    private ServiceImp serviceImp;

    @Autowired
    private QiNiu qiNiu;
    @Autowired
    private Dao dao;

//    @RequestMapping("/home")
//    public String home(){
//        return "homepage";
//    }

    @GetMapping(value = "/index", produces = "application/json")
    public String index(Body body){
        int pageNo = body.getPage();
        int pageSize = body.getPageSize();
        Page<Issue> issues = serviceImp.findIssuePage(pageNo, pageSize);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<Issue> pageInfo = new PageInfo<>(issues);
        pageInfo.setStartRow((pageNo-1)*pageSize+1);
        pageInfo.setEndRow(pageNo*pageSize);
        pageInfo.setSize(30);

        JSONObject json = new JSONObject();
        json.put("status",0);
        json.put("data", pageInfo);

//        Assert.assertNotNull(persons);
        return JSON.toJSONString(json);
    }


    @PostMapping("/user")
    public String scholar(Body body){
         JSONObject json = new JSONObject();
        if (body.getType().equals("scholar")){
        User user = new User();
        user.setScholar(true);
        json.put("status",0);
        json.put("data",JSON.toJSONString(user));}
        return json.toString();
    }
    @GetMapping("/user")
    public String user(HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = new UserInfo();
        userInfo.userInfo(user);
        userInfo.setScholar(false);
        JSONObject json = new JSONObject();
        json.put("status",0);
        json.put("data",JSON.toJSON(userInfo));
        System.out.println(json);
        return json.toString();
    }


    @RequestMapping(value = "/discuss/operation", produces = "application/json")
    public String operation(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        String type = request.getParameter("type");
        int id = Integer.parseInt(request.getParameter("id"));
        Issue issue = new Issue();
        issue.setId(id);
        Answer answer = new Answer();
        answer.setId(id);
        Like like = new Like();
        like.setUid(Math.toIntExact(user.getUid()));
        like.setId(id);

        JSONObject json = new JSONObject();

        if (type.equals("like")){
            if (dao.selectLike(like)==null){
                dao.insertLike(like);
                dao.updateVote(issue);
            }
        }else if (type.equals("accept")){
            if (!dao.findAccept(answer)){
                dao.updateAccept(answer);
            }
        }else if (!serviceImp.findAnswerByMine(issue)){
            json.put("status",1);
            json.put("msg","只能操作自己提出问题下的回复哦！～");
            return json.toJSONString();
        }
        json.put("status",0);
        return json.toJSONString();
    }

    @GetMapping(value = "/discuss", produces = "application/json")
    public String issue(int id){
        Issue issue = dao.findIssueBy(id);
        issue.getIssue(id);
        issue.setRepliesList(serviceImp.findAnswerByUID(id));
        JSONObject json = new JSONObject();
        json.put("status",0);
        json.put("data",JSON.toJSON(issue));
        return json.toJSONString();
    }
    @PostMapping(value = "/discuss", produces = "application/json")
    public String discuss(HttpServletRequest request) throws Exception {
        Body body = new Body();
        body.body(request);
        String pic_thumb = null;
        User user = (User) request.getSession().getAttribute("user");
        String type = body.getType();
        if (!body.getOrgPic().equals("undefined")) {
            MultipartFile file = WebFileUtils.createImg(body.getOrgPic());
            pic_thumb = qiNiu.upFile(file);
        }
        if (type.equals("question")) {
            Issue issue = new Issue();
            issue.issue(user, body);
            issue.setPic_thumb(pic_thumb);
            issue.setAuthor_id(user.getOpenid());
            serviceImp.insertIssue(issue);
        }
        else if (type.equals("answer")){

            Answer answer = new Answer();
            answer.answer(user, body);
            answer.setScholar(serviceImp.selectUserScholar(user));
            answer.setPic_thumb(pic_thumb);
            answer.setAuthor_id(user.getOpenid());

            serviceImp.insertAnswer(answer);
        }
        JSONObject json = new JSONObject();
        json.put("status", 0);
        json.put("msg","增加成功");
        return JSON.toJSONString(json);
    }

    @GetMapping("/mybbm")
    public String mybbm(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        Body body = new Body();
        body.body(request);
        int pageNo=body.getPage();
        int pageSize=body.getPageSize();
        if (pageNo<=0||pageSize<=0) {
            pageNo = 1;
            pageSize = 30;
        }
        String type = body.getType();
        Issue issue = new Issue();
        issue.setId(body.getId());
        issue.setAuthor_id(user.getOpenid());

        Answer answer = new Answer();
        answer.setId(body.getId());
        answer.setAuthor_id(user.getOpenid());
        if (type.equals("question")) {
            Page<Issue> issues = serviceImp.searchIssue(pageNo, pageSize,issue);
            PageInfo<Issue> pageInfo = new PageInfo<>(issues);
            pageInfo.setStartRow((pageNo - 1) * pageSize + 1);
            pageInfo.setEndRow(pageNo * pageSize);
            pageInfo.setSize(30);

            JSONObject json = new JSONObject();
            json.put("status", 0);
            json.put("data", pageInfo);
            return JSON.toJSONString(json);
        }else if (type.equals("answer")){
            Page<Answer> answers = serviceImp.myAnswer(pageNo, pageSize,answer);
            PageInfo<Answer> pageInfo = new PageInfo<>(answers);
            pageInfo.setStartRow((pageNo - 1) * pageSize + 1);
            pageInfo.setEndRow(pageNo * pageSize);

            JSONObject json = new JSONObject();
            json.put("status", 0);
            json.put("data", pageInfo);
            return JSON.toJSONString(json);
        }
        return "";
    }

    @GetMapping("/search")
    public String search(Body body){
        int pageNo = body.getPage();
        int pageSize = body.getPageSize();


        if (pageNo<=0||pageSize<=0){
            pageNo=1;
            pageSize=30;
        }
        Page<Issue> issues = null;
        Issue issue = new Issue();
        issue.setContent(body.getKey());
        issue.setTag(body.getTag());
        if (issue.getTag()!=null) {
           issues = serviceImp.searchIssue(pageNo,pageSize,issue);
        }else {
            issues = serviceImp.searchI(pageNo,pageSize,issue);
        }
        PageInfo<Issue> pageInfo = new PageInfo<>(issues);
        pageInfo.setStartRow((pageNo-1)*pageSize+1);
        pageInfo.setEndRow(pageNo*pageSize);
        pageInfo.setSize(issues.size());

        JSONObject json = new JSONObject();
        json.put("status",0);
        json.put("data", pageInfo);

        return JSON.toJSONString(json);
    }

}
