$(function () {
    $("#usermanage").click(function () {
        usermanage(1);
        $("#usermanage").css("background","blue");
        $("#refermanage").css("background","white");
        $("#quesmanage").css("background","white");
        $("#answermanage").css("background","white");
        $("#showusermanage").css("display","block");
        $("#showquesmanage").css("display","none");
        $("#showanswermanage").css("display","none");
        $("#pageNum").css("display","block");

    })



    /*$("#refermanage").click(function () {
        refermanage(1);
        $("#refermanage").css("background","blue");
        $("#showrefermanage").css("display","block");
        $("#pageNum").css("display","block");

    })*/
    $("#quesmanage").click(function () {
        quesmanage(1);
        $("#quesmanage").css("background","blue");
        $("#refermanage").css("background","white");
        $("#usermanage").css("background","white");
        $("#answermanage").css("background","white");
        $("#showquesmanage").css("display","block");
        $("#showusermanage").css("display","none");
        $("#showanswermanage").css("display","none");
        $("#pageNum").css("display","block");

    });
    $("#answermanage").click(function () {
        answermanage(1);
        $("#answermanage").css("background","blue");
        $("#refermanage").css("background","white");
        $("#usermanage").css("background","white");
        $("#quesmanage").css("background","white");
        $("#showanswermanage").css("display","block");
        $("#pageNum").css("display","block");
        $("#showquesmanage").css("display","none");
        $("#showusermanage").css("display","none");

    })
})
function deluser(user_id,status,currentPage) {
    var cons = confirm("确认你的操作！")
    if (cons) {
        $.get("/travelknow/user/deluser",{user_id:user_id,status:status},function (data) {

            usermanage(currentPage);
        })
    }

}

function usermanage(current_Page) {
    $.get("/travelknow/place_list/userPageQuery",{current_Page:current_Page},function (pb) {

        var lis = "";

        lis +='<ul id="pageLine" class="pageLine">';
        var firstPage = '<a href="javascript:usermanage(1)"><li>首页</li></a>';
        var beforeNum = pb.currentPage - 1;
        if (beforeNum <1){
            beforeNum = 1
        }
        var beforePage = '<a href="javascript:usermanage('+beforeNum+')"><li>上一页</li></a>';
        var afterNum = pb.currentPage + 1;
        if (afterNum > pb.totalPage){
            afterNum = pb.totalPage
        }

        var afterPage = '<a href="javascript:usermanage('+afterNum+')"><li>下一页</li></a>';


        var lastPage = '<a href="javascript:usermanage('+pb.totalPage+')"><li>末页</li></a>';

        lis +=lastPage;
        lis +=afterPage;
        lis +=beforePage;
        lis +=firstPage;
       $("#pageNum").html(lis);

        var user_lis = ' <tr>\n' +
            '                    <th>用户id</th>\n' +
            '                    <th>用户名</th>\n' +
            '                    <th>用户邮箱</th>\n' +
            '                    <th>用户签名</th>\n' +
            '                    <th>创建时间</th>\n' +
            '                    <th>用户状态</th>\n' +
            '                    <th>操作选项</th>\n' +
            '                </tr>';

        for (var i = 0;i < pb.list.length;i++) {

            /*{"totalCount":20,"totalPage":2,"currentPage":1,"pageSize":10,"
        list":[{"user_id":7,"username":"wsxter","password":"123","email":"xutian583307987@gmail.com","
        autograph":"你还没有签名，快来写一个吧！","role":1,"create_time":1584748800000}*/
            var data = pb.list[i];

            var li = '<tr>\n' +
                '                    <td>'+data.user_id+'</td>\n' +
                '                    <td>'+data.username+'</td>\n' +
                '                    <td>'+data.email+'</td>\n' +
                '                    <td>'+data.autograph+'</td>\n' +
                '                    <td>'+data.create_time+'</td>';

            if(data.status ==1){
                var lia = '<td style="color: #237332">正常</td>';
                var li1 = '<td><button onclick="deluser('+data.user_id+','+data.status+','+pb.currentPage+')">禁言</button></td>\\n\' +\n' +
                    '                   </tr>;'

            }else {
                var lia ='<td style="color: red">禁言</td>'
                var li1 = '<td><button onclick="deluser('+data.user_id+','+data.status+','+pb.currentPage+')">恢复</button></td>\\n\' +\n' +
                    '                   </tr>;'

            }
            user_lis += li;
            user_lis +=lia;
            user_lis +=li1;

        }
        /*user_lis +=lis;*/
        $("#user_table").html(user_lis);

        window.scrollTo(0,0);

    })
}


