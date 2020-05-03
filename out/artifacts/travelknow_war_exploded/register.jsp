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
    <link rel="stylesheet" href="css/register.css" type="text/css">
    <script src="js/jquery-3.3.1.js" charset="UTF-8"></script>
</head>
<body>
<div class="regster">
    <%--<img src="image/register.jpeg" width="247" height="370">--%>
    <form id="registerform" >
        <div class="regster-box">
            <h1>注册</h1>
            <div class="textbox"  >
                <i>用户名：</i>
                <input id="Username" type="text" placeholder="英文，至少5位" name="username" value=""><br>

            </div>
            <div class="textbox">
                <i>密码：</i>
                <input id="Password"  type="password" placeholder="不得于8位" name="password" value="">
            </div>
            <div class="textbox">
                <i>邮箱：</i>
                <input id="Email"  type="email" placeholder="email" name="email" value="">
            </div>
            <div class="textbox">
                <img src="/travelknow/checkCodeServlet" height="32px" alt="" onclick="changeCheckCode(this)">
                <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>



            </div>
            <input class="btu" type="submit"  name="" value="注册">
        </div>

    </form>
    <div id="errormsg" style="float: right; color: red"></div>
</div>

<script type="text/javascript">
    //图片点击事件
    function changeCheckCode(img) {
        img.src="/travelknow/checkCodeServlet?"+new Date().getTime();
    }
</script>
<script type="text/javascript">
    function checkUsername(){
        var username = $("#Username").val();
        var reg_username = /^\w{5,20}$/;
        var flag = reg_username.test(username);
        if(flag){
            $("#Username").css("color","white");
            $("#errormsg").html("")

        }else{
            $("#Username").css("color","red");
            $("#errormsg").html("用户名格式不正确")
        }
        return flag;
    }
    function checkPassword(){
        var password = $("#Password").val();
        var reg_password = /^\w{8,20}$/;
        var flag = reg_password.test(password);
        if(flag){
            $("#Password").css("color","white");
            $("#errormsg").html("")

        }else{
            $("#Password").css("color","red");
            $("#errormsg").html("密码格式不正确")
        }
        return flag;
    }
    function checkEmail(){
        var email = $("#Email").val();
        var reg_email = /^\w+@\w+\.\w+$/;
        var flag = reg_email.test(email);
        if(flag){
            $("#Email").css("color","white");
            $("#errormsg").html("")

        }else{
            $("#Email").css("color","red");
            $("#errormsg").html("邮件格式不正确")
        }
        return flag;
    }




    $(document).ready(function(){
        $("#registerform").submit(function(){
             if(checkEmail() && checkPassword() && checkUsername()){


            $.post("${pageContext.request.contextPath}/user/register",$("#registerform").serialize(),function(rest){
                console.log(rest);
                if (rest.flag){
                    //注册成功
                    location.replace("${pageContext.request.contextPath}/register_ok.html");
                }else {
                    //注册失败
                    alert(rest.errorMsg);
                    location.replace("${pageContext.request.contextPath}/register.jsp");

                }

            });
            }
            return false;
        });


        $("#Username").blur(checkUsername);
        $("#Password").blur(checkPassword);
        $("#Email").blur(checkEmail);
    });


</script>


</body>
</html>