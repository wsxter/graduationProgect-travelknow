$(function () {
    $.get("login.html",function (data) {
        $("#login-box1").html(data);
    });
    $.get("register.jsp",function (data) {
        $("#register-box1").html(data);
    });
    $("#loginli").click(function () {

        $(document.getElementById("login-box1")).css("display","block");
        $(document.getElementById("register-box1")).css("display","none");

    });
    $("#registerli").click(function () {

        $(document.getElementById("login-box1")).css("display","none");
        $(document.getElementById("register-box1")).css("display","block");

    });

});


function registerPlay() {
    var loginbox = document.getElementById("login-box1");
    loginbox.css("display","block");
}