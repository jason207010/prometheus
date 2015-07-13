<%--
  Created by IntelliJ IDEA.
  User: dell-2
  Date: 2015/7/13
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
  <table>
    <tr>
      <th>id</th>
      <th>描述</th>
      <th>状态</th>
    </tr>
    <c:forEach items="${tasks}" var="task">
      <tr>
        <td>${task.context.info.id}</td>
        <td>${task.context.info.desc}</td>
        <td>${task.status().desc}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
