function load(place_id,current_page,question_name){
    $.get("/travelknow/place_list/quesPageQuery",{place_id:place_id,current_Page:current_page,question_name:question_name},function (pb) {


        /*  //创建分页按钮
          var page_lis = "";
          var firstPage = ' <a href=""><li>首页</li></a>';
          var beforePage = '<a href=""><li>上一页</li></a>';
          var lastPage = ' <a href=""><li>首页</li></a>';
          var afterPage = '<a href=""><li>上一页</li></a>';
          page_lis +=firstPage;
          page_lis +=beforePage;
          for (var i = 1;i<=pb.totalPage;i++ ){
              var li = '<li><a href="">'+i+'</a></li>';
              page_lis +=li;
          }

          page_lis +=lastPage;
          page_lis +=afterPage;*/
        var lis = "";
        lis +='<div class="pageNum">';
        lis +='<ul id="pageLine" class="pageLine">';
        var firstPage = '<a href="javascript:load('+place_id+',1,\''+question_name+'\')"><li>首页</li></a>';
        var beforeNum = pb.currentPage - 1;
        if (beforeNum <1){
            beforeNum = 1
        }
        var beforePage = '<a href="javascript:load('+place_id+','+beforeNum+',\''+question_name+'\')"><li>上一页</li></a>';
        var afterNum = pb.currentPage + 1;
        if (afterNum > pb.totalPage){
            afterNum = pb.totalPage
        }

        var afterPage = '<a href="javascript:load('+place_id+','+afterNum+',\''+question_name+'\')"><li>下一页</li></a>';


        var lastPage = ' <a href="javascript:load('+place_id+','+pb.totalPage+',\''+question_name+'\')"><li>末页</li></a>';

        lis +=lastPage;
        lis +=afterPage;
        lis +=beforePage;
        lis +=firstPage;







        //数据展示
        /* k"totalCount":8 有几条数据,"totalPage":有几页,"currentPage":1 当前,"pageSize":5页面大小,
        "list":[{"question_id":6,"user_id":7,"
        question_name":"小白求助！！","
        ques_describle":"2017兴安岭和嫩江从",
        "photo":"xxx","opicId":4,
        "attend_num":23,
        "answer_num":34,
        "create_time":"2020-03-14 00:00:00.0"},*/
        var place_lis = "";
        for (var i = 0;i < pb.list.length;i++) {

            var data = pb.list[i];
            //标签功能：未实现
            place_name = $.get("/travelknow/category/findOne",{opicId:data.opicId},function (name) {
                /*alert(data);*/

                return name;
            });

            if(data.photo != null)
            {


                var li = '<div class="card1 backcolor1 circlestyle"  >\n' +
                    '                 <div class="backcolor9 circlestyle" style="display:inline-block; margin: 5px;"><a href="question-reply.html?question_id='+data.question_id+'" ><h2 ><strong>'+data.question_name+'</strong></h2></a></div>\n' +
                    '                <a href="question-reply.html?question_id='+data.question_id+'"> <div class="index-answer">\n' +
                    '                    <div class="index-answer-inimage">\n' +
                    '                        <img src="' + data.photo + '" width="170" height="80">\n' +
                    '                    </div>\n' +
                    '                    <div class="index-answer-introdu">\n' +
                    '                        <p>' + data.ques_describle + '</p>\n' +
                    '                    </div>\n' +
                    '\n' +
                    '                </div></a>\n' +
                    '                <span class="ques-type"></span>\n' +
                    '\n' +
                    '\n' +
                    '            </div>';
            }
            if(data.photo == null){
                var li ='<div class="card2 backcolor1 circlestyle" xmlns="http://www.w3.org/1999/html">\n' +
                    '                <div class="backcolor9 circlestyle" style="display:inline-block; margin: 5px;"><a href="question-reply.html?question_id='+data.question_id+'" ><h2 ><strong>'+data.question_name+'</strong></h2></a></div>\n' +
                    '\n' +
                    '\n' +
                    '                   <a href="question-reply.html?question_id='+data.question_id+'" <div class="index-answer-introdu2">\n' +
                    '                        <p>'+data.ques_describle+'</p>\n' +
                    '                    </div></a>\n' +
                    '                </a>\n' +
                    '\n' +
                    '                <div class="ques-type"></div>\n' +
                    '\n' +
                    '            </div>';
            }
            place_lis += li;



        }
        place_lis +=lis;
        $("#cards").html(place_lis);

        window.scrollTo(0,0);

    },"json");
}
/*function find_hot(){
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
    var place_id = getParameter("place_id");
    var question_name = getParameter("question_name");
    if (question_name){
        question_name = window.decodeURIComponent(question_name);
    }


    load(place_id,1,question_name);



    /* find_hot();*/

});

