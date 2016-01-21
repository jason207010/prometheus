<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${path}/admin/resource/edit.do" method="post">
    <input type="hidden" value="${entity.id}">
    <input name="url" value="${entity.url}" placeholder="请输入资源url">
    <input type="submit">
</form>
</body>
</html>
