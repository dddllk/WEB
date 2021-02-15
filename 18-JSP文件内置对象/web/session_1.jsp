<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/15
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
    jsp文件内置对象：session
                类型：HttpSession
                作用：JSP文件在运行时，session指向当前用户私人储物柜，
                        添加共享数据，或者读取共享数据。
-->
<!--将共享数据添加到当前用户私人储物柜-->
<%
   // HttpSession session = request.getSession();
   session.setAttribute("key1", 200);
%>
