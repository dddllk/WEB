<%@ page import="com.bjpowernode.entity.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/15
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%
        //在jsp文件中，只有书写在执行标记中的内容才会被当做Java命令
        int num1 = 20,num2 = 30;
        int c = num1 + num2;
    %>
    <!--在JSP文件，通过输出标记，通知JSP将Java变量的值写入到响应体-->
    变量num1的值：<%=num1%><br/>
    变量num2的值：<%=num2%><br/>
    <!--执行标记还可以通知JSP将运算结果写入到响应体-->
    num1 + num2 = <%=num1+num2%>

    <%
        // 创建一个Student类型对象
        Student stu = new Student("lucy",10);

        List list = new ArrayList();
    %>

    <%
        int age = 15;
    %>
    <%
        if(age > 16){
    %>
        <font style="color:red;font-size:45px">热烈欢迎！</font>
    <%
        }else{
    %>
        <font style="color:red;font-size:45px">谢绝入内！</font>
    <%
        }
    %>
    <!--JSP中嵌入循环控制语句-->
    <%
        Student stu1 = new Student("jack", 16);
        Student stu2 = new Student("lucy", 17);
        Student stu3 = new Student("mike", 18);
        List<Student> stuList = new ArrayList();
        stuList.add(stu1);
        stuList.add(stu2);
        stuList.add(stu3);
    %>
    <!--输出数据-->
    <table border="2" align="center">
        <tr>
            <td>编号</td>
            <td>姓名</td>
        </tr>
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
</html>
