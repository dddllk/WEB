package com.bjpowernode.controller;

/**
 * Created by dlkyy on 2021/2/11 21:40
 *
 *
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletTest01 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String result = "hello world";

    // 1.通过响应对象，向Tomcat索要输出流
    PrintWriter out = response.getWriter();
    // 通过输出流，将执行结果以二进制的形式写入到响应体
    out.write(result);
  }
  //
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
