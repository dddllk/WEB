package com.bjpowernode.dao;

import com.bjpowernode.entity.Users;
import com.bjpowernode.util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dlkyy on 2021/2/12 15:41
 */
public class UserDao {
  private final JdbcUtil util = new JdbcUtil();
  // 用户注册
  // JDBC规范中，Connection创建与销毁最浪费时间

  //--- add方法重载 --- start
  public int add(Users user, HttpServletRequest request){
    int result = 0;
    String sql = "insert into Users(userName,password,sex,email) values(?,?,?,?)";

    PreparedStatement ps = util.createStatement(sql, request);

    try {
      ps.setString(1,user.getUserName());
      ps.setString(2,user.getPassword());
      ps.setString(3,user.getSex());
      ps.setString(4,user.getEmail());
      result = ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close(request);
    }
    return result;
  }
  //--- add方法重载 --- end

  // add 方法
  public int add(Users user){
    int result = 0;
    String sql = "insert into Users(userName,password,sex,email) values(?,?,?,?)";

    PreparedStatement ps = util.createStatement(sql);

    try {
      ps.setString(1,user.getUserName());
      ps.setString(2,user.getPassword());
      ps.setString(3,user.getSex());
      ps.setString(4,user.getEmail());
      result = ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close();
    }
    return result;
  }
  // 用户查询
  public List findAll(){
    ResultSet rs = null;
    String sql = "select *from Users";
    Users user;
    List list = new ArrayList();

    PreparedStatement ps = util.createStatement(sql);

    try {
      rs = ps.executeQuery();
      while(rs.next()) {
        Integer userId = rs.getInt("userId");
        String userName = rs.getString("userName");
        String password = rs.getString("password");
        String sex = rs.getString("sex");
        String email = rs.getString("email");

        user = new Users(userId, userName, password, sex, email);
        list.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close(rs);
    }
    return list;
  }
  // 用户删除
  public int delete(int userId){
    int result = 0;
    String sql = "delete from users where userId=?";
    PreparedStatement ps = util.createStatement(sql);
    try {
      ps.setInt(1, userId);
      result = ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close();
    }
    return result;
  }
  // 验证登录
  public int login(String userName, String password){
    ResultSet rs = null;
    PreparedStatement ps = null;
    int result = 0;
    String sql = "select count(*) from users where userName=? and password=?";

    ps = util.createStatement(sql);
    try {
      ps.setString(1, userName);
      ps.setString(2, password);
      rs = ps.executeQuery();
      while(rs.next()) {
        result = rs.getInt("count(*)");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close(rs);
    }
    return result;
  }
}
