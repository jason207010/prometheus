<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>${entity.title}_千度搜索</title>
    <link rel="stylesheet" href="${path}/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/lib/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${path}/css/common.css">
    <script type="text/javascript" src="${path}/lib/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="${path}/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
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
    <div class="row">
        <div class="col-xs-12 text-center"><h3><a href="${entity.url}">${entity.title}</a></h3></div>
    </div>
    <div class="row">
        <div class="col-xs-12 text-center">
            作者：${entity.author}&nbsp;&nbsp;发布时间：${entity.releaseTime}
        </div>
    </div>
    <div class="row"><div class="col-xs-12"><hr/></div></div>
    <div class="row">
        <div class="col-xs-12">${entity.articleBody}</div>
    </div>
    <div class="row"><div class="col-xs-12"><hr/></div></div>
</div>

<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>