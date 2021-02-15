package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dlkyy on 2021/2/15 15:45
 */
public class QuestionAddServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    QuestionDao dao = new QuestionDao();
    PrintWriter out = null;
    List<Question> questionList = new ArrayList();
    // 获取参数
    String title = req.getParameter("title");
    String optionA = req.getParameter("optionA");
    String optionB = req.getParameter("optionB");
    String optionC = req.getParameter("optionC");
    String optionD = req.getParameter("optionD");
    String answer = req.getParameter("answer");

    // 将参数放进question对象中
    Question question = new Question(null, title, optionA, optionB, optionC, optionD, answer);

    // 调用QuestionDao将获得的数据添加进数据库中
    int result = dao.add(question, req);
    // 将处理结果添加到请求作用域对象
    req.setAttribute("key", result);
    // 请求转发
    req.getRequestDispatcher("/add_question_success.jsp").forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
