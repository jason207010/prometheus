<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <form action="${path}/admin/role/add.do" method="post">
        <input name="name">

        <c:forEach items="${resourceEntities}" var="r">
        <input type="checkbox" name="resourceIds" value="${r.id}" id="resourceIds${r.id}"><label for="resourceIds${r.id}">${r.url}</label>
        </c:forEach>

        <input type="submit">
    </form>
</div>
</body>
</html>
