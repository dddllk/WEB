package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dlkyy on 2021/2/15 20:47
 */
public class QuestionDeleteServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 1.获取参数信息
    Integer questionId = Integer.valueOf(req.getParameter("questionId"));
    int result = 0;
    QuestionDao dao = new QuestionDao();
    // 2.从数据库中获取删除数据
    result = dao.delete(questionId, req);
    // 3.判断是否删除成功！
    if(result == 1){
      req.setAttribute("info", "删除成功！");
    }else{
      req.setAttribute("info", "删除失败！");
    }
    // 请求转发
    req.getRequestDispatcher("/question_delete_info.jsp").forward(req, resp);
  }
}
