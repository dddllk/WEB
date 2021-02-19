<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/19
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function init(){
        	var deptArr = ${requestScope.key};
        	for(var i = 0; i < deptArr.length; i++){
        		var deptObj = deptArr[i];
        		var trDom = document.createElement("tr");
        		var tdDom_1 = document.createElement("td");
        		var tdDom_2 = document.createElement("td");
        		var tdDom_3 = document.createElement("td");
        		tdDom_1.innerHTML = deptObj.deptNo;
        		tdDom_2.innerHTML = deptObj.dname;
        		tdDom_3.innerHTML = deptObj.loc;
        		trDom.appendChild(tdDom_1);
        		trDom.appendChild(tdDom_2);
        		trDom.appendChild(tdDom_3);
        		document.getElementById("table").appendChild(trDom);
            }
        }
    </script>
</head>
<body onload="init()">
<table border="1" align="center" id="table">
    <tr>
        <td>部门编号</td>
        <td>部门名称</td>
        <td>部门位置</td>
    </tr>
</table>
</body>
</html>
