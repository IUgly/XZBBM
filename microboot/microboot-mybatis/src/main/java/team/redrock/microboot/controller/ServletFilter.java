package team.redrock.microboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import team.redrock.microboot.dao.Dao;
import team.redrock.microboot.service.impl.ServiceImp;
import team.redrock.microboot.util.wechat.WechatUtil;
import team.redrock.microboot.vo.User;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ServletFilter
 * 注解注册过滤器：实现 javax.servlet.Filter接口
 * filterName 是过滤器的名字
 * urlPatterns 是需要过滤的请求 ，这里只过滤servlet/* 下面的所有请求
 */
@WebFilter(filterName="ServletFilter",urlPatterns="/*")
public class ServletFilter implements Filter {
    @Autowired
    private ServiceImp serviceImp;
    @Autowired
    private Dao dao;

    /**
     * Default constructor.
     */
    public ServletFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
        System.out.println("过滤器被销毁。");
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        if (httpRequest.getSession().getAttribute("user")==null) {
            String code = request.getParameter("code");


            User user = WechatUtil.getUser(code);
            User user1 = dao.findUserByOpenID(user);
            if (user1==null) {
                serviceImp.insertUser(user);
            }
            httpRequest.getSession().setAttribute("user", dao.findUserByOpenID(user));

        }
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("初始化过滤器。");
    }

}