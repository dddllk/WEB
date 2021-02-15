package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dlkyy on 2021/2/15 21:20
 */
public class QuestionShowDetailServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    QuestionDao dao = new QuestionDao();
    Question question = null;
    // 1.从参数中获取信息
    Integer questionId = Integer.parseInt(req.getParameter("questionId"));
    // 2.将questionId放入数据库中查询
    question = dao.findById(questionId, req);
    // 3.将question添加到全局作用域对象
    req.setAttribute("key", question);
    // 4.请求转发
    req.getRequestDispatcher("/question_detail_info.jsp").forward(req, resp);
  }
}
