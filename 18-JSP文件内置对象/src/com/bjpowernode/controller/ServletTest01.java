package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/15 14:04
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletTest01 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ServletContext application = request.getServletContext();
    String value = (String) application.getAttribute("key1");
    System.out.println("value =" + value);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
