$(function () {
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
    $("#push").click(function (){
        var content = editor.txt.html();//获取富文本数据

        $.get("/travelknow/user/findUser",{},function(res){
            //获取登录用户数据
            if(res.flag){
                var answer_ques = $("#answer-ques").val();
                var answer_quesdesc = $("#answer-quesdesc").val();
                var answer_place = $("#answer-place").val();

                $.post("/travelknow/answer/submit_answer",{content:content,question_name:answer_ques,place_name:answer_place,ques_describle:answer_quesdesc},function(data){

                },"json");
                alert("回答已经提交，待审核通过后显示");

            }else {
                alert(res.flag);
                window.location.href("errormsg.html");
            }
        })
        editor.txt.clear();
        $("#answer-ques").val("");
        $("#answer-quesdesc").val("");
        $("#answer-place").val("");

    });
    $("#answer-ques").keydown(function(event){
        if(event.keyCode == 13){
         /*   alert('你按下了Enter');*/
            var answer_ques=  $("#answer-ques").val();
            $.get("/travelknow/place_list/findlikename",{question_name:answer_ques},function (pb) {
                var lis = '';
                for (var i = 0;i < pb.list.length;i++) {
                    var li = '<a href="#"><li onclick="showquestion('+pb.list[i].question_id+')">'+pb.list[i].question_name+'</li></a>';
                    lis +=li;
                }
                $("#show-quesname").html(lis);
            })

        }
    });
})
function showquestion(question_id) {
    $.get("/travelknow/questionReplyServlet/questionQuery",{question_id:question_id},function (data) {
        /*$("#sys-quesname").html(data.question.question_name);
        $("#sys-quesdesc").html(data.question.ques_describle);
        $("#sys-quesplace").html(data.place.place_name);
        $("#answer-ques").html("display","none" );
        $("#answer-place").html("display","none" );*/
        document.getElementById("answer-ques").value=data.question.question_name;
        document.getElementById("answer-place").value=data.place.place_name;
        document.getElementById("answer-quesdesc").value=data.question.ques_describle;
        $("#show-quesname").css("display","none");




    })

}
