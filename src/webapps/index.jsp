<%--
  Created by IntelliJ IDEA.
  User: Bruce
  Date: 02/11/2022
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--path for package upload to the server: cd usr/local/Tomcat8.5/webapps/k125--%>
<head>
	<meta charset="utf-8">
	<title></title>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<style>
		/*Please take some time read this before writing CSS!
		请用几分钟详细阅读后再书写CSS!
		CSS coding style: CSS书写规范
		Reference 参考: https://zhuanlan.zhihu.com/p/75946952

		When writing CSS, please follow this type of format for style
		在书写CSS时，请在每个样式声明里保持这样格式,属性请按这样顺序声明
		name {
		    1. first order declaration style type, 首先要最先声明这些属性(如果有):
		    position type,位置属性: position, top, right, z-index, display, float
			2. second order declaration style type,其次再声明这些属性(如果有):
			Box style type,盒子样式属性: width, height, padding, margin
		    3. third type order, font type
		    文字属性 font, line-height, letter-spacing, color- text-align
		    4. forth type order, background type
			背景属性 background, border
			5. fifth type order, animation type
			动画属性 animation, transition

		}
		Summary: position > box type > font type > background type + other > animation
		总结: 位置>盒子格式>盒子内部格式>背景>动画

		2. Please write CSS style in every domain related order.
		   For instance, we have a box with class chatting_app_chatting_room, and a box classed chatting_box inside, and
		   a box classed chatting_message inside chatting_box,
		   please style in this order: chatting_app_chatting_room -> chatting_box -> chatting_message
		   Please do not write chatting_box style underneath other domain class!

		   请把每个CSS元素样式按顺序排列, 比如chatting_app_chatting_room里有一个chatting_box里有一个chatting_message
		   请按如下顺序chatting_app_chatting_room -> chatting_box -> chatting_message
		   不要把chatting_box写在其他大类下面
		   每个大类按顺序写好

		3. Naming rules: when naming class and id, please give element a name that can easily related to its domain and
		   parent, enable others to inspect.
		   命名:命名class与id时,命名能够，跟父元素+此板块+相关功能 相关联,方便他人阅读

		4. It is suggested that you should comment on every style, so that people can understand quickly.
		   Adding reference if necessary
		   建议每个样式都写入注释,方便他人阅读, 如果直接从网页复制,请添加reference以供他人了解

		It is believable that you can become a very elegant frontend constructor after obeying those rules!!!
		Thanks for your time!
		遵循以上书写规范,相信你能成为优秀的前端设计师-----K125-Team-2022.11.07
		 */

		/*CSS project coding 一下为project CSS coding*/
		/* Whole Web CSS Setting 全局设定 */
		* {
			margin: 0px;

			list-style: none;
			text-decoration: none;
		}

		/* font icon, using icomoon, reference: https://icomoon.io/app/#/select/font
		设定个性化字符标签,引入方法:直接输入此icon对应的字符串
		*/
		@font-face {
			font-family: 'icomoon';
			src: url('fonts/icomoon.eot?r27nfd');
			src: url('fonts/icomoon.eot?r27nfd#iefix') format('embedded-opentype'),
			url('fonts/icomoon.ttf?r27nfd') format('truetype'),
			url('fonts/icomoon.woff?r27nfd') format('woff'),
			url('fonts/icomoon.svg?r27nfd#icomoon') format('svg');
			font-weight: normal;
			font-style: normal;
			font-display: block;
		}
		.hide_element {
			display: none;
		}

		/* Five domain CSS design 五大板块 */
		/* 大类: header domain design 头部设计*/
		.chatting_app_header {
			position: relative;
			height: 8%;
			background-color: pink;
		}

		#LoginUser {
			width: 100px;
			height: 20px;
			background-color: beige;
			border-radius: 10%;
		}

		#LoginUser:after {
			color: blueviolet;
		}

		/* 大类: left side domain design 左侧栏目设计 */
		.chatting_app_left_side {
			position: relative;
			float: left;
			height: 84%;
			width: 8%;
			background-color: red;
		}

		/* 大类: chatting room domain design 中部聊天室设计 */
		.chatting_app_chatting_room {
			position: relative;
			float: left;
			height: 84%;
			width: 78%;
			border-radius: 10px 10px;
			background-color: rgb(188, 182, 216);
		}

		/*Chatting window 聊天窗口*/
		.chatting_box {
			display: block;
			height: 90%;
			width: 90%;
			overflow: scroll;
			background-color: transparent;
			border: none;
			cursor: default;
		}

		/*Alter the scrollbar pattern 修改scrollbar外观*/
		/*Reference:https://zhuanlan.zhihu.com/p/457998392*/
		.chatting_box::-webkit-scrollbar {
			width: 10px;
			height: 1px;
		}

		.chatting_box::-webkit-scrollbar-thumb {
			border-radius: 10px;
			background-color: skyblue;
			background-image: -webkit-linear-gradient(45deg,
			rgba(255, 255, 255, 0.2) 25%,
			transparent 25%,
			transparent 50%,
			rgba(255, 255, 255, 0.2) 50%,
			rgba(255, 255, 255, 0.2) 75%,
			transparent 75%,
			transparent);
		}

		.chatting_box::-webkit-scrollbar-track {
			box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
			background: #ededed;
			border-radius: 10px;
		}

		/*chatting window 聊天窗口*/
		.chatting_messageBox {
			transition: 1s;
		}

		.chatting_messageBox:hover {
			background-color: rgb(144, 135, 184)
		}

		#top {
			z-index: 0;
		}

		#bottom {
			position: absolute;
			left: 0%;
			top: 0%;
			z-index: -1;
		}

		.chatting_messageBox>.other {
			margin-left: 10%;
		}

		.chatting_messageBox>.userme {
			display: inline-block;
			margin-left: 50%;
		}

		.timeline {
			color: grey;
			font-size: 0.8rem;
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

		.vip {
			animation-name: vipSpecial;
			animation-iteration-count: infinite;
			animation-duration: 2s;
			animation-timing-function: ease-in;
		}

		/* input box 输入框 */
		.chatting_input_box {
			height: 10%;
			background-color: blue;
		}

		.chatting_input_function {
			width: 100%;
			height: 45%;
			background-color: gold;
		}

		.chatting_input_text {
			float: left;
			width: 86%;
			height: 50%;
			font-size: 1.1em;
			border-radius: 10px 10px;
		}
		/*emoji tab css style 表情符面板CSS样式*/
		.chatting_input_emoji {
			position: relative;
			float: left;
			width: 4%;
			height: 50%;
			padding-top: .6%;
			font-size: 1.5em;
			text-align: center;
			font-family: 'icomoon';
			background-color: transparent;
			user-select: none;
		}

		.chatting_input_emoji:hover {
			color: beige;
		}

		.chatting_input_emoji_tab {
			position: absolute;
			left: -300px;
			top: -300px;
			width: 300px;
			height: 300px;
			background-color: yellow;
		}

		.chatting_input_emoji_tab_header {
			float: left;
			height: 20%;
			width: 100%;
			background-color: purple;
		}

		.exit_emoji_box {
			float: right;
			margin-top: 2%;
			margin-right: 2%;
		}

		.chatting_input_emoji_tab_body {
			float: left;
			height: 80%;
			width: 100%;
			overflow: scroll;
			background-color: skyblue;
		}

		.chatting_input_emoji_tab_body>.chatting_input_emoji_singleword {
			float: left;
			height: 10%;
			width: 10%;
			font-size: .6em;
			text-align: center;
			line-height: 140%;
			background-color: transparent;
			cursor: pointer;
		}
		.chatting_input_emoji_tab_body>.chatting_input_emoji_singleword:hover {
			background-color: grey;
		}

		/*Send message button CSS style\发送信息按钮CSS样式*/
		.chatting_input_submit {
			float: left;
			height: 45%;
			width: 10%;
			margin-top: 0.2%;
			text-align: center;
			line-height: 170%;
			background-color: pink;
			border-radius: 10px 10px;
			cursor: pointer;
			user-select: none;
		}


		/* 大类: right side domain design 右部边栏设计 */
		.chatting_app_right_side {
			position: relative;
			float: left;
			height: 84%;
			width: 14%;
			background-color: violet;
		}

		/* 大类: bottom domain design 底部栏目设计 */
		.chatting_app_bottom {
			position: relative;
			float: left;

			height: 8%;
			width: 100%;
			background-color: grey;
		}
	</style>
</head>

<body>
<!-- Five domain 五大板块 -->

<!-- Header domain 头部栏 -->
<div class="chatting_app_header">
	<div class="night"></div>
	<button id="switch_chatting_box">点击切换版面(测试中)</button>
	<button>点击切换网页(未创建)</button>
	<button id="switch">登录/切换用户(测试中)</button>
	<button id="logout">退出(测试中)</button>
	<button>点击切换天气(筹备中)</button>
	<button id="apply_Vip">点击申请vip,彩虹狗牌(筹备中)</button>
	<div id="LoginUser">尚未登陆</div>
</div>

<!-- left side domain 左侧边栏 -->
<div class="chatting_app_left_side">

</div>

<!-- middle domain:chatting room 聊天室 -->
<div class="chatting_app_chatting_room">
	<div class="chatting_box" id="top">
		<div class="chatting_messageBox">
			<p class="timeline other">2022-10-31-10:46:42</p>
			<p class="other">这是第一段话</p>
		</div>
	</div>
	<div class="chatting_box" id="bottom">
		<p>公共群群2</p>
		<div class="chatting_messageBox">
			<p class="timeline">2022-10-31-10:46:42</p>
			<p class="other">这是第二段话</p>
		</div>
	</div>
	<div class="chatting_input_box">
		<div class="chatting_input_function"></div>
		<input class="chatting_input_text" placeholder="输入你想要的话" value="" />
		<div class="chatting_input_emoji">
			<div class="chatting_input_emoji_tab hide_element">
				<div class="chatting_input_emoji_tab_header">
				</div>
				<div class="chatting_input_emoji_tab_body">
					<div class="chatting_input_emoji_singleword"></div>
					<div class="chatting_input_emoji_singleword">😂</div>
				</div>
			</div>
			<span class="chatting_input_emoji_logo"></span>
		</div>
		<div class="chatting_input_submit"><span class="chatting_input_submit_mark">发送</span></div>
	</div>
</div>

<!-- left side domain 右侧边栏 -->
<div class="chatting_app_right_side">

</div>

<!-- bottom side domain 底部边栏 -->
<div class="chatting_app_bottom">

</div>

<!-- 代码部分(需要js文档与html分离) -->
<script>
	var User; //Prepare to request User information || 准备获取User信息
	// jq framework language || jq语法: $(function(){}) || Immediately execute these function ||刷新时立即响应
	$(function () {
		//acquier the User information||获取用户信息
		//get the cookie if user already login||cookie设置,因为安全问题之后需要清除重写
		let cookieIndex = document.cookie.indexOf("userName");
		User = document.cookie.substring(cookieIndex + 9);
		if (User != '') $("#LoginUser").text(User);


		//Function_piece 1: display the message history || loading界面时，获取并展示历史消息
		display_message_history();
		//Switch the chatting box when click this button || 点击切换版面
		$("#switch_chatting_box").click(function () {
			let user1 = $('#top');
			let user2 = $('#bottom');
			user1.attr("id", "bottom");
			user2.attr("id", "top");
			console.log("测试一下")
			console.log(user1);
			console.log(user2);
		});
		//Function_piece 4: Initialize the emoji tab\生成表情包库
		initialize_emoji_tab();

		$("body").click(function(){
			if ($(".chatting_input_emoji_tab").attr('class')=="chatting_input_emoji_tab"){
				$(".chatting_input_emoji_tab").attr("class","chatting_input_emoji_tab hide_element");
			}
		})
		$(".chatting_input_emoji").bind("click",function(){
			return false;
		})
	})
	//Send message when click this button || 点击按钮发送消息
	$(".chatting_input_submit").click(function () {
		// 传递数据
		//如果没登陆，那么不能发送信息
		if (User == '') {
			alert("请先登录!");
			return
		}
		var absolu = initialWord(); //line 375, display the message just sent || 前端展示刚刚发送消息, 374行
		$.ajax({
			url: "ser03", //java文件名 ser03
			contentType: "application/x-www-form-urlencoded;charset:utf-8;",
			type: "get", //post, send the parameter || post传递参数
			data: { time: absolu[0], text: absolu[1], userName: User }, //send key:values data || 传递参数类型
			async: false,
			success: function (data) {
				//get response from backend || 遍历数据 实现array
				console.log("成功");
				console.log(eval("(" + data + ")"));
			},
			error: function (e) {
				console.log("出现错误:" + e);
			}
		});
		// Form emoji word 生成emoji

	})

	//Function piece part, definition of the function

	//Function_piece 1: Function that show message history\此处function为展示历史记录
	function display_message_history(){
		$.ajax({
			type: "get",
			url: "Servlet04", //Servlet04
			async: false,
			success: function (data) {
				//turn data to array type || 将数据转换成数组
				console.log(data);
				let messageArr = data.split("tbs010143fniwufwifnj+)4733&3uoghqgushvsjcvbjbke3bfb34uofuvhduvwb1=f");
				console.log(messageArr);
				for (var i = messageArr.length - 2; i >= 0; i--) {
					//turn each element in array to json type || 转化成json形式
					let messageJson = eval("(" + messageArr[i] + ")");
					//distinguish other user and "me" || 根据用户名生成，区别“其他用户”和“我”
					let messageClass = 'other'
					//set the user name tag || 设置UserTag(姓名牌)
					let userTag = messageJson.user_nickname;
					//if this message is sent by "me" || 如果是user本人发送的信息
					if (messageJson.user_nickname == User) {
						messageClass = "userme"
						userTag = "Me"
					}
					//build div element || 创建盒子元素
					let messageBox = $("<div class='chatting_messageBox'></div>");
					//build text element, put history message || 创建文本元素
					let message = $("<p class =" + messageClass + ">" + messageJson.content + "</p>");
					//record the time send the element || 创建时间元素
					let time = $("<p>" + messageJson.created_on + " <span>(" + userTag + ")<span></p>");
					//append message element and time element into div element || 盒子中塞入文本和时间元素
					messageBox.append(time);
					messageBox.append(message);

					//This is just for fun || 一下纯属娱乐,vip + title标签测试
					if (messageJson.user_nickname == "tianxianbaobao") {
						let vipTitle = "这是尊贵的VIP用户"
						time.attr("title", vipTitle);
						time.children("span").attr("class", "vip")
					}
					if (messageJson.user_nickname == "bruce_liu") {
						let descriptiveTitle = "这是个写不完论文的废物"
						time.attr("title", descriptiveTitle);
					}
					if (messageJson.user_nickname == "Dai") {
						let descriptiveTitle = "这是高级数据工程师 + shuaibi"
						time.attr("title", descriptiveTitle);
					}
					time.attr("class", "timeline " + messageClass);

					//创建昵称元素(弃用)
					let nickname = $("<p class =" + messageClass + ">" + messageJson.user_nickname + "</p>")
					$("#top>div").eq(0).before(messageBox);


				}
				//Make the scrollbar bottom || 让滚动条处于最底部(最底部展示最新消息)
				$("#top").scrollTop(0);
			},
			error: function (e) {
				//If request history message fails, return error || 如果请求失败,返回错误问题
				console.log(e);
				console.log("Error occur!");
			}
		});
	}
	//Function_piece 2: Display the message at chatting box once click the button || 前端立即响应发送消息event
	function initialWord() {
		var inppp = document.getElementsByTagName("input")[0];
		var intime = initialTime();
		inpContent = inppp.value
		if (inppp.value.trim() == "") {
			inpContent = "[空白文字no]"
		}
		//此处代码有耦合，注意优化
		var messageBox = $("<div class='chatting_messageBox'></div>")
		var content = $('<p class= "userme">' + inpContent + '</p>');
		var content_time = $('<p class = "timeline userme">' + intime + '<span>(Me)</span></p>');
		messageBox.append(content_time);
		messageBox.append(content);
		if (User == "tianxianbaobao") {
			let vipTitle = "这是尊贵的VIP用户"
			content_time.attr("title", vipTitle);
			content_time.children("span").attr("class", "vip")
		}
		$("#top>.chatting_messageBox").eq(0).before(messageBox);
		inppp.value = "";
		// make scrollbar always bottom when sending message 让滚轮处于最底部
		$("#top").scrollTop(0);
		return [intime, inpContent]
	}

	//Function_piece 3: initialize the time\生成时间
	function initialTime() {
		let dayTime = new Date();
		let year = dayTime.getFullYear();
		let month = dayTime.getMonth() + 1;
		let day = dayTime.getDate();
		let hour = dayTime.getHours();
		let minute = dayTime.getMinutes();
		let second = dayTime.getSeconds();
		let time = year + "-" + month + "-" + day + "-" + hour + ":" + minute + ":" + second;
		return time;
	}
	//Function_piece 4: Initialize the emoji tab\生成表情包库
	function initialize_emoji_tab(){
		var emoji = '😀😁😂😃😄😅😆😉😊😋😎😍😘😗😙😚😇😐😑😶😏😣😥😮😯😪😫😴😌😛😜😝😒😓😔😕😲😷😖😞😟😤😢😭😦😧😨😬😰😱😳😵😡😠😈👿👹👺💀👻👽👦👧👨👩👴👵👶👱👮👲👳👷👸💂🎅👰👼💆💇🙍🙎🙅🙆💁🙋🙇🙌🙏👤👥🚶🏃👯💃👫👬👭💏💑👪💪👈👉☝';
		console.log("测试"+emoji.substring(0,2))
		console.log("测试" + '😃')
		for(var i=0;i<emoji.length;i+=2){
			let emoji_singleword = emoji.substring(i,i + 2);
			let chatting_emoji_singleword = $("<div class='chatting_input_emoji_singleword'>"+emoji_singleword+"</div>");
			$(".chatting_input_emoji_tab_body").append(chatting_emoji_singleword);
			console.log(emoji_singleword);
		}
	}
	//clicking chatting_input_emoji show emoji tab
	//点击emoji出现emoji提示库
	//emoji提示词
	$(".chatting_input_emoji").click(function () {
		$(".chatting_input_emoji_tab").toggleClass("hide_element");
		if ($(".chatting_input_emoji_logo").text() == '') {
			$(".chatting_input_emoji_logo").text('')}
		else {
			$(".chatting_input_emoji_logo").text('')
		}
		$("input").focus();
	})
	$(".chatting_input_emoji_tab").bind("click", function(){
		return false
	})
	//input will add the emoji which clicked
	//点击哪个emoji，就添加哪个emoji
	$(".chatting_input_emoji_tab_body").delegate(".chatting_input_emoji_singleword","click", function(){
		if($("input").val() !='') {
			let input_text = $("input").val() + $(this).text();
			$("input").val(input_text);
		}
		else {
			$("input").val($(this).text());
		}
		$("input").focus();
	})


	//some funny extension || 趣味测试
	//jump to another webpage || 网页转换测试
	$("button").eq(1).click(function () {
		window.open("163.html");
	})
	//switch the user || 切换用户测试
	$("#switch").click(function () {
		document.cookie = 'userName=tianxianbaobao;expires=Fri, 04 Nov 2022 17:59:51 GMT'
		let User = prompt("请输入你想切换的NickName");
		let r = /\W/;
		while (User.search(r) != -1) {
			User = prompt("NickName中不能出现数字和字母以外的符号!请重新输入");
			document.cookie = "userName=" + User;
		}
		if ($.trim(User) == '') alert("登录失败,不能输入空白！");
		document.cookie = 'userName=' + User;
		location.reload();
	})
	//when user login, check if user spell right username || 检查用户拼写规范(还未使用)
	function checkUser() {
		let r = /\W/;
		while ($.trim(User) == '' || User.search(r) != -1) {
			User = prompt("NickName中不能出现数字和字母以外的符号!请重新输入,也不能输入空白！");
			document.cookie = "userName=" + User;
		}
	}
	//exit from this user || 退出web
	$("#logout").on("click", function () {
		document.cookie = 'userName=tianxianbaobao;expires=Fri, 04 Nov 2022 17:59:51 GMT';
		User = "";
		location.reload();
	})
</script>
</body>

</html>