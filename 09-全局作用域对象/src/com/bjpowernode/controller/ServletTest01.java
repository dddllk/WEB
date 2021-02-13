package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/13 10:14
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletTest01 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1.通过【请求对象】向Tomcat中索要当前网站中【全局作用域】对象
    ServletContext application = request.getServletContext();
    //2.将数据添加到全局作用域对象作为【共享数据】
    application.setAttribute("key1", 123);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
