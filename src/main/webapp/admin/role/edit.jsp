<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑角色</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-xs-12">
                <form action="${path}/admin/role/edit.do" method="post">
                    <div class="form-group">
                        <label>角色名：</label>
                        <input class="form-control" name="name" value="${entity.name}" placeholder="请输入角色名">
                    </div>

                    <c:forEach items="${resourceEntities}" var="r">
                    <div class="checkbox">
                        <label>
                            <input name="resourceIds" id="resourceIds${r.id}" type="checkbox">${r.url}
                        </label>
                    </div>
                    </c:forEach>

                    <input name="id" value="${entity.id}" type="hidden">

                    <input class="btn btn-default" type="submit" value="确定">
                </form>
            </div>
        </div>
    </div>
</body>
</html>
