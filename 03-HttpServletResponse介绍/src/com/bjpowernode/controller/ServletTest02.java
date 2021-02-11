package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/11 21:54
 *
 *
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletTest02 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int money = 50;
    PrintWriter out = response.getWriter();
    // out.write(money); // 2-----[ASCII码]
    // 问题解决方法：实际开发过程中，都是通过out.print()将真实数据写入到响应体中
    out.print(money);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
