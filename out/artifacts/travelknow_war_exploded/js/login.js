$(function () {
    $("#loginFrom").submit(function () {

        $.post("/travelknow/user/login",$("#loginFrom").serialize(),function (data) {
            if (data.flag){
                window.location.replace("index.html");
            }else {

                $("#loginSpan").html(data.errorMsg);
            }
        });
        return false;
    })


})