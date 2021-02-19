package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/19 13:28
 */

import com.bjpowernode.entity.Student;
import com.bjpowernode.util.ReflectUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletTest01 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Student s1 = new Student("10", "mike");
    // String str = "{\"id\": \"10\", \"sname\" : \"mike\"}";
    Student s1 = new Student("10", "dlkyy");
    // 通过反射机制将S图等类型对象内容转换为JSON格式的字符串
    String str = ReflectUtil.jsonObject(s1);
    // 将学院信息存储到请求作用域对象
    request.setAttribute("key", str);
    // 请求转发，申请调用index_1.jsp，并将request和response通过Tomcat交给index_1.jsp
    request.getRequestDispatcher("index_1.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
