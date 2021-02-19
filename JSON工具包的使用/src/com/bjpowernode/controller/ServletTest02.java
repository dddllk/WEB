package com.bjpowernode.controller; /**
 * Created by dlkyy on 2021/2/19 15:34
 */

import com.bjpowernode.entity.Dept;
import net.sf.json.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServletTest02 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //获得一个集合存放部门对象
    Dept dept1 = new Dept(10, "专车", "双福");
    Dept dept2 = new Dept(20,"零部件","双福");
    List deptList = new ArrayList();
    deptList.add(dept1);
    deptList.add(dept2);
    // 通过json.jar工具类将集合内容转化为【JSON数组格式】字符串
    JSONArray jsonArray = JSONArray.fromObject(deptList);
    // 将【JSON数组格式】字符串添加到请求作用域对象
    request.setAttribute("key", jsonArray.toString());
    // 请求转发
    request.getRequestDispatcher("/index_2.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
