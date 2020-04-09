

$(function () {
    $.get("/travelknow/user/findUser",{},function(res){
        //获取登录用户数据
        if(res.flag){
            $("#userpan").html(res.data.username);
            document.getElementById("userzone").href = "/travelknow/userzone.html";
        }else {
            /*alert(res.flag);
            window.location.href("ErrorMsg.html");*/
        }
    })


    $("#exit").click(function () {
        location.replace("/travelknow/user/exit");
    })

    $.get("/travelknow/category/findAll",{},function (data) {
        var lis = '<div class="msg circlestyle" >热门标签</div>';
        for (var i = 0 ;i <data.length; i++) {
            var li = '<div class="place_lable circlestyle"><a href="place_list.html?place_id='+data[i].place_id+'" onclick="tagSearch(data[i].place_id)" >'+data[i].place_name+'</a></div>';
            lis += li;
        }
        $("#categoryId").html(lis);
    },"json");


    var current_page = 1;
    load(current_page);


    $("#allid").click(function () {
        $(".index_answer").css("overflow","visible");
        $(".introdu").css("height","auto");
        $(".allid").css("display","none");
    })


})

function load(current) {

    $.get("/travelknow/recommendServlet",{current_Page:current},function (pb) {


        var hot_lis = '';
        var qq ='<div class="pageNum">';

        var  zz = '<ul id="pageLine" class="pageLine">';
        var beforePage = '<a href="javascript:load(1)"><li>上一页</li></a>';
        var afterPage = '<a href="javascript:load(2)"><li>下一页</li></a>';
        for(var i =0;i<pb.length;i++) {

            /*console.log(pb[i].username);
            if (pb[i].answer){
                console.log((pb[i].answer.answer_id));
            }
            if (pb[i].question) {
                console.log((pb[i].question.question_id));
            }*/
            /*console.log(pb[i].question_id)*/
            if(pb[i].answer !=null){
                /*console.log(pb[i].answer_id)*/


                var  li = '<div class="card1 backcolor7 circlestyle" >\n' +
                    '                <div class="backcolor1 circlestyle" style="display:inline-block; margin: 5px;"><a href="/travelknow/question-reply.html?question_id='+pb[i].answer.question_id+'" ><h2 ><strong>' + pb[i].question_name + '</strong></h2></a></div>\n' +
                    '                <a href="/travelknow/question-reply.html?question_id='+pb[i].answer.question_id+'&answer_id='+pb[i].answer.answer_id+'"><div  id="index_answer" class="index-answer circlestyle">\n' +
                    '                    <div  class="index-answer-introdu introdu" >\n' +
                    '                        <p><span class="backcolor3">'+pb[i].username+'的回答：</span>' + pb[i].answer.answer_content + '</p>\n' +
                    '                    </div>\n' +
                    '                </div></a>\n' +
                    '                <div class="index-answer-foot">\n' +
                    '                    <button class="buttonstyle backcolor4">赞同<span style="display: none">:'+ pb[i].answer.comment_num+'</span></button>\n' +
                    '                    <button class="buttonstyle backcolor6">收藏<span>0</span></button>\n' +
                    '                </div>\n' +
                    '            </div>\n';


            }
            if(pb[i].answer ==null){

                var li = '  <div class="card1 backcolor1 circlestyle" >\n' +
                    '                <div class="backcolor2 circlestyle" style="float: right;padding: 5px;margin-top: 5px;">'+pb[i].place_name+'</div>\n' +
                    '                <div class="backcolor9 circlestyle" style="display:inline-block; margin: 5px;"><a href="/travelknow/question-reply.html?question_id='+pb[i].question.question_id+'" ><h2 ><strong>'+pb[i].question.question_name+'</strong></h2></a></div>\n' +
                    '                <a href="/travelknow/question-reply.html?question_id='+pb[i].question.question_id+'"><div  id="index_answer" class="index-answer circlestyle">\n' +
                    '                    <div  class="index-answer-introdu introdu" >\n' +
                    '                        <p><span class="backcolor3">'+pb[i].username+'的回答：</span>'+pb[i].question.ques_describle+'</p>\n' +
                    '                    </div>\n' +
                    '                </div></a>\n' +
                    '                <div class="index-answer-foot">\n' +
                    '                    <button class="buttonstyle backcolor4">赞同<span style="display: none">:'+pb[i].question.attend_num+'</span></button>\n' +
                    '                    <button class="buttonstyle backcolor6">关注<span>0</span></button>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '    ';


            }
            hot_lis += li;
        }

        hot_lis +=qq;
        hot_lis +=zz;
        hot_lis +=beforePage;
        hot_lis +=afterPage;

        $("#cards").html(hot_lis);
        $("#newest").css("background","#78244c");
        window.scrollTo(0,0);
    },"json");

}