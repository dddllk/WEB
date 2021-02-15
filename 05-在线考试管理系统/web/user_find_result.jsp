<%@ page import="com.bjpowernode.entity.Question" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/15
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Question> questionList = (List) request.getAttribute("key");%>
<table border="1">
    <tr>
        <td>序号</td>
        <td>问题</td>
        <td>选项A</td>
        <td>选项B</td>
        <td>选项C</td>
        <td>选项D</td>
        <td>正确答案</td>
    </tr>
    <%
     for(Question question : questionList){
       Integer questionId = question.getQuestionId();
       String title = question.getTitle();
       String optionA = question.getOptionA();
       String optionB = question.getOptionB();
       String optionC = question.getOptionC();
       String optionD = question.getOptionD();
       String answer = question.getAnswer();
       if(questionId%2 == 0){
    %>
        <tr bgcolor="green">
    <%
        }else if(questionId%2 == 1){
    %>
        <tr bgcolor="yellow">
    <%
        }
    %>
            <td><%=questionId%></td>
            <td><%=title%></td>
            <td><%=optionA%></td>
            <td><%=optionB%></td>
            <td><%=optionC%></td>
            <td><%=optionD%></td>
            <td><%=answer%></td>
        </tr>
    <%
      }
    %>
</table>
