<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-12">
                <a class="btn btn-primary" href="${path}/admin/user/addInit.do">添加用户</a>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-12">
                <hr/>

                <table class="table table-bordered table-striped">
                    <tr>
                        <th>用户名</th>
                        <th>是否可用</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${userEntities}" var="u">
                        <tr>
                            <td>${u.name}</td>
                            <td>${u.enable}</td>
                            <td>
                                <a href="${path}/admin/user/editInit.do?id=${u.id}">编辑</a>
                                <a href="${path}/admin/user/delete.do?id=${u.id}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
