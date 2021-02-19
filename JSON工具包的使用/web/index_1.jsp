<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/19
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function init(){
        	var deptObj = ${requestScope.key};
        	document.getElementById("deptNo").value = deptObj.deptNo;
        	document.getElementById("dname").value = deptObj.dname;
        	document.getElementById("loc").value = deptObj.loc;
        }
    </script>
</head>
<body onload="init()">
    <table border="2" align="center">
        <tr>
            <td>部门编号</td>
            <td><input type="text" id="deptNo"></td>
        </tr>
        <tr>
            <td>部门名称</td>
            <td><input type="text" id="dname"></td>
        </tr>
        <tr>
            <td>部门位置</td>
            <td><input type="text" id="loc"></td>
        </tr>
    </table>
</body>
</html>
