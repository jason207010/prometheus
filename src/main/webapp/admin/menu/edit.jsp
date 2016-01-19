<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <form action="${path}/admin/menu/edit.do" method="post">
        <table class="table">
            <tr>
                <td>菜单名：</td>
                <td>
                    <input name="name" value="${entity.name}">
                </td>
            </tr>
            <tr>
                <td>资源：</td>
                <td>
                    <select name="resourceId">
                        <c:forEach items="${resourceEntities}" var="r">
                            <option value="${r.id}" <c:if test="${r.id == entity.resourceEntity.id}">selected="selected"</c:if>>
                                    ${r.url}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
        <input type="hidden" name="id" value="${entity.id}">
    </form>
</div>
</body>
</html>
