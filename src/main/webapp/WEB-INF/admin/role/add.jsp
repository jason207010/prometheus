<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加角色</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6 col-xs-12">
            <form action="${path}/admin/role/add.do" method="post">
                <div class="form-group">
                    <label>角色名：</label>
                    <input class="form-control" name="name">
                </div>

                <c:forEach items="${resourceEntities}" var="r">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="resourceIds" value="${r.id}">${r.url}
                    </label>
                </div>
                </c:forEach>

                <input class="btn btn-default" type="submit" value="确定">
            </form>
        </div>
    </div>
</div>
</body>
</html>
