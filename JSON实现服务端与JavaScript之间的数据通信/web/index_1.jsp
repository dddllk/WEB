<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/19
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        // 从request作用域对象得到服务端得到的学生对象
        var stuObj = ${requestScope.key};
        window.alert("学生编号：" + stuObj.id + "学生姓名：" + stuObj.sname);
    </script>
</head>
<body>

</body>
</html>
