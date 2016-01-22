<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新用户</title>
</head>
<body>
    <div class="container-fluid">
        <form action="${path}/admin/user/add.do" method="post">
            <div class="form-group">
                <label>用户名：</label>
                <input class="form-control" name="name" placeholder="请输入用户名">
            </div>

            <div class="form-group">
                <label>密码：</label>
                <input class="form-control" name="password" type="password" placeholder="请输入密码">
            </div>

            <div class="form-group">
                <label>是否可用：</label>
                <select class="form-control" name="enable">
                    <option value="true">是</option>
                    <option value="false">否</option>
                </select>
            </div>

            <c:forEach items="${roleEntities}" var="r">
            <div class="checkbox">
                <label>
                    <input type="checkbox" name="roleIds" id="roleIds${r.id}" value="${r.id}">${r.name}
                </label>
            </div>
            </c:forEach>

            <input class="btn btn-default" type="submit" value="确定">
        </form>
    </div>
</body>
</html>
