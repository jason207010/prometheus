<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑菜单</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6 col-xs-12">
            <form action="${path}/admin/menu/edit.do" method="post">
                <div class="form-group">
                    <label>菜单名：</label>
                    <input class="form-control" name="name" value="${entity.name}">
                </div>

                <div class="form-group">
                    <label>资源：</label>
                    <select class="form-control" name="resourceId">
                        <c:forEach items="${resourceEntities}" var="r">
                            <option value="${r.id}" <c:if test="${r.id == entity.resourceEntity.id}">selected="selected"</c:if>>
                                    ${r.url}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <input type="hidden" name="id" value="${entity.id}">

                <input class="btn btn-default" type="submit" value="提交">

            </form>
        </div>
    </div>
</div>
</body>
</html>
