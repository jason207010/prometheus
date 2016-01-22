<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑资源</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-xs-12">
                <form action="${path}/admin/resource/edit.do" method="post">
                    <input type="hidden" value="${entity.id}">
                    <div class="form-group">
                        <label>资源url</label>
                        <input class="form-control" name="url" value="${entity.url}" placeholder="请输入资源url">
                    </div>
                    <input class="btn btn-default" type="submit" value="确定">
                </form>
            </div>
        </div>
    </div>
</body>
</html>
