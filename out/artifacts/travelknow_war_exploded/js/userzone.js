$(function () {
    $.get("/travelknow/user/findUser",{},function(res){
        $("#nickname").html(res.data.username);
        if (res.data.role == 1) {
            $("#rel").html("男");
        }else {
            $("#rel").html("女");
        }


        $("#signature").html(res.data.autograph);



    })

      userAnswerQuery(1);
      $("#quesid ").css("background","white");
        $("#collectid ").css("background","white");
        $("#attendid ").css("background","white");

    $("#quesid").click(function () {
        userQuesQuery(1);
        $("#attendid ").css("background","white");
        $("#collectid ").css("background","white");
        $("#attendid ").css("background","white");
    });
    $("#collectid").click(function () {

        userCollectQuery(1);
        $("#attendid ").css("background","white");
        $("#quesid ").css("background","white");
        $("#attendid ").css("background","white");
    });
    $("#attendid").click(function () {
        userAttendQuery(1);
        $("#quesid ").css("background","white");
        $("#collectid ").css("background","white");
        $("#answerid ").css("background","white");

    });
    $("#nomodifi").click(function () {
        $("#modifi").css("display","block");
        $("#nomodifi").css("display","none");
        $("#registerform").css("display","none");

    });
    $("#updatefotm").submit(function () {
        if(checkEmail() && checkPassword() && checkUsername()) {
            updateCustomer();
        }
        return false;
    })
    $("#modifi").click(function () {
        modifi();
    });
    $("#Username").blur(checkUsername);
    $("#Password").blur(checkPassword);
    $("#Email").blur(checkEmail);

})
function updateCustomer() {
    $.post("/travelknow/user/updateUser",$("#updatefotm").serialize(),function () {
        alert("修改成功，重新登录已以更新信息！");
        window.location.href="/travelknow/home.html"
    })
}
function modifi(){
   /* $("#message").css("display","none");*/
    /*$("#sort").css("display","none");
    $("#show-box").css("display","none");*/
    $("#registerform").css("display","block");
    $("#nomodifi").css("display","block");
    $("#modifi").css("display","none");

    $.get("/travelknow/user/findUser",{},function(res){
        var username = res.data.username;
        console.log(username);
        document.getElementById("Username").value=username;
        if (res.data.role ) {
            document.getElementById("male").checked="true";
        }else {
            document.getElementById("female").checked="true";
        }
        var password = res.data.password;
        document.getElementById("Password").value=password;
        var email = res.data.email;
        document.getElementById("Email").value=email;
        var sign = res.data.autograph;
        document.getElementById("sign").value=sign;


    })
}
function checkUsername(){
    var username = $("#Username").val();
    var reg_username = /^\w{5,20}$/;
    var flag = reg_username.test(username);
    if(flag){
        $("#Username").css("color","black");
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
        $("#Password").css("color","black");
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
        $("#Email").css("color","black");
        $("#errormsg").html("")

    }else{
        $("#Email").css("color","red");
        $("#errormsg").html("邮件格式不正确")
    }
    return flag;
}
function userAnswerQuery(current) {
    $.get("/travelknow/userZone/userZoneQuery",{current_Page:current,buttonCategory:1},function (pb) {

        var hot_lis = '';
        var qq ='<div class="pageNum">';
        var beforeNum = pb.currentPage - 1;
        if (beforeNum <1){
            beforeNum = 1
        }
        var afterNum = pb.currentPage + 1;
        if (afterNum > pb.totalPage){
            afterNum = pb.totalPage
        }

        var  zz = '<ul id="pageLine" class="pageLine">';
        var beforePage = '<a href="javascript:userAnswerQuery('+beforeNum+')"><li class="circlestyle">上一页</li></a>';
        var afterPage = '<a href="javascript:userAnswerQuery('+afterNum+')"><li class="circlestyle">下一页</li></a>';
        for(var i =0;i<pb.list.length;i++) {



                var  li = '<div class="card1 backcolor7 circlestyle" >\n' +
                    '     <div class="backcolor1 circlestyle" style="display:inline-block; margin: 5px;"><a href="/travelknow/question-reply.html?question_id='+pb.list[i].question_id+'" ><h2 ><strong>'+pb.place_name[i]+'</strong></h2></a></div>\n' +
                    '                <a href="/travelknow/answer.html?question_id='+pb.list[i].question_id+'&answer_id='+pb.list[i].answer_id+'"><div  id="index_answer" class="index-answer circlestyle">\n' +
                    '                    <div  class="index-answer-introdu introdu" >\n' +
                    '                        <p><span class="backcolor3">我的回答：</span>' + pb.list[i].answer_content + '</p>\n' +
                    '                    </div>\n' +
                    '                </div></a>\n' +
                    '            </div>\n';




            hot_lis += li;
        }

        hot_lis +=qq;
        hot_lis +=zz;
        hot_lis +=beforePage;
        hot_lis +=afterPage;

        $("#show-box").html(hot_lis);
        $("#answerid").css("background","#379683");
        window.scrollTo(0,0);

    })
}
function userQuesQuery(current) {
    $.get("/travelknow/userZone/userZoneQuery", {current_Page: current, buttonCategory: 2}, function (pb) {

        var hot_lis = '';
        var qq = '<div class="pageNum">';
        var beforeNum = pb.currentPage - 1;
        if (beforeNum < 1) {
            beforeNum = 1
        }
        var afterNum = pb.currentPage + 1;
        if (afterNum > pb.totalPage) {
            afterNum = pb.totalPage
        }

        var zz = '<ul id="pageLine" class="pageLine">';
        var beforePage = '<a href="javascript:userQuesQuery(' + beforeNum + ')"><li class="circlestyle">上一页</li></a>';
        var afterPage = '<a href="javascript:userQuesQuery(' + afterNum + ')"><li class="circlestyle">下一页</li></a>';
        for (var i = 0; i < pb.list.length; i++) {
            var  li = ' <div class="card1 backcolor1 circlestyle" >\n' +
                '                 <div class="backcolor2 circlestyle" style="float: right;padding: 5px;margin-top: 5px;">'+pb.place_name[i]+'</div>\n' +
                '                    <div class="backcolor9 circlestyle" style="display:inline-block; margin: 5px;"><a href="/travelknow/question-reply.html?question_id='+pb.list[i].question_id+'" ><h2 ><strong>'+pb.list[i].question_name+'</strong></h2></a></div>\n' +
                '                       <a href="/travelknow/question-reply.html?question_id='+pb.list[i].question_id+'"><div  id="index_answer" class="index-answer circlestyle">\n' +
                '                            <div  class="index-answer-introdu introdu" >\n' +
                '                               <p><span class="backcolor3"></span>'+pb.list[i].ques_describle+'</p>\n' +
                '                           </div>\n' +
                '                      </div></a>\n' +
                '                    </div>\n' +
                '                ';
            hot_lis += li;
        }
        hot_lis +=qq;
        hot_lis +=zz;
        hot_lis +=beforePage;
        hot_lis +=afterPage;

        $("#show-box").html(hot_lis);
        $("#quesid").css("background","#379683");
        window.scrollTo(0,0);

    })
}
function userCollectQuery(current) {
    $.get("/travelknow/userZone/userZoneQuery", {current_Page: current, buttonCategory: 3}, function (pb) {

        var hot_lis = '';
        var qq = '<div class="pageNum">';
        var beforeNum = pb.currentPage - 1;
        if (beforeNum < 1) {
            beforeNum = 1
        }
        var afterNum = pb.currentPage + 1;
        if (afterNum > pb.totalPage) {
            afterNum = pb.totalPage
        }

        var zz = '<ul id="pageLine" class="pageLine">';
        var beforePage = '<a href="javascript:userCollectQuery(' + beforeNum + ')"><li class="circlestyle">上一页</li></a>';
        var afterPage = '<a href="javascript:userCollectQuery(' + afterNum + ')"><li class="circlestyle">下一页</li></a>';
        for (var i = 0; i < pb.list.length; i++) {

            var  li = '<div class="card1 backcolor7 circlestyle" >\n' +
                '     <div class="backcolor1 circlestyle" style="display:inline-block; margin: 5px;"><a href="/travelknow/question-reply.html?question_id='+pb.list[i].question_id+'" ><h2 ><strong>'+pb.list[i].question_name+'</strong></h2></a></div>\n' +
                '                <a href="/travelknow/answer.html?answer_id='+pb.list[i].answer_id+'"><div  id="index_answer" class="index-answer circlestyle">\n' +
                '                    <div  class="index-answer-introdu introdu" >\n' +
                '                        <p><span class="backcolor3">我的回答：</span>' + pb.list[i].answer_content + '</p>\n' +
                '                    </div>\n' +
                '                </div></a>\n' +
                '            </div>\n';




            hot_lis += li;
        }

        hot_lis +=qq;
        hot_lis +=zz;
        hot_lis +=beforePage;
        hot_lis +=afterPage;

        $("#show-box").html(hot_lis);
        $("#collectid").css("background","#379683");
        window.scrollTo(0,0);
    });

}
function userAttendQuery(current) {
    $.get("/travelknow/userZone/userZoneQuery", {current_Page: current, buttonCategory: 4}, function (pb) {

        var hot_lis = '';
        var qq = '<div class="pageNum">';
        var beforeNum = pb.currentPage - 1;
        if (beforeNum < 1) {
            beforeNum = 1
        }
        var afterNum = pb.currentPage + 1;
        if (afterNum > pb.totalPage) {
            afterNum = pb.totalPage
        }

        var zz = '<ul id="pageLine" class="pageLine">';
        var beforePage = '<a href="javascript:userAttendQuery(' + beforeNum + ')"><li class="circlestyle">上一页</li></a>';
        var afterPage = '<a href="javascript:userAttendQuery(' + afterNum + ')"><li class="circlestyle">下一页</li></a>';
        for (var i = 0; i < pb.list.length; i++) {
            var  li = ' <div class="card1 backcolor1 circlestyle" >\n' +
                '                 <div class="backcolor2 circlestyle" style="float: right;padding: 5px;margin-top: 5px;">'+pb.place_name[i]+'</div>\n' +
                '                    <div class="backcolor9 circlestyle" style="display:inline-block; margin: 5px;"><a href="/travelknow/question-reply.html?question_id='+pb.list[i].question_id+'" ><h2 ><strong>'+pb.list[i].question_name+'</strong></h2></a></div>\n' +
                '                       <a href="/travelknow/question-reply.html?question_id='+pb.list[i].question_id+'"><div  id="index_answer" class="index-answer circlestyle">\n' +
                '                            <div  class="index-answer-introdu introdu" >\n' +
                '                               <p><span class="backcolor3"></span>'+pb.list[i].ques_describle+'</p>\n' +
                '                           </div>\n' +
                '                      </div></a>\n' +
                '                    </div>\n' +
                '                ';
            hot_lis += li;
        }
        hot_lis +=qq;
        hot_lis +=zz;
        hot_lis +=beforePage;
        hot_lis +=afterPage;

        $("#show-box").html(hot_lis);
        $("#attendid").css("background","#379683");
        window.scrollTo(0,0);

    })
}