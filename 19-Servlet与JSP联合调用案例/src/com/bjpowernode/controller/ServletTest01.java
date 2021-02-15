package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/15 14:25
 */

import com.bjpowernode.entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletTest01", value = "/ServletTest01")
public class ServletTest01 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Student s1 = new Student("jack", 12);
    Student s2 = new Student("mike", 13);
    List<Student> stuList = new ArrayList();
    stuList.add(s1);
    stuList.add(s2);

    // 将处理结果添加到请求作用域对象
    request.setAttribute("key", stuList);

    // 通过请求转发方案，向Tomcat申请调用user_show.jsp
    // 同时将request与response通过Tomcat交给user_show.jsp使用
    request.getRequestDispatcher("/user_show.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
