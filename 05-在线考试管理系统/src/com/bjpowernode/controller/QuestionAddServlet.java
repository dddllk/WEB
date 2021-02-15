package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dlkyy on 2021/2/15 15:45
 */
public class QuestionAddServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String title, optionA,optionB,optionC,optionD,answer;
    QuestionDao dao = new QuestionDao();

    List<Question> questionList = new ArrayList();
    // 获取参数
    title = req.getParameter("title");
    optionA = req.getParameter("optionA");
    optionB = req.getParameter("optionB");
    optionC = req.getParameter("optionC");
    optionD = req.getParameter("optionD");
    answer = req.getParameter("answer");

    // 将参数放进question对象中
    Question question = new Question(null, title, optionA, optionB, optionC, optionD, answer);

    // 调用QuestionDao将获得的数据添加进数据库中
    int result = dao.add(question, req);
    if(result == 1){
      // 将处理结果添加到请求作用域对象
      req.setAttribute("info", "添加成功！");
    }else{
      // 将处理结果添加到请求作用域对象
      req.setAttribute("info", "添加失败！");
    }
    // 请求转发
    req.getRequestDispatcher("/question_success.jsp").forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
