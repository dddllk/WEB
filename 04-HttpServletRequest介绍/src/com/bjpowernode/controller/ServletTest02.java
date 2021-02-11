package com.bjpowernode.controller; /**
 * Created by dlkyy on 2021/2/12 0:32
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class ServletTest02 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 1.通过请求对象获得【请求头】中，【所有请求参数名】
    Enumeration paramNames= request.getParameterNames();//将所有请求参数名称保存到一个枚举对象里面进行返回
    while(paramNames.hasMoreElements()){
      String paramName = (String) paramNames.nextElement();
      // 2.通过请求对象读取指定的请求参数的值
      String value = request.getParameter(paramName);
      System.out.println("请求参数名" + paramName + "，请求参数的值：" + value);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
