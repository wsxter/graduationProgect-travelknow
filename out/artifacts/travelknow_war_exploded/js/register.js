function checkUsername(){
    var username = $("#Username").val();
    var reg_username = /^\w{3,8}$/;
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
        // if(checkEmail() && checkPassword() && checkUsername()){


        $.post("/user/register",$("#formId").serialize(),function(rest){
            console.log(rest);
            if (rest.flag){
                //注册成功
                location.replace("/register_ok.html");
            }else {
                //注册失败
                alert(rest.errorMsg);
                location.replace("/register.html");

            }

        });
        // }
        return false;
    });


    $("#Username").blur(checkUsername);
    $("#Password").blur(checkPassword);
    $("#Email").blur(checkEmail);
});

function changeCheckCode(img) {
    img.src="/travelknow/checkCodeServlet?"+new Date().getTime();
}