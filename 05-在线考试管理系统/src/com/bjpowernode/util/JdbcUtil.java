package com.bjpowernode.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by dlkyy on 2021/2/12 14:39
 */
public class JdbcUtil {

  Connection con = null;
  PreparedStatement ps = null;

  // ---------------  通过全局作用域对象得到Connection ----------start
  public Connection createConn(HttpServletRequest request){
    //1.通过请求对象得到全局作用域对象
    ServletContext application = request.getServletContext();
    //2.从全局作用域对象得到一个map
    Map map = (Map)application.getAttribute("key1");
    //3.从map得到一个处于空闲状态的Connection
    Iterator it = map.keySet().iterator();
    while(it.hasNext()){
      con = (Connection) it.next();
      boolean flag = (boolean) map.get(con);
      if(flag){
        map.put(con, false); // 将当前被占用的con状态设置为false;
        break;
      }
    }
    return con;
  }
  // ---------------  通过全局作用域对象得到Connection ----------end

  // ---------------  通过全局作用域对象得到Connection 封装PreparedStatement对象----------start
  public PreparedStatement createStatement(String sql, HttpServletRequest request){
    try {
      ps = createConn(request).prepareStatement(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ps;
  }

  // ---------------  通过全局作用域对象得到Connection 封装PreparedStatement对象----------end

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

  // close方法重载
  public void close(HttpServletRequest request){
    if(ps != null){
      try {
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    ServletContext application = request.getServletContext();
    Map map = (Map)application.getAttribute("key1");
    map.put(con, true);
  }
  public void close(ResultSet rs, HttpServletRequest request){
    if(rs != null) {
      try {
        rs.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    close(request);
  }
}
