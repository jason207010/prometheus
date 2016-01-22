<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <link rel="stylesheet" href="${path}/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/lib/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="${path}/lib/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="${path}/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <sitemesh:write property='head'/>
    <title><sitemesh:write property='title'/>&nbsp;&nbsp;Prometheus后台管理系统</title>
</head>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="${path}/admin/index.do">首页</a>
            </div>

            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="disabled">
                        <a href="#">欢迎登陆，${sessionScope.SPRING_SECURITY_CONTEXT.authentication.name}</a>
                    </li>
                    <li>
                        <a href="${path}/admin/logout.do">退出</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="row">
        <div class="col-xs-2">
            <ul class="list-group">
                <c:forEach items="${sessionScope.menus}" var="menu">
                    <li class="list-group-item"><a href="${menu.resourceEntity.url}">${menu.name}</a></li>
                </c:forEach>
            </ul>
        </div>
        <div class="col-xs-10">
            <sitemesh:write property='body'/>
        </div>
    </div>
</div>
</body>
</html>