package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/13 9:28
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletTest01 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("ServletTest01...执行");
    // 请求转发方案：
    // 1.通过当前请求对象生成资源文件申请报告对象
    RequestDispatcher report = request.getRequestDispatcher("/test02");
    // 2.将报告对象发送给Tomcat
    report.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
