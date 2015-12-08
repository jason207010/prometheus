<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
  request.setAttribute("path" , path);
%>
<html>
<head>
    <title>添加新爬虫任务</title>
</head>
<body>
<div>
  <form action="${path}/crawler/add.do" method="post">
    <select name="id">
      <c:forEach items="${crawlers}" var="crawler">
        <option value="${crawler.crawlerInfo.id}">${crawler.crawlerInfo.desc}</option>
      </c:forEach>
    </select>
    <input type="submit">
  </form>
</div>
</body>
</html>