<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新用户</title>
</head>
<body>
    <div class="container-fluid">
        <sp:form action="${path}/admin/user/add.do" method="post" commandName="form">

            <div class="form-group">
                <label>用户名：</label>
                <sp:input cssClass="form-control" path="name" placeholder="请输入用户名"/>
                <sp:errors cssClass="error" path="name"/>
            </div>

            <div class="form-group">
                <label>密码：</label>
                <sp:password cssClass="form-control" path="password" placeholder="请输入密码"/>
                <sp:errors cssClass="error" path="password"/>
            </div>

            <div class="form-group">
                <label>是否可用：</label>
                <sp:select cssClass="form-control" path="enable">
                    <sp:option value="true">是</sp:option>
                    <sp:option value="false">否</sp:option>
                </sp:select>
                <sp:errors cssClass="error" path="enable"/>
            </div>

            <c:forEach items="${roleEntities}" var="r">
                <div class="checkbox">
                    <label>
                        <sp:checkbox path="roleIds" value="${r.id}"/>${r.name}
                    </label>
                </div>
            </c:forEach>

            <input class="btn btn-default" type="submit" value="确定">
        </sp:form>
    </div>
</body>
</html>
