<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <form action="${path}/admin/user/edit.do" method="post">
        <input type="hidden" name="id" value="${userEntity.id}">
        <table class="table">
            <tr>
                <td>用户名：</td>
                <td><input name="name" value="${userEntity.name}" placeholder="请输入用户名"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input name="password" type="password" placeholder="请输入密码"></td>
            </tr>
            <tr>
                <td>是否可用：</td>
                <td>
                    <select name="enable">
                        <option value="true">是</option>
                        <option value="false" <c:if test="${!userEntity.enable}">selected="selected"</c:if>>否</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
