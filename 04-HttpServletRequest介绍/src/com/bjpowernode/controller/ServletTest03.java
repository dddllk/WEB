package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/12 0:44
 *
 * 问题：以get方式发送中文参数时，得到正常结果
 *      以post方式发送中文参数时，得到乱码
 *
 *  原因：
 *    浏览器以GET方式发送请求，请求参数保存在【请求头】，在HTTP请求协议包到达HTTP服务器之后，第一件事就是进行解码
 *    请求头中的二进制内容由Tomcat负责解码的，Tomcat默认使用UTF-8字符集，可以解释一切国家的问题
 *
 *    浏览器以POST方式发送请求，请求参数保存在【请求体】，在HTTp请求协议包到达HTTP服务器之后，第一件事就是进行解码
 *    请求体二进制内容由当前请求对象（request）负责解码。request默认使用【ISO-8859-1】字符集，一个东欧语系字符集
 *    此时如果请求体参数内容是中文，将无法解码只能得到乱码
 *
 *  解决方法：
 *    在POST请求方式下：在读取请求体内容之前，应该通知请求对象使用utf-8字符集对请求体内容进行一次重新解码
 *
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletTest03 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 通知请求对象，使用utf-8字符集对请求体二进制进行一次重新解码
    request.setCharacterEncoding("utf-8");
    // 通过请求对象，读取【请求头】参数信息
    String userName = request.getParameter("userName");
    System.out.println("从请求头得到参数值：" + userName);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 通过请求参数对象，读取【请求体】参数信息
    String userName = request.getParameter("userName");
    System.out.println("从请求体的到参数值：" + userName);
  }
}
