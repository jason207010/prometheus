<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
  request.setAttribute("path" , path);
%>
<html>
<head>
    <title></title>
</head>
<body>
${path}crawler/add.do
<form action="${path}crawler/add.do" method="post">
  <table>
    <tr>
      <td>描述：</td>
      <td><input name="desc"></td>
    </tr>
    <tr>
      <td>topN：</td>
      <td><input name="topN"></td>
    </tr>
    <tr>
      <td>autoParse：</td>
      <td>
        <select name="autoParse">
          <option value="true">true</option>
          <option value="false">false</option>
        </select>
      </td>
    </tr>
    <tr>
      <td>threadNum：</td>
      <td><input name="threadNum"></td>
    </tr>
    <tr>
      <td>resumable：</td>
      <td>
        <select name="resumable">
          <option value="true">true</option>
          <option value="false">false</option>
        </select>
      </td>
    </tr>
    <tr>
      <td>seed：</td>
      <td><input name="seed[0]"></td>
    </tr>
    <tr>
      <td>regex：</td>
      <td><input name="regex[0]"></td>
    </tr>
    <tr>
      <td>maxRetry：</td>
      <td><input name="maxRetry"></td>
    </tr>
    <tr>
      <td>retry：</td>
      <td><input name="retry"></td>
    </tr>
    <tr>
      <td>depth：</td>
      <td><input name="depth"></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit">
      </td>
    </tr>
  </table>
</form>
</body>
</html>
