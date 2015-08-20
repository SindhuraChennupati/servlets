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
  <link rel="stylesheet" type="text/css" href="/css/servletdemo.css">
</head>
<body>
  <header>
    welcome ${sessionScope.principal.username}
    <a href="/logout">logout</a>
  </header>
</body>
</html>