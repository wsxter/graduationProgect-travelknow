<%--
  Created by IntelliJ IDEA.
  User: wsxter
  Date: 2020/4/6
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script src="js/wangEditor.min.js"></script>
    <script src="js/jquery-3.3.1.js"></script>
</head>
<body>


                    <!---这里使用wangedite   存储图片使用的base64-->
                    <div id="WangEdite">
                        <p>欢迎使用 wangEditor 富文本编辑器</p>
                    </div>

                <div >
                    <button id="submit" class="btn btn-default">发布文章</button>
                </div>


<script>
    var E = window.wangEditor;
    var editor = new E('#WangEdite');
    editor.customConfig.uploadImgShowBase64 = true ;  // 使用 base64 保存图片
    editor.create();     //创建富文本编辑器

    //点击提交命令，将数据提交到后台
    $("#submit").click(function (){
        var content = editor.txt.html();     //获取富文本数据
        $.post("/travelknow/answerServlet",{content:content},function(data){
            Alert(data);
        },"text");


    });

</script>
</body>
</html>
