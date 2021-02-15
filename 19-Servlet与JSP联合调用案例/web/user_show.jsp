<%@ page import="com.bjpowernode.entity.Student" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/15
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 从请求作用域对象得到ServletTest01添加进去的集合
    List<Student> stuList = (List) request.getAttribute("key");
%>
<table>
    <td>
        <tr>用户编号</tr>
        <tr>用户姓名</tr>
    </td>
    <%
        for(Student student : stuList){
    %>
            <tr>
                <td><%=student.getId()%></td>
                <td><%=student.getName()%></td>
            </tr>
    <%
        }
    %>
</table>
