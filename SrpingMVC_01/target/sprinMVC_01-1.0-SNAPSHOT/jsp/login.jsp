<%--
  Created by IntelliJ IDEA.
  User: meiyukai
  Date: 2020-01-18
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>



<body>
            <form action="/interceptor/login.do" method="post">
                用户名 ：<input type="text" name="username"><br>
                密码      : <input type="text" name="password"><br>
                <input type="submit" value="登陆">
            </form>

</body>

</html>
