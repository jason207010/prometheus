<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>角色列表</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12">
            <a class="btn btn-primary" href="${path}/admin/role/addInit.do">添加角色</a>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12">
            <hr/>

            <table class="table table-bordered table-striped">
                <tr>
                    <th>角色名</th>
                    <th>操作</th>
                </tr>
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
    </div>
</div>
</body>
</html>
