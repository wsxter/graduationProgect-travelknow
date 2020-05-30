function writepage() {
    $.get("/travelknow/user/findUser",{},function(res) {
        //获取登录用户数据
        if (res.flag) {
            $("#replyid").css("display", "inline-block");
        } else {
            window.location.href = "errormsg.html";
        }
    });
}



function load(question_id,current_page){
    $.get("/travelknow/place_list/answerPageQuery",{question_id:question_id,current_Page:current_page},function (pb) {



        var lis = "";
        lis +='<div class="pageNum">';
        lis +='<ul id="pageLine" class="pageLine">';
        var firstPage = '<a href="javascript:load('+question_id+',1)"><li>首页</li></a>';
        var beforeNum = pb.currentPage - 1;
        if (beforeNum <1){
            beforeNum = 1
        }
        var beforePage = '<a href="javascript:load('+question_id+','+beforeNum+')"><li>上一页</li></a>';
        var afterNum = pb.currentPage + 1;
        if (afterNum > pb.totalPage){
            afterNum = pb.totalPage
        }

        var afterPage = '<a href="javascript:load('+question_id+','+afterNum+')"><li>下一页</li></a>';


        var lastPage = '<a href="javascript:load('+question_id+','+pb.totalPage+')"><li>末页</li></a>';

        lis +=lastPage;
        lis +=afterPage;
        lis +=beforePage;
        lis +=firstPage;

        var place_lis = "";

        for (var i = 0;i < pb.list.length;i++) {

            /* {"totalCount":36,"totalPage":8,"currentPage":1,"pageSize":5,"
            list":[{"answer_id":1,"user_id":7,"question_id":3,"
            answer_content":"其实我觉得旅游之前要","photo":"xxx",
            "comment_num":24,"create_time":"2020-03-14 00:00:00.0"}
             */
            var data = pb.list[i];







            var li = '<a href="/travelknow/answer.html?question_id='+data.question_id+'&answer_id='+data.answer_id+'"><div class="card1 backcolor7 circlestyle">\n' +
                '                <span><strong>'+pb.place_name[i]+'</strong></span>的回答：\n' +
                '                    <div class="answer-introdu">\n' +
                '                        <p>'+data.answer_content+'</p>\n' +
                '                    </div>\n' +
                '                <div class="answer-foot">\n' +
                '                    <div class="createtime" style="float: right;width: auto;">创建于：<span>'+data.create_time+'</span></div>\n' +
                '\n' +
                '                </div>\n' +
                '\n' +
                '                </div></a> ';


            place_lis += li;

        }
        place_lis +=lis;
        $("#answer_card").html(place_lis);

        window.scrollTo(0,0);

    },"json");
}
/* function find_hot(){
     $.get("/travelknow/place_list/find_hot",{},function (pb) {
         var place_lis = '<div class="msg circlestyle" >热门标签</div>';
         for (var i = 0;i < pb.length;i++) {

             var data = pb[i];
             var li = '<a href="/travelknow/question-reply.html?question_id='+data.question_id+'"><div class="place_lable circlestyle">'+data.question_name+'</div></a>';
             place_lis +=li;
         }
         $("#categoryId").html(place_lis)
     });
 }*/
