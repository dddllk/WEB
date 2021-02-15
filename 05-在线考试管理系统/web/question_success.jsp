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
    String info = (String)request.getAttribute("info");
%>
<font size="40px" color="red"><%=info%></font>
