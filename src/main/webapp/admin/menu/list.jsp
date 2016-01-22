<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>菜单列表</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-12">
                <a class="btn btn-primary" href="${path}/admin/menu/addInit.do">添加菜单</a>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <hr/>

                <table class="table table-bordered table-striped">
                    <tr>
                        <th>菜单名</th>
                        <th>菜单url</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${menuEntities}" var="m">
                        <tr>
                            <td>${m.name}</td>
                            <td>${m.resourceEntity.url}</td>
                            <td>
                                <a href="${path}/admin/menu/editInit.do?id=${m.id}">编辑</a>
                                <a href="${path}/admin/menu/delete.do?id=${m.id}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
