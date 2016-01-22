<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>资源列表</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-xs-12">
                <a class="btn btn-primary" href="${path}/admin/resource/addInit.do">添加资源</a>
            </div>
        </div>

        <div class="row"></div>

        <div class="row">
            <div class="col-xs-12">

                <hr/>

                <table class="table table-bordered table-striped table-hover">
                    <tr>
                        <th>资源url</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${resourceEntities}" var="r">
                        <tr>
                            <td>${r.url}</td>
                            <td>
                                <a href="${path}/admin/resource/editInit.do?id=${r.id}">编辑</a>
                                <a href="${path}/admin/resource/delete.do?id=${r.id}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
