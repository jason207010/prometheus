<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加菜单</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-xs-12">
                <form action="${path}/admin/menu/add.do" method="post">
                    <div class="form-group">
                        <label>菜单名：</label>
                        <input class="form-control" name="name" placeholder="请输入菜单名">
                    </div>

                    <div class="form-group">
                        <label>资源：</label>
                        <select class="form-control" name="resourceId">
                            <c:forEach items="${resourceEntities}" var="r">
                                <option value="${r.id}">
                                        ${r.url}
                                </option>
                            </c:forEach>
                        </select>
                    </div>

                    <input class="btn btn-default" type="submit" value="提交">
                </form>
            </div>
        </div>
    </div>
</body>
</html>
