package com.bjpowernode.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by dlkyy on 2021/2/14 21:52
 */
public class Filter01 implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;

    //1.调用请求对象读取请求包中请求行中的URI，了解用户访问的资源文件
    String uri = request.getRequestURI();
    //2.如果本次请求的资源文件与登录相关
    if(uri.indexOf("login") != -1 || "/myWeb/".equals(uri)){
      filterChain.doFilter(servletRequest, servletResponse);// 放行
      return;
    }
    //3.如果本次访问的请求资源是其他资源文件时，需要得到用户的HttpSession
    HttpSession session = request.getSession(false);
    if(session != null){
      filterChain.doFilter(servletRequest, servletResponse);// 放行
      return;
    }
    // 4.拒绝请求
    request.getRequestDispatcher("/login_error.html").forward(servletRequest, servletResponse);
  }
}
