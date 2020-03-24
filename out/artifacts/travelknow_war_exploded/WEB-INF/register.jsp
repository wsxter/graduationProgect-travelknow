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
    <%--<script>

        function refreshCode() {
            var  vode = document.getElementById("vcode");
            vode.src = "${pageContext.request.contextPath}/checkCodeServlet?time="+new date().getTime();
        }
        function checkusername(){
            var username = $("#username").val();
            var reg_username = /^\w{8,20}$/;
            var flag = reg_username.test(username);
            if(flag){
                $("#username").css("border","");

            }else{
                $("#username").css("border","1px soild red");
            }
            return flag;
        }
        function checkpassword(){
            var password = $("#password").val();
            var reg_password = /^\w{8,20}$/;
            var flag = reg_password.test(password);
            if(flag){
                $("#password").css("border","");

            }else{
                $("#password").css("border","1px soild red");
            }
            return flag;
        }
        function checkemail(){
            var email = $("#email").val();
            var reg_email = /^\w+@\w+\.\w+$/;
            var flag = reg_email.test(email);
            if(flag){
                $("#email").css("border","");

            }else{
                $("#email").css("border","1px soild red");
            }
            return flag;
        }
        $(function(){
            $("#formId ").submit(function(){
                return checkusername() && checkpassword() && checkemail();
            });
            $("#username").blur(checkusername);
            $("#password").blur(checkpassword);
            $("#email").blur(checkemail);
        })

    </script>--%>
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
            <input  type="password" placeholder="Passeord" name="password" value="">
        </div>
        <div class="textbox">
            <i>邮箱：</i>
            <input  type="email" placeholder="email" name="email" value="">
        </div>
        <div class="textbox">
            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
            <img src="${pageContext.request.contextPath}/checkCodeServlet" height="32px" alt="" onclick="changeCheckCode(this)">
            <script type="text/javascript">
                //图片点击事件
                function changeCheckCode(img) {
                    img.src="${pageContext.request.contextPath}/checkCodeServlet?"+new Date().getTime();
                }
            </script>
            </a>
        </div>
        <input class="btu" type="submit"  name="" value="注册">
    </div>
    </form>
</div>

</body>
</html>