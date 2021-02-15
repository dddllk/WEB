package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dlkyy on 2021/2/15 23:00
 */
public class QuestionUpdateServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Integer questionId;
    String title,optionA,optionB,optionC,optionD,answer;
    Question question = null;
    QuestionDao dao = new QuestionDao();
    int result;
    // 调用请求对象读取请求头参数信息
    questionId = Integer.valueOf(req.getParameter("questionId"));
    title = req.getParameter("title");
    optionA = req.getParameter("optionA");
    optionB = req.getParameter("optionB");
    optionC = req.getParameter("optionC");
    optionD = req.getParameter("optionD");
    answer = req.getParameter("answer");
    // 将试题内容放入question对象中
    question = new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
    // 调用Dao实现更新
    result = dao.update(question, req);
    // 判断
    if(result == 1){
      req.setAttribute("info", "更新成功！");
    }else{
      req.setAttribute("info", "更新失败！");
    }
    // 调用question_success.jsp将结果写入到响应体中
    req.getRequestDispatcher("/question_success.jsp").forward(req,resp);
  }
}
