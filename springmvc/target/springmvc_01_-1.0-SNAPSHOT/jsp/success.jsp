<%--
  Created by IntelliJ IDEA.
  User: meiyukai
  Date: 2020-01-15
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>success</title>
</head>

<body>
<h2> this is success page ! </h2>


姓名   :   ${user.id}  <br/>
用户名   : ${user.name} <br/>
密码   :${user.password} <br/>

</hr>

msg: ${msg} <br/>

requestMsg:${requestScope.Msg} <br/>

responseMsg:${sessionScope.Msg}<br/>

</hr>




</body>

</html>
