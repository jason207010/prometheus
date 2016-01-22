<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加新爬虫任务</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6 col-xs-12">
            <form action="${path}/admin/crawler/add.do" method="post">
                <div class="form-group">
                    <label>爬虫任务：</label>
                    <select class="form-control" name="id">
                        <c:forEach items="${crawlers}" var="crawler">
                            <option value="${crawler.crawlerInfo.id}">${crawler.crawlerInfo.desc}</option>
                        </c:forEach>
                    </select>
                </div>

                <input class="btn btn-default" type="submit" value="确定">
            </form>
        </div>
    </div>
</div>
</body>
</html>