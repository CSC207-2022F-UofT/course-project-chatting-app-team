<%--
  Created by IntelliJ IDEA.
  User: Bruce
  Date: 02/11/2022
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<head>
    <meta charset="utf-8">
    <title></title>
    <style>
        * {
            list-style: none;
            margin: 0px;
            text-decoration: none;
        }
        .toolbar {
            border: solid 1px brown;
            width: 400px;
        }
        .shit {
            border-bottom: solid 1px green;
            color: antiquewhite;
        }
        .shit>.fuck {
            padding: 5px;
            margin-right: 10px;
            margin-left: 10px;
            border: solid 1px yellow;
            display: inline-block;
        }
        .shit>.box {
            border: solid 1px blueviolet;
        }
        .nnn {
            height: 300px;
        }
        .interview {
            width: 300px;
            height: 200px;

            display: block;
            overflow: scroll;
            background-color: white;
            border: solid 1px green;
        }
        .timeline {
            color: grey;
            font-size: 0.8rem;
        }
        .interview>.other{
            color: aquamarine;
        }
        .interview>.userme{
            display: inline-block;
            margin-left: 150px;
        }
        #top {
            position: absolute;
            left: 200px;
            top: 100px;
            z-index: 0;
        }
        #bottom {
            position: absolute;
            left: 200px;
            top: 100px;
            z-index: -1;
        }
    </style>
</head>
<body>
<input placeholder="输入你想要的话" value=""/>
<button>发送</button>
<button>点击切换</button>
<button>点击切换网页(测试)</button>
<span class="interview" id="top">
			<p></p>
			<p class="timeline">2022-10-31-10:46:42</p>
			<p class="other">这是第一段话</p>
		</span>
<span class="interview" id="bottom">
			<p></p>
			<p class="timeline">2022-10-31-10:46:42</p>
			<p class="other">这是第二段话</p>
		</span>
<script>
    $(function(){
        console.log("nihao");
        $.ajax({
            type: "get",
            url: "Servlet04",
            async: false,
            success: function(data){
				console.log(data[18]);
                // $.each(data, function(index, element){
				// 	let content = $('<p class= "userme">'+element["your_own_property"] + '</p>');
				// 	let time = $('<p class = "timeline userme">'+element["theTime"] + '</p>');
				// 	$("#top>p").eq(-1).after(time);
				// 	$("#top>p").eq(-1).after(content);
				// })
            },
            error: function(e){
                console.log(e);
                console.log("发生错误");
            }
        });
        $("button").eq(1).click(function(){
            let user1 = $('#top');
            let user2 = $('#bottom');
            user1.attr("id","bottom");
            user2.attr("id","top");
            console.log("测试一下")
            console.log(user1);
            console.log(user2);
        })
    })
    $("button").eq(0).click(function(){
        // 传递数据
        var absolu = initialWord();
        $.ajax({
            url: "ser03", //java文件名
            contentType: "application/x-www-form-urlencoded;charset:utf-8;",
            type: "get", //post传递参数
            data: {time:absolu[0],text:absolu[1]}, //传递参数类型
            async: false,
            success: function(data){
                //遍历数据 实现array
                console.log("成功");
                console.log(data);
            },
            error: function (e) {
                console.log("出现错误:" + e);
            }
        });


        // 创建文件
        $("input").eq(0).attr("autofocus","true");
    })
    $("button").eq(2).click(function(){
        window.open("163.html");
    })
    function initialWord(){
        var inppp = document.getElementsByTagName("input")[0];
        var intime = initialTime();
        inpContent = inppp.value
        if(inppp.value.trim() == ""){
            inpContent = "[空白文字no]"
        }
        var content = $('<p class= "userme">'+inpContent + '</p>');
        var content_time = $('<p class = "timeline userme">'+intime + '</p>');
        $("#top>p").eq(-1).after(content_time);
        $("#top>p").eq(-1).after(content);
        inppp.value = "";
        return [intime, inpContent]
    }
    function initialTime(){
        let dayTime = new Date();
        let year = dayTime.getFullYear();
        let month = dayTime.getMonth() + 1;
        let day = dayTime.getDate();
        let hour = dayTime.getHours();
        let minute = dayTime.getMinutes();
        let second = dayTime.getSeconds();
        let time = year+"-"+month+"-"+day+"-"+hour+":"+minute+":"+second;
        return time;
    }
    function initialUser(){
        $.ajax({
            type: "get",
            url: "demo.json",
            dataType: "json",
            async: false,
            success: function(data){
                console.log(data[0]["user"]);
            },
            error: function(e){
                console.log(e);
                console.log("发生错误");
            }
        });
    }
</script>
</body>
</html>