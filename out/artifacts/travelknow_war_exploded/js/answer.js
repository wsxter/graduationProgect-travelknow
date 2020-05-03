function writepage() {
    $("#replyid").css("display","inline-block");

}
$(function () {
    //切割传入的place_id
    /* var search = location.search;
     var  place_id = search.split("=")[1];*/
    var question_id = getParameter("question_id");
    var  answer_id = getParameter("answer_id");

    console.log(question_id);
    console.log(answer_id);


    $.get("/travelknow/questionReplyServlet/questionQuery",{question_id:question_id},function (data) {



        var li = '<div class="sponsor ">\n' +
            '        <div class="initiator">\n' +
            '            <a href="#"><div class="sponsor-test">\n' +
            '                <p><img src="image/01.jpg" style="width: 30px;height: 30px;">\n' +
            '                    <span><strong>'+data.customer.username+'</strong></span>发起的提问</p>\n' +
            '            </div>\n' +
            '            </a>\n' +
            '        </div>\n' +
            '\n' +
            '    </div>\n' +
            '    <div class="backcolor9 circlestyle" style="display:inline-block; margin: 5px;float: left"><h2><strong>'+data.question.question_name+'</strong></h2></div>\n' +
            '        <!--<div class="index-answer-inimage">\n' +
            '            <img src="image/01.jpg" width="150" height="70">\n' +
            '        </div>-->\n' +
            '        <div class="question_content">\n' +
            '            <span>'+data.question.ques_describle+'</span>\n' +
            '        </div>\n' +
            '    <div class="index-question-foot">\n' +
            '        <button id="atte" class="buttonstyle backcolor4 circlestyle" onclick="attendques('+data.question.question_id+')">关注问题</button>\n' +
            '        <button class="buttonstyle backcolor5 circlestyle" onclick="writepage()">写回答</button>\n' +

            '        <div class="backcolor2 circlestyle" style="padding: 5px;margin-top: 5px;display: inline-block;float: right;"><span class="ques-type circlestyle">'+data.place.place_name+'</span></div>\n' +
            '\n' +
            '    </div>';
        $("#ques").html(li);

    });



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

    $("#popimg").css("display","none");
    //点击提交命令，将数据提交到后台
    $("#submit").click(function (){
        var content = editor.txt.html();//获取富文本数据

        $.get("/travelknow/user/findUser",{},function(res){
            //获取登录用户数据
            if(res.flag){
                var question_id = getParameter("question_id");
                $.post("/travelknow/answer/submit_answer",{content:content,question_id:question_id},function(data){
                    alert(data.flag);
                },"text");
            }else {
                alert(res.flag);
                window.location.href("/travelknow/ErrorMsg.html");
            }
        })



    });


    $.get("/travelknow/answer/findbyAnswerId",{answer_id:answer_id},function (data) {
/*

    <div class="card1 backcolor circlestyle">
            <a href="#"><span id="nameid"><strong>'+user.username+'</strong></span></a>的回答：
        <div class="answer-introdu">
            <p id="contentid">'+data.answer_content+'</p>
            </div>
            <div class="answer-foot">
            <button class="buttonstyle">赞同:<span id="commentid">'+data.comment_num+'</span></button>
        <button class="buttonstyle">收藏</button>
            <div class="createtime" style="float: right;width: auto;">创建于：<span id="createid">'+data.create_time+'</span></div>

        </div>

        </div>
*/

        $.get("/travelknow/user/userfindone",{user_id:data.user_id},function (res) {

            $("#nameid").html(res.username);
        });
        $("#contentid").html(data.answer_content);

        $("#commentid").html(data.comment_num);
        $("#createid").html(data.create_time);
        window.scrollTo(100, 100);

    }, "json");


    $("#agr").click(function () {
        addcomm(answer_id,1);
    })
    $("#collect").click(function () {
        addcollect(answer_id);
    })
    $.get("/travelknow/agreeoppose/loadjudgment",{answer_id:answer_id,agropp:1},function (res) {
        if (res.flag) {
                $("#agr").html("已赞同");
                $("#agr").css("background", "#2F66DE");
        }
    })

    $.get("/travelknow/collect/loadaddcollect",{answer_id:answer_id},function (res) {

        if (res.flag) {
            $("#collect").html("取消收藏");
            $("#collect").css("background", "#2F66DE");

        }
    })
});
function addcomm(answer_id,agropp) {
    //思路：查询表，看有没有，如果有，返回
    $.get("/travelknow/user/findUser",{},function(res){
        //获取登录用户数据
        if(res.flag){
            $.get("/travelknow/agreeoppose/judgment",{answer_id:answer_id,agropp:agropp},function (res) {
                if (res.flag) {
                    $.get("travelknow/answer/addcomment",{answer_id:answer_id},function (data) {
                        $("#commentid").html(data);
                        $("#commentid").css("background", "#2F66DE");
                    })

                    $("#agr").html("已点赞：");
                }else {
                    alert("点赞不能取消哦");

                }
            })


        }else {

           alert("请登录后尝试")
        }
    })





}
function addcollect(answer_id) {

    $.get("/travelknow/user/findUser",{},function(res){
        //获取登录用户数据
        if(res.flag){
            $.get("/travelknow/collect/addcollect",{answer_id:answer_id},function (res) {

                if (res.flag) {
                    $("#collect").html("取消收藏");
                    $("#collect").css("background", "#2F66DE");

                }else {
                    alert("功能暂未实现")
                }

            })
        }else {
            alert("请登录后尝试")
        }
    })


}
function attendques(question_id) {
    $.post("/travelknow/attend/attendques",{question_id:question_id},function (re) {
        if (re.flag) {
            $("#atte").html("已关注");
        }else {
            $("#atte").html("关注问题");
        }
    })

}