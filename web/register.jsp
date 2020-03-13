<%--
  Created by IntelliJ IDEA.
  User: wsxter
  Date: 2020/3/12
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>知道*注册</title>
    <link rel="stylesheet" href="css/register.css">
    <script>

        function refreshCode() {
            var  vode = document.getElementById("vcode");
            vode.src = "${pageContext.request.contextPath}/checkCodeServlet?time="+new date().getTime();

        }

    </script>
</head>
<body>
<div class="regster">
    <img src="image/register.jpeg" width="247" height="370">
    <form id="formId " action="${pageContext.request.contextPath}/userRegisterServlet" method="post"><div class="login-box">
        <h1>注册</h1>
        <div class="textbox">
            <i>用户名：</i>
            <input type="text" placeholder="Username" name="username" value="">
        </div>
        <div class="textbox">
            <i>密码：</i>
            <input type="password" placeholder="Passeord" name="password" value="">
        </div>
        <div class="textbox">
            <i>邮箱：</i>
            <input type="email" placeholder="email" name="email" value="">
        </div>
        <div class="textbox">
            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
            <a href="javascript:refreshCode();">
                <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/>
            </a>
        </div>
        <input class="btu" type="submit"  name="" value="注册">
    </div>
    </form>
</div>

</body>
</html>