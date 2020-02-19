<%--
  Created by IntelliJ IDEA.
  User: meiyukai
  Date: 2020-01-15
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>anno</title>
</head>
<body>

<h2>this is anno page ! </h2>

<a href="/anno/restful/2.do">测试 restful 风格 </a> </br>

<a href="/anno/header.do">测试获取含有Accept 请求头</a> </br>
<a href="/anno/cookie.do">测试获取含有JSESSIONID的 cookie</a> </br>



<form action="/anno/modelAttribute_03.do">
    姓名：<input type="text" name="username"><br/>
    密码：<input type="text" name="password"><br/>
    <input type="submit" value="提交">
</form>

<a href="/anno/testSessionAttribute.do">测试往attribute中保存数据</a> </br>
requestScope  :  ${requestScope.msg}<br/>

SessionScope   :  ${sessionScope.msg}<br/>



<a href="/anno/testGetSessionValue.do">测试从前端数据中取值</a> </br>

<a href="/anno/testClearSession.do">测试清除Session中缓存的数据</a> </br>


</body>
</html>
