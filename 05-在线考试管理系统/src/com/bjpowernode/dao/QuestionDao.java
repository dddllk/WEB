package com.bjpowernode.dao;

import com.bjpowernode.entity.Question;
import com.bjpowernode.util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dlkyy on 2021/2/15 16:01
 */
public class QuestionDao {

  private final JdbcUtil util = new JdbcUtil();

  // 问题添加
  public int add(Question question, HttpServletRequest request){
    int result = 0;
    String sql = "insert into question(title,optionA,optionB,optionC,optionD,answer)" +
        "values(?,?,?,?,?,?)";
    PreparedStatement ps = util.createStatement(sql, request);

    try {
      ps.setString(1, question.getTitle());
      ps.setString(2, question.getOptionA());
      ps.setString(3, question.getOptionB());
      ps.setString(4, question.getOptionC());
      ps.setString(5, question.getOptionD());
      ps.setString(6, question.getAnswer());

      result = ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close(request);
    }
    return result;
  }
  //问题查找
  public List findAll(HttpServletRequest request){
    String sql = "select *from question";
    ResultSet rs = null;
    Question question;
    List<Question> list = new ArrayList();
    PreparedStatement ps = util.createStatement(sql, request);

    try {
      rs = ps.executeQuery();
      while(rs.next()){
        Integer id = rs.getInt("questionId");
        String title = rs.getString("title");
        String optionA = rs.getString("optionA");
        String optionB = rs.getString("optionB");
        String optionC = rs.getString("optionC");
        String optionD = rs.getString("optionD");
        String answer =  rs.getString("answer");

        question = new Question(id, title, optionA, optionB, optionC, optionD, answer);

        list.add(question);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close(rs);
    }
    return list;
  }
  // 问题删除
  public int delete(Integer questionId,HttpServletRequest request){
    int result = 0;
    String sql = "delete from question where questionId = ?";
    PreparedStatement ps = util.createStatement(sql, request);
    try {
      ps.setInt(1, questionId);
      result = ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close(request);
    }
    return result;
  }

  // 按问题编号查询
  public Question findById(Integer questionId, HttpServletRequest req) {
    Question question = null;
    ResultSet rs = null;
    String sql = "select * from question where questionId = ?";
    PreparedStatement ps = util.createStatement(sql, req);

    try {
      ps.setInt(1, questionId);
      rs = ps.executeQuery();
      while(rs.next()){
        String title = rs.getString("title");
        String optionA = rs.getString("optionA");
        String optionB = rs.getString("optionB");
        String optionC = rs.getString("optionC");
        String optionD = rs.getString("optionD");
        String answer = rs.getString("answer");

        question = new Question(questionId, title, optionA, optionB, optionC, optionD, answer);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close(rs, req);
    }
    return question;
  }

  public int update(Question question, HttpServletRequest req) {
    int result = 0;
    String sql = "update question set title=?,optionA=?,optionB=?," +
        "optionC=?,optionD=?,answer=? where questionId=?";
    PreparedStatement ps = util.createStatement(sql, req);

    try {
      ps.setString(1, question.getTitle());
      ps.setString(2, question.getOptionA());
      ps.setString(3, question.getOptionB());
      ps.setString(4, question.getOptionC());
      ps.setString(5, question.getOptionD());
      ps.setString(6, question.getAnswer());
      ps.setInt(7, question.getQuestionId());

      result = ps.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close(req);
    }
    return result;
  }
}
