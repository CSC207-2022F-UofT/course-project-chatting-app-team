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
		/*以上是测试*/
        .interview {
            width: 600px;
            height: 550px;

            display: block;
            overflow: scroll;
            background-color: white;
            border: solid 1px green;

			cursor: default;
        }
        .timeline {
            color: grey;
            font-size: 0.8rem;
        }
        .interview>.other{
        }
        .interview>.userme{
            display: inline-block;
            margin-left: 50%;
        }
		.vip{
			animation-name: vipSpecial;
			animation-iteration-count: infinite;
			animation-duration: 2s;
			animation-timing-function: ease-in;
		}
		@keyframes vipSpecial {
			0% {
				color: aliceblue;
			}
			25% {
				color: aquamarine;
			}
			50% {
				color: blueviolet;
			}
			75% {
				color: aquamarine;
			}
			100% {
				color: aliceblue;
			}
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
<div class="night"></div>
<input placeholder="输入你想要的话" value=""/>
<button>发送</button>
<button>点击切换版面(测试中)</button>
<button>点击切换网页(测试中)</button>
<button id="switch">切换用户(测试中)</button>
<button>点击切换天气(筹备中)</button>
<button id="apply_Vip">点击申请vip,彩虹狗牌(筹备中)</button>
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
	var User;
    $(function(){
        console.log("nihao");
		//cookie设置,之后需要清除重写
		let cookieIndex = document.cookie.indexOf("userName");
		User = document.cookie.substring(cookieIndex + 9);
		if(cookieIndex == -1 || User == "") {
			User = prompt("(测试)用户登录");
			document.cookie = "userName="+ User;
		    //用正则查找违规字符
		    let r = /\W/;
		    while ($.trim(User) == '' || User.search(r) != -1) {
			    User = prompt("NickName中不能出现数字和字母以外的符号!请重新输入,也不能输入空白！");
			    document.cookie = "userName=" + User;
		}
		}
		//loading界面
        $.ajax({
            type: "get",
            url: "Servlet04", //Servlet04
            async: false,
            success: function(data){
				//将数据转换成数组
				console.log(data);
				let messageArr = data.split("tbs010143fniwufwifnj+)4733&3uoghqgushvsjcvbjbke3bfb34uofuvhduvwb1=f");
				console.log(messageArr);
				for(var i = messageArr.length - 2; i >= 0; i--){
					//转化成json形式
					let messageJson = eval("(" + messageArr[i] + ")");
					//根据用户名生成
					let messageClass = 'other'
					//设置UserTag
					let userTag = messageJson.user_nickname;
					//如果是user本人
					if(messageJson.user_nickname == User) {
						messageClass = "userme"
						userTag = "Me"
					}
					//如果是尊贵的vip会员
					let message = $("<p class =" + messageClass + ">" + messageJson.content + "</p>");
					//创建时间元素
					let time = $("<p>" + messageJson.created_on + " <span>(" + userTag + ")<span></p>");
					//纯属娱乐
					if(messageJson.user_nickname == "tianxianbaobao") {
						let vipTitle = "这是尊贵的VIP用户"
						time.attr("title",vipTitle);
						time.children("span").attr("class","vip")
					}
					if(messageJson.user_nickname == "bruce_liu") {
						let descriptiveTitle = "这是个写不完论文的废物"
						time.attr("title",descriptiveTitle);
					}
					if(messageJson.user_nickname == "Dai") {
						let descriptiveTitle = "这是高级数据工程师 + shuaibi"
						time.attr("title",descriptiveTitle);
					}
					time.attr("class", "timeline " + messageClass);

					//创建昵称元素
					let nickname = $("<p class =" + messageClass + ">" + messageJson.user_nickname + "</p>")
					$("#top>p").eq(-1).after(time);
					$("#top>p").eq(-1).after(message);


				}
				//让滚动条处于最底部
				$("#top").scrollTop(10000);
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
	//发送消息
    $("button").eq(0).click(function(){
        // 传递数据
        var absolu = initialWord();
        $.ajax({
            url: "ser03", //java文件名 ser03
            contentType: "application/x-www-form-urlencoded;charset:utf-8;",
            type: "get", //post传递参数
            data: {time:absolu[0],text:absolu[1],userName:User}, //传递参数类型
            async: false,
            success: function(data){
                //遍历数据 实现array
                console.log("成功");
                console.log(eval("(" + data + ")"));
            },
            error: function (e) {
                console.log("出现错误:" + e);
            }
        });

    })
	//前端立即响应发送消息event
    function initialWord(){
        var inppp = document.getElementsByTagName("input")[0];
        var intime = initialTime();
        inpContent = inppp.value
        if(inppp.value.trim() == ""){
            inpContent = "[空白文字no]"
        }
		//此处代码有耦合，注意优化
        var content = $('<p class= "userme">'+inpContent + '</p>');
        var content_time = $('<p class = "timeline userme">'+intime + '<span>(Me)</span></p>');
		if(User == "tianxianbaobao") {
			let vipTitle = "这是尊贵的VIP用户"
			content_time.attr("title",vipTitle);
			content_time.children("span").attr("class","vip")
		}
        $("#top>p").eq(-1).after(content_time);
        $("#top>p").eq(-1).after(content);
        inppp.value = "";
		//让滚轮处于最底部
		$("#top").scrollTop(10000);
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
	//趣味测试
	//网页转换测试
	$("button").eq(2).click(function(){
		window.open("163.html");
	})
	//黑白切换测试
	//切换用户测试
	$("#switch").click(function(){
		document.cookie = 'userName=tianxianbaobao;expires=Fri, 04 Nov 2022 17:59:51 GMT'
		let User = prompt("请输入你想切换的NickName");
		let r = /\W/;
		while ($.trim(User) == '' || User.search(r) != -1) {
			User = prompt("NickName中不能出现数字和字母以外的符号!请重新输入,也不能输入空白！");
			document.cookie = "userName=" + User;
		}
		document.cookie = 'userName='+User;
		location.reload();
	})
	//检查用户拼写规范(还未使用)
	function checkUser(){
		let r = /\W/;
		while ($.trim(User) == '' || User.search(r) != -1) {
			User = prompt("NickName中不能出现数字和字母以外的符号!请重新输入,也不能输入空白！");
			document.cookie = "userName=" + User;
		}
	}
</script>
</body>
</html>