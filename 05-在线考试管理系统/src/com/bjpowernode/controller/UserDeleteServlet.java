package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by dlkyy on 2021/2/12 19:24
 */
public class UserDeleteServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out = null;
    int result = 0;

    String userId = req.getParameter("userId");
    UserDao dao = new UserDao();
    result = dao.delete(Integer.parseInt(userId));

    resp.setContentType("text/html;charset=utf-8");
    out = resp.getWriter();

    if(result == 1){
      out.print("<font style='color: red;font-size:40px'>用户信息删除成功！</font>");
    }else{
      out.print("<font style='color: red;font-size:40px'>用户信息删除失败！</font>");
    }
  }
}