$(function () {
    //切割传入的place_id
    /* var search = location.search;
     var  place_id = search.split("=")[1];*/
    var question_id = getParameter("question_id");
    var answer_id = getParameter("answer_id");
    if (answer_id) {
        loadindex_reply(answer_id);
    }

    $.get("/travelknow/questionReplyServlet/questionQuery", {question_id: question_id}, function (data) {


        var li = '<div class="sponsor ">\n' +
            '        <div class="initiator">\n' +
            '            <a href="#"><div class="sponsor-test">\n' +
            '                <p><img src="image/01.jpg" style="width: 30px;height: 30px;">\n' +
            '                    <span><strong>' + data.customer.username + '</strong></span>发起的提问</p>\n' +
            '            </div>\n' +
            '            </a>\n' +
            '        </div>\n' +
            '\n' +
            '    </div>\n' +
            '    <div class="backcolor9 circlestyle" style="display:inline-block; margin: 5px;"><h2><strong>' + data.question.question_name + '</strong></h2></div>\n' +
            '        <!--<div class="index-answer-inimage">\n' +
            '            <img src="image/01.jpg" width="150" height="70">\n' +
            '        </div>-->\n' +
            '        <div class="question_content">\n' +
            '            <span>' + data.question.ques_describle + '</span>\n' +
            '        </div>\n' +
            '    <div class="index-question-foot">\n' +
            '        <button id="atte" class="buttonstyle backcolor4 circlestyle" onclick="attendques(' + data.question.question_id + ')">关注问题</button>\n' +
            '        <button class="buttonstyle backcolor5 circlestyle" onclick="writepage()">写回答</button>\n' +
            '        <div class="backcolor2 circlestyle" style="padding: 5px;margin-top: 5px;display: inline-block;float: right;"><span class="ques-type circlestyle">' + data.place.place_name + '</span></div>\n' +
            '\n' +
            '    </div>';
        $("#ques").html(li);

    });
    $.get("/travelknow/user/findUser", {}, function (res) {
        //获取登录用户数据
        if (!res.flag) {
            $("#atte").hide();
        }
    });

    load(question_id, 1);
    /* find_hot();*/





    var E = window.wangEditor;
    var editor = new E('#WangEdite');
    editor.customConfig.uploadImgShowBase64 = true ;

    // 使用 base64 保存图片
    editor.customConfig.menus = [
        'head',
        'bold',
        'italic',
        'underline',
        'emoticon',  // 表情
        'image',// 插入图片
        'undo',  // 撤销
        'redo'  // 重复
    ];
    editor.create();     //创建富文本编辑器

    //点击提交命令，将数据提交到后台
    $("#submit").click(function (){
        var content = editor.txt.html();//获取富文本数据


        $.get("/travelknow/user/findUser",{},function(res){
            //获取登录用户数据
            if(res.flag){
                var question_id = getParameter("question_id");
                $.post("/travelknow/answer/submit_answer",{content:content,question_id:question_id},function(data){

                },"json");
            }else {

                window.location.href("ErrorMsg.html");
            }
        })

        $("#replyid").css("display","none");
        editor.txt.clear();
        alert("回答已经提交，等待审核");

    });
    $.get("/travelknow/attend/attendQuery",{question_id:question_id},function (re) {
        if (re.flag) {
            $("#atte").html("已关注");
        }else {
            $("#atte").html("关注问题");
        }
    })


})
function attendques(question_id) {

    $.post("/travelknow/attend/attendques",{question_id:question_id},function (re) {
        if (re.flag) {
            $("#atte").html("已关注");
        }else {
            $("#atte").html("关注问题");
        }
    })

}
function loadindex_reply(answer_id) {
    $.get("/travelknow/answer/findbyAnswerId",{answer_id:answer_id},function (data) {



        var li = '<div class="card1 backcolor7 circlestyle">\n' +
            '                               <a href="#"><span><strong></strong></span></a>的回答：\n' +
            '                                  <div class="answer-introdu">\n' +
            '                                           <p>'+data.answer_content+'</p>\n' +
            '                                        </div>\n' +
            '                                <div class="answer-foot">\n' +
            '                                       <button class="buttonstyle backcolor4">赞同:<span>'+data.comment_num+'</span></button>\n' +
            '                                    <button class="buttonstyle backcolor6">收藏</button>\n' +
            '                                       <div class="createtime" style="float: right;width: auto;">创建于：<span>'+data.create_time+'</span></div>\n' +
            '\n' +
            '                               </div>\n' +
            '\n' +
            '                          </div>';
        $("#index-reply").html(li);
        $("#index-reply").css("display","block");
    })
}
