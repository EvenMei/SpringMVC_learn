<%--
  Created by IntelliJ IDEA.
  User: meiyukai
  Date: 2020-01-15
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<br>
<head>
    <title>response</title>
    <script src="/js/jquery.min.js"></script>

    <script>

        function modifyUser(){
            alert("message  :  " ) ;
            var user = {"id":"001" , "name":"meimei", "password":"meimei001"};
            $.ajax({
                url:"/response/modify.do",
                type:"post",
                contentType:"application/json;charset=utf-8",
                data:JSON.stringify(user),
                dataType:"json",
                success:function (data) {
                    alert("message  :   "  + data );
                }
            });
        }



    </script>
</head>

<br>

<input type="button" value="modify" onclick="modifyUser()"> </br>

<a href="/response/getUser.do">测试 getUser</a>  </br>

<a href="/response/test_redirect.do">测试重定向</a> </br>

<a href="/response/test_requestDispatcher.do">测试请求转发</a> </br>

<a href="/response/testWrite.do">测试向前端页面输入html 语句</a></br>

<a href="/response/keyword_forward.do">测试关键字forward执行请求转发</a></br>

<a href="/response/keyword_redirect.do">测试关键字 redirect 重定向 </a></br>

<a href="/response/responseUser.do">测试使用 responseBody 向前端直接响应User</a></br>

</body>


</html>
