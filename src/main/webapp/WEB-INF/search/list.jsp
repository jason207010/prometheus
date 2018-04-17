<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
  String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
  request.setAttribute("path" , path);
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>${keyWord}_千度搜索</title>
  <link rel="stylesheet" href="${path}/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="${path}/lib/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="${path}/css/search/list.css">
  <link rel="stylesheet" href="${path}/css/common.css">
  <script type="text/javascript" src="${path}/lib/jquery-2.1.4.min.js"></script>
  <script type="text/javascript" src="${path}/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
  <script type="application/javascript" src="${path}/js/page.js"></script>
</head>
<body>
  <div class="top">
    <div class="container">
      <div class="row">
        <div class="col-md-9 col-sm-12">
          <div class="row">
            <div class="col-md-2 col-sm-12 text-center">
              <a href="${path}/search/searchIndex.do">
                <img src="${path}/img/logo_top.png">
              </a>
            </div>
            <div class="col-md-8 col-sm-12">
              <form action="${path}/search/search.do" method="post">
                <div class="input-group">
                  <input type="text" class="form-control" name="keyWord" value="${keyWord}">
                  <span class="input-group-btn">
                    <input type="submit" class="btn btn-default" value="千度一下">
                  </span>
                </div>

                <input type="hidden" name="pageSize" value="10">
                <input type="hidden" name="curPage" value="1">

              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="container">
    <c:if test="${empty page.list}">
      <div>
        <p>
          很抱歉，暂时没有您想要的结果。
        </p>
      </div>
    </c:if>
    <c:if test="${not empty page.list}">

    <c:forEach items="${page.list}" var="l">
      <div class="container article">
        <div class="row">
          <div class="col-xs-12">
            <h4>
              <a href="${path}/search/view.do?id=${l.id}" target="_blank">${l.articleTitle}</a>
              <small><a href="${l.url}" target="_blank">查看原文</a></small>
            </h4>

          </div>
          <div class="col-xs-12 no_padding">
            <hr class="no_padding no_margin"/>
          </div>
          <div class="col-xs-12">
            <p>作者：${l.author}</p>
          </div>
        </div>

        <div class="row">
          <div class="col-xs-12">
            <p>${l.articleBody}</p>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>

  <div class="container">
    <div class="page">
      <form action="/search/search.do" method="post" id="pageForm">
        <input type="hidden" name="curPage" value="${page.curPage}">
        <input type="hidden" name="pageSize" value="${page.pageSize}">
        <input type="hidden" name="keyWord" value="${keyWord}">
      </form>
    </div>
  </div>



  <script type="application/javascript">
    $(function(){
      showPages(${page.totalPages},${page.curPage});
    });
  </script>

  </c:if>

  <%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>
