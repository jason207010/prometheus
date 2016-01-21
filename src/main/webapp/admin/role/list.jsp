<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <table class="table">
        <c:forEach items="${roleEntities}" var="r">
        <tr>
            <td>${r.name}</td>
            <td>
                <a href="${path}/admin/role/editInit.do?id=${r.id}">编辑</a>
                <a href="${path}/admin/role/delete.do?id=${r.id}">删除</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
