package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/13 16:32
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletTest01 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String goodsName;
    //1.调用请求对象，读取请求头参数，得到用户选择商品名称
    goodsName = request.getParameter("goodsName");
    //2.调用请求对象，向Tomcat索要当前用户在服务端的私人储物柜
    HttpSession session = request.getSession();
    //3.将用户选购商品添加到当前用户的私人储物柜
    Integer goodsNum = (Integer)session.getAttribute(goodsName);
    if(goodsNum == null) {
      // 如果柜子里面没有商品
      session.setAttribute(goodsName, 1);
    }else{
      // 如果柜子里面有商品
      session.setAttribute(goodsName, goodsNum + 1);
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
