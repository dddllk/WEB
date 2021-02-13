package com.bjpowernode.controller; /**
 * Created by dlkyy on 2021/2/13 20:54
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletTest01", value = "/ServletTest01")
public class ServletTest01 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ServletContext application = request.getServletContext();
    application.setAttribute("key1", 100); // 设置共享数据
    application.setAttribute("key1", 200); // 更新共享数据
    application.removeAttribute("key1"); // 删除共享数据
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
