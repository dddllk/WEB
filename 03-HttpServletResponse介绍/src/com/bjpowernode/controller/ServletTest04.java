package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/11 22:26
 *
 * 浏览器在接受到响应包之后，如果
 * 发现响应头存在location属性
 * 自动通过地址栏想location指定网站发起请求
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletTest04 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String result = "http://www.baidu.com";

    // 通过响应对象，将地址赋值给响应头中location属性
    response.sendRedirect(result);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
