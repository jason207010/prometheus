<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>爬虫任务列表</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>描述</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${tasks}" var="task">
        <tr>
            <td>${task.crawler.crawlerInfo.id}</td>
            <td>${task.crawler.crawlerInfo.desc}</td>
            <td>${task.crawler.status.desc}</td>
            <td><a href="<s:url value="/crawler/remove.do?id="/>${task.crawler.crawlerInfo.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>

<script type="text/javascript">
    setInterval("location.reload()" , 5000);
</script>
</body>
</html>
