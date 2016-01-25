<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑角色</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-xs-12">
                <sp:form action="${path}/admin/role/edit.do" method="post" commandName="form">
                    <div class="form-group">
                        <label>角色名：</label>
                        <sp:input cssClass="form-control" path="name" placeholder="请输入角色名"/>
                        <sp:errors cssClass="error" path="name"/>
                    </div>

                    <c:forEach items="${resourceEntities}" var="r">
                        <div class="checkbox">
                            <label>
                                <sp:checkbox path="resourceIds" value="${r.id}"/>${r.url}
                            </label>
                        </div>
                    </c:forEach>

                    <sp:hidden path="id"/>

                    <input class="btn btn-default" type="submit" value="确定">
                </sp:form>
            </div>
        </div>
    </div>
</body>
</html>
