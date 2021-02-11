package com.bjpowernode.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dlkyy on 2021/2/11 17:41
 *
 * 子类 --> 父类 --> A接口
 * 此时 子类也是A接口的实现类
 *
 * Tomcat根据Servlet规范调用Servlet接口实现类规则：
 *  1.Tomcat有权创建Servlet接口实现类实例对象
 *    Servlet oneServlet = new OneServlet();
 *  2.Tomcat根据实例对象调用service方法处理当前请求
 *    oneServlet.servlet();
 *               extends                           extends                            implements
 *   oneServlet ----------> (abstract)HttpServlet --------->(abstract)GenericServlet ------------> servlet接口
 *                                                           init
 *                                                           destroy
 *                                                           getServletInfo
 *                                                           getServletConfig
 *
 *    通过父类决定在何种情况下调用子类方法 ------》【设计模式】------》模板设计模式
 *
 * 复习：
 *  重写规则
 *  抽象类作用
 *  子类实现接口规则
 *  this指向
 *  继承规则
 */
public class OneServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("OneServlet类正对浏览器发送GET请求方式处理！");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("OneServlet类正对浏览器发送POST请求方式处理！");
  }
}
