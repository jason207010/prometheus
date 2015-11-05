<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    request.setAttribute("path" , path);
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title><sitemesh:write property='title'/></title>
    <sitemesh:write property='head'/>
    <link rel="stylesheet" href="${path}/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/lib/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="${path}/lib/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="${path}/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-2">
            <ul class="list-group">
                <li class="list-group-item"><a href="${path}/crawler/addInit.do">添加新爬虫任务</a></li>
                <li class="list-group-item"><a href="${path}/crawler/list.do">爬虫任务列表</a></li>
                <li class="list-group-item"><a href="#">menu</a></li>
                <li class="list-group-item"><a href="#">menu</a></li>
                <li class="list-group-item"><a href="#">menu</a></li>
            </ul>
        </div>
        <div class="col-xs-10">
            <sitemesh:write property='body'/>
        </div>
    </div>
</div>
</body>
</html>