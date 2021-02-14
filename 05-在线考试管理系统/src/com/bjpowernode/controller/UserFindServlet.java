package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by dlkyy on 2021/2/12 17:27
 */
public class UserFindServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out = null;
    UserDao dao = new UserDao();

    List<Users> userList = dao.findAll();

    resp.setContentType("text/html;charset=utf-8");
    out = resp.getWriter();
    out.print("<table border=1>");
    out.print("<tr>");
    out.print("<td>用户编号</td>");
    out.print("<td>用户姓名</td>");
    out.print("<td>密码</td>");
    out.print("<td>性别</td>");
    out.print("<td>邮箱</td>");
    out.print("<td>操作</td>");
    out.print("</tr>");
    for(Users users : userList){
      out.print("<tr>");
      out.print("<td>" + users.getUserId() + "</td>");
      out.print("<td>" + users.getUserName() + "</td>");
      out.print("<td>******</td>");
      out.print("<td>" + users.getSex() + "</td>");
      out.print("<td>" + users.getEmail() + "</td>");
      out.print("<td><a href='/myWeb/user/delete?userId="+ users.getUserId()
          +"'>删除用户</a></td>");
      out.print("</tr>");
    }
    out.print("</table>");
  }
}
