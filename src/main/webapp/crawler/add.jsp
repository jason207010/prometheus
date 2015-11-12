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

  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"/>
      <a href="#custom" aria-controls="home" role="tab" data-toggle="tab">自定义爬虫</a>
    </li>
    <li role="presentation">
      <a href="#build-in" aria-controls="profile" role="tab" data-toggle="tab">内置爬虫</a>
    </li>
  </ul>

  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="custom">
      <sf:form action="${path}/crawler/add.do" method="post" modelAttribute="form">
        <table>
          <tr>
            <td>描述：</td>
            <td><sf:input path="desc"/></td>
            <td><sf:errors path="desc"/></td>
          </tr>
          <tr>
            <td>种子URL：</td>
            <td><sf:input path="seeds"/></td>
            <td><sf:errors path="seeds"/></td>
          </tr>
          <tr>
            <td>抓取正则：</td>
            <td><sf:input path="regex"/></td>
            <td><sf:errors path="regex"/></td>
          </tr>
          <tr>
            <td>分析正则：</td>
            <td><sf:input path="matching"/></td>
            <td><sf:errors path="matching"/></td>
          </tr>
          <tr>
            <td colspan="2">
              <input type="submit">
            </td>
          </tr>
        </table>
      </sf:form>
    </div>
    <div role="tabpanel" class="tab-pane" id="build-in">
      <form action="${path}/crawler/addBuildIn.do" method="post">
        <select name="id">
          <c:forEach items="${crawlers}" var="crawler">
            <option value="${crawler.crawlerInfo.id}">${crawler.crawlerInfo.desc}</option>
          </c:forEach>
        </select>
        <input type="submit">
      </form>
    </div>
  </div>
</div>
</body>
</html>