package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/13 16:39
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ServletTest02", value = "/ServletTest02")
public class ServletTest02 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1.调用请求对象向Tomcat索要当前用户的私人储物柜
    HttpSession session = request.getSession();
    //2.将session中所有key取出来，存放到一个枚举对象中
    Enumeration goodsNames = session.getAttributeNames();
    while(goodsNames.hasMoreElements()) {
      String goodsName = (String)goodsNames.nextElement();
      int goodsNum = (int)session.getAttribute(goodsName);
      System.out.println("商品名称" + goodsName + ",商品的数量" + goodsNum);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
