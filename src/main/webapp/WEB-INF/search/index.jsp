<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
  request.setAttribute("path" , path);
%>
<html>
<head>
    <title>千度搜索</title>
  <link rel="stylesheet" href="${path}/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="${path}/lib/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css">
  <script type="text/javascript" src="${path}/lib/jquery-2.1.4.min.js"></script>
  <script type="text/javascript" src="${path}/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="${path}/css/search/index.css">
</head>
<body>
  <div class="container text-center main">
    <div class="row">
      <div class="col-xs-12">
        <img class="logo" src="${path}/img/bd_logo.png">
      </div>
    </div>

    <div class="row">
      <div class="col-md-3 col-xs-1"></div>
      <div class="col-md-6 col-xs-10">
        <form action="${path}/search/search.do" method="post">
        <div class="input-group">
          <input class="form-control" name="keyWord">
          <span class="input-group-btn">
            <input type="submit" class="btn btn-default" value="千度一下">
          </span>
        </div>
        </form>
      </div>
      <div class="col-md-3 col-xs-1"></div>
    </div>
  </div>

  <div class="footer">
    <%@include file="/WEB-INF/footer.jsp"%>
  </div>

</body>
</html>
