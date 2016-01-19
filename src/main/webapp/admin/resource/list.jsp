<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div class="container">
        <table class="table table-bordered table-striped table-hover">
            <tr>
                <th>资源url</th>
            </tr>
            <c:forEach items="${resourceEntities}" var="r">
            <tr>
                <td>${r.url}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
