<%--
  Created by IntelliJ IDEA.
  User: 蒋东雨
  Date: 2016/11/9
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script language="JavaScript">


    </script>
</head>
<body>
<form action="Register" method="get">
    <table>
        <tr>
            <td>用户名：</td><td><input type="text" id="username"  name="username" placeholder="用户名"/></td>
        </tr>

        <tr>
            <td>密码：</td><td><input type="password" id="password1" name="password" placeholder="密码"/></td>
        </tr>

        <tr>
            <td>确认密码：</td><td><input type="password" id="password2" name="password" placeholder="密码"/></td>
        </tr>
        <tr>
            <td> <input type="submit" value="注册" onclick="cheack"></td><td><input type="reset" value="重置"/></td>

        </tr>
    </table>



</form>
</body>
</html>
