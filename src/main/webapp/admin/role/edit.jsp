<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div class="container">
        <form action="${path}/admin/role/edit.do" method="post">
            <input name="id" value="${entity.id}" type="hidden">
            <input name="name" value="${entity.name}" placeholder="请输入角色名">

            <c:forEach items="${resourceEntities}" var="r">
            <input name="resourceIds" id="resourceIds${r.id}" type="checkbox"><label for="resourceIds${r.id}">${r.url}</label>
            </c:forEach>

            <input type="submit">
        </form>
    </div>
</body>
</html>
