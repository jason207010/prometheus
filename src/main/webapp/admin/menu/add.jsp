<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div class="container">
        <form action="${path}/admin/menu/add.do" method="post">
        <table class="table">
            <tr>
                <td>菜单名：</td>
                <td>
                    <input name="name" placeholder="请输入菜单名">
                </td>
            </tr>
            <tr>
                <td>资源：</td>
                <td>
                    <select name="resourceId">
                        <c:forEach items="${resourceEntities}" var="r">
                        <option value="${r.id}">
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
        </form>
    </div>
</body>
</html>
