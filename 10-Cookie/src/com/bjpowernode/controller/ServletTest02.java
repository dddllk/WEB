package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/13 12:07
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletTest02 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int jiaozi_money = 30;
    int gaifan_money = 15;
    int miantiao_money = 20;
    String food, userName = null;
    int money,consume = 0,balance = 0;
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    Cookie newCard = null;
    Cookie cookie[] = null;
    //1.读取请求头参数信息，得到用户点餐食物类型
    food = request.getParameter("food");
    //2.读取cookie
    cookie = request.getCookies();
    //3.刷卡消费
    for(Cookie card: cookie){
      String key = card.getName();
      String value = card.getValue();
      if("userName".equals(key)){
        userName = value;
      }else if("money".equals(key)){
        money = Integer.parseInt(value);
        if("饺子".equals(food)){
          if(jiaozi_money > money){
            out.print("用户" + userName + "余额不足，请充值！");
          }else{
            newCard = new Cookie("money",  (money-jiaozi_money) + "");
            consume = jiaozi_money;
            balance = money - consume;
          }
        }else if("面条".equals(food)){
          if(miantiao_money > money){
            out.print("用户" + userName + "余额不足，请充值！");
          }else{
            newCard = new Cookie("money", (money-miantiao_money) + "");  // 10+ "abc" = "10abc"
            consume = miantiao_money;
            balance = money - consume;
          }
        }else if("盖饭".equals(food)){
          if(gaifan_money > money){
            out.print("用户" + userName + "余额不足，请充值！");
          }else{
            newCard = new Cookie("money", (money-gaifan_money) + "");
            consume = gaifan_money;
            balance = money - consume;
          }
        }
      }
    }
    // 4.将会员卡返还给用户
    response.addCookie(newCard);
    // 5.将消费记录写入到响应体中
    out.print("用户" + userName + "本次消费" + consume + "元,余额还剩" + balance);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
