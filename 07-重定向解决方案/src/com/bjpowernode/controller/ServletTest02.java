package com.bjpowernode.controller; /**
 * Created by dlkyy on 2021/2/12 22:39
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletTest02", value = "/ServletTest02")
public class ServletTest02 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("ServletTest02 负责洗碗！");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
