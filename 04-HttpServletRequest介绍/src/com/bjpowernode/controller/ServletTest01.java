package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/11 22:39
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletTest01 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1.通过请求对象，读取【请求行】中【url】信息
    String url = request.getRequestURL().toString();
    //2.通过请求对象，读取【请求行】中【method】信息
    String method = request.getMethod();
    //3.通过请求对象，读取【请求行】中的【uri】信息
    /**
     * URI: 资源文件进准定位地址，在请求行并没有URI这个属性
     *  实际上是从URL上截取的字符串。
     *  这个字符串格式“/网站名/资源文件名”
     *  URI用于让HTTP服务器对被访问资源文件进行定位
     */
    String uri = request.getRequestURI(); //substring
    System.out.println("URL:" + url);
    System.out.println("method:" + method);
    System.out.println("URI: " + uri);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