function quesmanage(current_Page) {
    $.get("/travelknow/fques/findques",{current_Page:current_Page,pageSize:5},function (pb) {

        var lis = "";

        lis +='<ul id="pageLine" class="pageLine">';
        var firstPage = '<a href="javascript:quesmanage(1)"><li>首页</li></a>';
        var beforeNum = pb.currentPage - 1;
        if (beforeNum <1){
            beforeNum = 1
        }
        var beforePage = '<a href="javascript:quesmanage('+beforeNum+')"><li>上一页</li></a>';
        var afterNum = pb.currentPage + 1;
        if (afterNum > pb.totalPage){
            afterNum = pb.totalPage
        }

        var afterPage = '<a href="javascript:quesmanage('+afterNum+')"><li>下一页</li></a>';


        var lastPage = '<a href="javascript:quesmanage('+pb.totalPage+')"><li>末页</li></a>';

        lis +=lastPage;
        lis +=afterPage;
        lis +=beforePage;
        lis +=firstPage;
        $("#pageNum").html(lis);

        var user_lis ='';

        for (var i = 0;i < pb.list.length;i++) {

            /*{{{"totalCount":2,"totalPage":1,"currentPage":1,"pageSize":10,"list":[{"ques_id":1,"ques_name":"小白在做什么？","ques_describle":"科尔沁草原的小白在做什么？","place_name":"黄土高坡"},*/
            var data = pb.list[i];


            var li = '<div id="questionId" class="questionId">\n' +
                '                    <p><span class="ques_name"><strong>'+data.ques_name+'</strong></span><span style="float: right">分类:'+data.place_name+'</span></p>\n' +
                '                    <P class="ques_txt">'+data.ques_describle+'</P>\n' +
                '                </div>';
                var lia ='<p>审核状态：<span class="status">待审核</span></p>';
                var li1 = '<button id="ques_no" class="circlestyle buttonstyle backcolor" style="margin-left: 500px" onclick="delques('+data.ques_id+','+pb.currentPage+')">不予通过</button>\n' +
                    '            <button id="ques_yes" class="circlestyle buttonstyle backcolor" style="margin-left: 50px" onclick="accques('+data.ques_id+','+pb.currentPage+')">通过</button>';


            user_lis += li;
            user_lis +=lia;
            user_lis +=li1;


        }
        console.log(user_lis);
        /*user_lis +=lis;*/
        $("#showquesmanage").html(user_lis);

        window.scrollTo(0,0);


    })
}



//回答
function answermanage(current_Page) {
    $.get("/travelknow/fanswer/findanswer",{current_Page:current_Page,pageSize:1},function (pb) {

        var lis = "";

        lis +='<ul id="pageLine" class="pageLine">';
        var firstPage = '<a href="javascript:answermanage(1)"><li>首页</li></a>';
        var beforeNum = pb.currentPage - 1;
        if (beforeNum <1){
            beforeNum = 1
        }
        var beforePage = '<a href="javascript:answermanage('+beforeNum+')"><li>上一页</li></a>';
        var afterNum = pb.currentPage + 1;
        if (afterNum > pb.totalPage){
            afterNum = pb.totalPage
        }

        var afterPage = '<a href="javascript:answermanage('+afterNum+')"><li>下一页</li></a>';


        var lastPage = '<a href="javascript:answermanage('+pb.totalPage+')"><li>末页</li></a>';


        lis +=afterPage;
        lis +=beforePage;

        $("#pageNum").html(lis);

        var user_lis ='';

        for (var i = 0;i < pb.list.length;i++) {

            /*{{{"totalCount":2,"totalPage":1,"currentPage":1,"pageSize":10,"list":[{"ques_id":1,"ques_name":"小白在做什么？","ques_describle":"科尔沁草原的小白在做什么？","place_name":"黄土高坡"},*/
            var data = pb.list[i];


            var li = '<div id="answerId" class="answerId">\n' +
                '                    <p><span class="ques_name"><strong>'+data.ques_name+'</strong></span><span style="float: right">分类:'+data.place_name+'</span></p>\n' +
                '                    <div id="answer_content" class="answer_content">\n' +
                '                        <P class="ques_txt">'+data.answer_content+'</P>\n' +
                '                    </div>';
            var li1 = '<button id="ques_no" class="circlestyle buttonstyle backcolor" style="margin-left: 500px" onclick="delanswer('+data.answer_id+','+pb.currentPage+')">不予通过</button>\n' +
                '            <button id="ques_yes" class="circlestyle buttonstyle backcolor" style="margin-left: 50px" onclick="accanswer('+data.answer_id+','+pb.currentPage+')">通过</button>';


            user_lis += li;
            user_lis +=li1;


        }
        console.log(user_lis);
        /*user_lis +=lis;*/
        $("#showanswermanage").html(user_lis);

        window.scrollTo(0,0);


    })
}






function delques(ques_id,currentPage) {

    $.get("/travelknow/fques/delques",{ques_id:ques_id},function (pb) {
        quesmanage(currentPage);
    })
}
function accques(ques_id,currentPage) {
    $.get("/travelknow/fques/addques",{ques_id:ques_id},function (pb) {
        quesmanage(currentPage);
    })
}


//不予通过
function delanswer(answer_id,currentPage) {

    $.get("/travelknow/fanswer/delanswer",{answer_id:answer_id},function (pb) {
        answermanage(currentPage);
    })
}
//通过
function accanswer(answer_id,currentPage) {
    $.get("/travelknow/fanswer/addanswer",{answer_id:answer_id},function (pb) {
        answermanage(currentPage);
    })
}