<%--
  Created by IntelliJ IDEA.
  User: meiyukai
  Date: 2020-01-17
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>文件上传</title>
</head>
<body>

<h2> mvc 实现文件上传</h2></br>

<form action="/upload/commonUpload.do" method="post" enctype="multipart/form-data">
    选择文件： <input type="file" name="upload" /><br/>
    <input type="submit" value="上传">
</form>



<h2> 跨服务器实现文件上传</h2></br>

<form action="/upload/betweenServers.do" method="post" enctype="multipart/form-data">
    选择文件： <input type="file" name="upload" /><br/>
    <input type="submit" value="上传">
</form>


<form action="/hello/converterDate.do" method="post">
    日期 : <input type="text" name="date">
    <input type="submit" value="提交">
</form>






</body>
</html>
