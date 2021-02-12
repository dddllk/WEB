package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/12 22:37
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletTest01", value = "/ServletTest01")
public class ServletTest01 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("ServletTest01 负责吃饭！");
    // 重定向解决方案
    response.sendRedirect("/myWeb/test02");// [地址格式：/网站名/资源文件]
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
