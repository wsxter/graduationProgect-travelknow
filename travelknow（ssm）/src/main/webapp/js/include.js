$(function () {
    $.get("header.html",function (data) {
        $("#header").html(data);
    });
    $.get("isfoot.html",function (re) {
        $("#footer").html(re);
    });
    $.get("aside.html",function (re) {
        $("#aside").html(re);
    });
    $.get("aside1.html",function (re) {
        $("#aside1").html(re);
    });

});