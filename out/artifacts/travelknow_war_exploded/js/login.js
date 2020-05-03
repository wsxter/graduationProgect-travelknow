$(function () {

    $("#loginFrom").submit(function () {

        $.post("/travelknow/user/login",$("#loginFrom").serialize(),function (data) {
            if (data.flag){
                if (data.errorMsg == null) {
                    window.location.replace("index.html");
                }else {
                    window.location.replace("admin" +
                        ".html");
                }


            }else {

                $("#loginSpan").html(data.errorMsg);
            }
        });
        return false;
    })


})