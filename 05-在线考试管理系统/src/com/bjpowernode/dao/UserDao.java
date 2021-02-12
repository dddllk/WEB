package com.bjpowernode.dao;

import com.bjpowernode.entity.Users;
import com.bjpowernode.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dlkyy on 2021/2/12 15:41
 */
public class UserDao {
  private JdbcUtil util = new JdbcUtil();
  // 用户注册
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
}
