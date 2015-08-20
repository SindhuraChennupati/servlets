<%--
  Created by IntelliJ IDEA.
  User: stevedezitter
  Date: 15/08/15
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

  <form name="loginForm" action="/login" method="POST">
    username: <input type="text" name="username" /><br>
    password: <input type="password" name="password" /><br>
    <input type="submit" value="login"/>
  </form>

</body>
</html>
