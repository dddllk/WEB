package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dlkyy on 2021/2/12 20:17
 */
public class LoginServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userName,password;
    int result = 0;
    UserDao dao = new UserDao();
    // 1.调用请求对象对请求体使用UTF-8字符集进行重新编辑
    req.setCharacterEncoding("utf-8");
    // 2.调用请求对象读取请求参数信息
    userName = req.getParameter("userName");
    password = req.getParameter("password");
    // 3.调用Dao将查询验证信息推送到数据库服务器上
    result = dao.login(userName, password);
    // 4.调用响应对象，根据验证结果将不同资源文件地址写入到响应头，交给浏览器。
    if(result == 1){
      resp.sendRedirect("/myWeb/index.html");
    }else {
      resp.sendRedirect("/myWeb/login_error.html");
    }
  }
}
