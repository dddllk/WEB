<%@ page import="com.bjpowernode.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/15
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>问题详情</title>
</head>
<body>
<%
    Question question = (Question) request.getAttribute("key");
    Integer questionId = question.getQuestionId();
    String title = question.getTitle();
    String optionA = question.getOptionA();
    String optionB = question.getOptionB();
    String optionC = question.getOptionC();
    String optionD = question.getOptionD();
    String answer = question.getAnswer();
%>
<form action="/myWeb/question/update" method="get">
    <table border="2">
        <tr>
            <td>题目编号</td>
            <td><input type="text" name="questionId" value="<%=questionId%>" readonly></td>
        </tr>
        <tr>
            <td>题目</td>
            <td><input type="text" name="title" value="<%=title%>"/></td>
        </tr>
        <tr>
            <td>选项A</td>
            <td><input type="text" name="optionA" value="<%=optionA%>"/></td>
        </tr>
        <tr>
            <td>选项B</td>
            <td><input type="text" name="optionB" value="<%=optionB%>"/></td>
        </tr>
        <tr>
            <td>选项C</td>
            <td><input type="text" name="optionC" value="<%=optionC%>"></td>
        </tr>
        <tr>
            <td>选项D</td>
            <td><input type="text" name="optionD" value="<%=optionD%>"></td>
        </tr>
        <td>正确答案</td>
        <td>
            <input type="radio" name="answer" value="A" <%="A".equals(answer) ? "checked" : ""%>>A
            <input type="radio" name="answer" value="B" <%="B".equals(answer) ? "checked" : ""%>>B
            <input type="radio" name="answer" value="C" <%="C".equals(answer) ? "checked" : ""%>>C
            <input type="radio" name="answer" value="D" <%="D".equals(answer) ? "checked" : ""%>>D
        </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="更新试题"><input type="reset"></td>
        </tr>
    </table>
</form>
</body>
</html>
