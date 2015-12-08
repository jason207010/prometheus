<%--
  Created by IntelliJ IDEA.
  User: Jayson
  Date: 2015/12/2
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <div>
    <h1>百度搜索</h1>
    <form action="/search/search.do" method="post">
      <input name="keyWord">
      <input type="hidden" name="curPage" value="1">
      <input type="hidden" name="pageSize" value="10">
      <input type="submit">
    </form>
  </div>
</body>
</html>
