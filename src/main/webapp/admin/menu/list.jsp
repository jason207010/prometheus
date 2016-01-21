<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <div>
        <a href="${path}/admin/menu/addInit.do">添加菜单</a>
    </div>
    <table class="table">
        <c:forEach items="${menuEntities}" var="m">
            <tr>
                <td>${m.name}</td>
                <td>${m.resourceEntity.url}</td>
                <td>
                    <a href="${path}/admin/menu/delete.do?id=${m.id}">删除</a>
                    <a href="${path}/admin/menu/editInit.do?id=${m.id}">编辑</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
