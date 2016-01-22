<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加资源</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-xs-12">
                <form action="${path}/admin/resource/add.do" method="post">
                    <div class="form-group">
                        <label>资源url</label>
                        <input class="form-control" name="url" placeholder="请输入资源url">
                    </div>
                    <input class="btn btn-default" type="submit" value="确定">
                </form>
            </div>
        </div>
    </div>
</body>
</html>
