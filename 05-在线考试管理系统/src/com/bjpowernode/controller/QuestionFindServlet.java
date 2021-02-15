package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dlkyy on 2021/2/15 16:32
 */
public class QuestionFindServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 从数据库中获取元素
    QuestionDao dao = new QuestionDao();
    List<Question> questionList = dao.findAll();
    // 将处理结果添加到请求作用域对象
    req.setAttribute("key", questionList);
    // 请求转发
    req.getRequestDispatcher("/user_find_result.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
