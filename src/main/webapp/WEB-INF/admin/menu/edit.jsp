<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑菜单</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6 col-xs-12">
            <sp:form action="${path}/admin/menu/edit.do" method="post" commandName="form">
                <div class="form-group">
                    <label>菜单名：</label>
                    <sp:input cssClass="form-control" path="name" placeholder="请填写菜单名"/>
                    <sp:errors cssClass="error" path="name"/>
                </div>

                <div class="form-group">
                    <label>资源：</label>
                    <sp:select cssClass="form-control" path="resourceId">
                        <c:forEach items="${resourceEntities}" var="r">
                            <sp:option value="${r.id}">
                                ${r.url}
                            </sp:option>
                        </c:forEach>
                    </sp:select>

                    <sp:errors cssClass="error" path="resourceId"/>
                </div>

                <sp:hidden path="id"/>

                <input class="btn btn-default" type="submit" value="提交">
            </sp:form>
        </div>
    </div>
</div>
</body>
</html>
