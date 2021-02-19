package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/19 14:40
 */

import com.bjpowernode.entity.Dept;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletTest01 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1.部门对象
    Dept dept = new Dept(10, "综合部", "bj");
    //2.通过json.jar工具类将Dept对象中内容转换为JSON格式字符串
    JSONObject jsonObject = JSONObject.fromObject(dept);
    //3.将JSON格式字符串添加到请求作用域对象
    request.setAttribute("key", jsonObject.toString());
    //4.请求转发
    request.getRequestDispatcher("index_1.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
