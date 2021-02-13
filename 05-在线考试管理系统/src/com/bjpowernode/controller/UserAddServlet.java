package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by dlkyy on 2021/2/12 15:29
 */
public class UserAddServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userName,password,sex,email;
    UserDao dao = new UserDao();
    Users user = null;
    int result = 0;
    PrintWriter out = null; // 借用Tomcat的PrintWriter
    //1.【调用请求对象】读取【请求头】参数信息，得到用户的信息
    userName = req.getParameter("userName");
    password = req.getParameter("password");
    sex = req.getParameter("sex");
    email = req.getParameter("email");

    //2.【调用UserDao】将用户信息填充到INSERT命令，并借助JDBC规范发送到数据库服务器
    user = new Users(null, userName, password, sex, email);
    Date start = new Date();//添加开始时间
    result = dao.add(user, req);
    Date end = new Date();//添加结束时间
    System.out.println("添加消耗的时间：" + (end.getTime()-start.getTime()));
    //3.【调用响应对象】将【处理结果】以二进制形式写入到响应体
    resp.setContentType("text/html;charset=utf-8");
    out = resp.getWriter();
    if(result == 1){
      out.print("<font style='color:red;font-size:40'>用户信息注册成功！</font>");
    }else{
      out.print("<font style='color:red;font-size:40'>用户信息注册失败！</font>");
    }
    // Tomcat负责【请求对象】和【响应对象】
    // Tomcat负责将Http响应协议包推送到发起请求的浏览器上
    // 浏览器根据响应头content-type指定编译器对响应体二进制内容编辑
    // 浏览器将编辑后的结果在窗口展示给用户【结束】

    // 以上没有带序号的内容由浏览器和服务器自动完成。
  }
}
