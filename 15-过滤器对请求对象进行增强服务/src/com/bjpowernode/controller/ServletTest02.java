package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/13 23:01
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletTest02 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 直接从请求体读取请求参数
    String userName = request.getParameter("userName");
    System.out.println("ServletTest01从请求体得到参数 " + userName);
  }
}
