package com.bjpowernode.util;

import java.sql.*;

/**
 * Created by dlkyy on 2021/2/12 14:39
 */
public class JdbcUtil {

  Connection con = null;
  PreparedStatement ps = null;
  // 在当前类文件第一次加载到JVM时，JVM将会自动调用当前类文件静态语句块
  static {
    // 注册驱动
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println("Driver接口被注册了");
  }

  // 封装Connection对象创建细节
  public Connection createConn(){
    try {
      String URL = "jdbc:mysql://localhost:3306/bjpowernode";
      String user = "root";
      String password = "123456";
      con = DriverManager.getConnection(URL, user, password);
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Connection 对象创建失败！");
    }
    return con;
  }

  // 封装PreparedStatement对象创建细节
  public PreparedStatement createStatement(String sql) {
    Connection con = createConn();
    try {
      ps = con.prepareStatement(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ps;
  }

  // 封装PreparedStatement对象与Connection对象销毁细节
  public void close(){
    if(ps != null){
      try {
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if(con != null){
      try {
        con.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
  // 封装PreparedStatement对象、Connection对象与ResultSet对象
  public void close(ResultSet rs){
    if(rs != null) {
      try {
        rs.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    close();
  }
}
