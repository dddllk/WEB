package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/11 22:04
 *
 * w问题描述：
 *      String result = "Java<br/>Mysql<br/>HTML<br/>";
 *      浏览器直接输出字符串
 *      没有将<br/>当做HTML标签
 *
 *  问题的原因：
 *    浏览器在接收到响应包之后，根据【响应头中content-type】
 *    属性的值，来采用【编译器】对【响应体中二进制内容】进行编译处理
 *
 *    在默认情况下，content-type属性的值“text” content-type="text"
 *    此时浏览器将会采用【文本编辑器】对响应体二进制进行解析
 *
 *   解决方法：
 *      一定要在得到输出流之前，通过响应对象对响应头中content-type属性进行
 *      一次重新赋值用于指定浏览器采用正确的编译器。
 */

import javafx.print.Printer;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletTest03 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String result = "Java<br/>Mysql<br/>HTML<br/>";
    String result2 = "红烧排骨！<br/>梅菜肘子<br/>糖醋里脊";

    //设置响应头content-type
    response.setContentType("text/html;charset=utf-8");
    //向Tomcat索要输出流
    PrintWriter out = response.getWriter();
    // 通过输出流将结果写入到响应体
    out.print(result);
    out.print(result2);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
