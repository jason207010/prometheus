<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="${path}/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/lib/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="${path}/lib/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="${path}/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="${path}/css/admin/login.css">
    <link rel="stylesheet" href="${path}/css/common.css">
    <title>欢迎登陆Prometheus后台管理系统</title>
</head>
<body>
<form action="${path}/admin/login.do" method="post">
<div class="container main">
    <c:if test="${param.authError}">
        <div class="row main-row">
            <div class="col-md-4"></div>
            <div class="col-md-4 col-xs-12 error">
                用户名或密码错误！
            </div>
            <div class="col-md-4"></div>
        </div>
    </c:if>
    <div class="row main-row">
        <div class="col-md-4"></div>
        <div class="col-md-4 col-xs-12">
            <input class="form-control" name="name" placeholder="请输入用户名">
        </div>
        <div class="col-md-4"></div>
    </div>
    <div class="row main-row">
        <div class="col-md-4"></div>
        <div class="col-md-4 col-xs-12">
            <input class="form-control" type="password" name="password" placeholder="请输入密码">
        </div>
        <div class="col-md-4"></div>
    </div>
    <div class="row main-row">
        <div class="col-md-4"></div>
        <div class="col-md-4 col-xs-12">
            <input class="btn btn-default" type="submit" value="登陆">
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</form>
</body>
</html>
