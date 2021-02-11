package com.bjpowernode.oneServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dlkyy on 2021/2/11 20:10
 */
public class OneServlet extends HttpServlet {
  public OneServlet() {
    System.out.println("OneServlet类被创建实例对象");
  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("OneServlet doGet is run...");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("OneServlet doPost is run...");
  }
}
