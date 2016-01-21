<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新用户</title>
</head>
<body>
    <div class="container">
        <form action="${path}/admin/user/add.do" method="post">
        <table class="table">
            <tr>
                <td>用户名：</td>
                <td><input name="name" placeholder="请输入用户名"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input name="password" type="password" placeholder="请输入密码"></td>
            </tr>
            <tr>
                <td>是否可用：</td>
                <td>
                    <select name="enable">
                        <option value="true">是</option>
                        <option value="false">否</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit">
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>
