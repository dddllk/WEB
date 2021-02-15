<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/15
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // 获取结果
    Integer result = (Integer)request.getAttribute("key");
%>
<%
    if(result == 1){
%>
    <font color="red" size="40px">添加成功！</font>
<%
    }else{
%>
    <font color="red" size="40px">添加失败！</font>
<%
    }
%>
