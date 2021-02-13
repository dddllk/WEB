package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/13 10:14
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletTest02 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 1.通过【请求对象】向Tomcat索要当前网站中【全局作用域对象】
    ServletContext application = request.getServletContext();
    // 2.从全局作用域对象的到指定关键字对应数据
    Integer i = (Integer)application.getAttribute("key1");
    System.out.println(i);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
