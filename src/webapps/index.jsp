<%--
  Created by IntelliJ IDEA.
  User: Bruce
  Date: 02/11/2022
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!-- <%--path for package upload to the server: cd usr/local/Tomcat8.5/webapps/k125--%> -->

<head>
	<meta charset="utf-8">
	<meta name="google-site-verification" content="voj8Ol_S-ikM2atkCkB7B1yjKW-pDuJVGq2cMi403h0" />
	<title></title>
	<script src="https://cdn.staticfile.org/vue/2.7.0/vue.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<script src="jsfile/post.js"></script>
	<script src="jsfile/user.js"></script>
	<script src="jsfile/cat.js"></script>
	<script src="jsfile/allpost.js" type="text/javascript"></script>
	<link rel="stylesheet" href="CSSstyle/popupwindow.css" />
	<link rel="stylesheet" href="CSSstyle/header.css" />
	<link rel="stylesheet" href="CSSstyle/chattingpost.css" />
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
			border: none;
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
		#catKnows {
			float: left;
			width: 30%;
			height: 50%;
			color: black;
			margin-left: 4%;
			font-family: 'icomoon';
			text-align: center;
			line-height: 265px;
			background-color: darkslategrey;
			background-image: url("images/catlink/servercat.jpg");
			background-repeat: no-repeat;
			background-size: cover;
			border-radius: 63%;
		}
		/* 大类: header domain design 头部设计*/
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
			background-color: rgba(249,250,249);
		}
		/*Chatting window 聊天窗口*/
		.chatting_box {
			display: block;
			height: 100%;
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
			margin-left: 50%;
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
		#creater_photo {
			background-image: url("images/creator_photo/creatorphoto.jpeg");
			background-repeat: no-repeat;
			background-size: cover;
		}
		.chatting_reply_function_box {
			margin-top: 10%;
			width: 100%;
			background-color: grey;
		}
		.chatting_post_reply_box>p{
			word-break: break-all;
		}
		.chatting_reply_main {
			float: left;
			margin-bottom: 8%;
			width: 85%;
			max-height: 175px;
			padding-left: 1%;
			font-size: 2.1em;
			border-radius: 5%;
			background: rgba(211, 211, 211, 0.6);
			overflow: scroll;
		}
		.chatting_reply_send {
			float: left;
			margin-left: 1%;
			width: 12%;
			color: dodgerblue;
			font-size: 2em;
			text-align: center;
		}
		.vip {
			animation-name: vipSpecial;
			animation-iteration-count: infinite;
			animation-duration: 2s;
			animation-timing-function: ease-in;
		}
		/* input box 输入框 */
		.chatting_input_box {
		}
		.chatting_input_function {
			width: 100%;
			height: 40%;
			overflow: scroll;
			background-color: gold;
		}
		.chatting_input_text {
			resize: none;
			width: 100%;
			font-size: 1.3em;
			padding-top: 20px;
			padding-left: 20px;
			border: none;
		}
		textarea::-webkit-input-placeholder {
			font-family: 'icomoon';
			color: #24787c;
			font-size: 2em;
		}
		.chatting_input_function_tab {
			height: 10%;
			overflow: hidden;
			background-color: lightgray;
		}
		.chatting_emoji_singles {
			float: left;
			width: 10%;
			height: 25%;
			font-size: 3em;
			text-align: center;
		}
		/*emoji tab css style 表情符面板CSS样式*/
		.chatting_input_emoji {
			position: relative;
			float: left;
			width: 13%;
			height: 100%;
			padding-top: .6%;
			font-size: 4.0em;
			text-align: center;
			font-family: 'icomoon';
			background-color: transparent;
			user-select: none;
		}
		.chatting_input_emoji:hover {
			color: beige;
		}
		.chatting_input_img {
			position: relative;
			float: left;
			width: 13%;
			height: 100%;
			padding-top: .6%;
			font-size: 4.5em;
			text-align: center;
			font-family: 'icomoon';
			background-color: transparent;
			user-select: none;
		}
		/*Send message button CSS style\发送信息按钮CSS样式*/
		.chatting_input_submit {
			float: right;
			height: 81%;
			width: 19%;
			margin-top: 0.7%;
			margin-right: 0.8%;
			font-size: 2em;
			color: #153f54;
			text-align: center;
			line-height: 211%;
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
			background-color: whitesmoke;
		}
		.chatting_app_bottom_function_box {

		}
		.chatting_initial_send {
			float: left;
			margin: 1%;
			color: darkolivegreen;
			font-family: 'icomoon';
			font-size: 5em;
			border-radius: 51%;
			background: dodgerblue;
		}
		/* mobile end webpage alteration */
		@media screen and (max-width: 980px) {
			.chatting_app_left_side {
				display: none;
				background-color: grey;
			}
			.chatting_app_chatting_room {
				width: 100%;
			}
			.chatting_app_right_side {
				display: none;
				background-color: black;
			}
			#catKnows {
				float: left;
				width: 14%;
				height: 83%;
				margin-top: 1%;
				margin-left: 4%;
				color: black;
				font-family: 'icomoon';
				text-align: center;
				line-height: 265px;
				background-color: darkslategrey;
				background-image: url("images/catlink/servercat.jpg");
				background-repeat: no-repeat;
				background-size: cover;
				border-radius: 63%;
			}
			#catKnowsWhatSay{
				float: left;
				width: 52%;
				margin-top: 4%;
				margin-left:1%;
				font-size: 25px;
				word-break: break-word;
				font-family: "icomoon";
			}
		}
	</style>
</head>

<body>
<!-- Five domain 五大板块 -->
<div id="background" class="back">
	<div id="div1" class="content">
		<div id="close">
			<span id="close-button" @click="close_login"></span>
			<h2>Login / Sign Up</h2>
		</div>
		<div id="div2">
			<h3>Password Login</h3>
			<form class="form">
				<label class="account__label"
				>account number
					<input
							class="account"
							type="text"
							placeholder="Please input your account number"
							v-model="nickname"
					/>
				</label>
				<label class="password__label"
				>password
					<input
							class="password"
							type="password"
							placeholder="Please input your password"
							v-model="first_password"
					/>
				</label>
				<label class="password__label password__label__repeat" :style="{'display':display_confirm}"
				>confirm password
					<input
							class="password"
							type="password"
							placeholder="Please input your password"
							v-model="confirm_password"
					/>
				</label>
			</form>
			<div class="buttons">
				<button id="user_login" class="button" @click="login" :style="{'display':display_login}">LOGIN</button>
				<button class="button button--register" @click="register" :style="{'display':display_confirm}">REGISTER</button>
			</div>
		</div>
		<div class="switch_login" @click="switch_login">click here to {{ do_what }}</div>
		<div class="footer" font-family="icomoon">
			<span></span>
			<span></span>
			<span></span>
			<span></span>
			<span></span>
			<span></span>
		</div>
	</div>
</div>
<!-- Header domain 头部栏 -->
<div class="chatting_app_header">
	<%--	<button id="switch_chatting_box">点击切换版面(测试中)</button>--%>
	<%--	<button>点击切换网页(未创建)</button>--%>
	<%--	<button id="switch">登录/切换用户(测试中)</button>--%>
	<%--	<button id="logout">退出(测试中)</button>--%>
	<%--	<button>点击切换天气(筹备中)</button>--%>
	<%--	<button id="apply_Vip">点击申请vip,彩虹狗牌(筹备中)</button>--%>
	<div id="catKnows">你好猫</div>
	<div id="catKnowsWhatSay">(测试中){{ catWord }}</div>
	<div id="LoginUser">请登录</div>
</div>

<!-- left side domain 左侧边栏 -->
<div class="chatting_app_left_side">

</div>

<!-- middle domain:chatting room 聊天室 -->
<div class="chatting_app_chatting_room">
	<div class="chatting_box" id="top">
		<%--		//One example of the post style --%>
		<div class="chatting_post" id="announcement">
			<div class="chatting_post_body" @click="change_index">
				<div class="chatting_post_body_para">
					<div class="chatting_post_body_head">
						<div class="chatting_post_user_pic">
							<div class="user_photo" id="creater_photo"></div>
						</div>
						<span class="chatting_post_user_name">创作者公告栏 Announcement</span>
					</div>
					<div class="chatting_post_body_content" v-if="display_index==1">
						<p color="brown">制作者团队</p>
						<p>我们是热爱计算机的年轻人,致力于创造出更好的作品, 造福人类</p>
						<p>Mike, Michelle, Rannuo, Daii, Karrie, Bruce</p>
						<p>加入我们请致电120</p>
					</div>
					<div class="chatting_post_body_pictures" v-if="display_index==1">
					</div>
					<div class="chatting_function_box" v-if="display_index==1">
						<span class="chatting_post_time">2022.12.05</span>
						<div class="chatting_post_like"><span class="chatting_post_like_count">666</span></div>
					</div>
					<div class="chatting_reply_function_box" v-if="display_index==2">
						<div class="chatting_reply_main" contenteditable="true">你好啊</div><div class="chatting_reply_send">发送</div>
						<div class="chatting_reply_other_function"></div>
					</div>
				</div>
			</div>
		</div>
		<%--	Here is what Vue need to initialize--%>
		<div class="chatting_post_reach_out">
			<div v-for="(post,index) in posts" class="chatting_post">
				<div :class='["chatting_post_body", {"chatting_post_shadow":post.post_shadow}]' :id="post.id" @mousedown="change_shadow($event)" @mouseup="change_shadow($event)">
					<div class="chatting_post_body_para" >
						<div class="chatting_post_body_head" @click="reply(index)">
							<div class="chatting_post_user_pic">
								<div class="user_photo" :style="{'background-image': post.user_pic}"></div>
							</div>
							<span class="chatting_post_user_name">{{ post.user }}</span>
						</div>
						<div class="chatting_post_body_content" @click="reply(index)" :style="{'max-height': index==reply_index? '100%':'300px'}">
							<p>{{ post.message }}</p>
						</div>
						<div class="chatting_post_body_pictures">
							<img v-for="picture in post.img">
						</div>
						<div class="chatting_function_box">
							<span class="chatting_post_time">{{post.time}}</span>
							<div class="chatting_post_like" @click="post_liked">{{ post.has_liked }}<span class="chatting_post_like_count">{{ post.liked.length }}</span></div>
							<span v-if="post.userme" class="chatting_post_delete" @click="deletePost(index)">删除</span>
						</div>
						<div v-if="post.has_reply" class="chatting_post_reply_box" :style="{'background':index==reply_index? 'white':'rgba(233,233,233,.8)'}" @click="reply(index)">
							<p v-for="reply in post.display_reply"><em>{{ reply.user_nickname }}: </em>{{ reply.content }}</p>
							<div v-if="index != reply_index" class="chatting_post_reply_history">--查看历史记录<span>{{ post.reply.length }}</span>条--</div>
						</div>
						<div class="chatting_reply_function_box" v-if="index==reply_index&&User!=''">
							<div class="chatting_reply_main" contenteditable="true"></div><div class="chatting_reply_send" @click="getReplyMessage(index)">发送</div>
							<div class="chatting_reply_other_function"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- chatting post two example -->
		<div class="chatting_post">
			<div class="chatting_post_body">
				<div class="chatting_post_body_para">
					<div class="chatting_post_body_head">
						<div class="chatting_post_user_pic">
							<div class="user_photo"></div>
						</div>
						<span class="chatting_post_user_name">Bruce</span>
					</div>
					<div class="chatting_post_body_content">
						<p>我今天写不完论文了,太难受了</p>
						<p>Robart走起!</p>
					</div>
					<div class="chatting_post_body_pictures">
					</div>
					<div class="chatting_function_box">
						<span class="chatting_post_time">21 小时前</span>
						<div class="chatting_post_like"><span class="chatting_post_like_count">20</span></div>
						<span class="chatting_post_delete">删除</span>
					</div>
					<div class="chatting_post_reply_box">
						<p><em>DingDing:</em>太惨了，论文啥玩意</p>
						<p><em>Xiaobo:</em>哇，你在哪里</p>
						<div class="chatting_post_reply_history">--查看历史记录<span>17</span>条--</div>
					</div>
				</div>
			</div>
		</div>
		<div class="chatting_post">
			<div class="chatting_post_body">
				<div class="chatting_post_body_para">
					<div class="chatting_post_body_head">
						<div class="chatting_post_user_pic">
							<div class="user_photo"></div>
						</div>
						<span class="chatting_post_user_name">Mike</span>
					</div>
					<div class="chatting_post_body_content">
						<p>大家好,我是Mike,我想说两句，今天的月色真美</p>
						<p>月色真美，快看看月亮！</p>
					</div>
					<div class="chatting_post_body_pictures">
						<img>
						<img>
						<img>
					</div>
					<div class="chatting_function_box">
						<span class="chatting_post_time">21 小时前</span>
						<div class="chatting_post_like"><span class="chatting_post_like_count">20</span></div>
						<span class="chatting_post_delete">删除</span>
					</div>
					<div class="chatting_post_reply_box">
						<p><em>Tianxianbaobao:</em>快看看月亮!</p>
						<p><em>Tianxianbaobao:</em>快看看月亮!</p>
						<div class="chatting_post_reply_history">--查看历史记录<span>17</span>条--</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%--	<div class="chatting_box" id="bottom">--%>
	<%--		<p>公共群群2</p>--%>
	<%--	</div>--%>

	<div class="chatting_input_box" :style="{display: input_view, height: input_height}">
		<textarea :style="{height: input_text_height}" class="chatting_input_text" placeholder="把那些心情都讲出来啦" v-model="post_message" maxlength="500" ></textarea>
		<%--		<input class="chatting_input_text" placeholder="输入你想要的话" value="" />--%>
		<div class="chatting_input_function_tab">
			<div class="chatting_input_emoji" v-for="(logo,index) in function_logo" @click="show_tab(index)">
				<span class="chatting_input_emoji_logo">{{logo}}</span>
			</div>
			<div class="chatting_input_submit" @click="sendPost"><span class="chatting_input_submit_mark">发送</span></div>
		</div>
		<div v-if="function_box == 0" class="chatting_input_function">
			<div class="chatting_emoji_singles" v-for="(emoji,index) in emojis" @click="add_emoji(index)">{{emoji}}</div>
		</div>
		<div v-if="function_box == 1" class="chatting_input_function">
			<input type="file">
		</div>
		<div v-if="function_box == 2" class="chatting_input_function">
			<input type="file">
		</div>
		<div v-if="function_box == 3" class="chatting_input_function">

		</div>
	</div>
</div>

<!-- left side domain 右侧边栏 -->
<div class="chatting_app_right_side">

</div>

<!-- bottom side domain 底部边栏 -->
<div class="chatting_app_bottom">
	<div class="chatting_app_bottom_function_box">
		<span class="chatting_initial_send" @click="change_view">{{button_text}}</span>
	</div>
</div>
<script src="https://o.alicdn.com/mecloud/shell/dialog.js"></script>
<script>
	window.AlimeDialog({
		from: 'u7OcXcfF8L'
	});
</script>
<!-- 代码部分(需要js文档与html分离) -->
<script>
	// jq framework language || jq语法: $(function(){}) || Immediately execute these function ||刷新时立即响应
	//initialize the User
	const user = new User();
	//Function_piece 4: Initialize the emoji tab\生成表情包库
	console.log('this will be initialize first');
	//initialize the post history
	const postManage = new PostManage()
	display_message_history();


	// Vue part, user register and login block
	const register_block = new Vue({
		el: "#div1",
		data: {
			display_confirm: 'none',
			display_login:'display',
			do_what:'register',
			nickname:'',
			first_password:'',
			confirm_password:''
		},
		methods: {
			// User choose to login or register
			switch_login: function(){
				if (this.do_what == "login"){
					this.do_what = 'register'
					this.display_confirm = "none"
					this.display_login = 'block'
				}
				else {
					this.do_what = 'login'
					this.display_confirm = "block"
					this.display_login = "none"
				}
			},
			// close login block
			close_login: function(){
				div.style.display = "none";
			},
			login: function(){
				axios.get('login',{params:{username:this.nickname,password:this.first_password}}).
				then(function(res){
					if(res.data == 'success'){
						document.cookie = 'userName=;expires=Fri, 04 Nov 2022 17:59:51 GMT';
						document.cookie = 'password=;expires=Fri, 04 Nov 2022 17:59:51 GMT'
						document.cookie = 'userName=' + register_block.nickname;
						document.cookie = 'password=' + register_block.first_password;
						location.reload();
					}
					else if(res.data=='incorrect'){
						alert('incorrect password, please login again!!!')
					}
					else {
						alert('username does not exist!!!')
					}
				})
			},
			register: function(){
				axios.get('listenRegister',{
					params:{username:this.nickname,password:this.first_password,reEnterPassword:this.confirm_password}})
						.then(function(res){
									if(res.data == 'success'){
										register_block.do_what = 'register'
										register_block.display_confirm = "none"
										register_block.display_login = 'block'
										alert("注册成功！！！");
									}
									else {
										alert(res.data);
									}
								}
						).catch(error=>alert(error));
			}
		}
	})
	// top announcement block
	const announcement_block = new Vue({
		el:"#announcement",
		data:{
			display_index : 0
		},
		methods: {
			change_index: function(){
				console.log("想要加入我们请致电120")
				this.display_index == 0? this.display_index = 1:this.display_index = 0;
			}
		}
	})
	// Display all the post message and its associated method
	const post_block = new Vue({
		el: ".chatting_post_reach_out",
		data: {
			posts: postManage.postlist,
			reply_index: -1
		},
		methods: {
			//change the CSS style when user clicking the post
			change_shadow: function(){

			},
			deletePost: function(index){
				console.log(index);
				axios.get('listenDelete',{params: {username:user.username,id:post_block.posts[index]["id"]}}).then(
						res=>{res.data=="success"? post_block.posts.splice(index,1) : alert("fail to delete this")
						}).catch(error=>alert("fail to delete"));
			},
			// like the post
			post_liked: function(e){
				if (user.username ==''){
					alert("请先登录");
					return;
				}
				let current_id = e.currentTarget.parentElement.parentElement.parentElement.getAttribute("id");
				let status;
				for (let i = 0; i < post_block.posts.length; i++){
					if (post_block.posts[i]["id"] == current_id) {
						if(post_block.posts[i].has_liked == ''){
							post_block.posts[i].has_liked = '';
							post_block.posts[i].liked.push(user.username);
							status = 'liked'
						}
						else{
							status = 'unliked'
							post_block.posts[i].has_liked = '';
							let record_position = post_block.posts[i].liked.indexOf(user.username);
							post_block.posts[i].liked.splice(record_position,1);
						}
						// setTimeout(function(){
						axios.get('listenLikedEvent',{params:{username:user.username,post_id:current_id,event_type:status}}).then(
								function(res){}
						).catch(error=>alert(error))
						// },3000)
					}
				}
			},
			// prepare for reply ( not really send the reply)
			reply: function(index){
				post_block.posts[index].display_replies();
				post_block.posts.forEach(function(element,index2){
					if(index != index2){
						post_block.posts[index2].display_reply = post_block.posts[index2].reply.slice(0,3);
					}
				})
				if(index == post_block.reply_index){
					post_block.reply_index = -1;
				}
				else {
					post_block.reply_index = index;
				}
			},
			// this send the reply message
			getReplyMessage: function(index){
				if (user.username == ''){
					alert('please login');
					return;
				}
				contents = document.getElementsByClassName("chatting_reply_main")[0].innerHTML;
				document.getElementsByClassName("chatting_reply_main")[0].innerHTML = '';
				current_id = post_block.posts[index]["id"];
				axios.get('listenSendReply',{params:{username:user.username,id:current_id,text:contents}}).then(
						function(res){
							post_block.posts[index]["has_reply"] = true
							post_block.posts[index]["reply"].push({content:contents,user_nickname:user.username});
							post_block.posts[index].display_replies(1);
							console.log(res.data)
						}
				).catch(error=>{alert(error)})
			}
		}
	})
	// This is the block for the nav bar
	const headerView = new Vue({
		el: ".chatting_app_header",
		data: {
			catmessage: 'hi',
		},
		computed: {
			// How the cat response to the login
			catWord: function(){
				if(user.username == ''){
					return '喵~啦啦啦,检测到你还没登录，除了浏览功能之外你可能做不了什么欧,要不点一下右侧头像框登录或者注册一下?'
				}
				else {
					return  '喵~你好啊' + user.username + '欢迎来找我,你现在有'+ post_block.posts[0]["liked"].length + '条点赞消息'+post_block.posts[0]["reply"].length + '条回复消息'
				}
			}
		}
	})

	//This is the block for the input bar
	const input_block = new Vue({
		el:".chatting_input_box",
		data:{
			input_view: "none",
			input_height: "0%",
			input_text_height:"90%",
			post_message: '',
			function_box: -1,
			function_logo: [initialize_emoji_logo(),"","",""],
			emojis: initialize_emojis(),
		},
		methods: {
			//change the button pattern when clicking different buttons
			change_input_view: function(){
				let chatting_box = document.getElementsByClassName("chatting_box")[0];
				if(this.input_view === "none"){
					chatting_box.style.height = "50%"
					this.input_view="block"
					this.input_height="50%"
				}
				else {
					chatting_box.style.height = "100%"
					this.input_view="none"
					this.input_height="0%"
				}
			},
			add_emoji: function(index){
				// initialize emoji tab
				console.log(index)
				input_block.post_message +=input_block.emojis[index]
				let chatting_box = document.getElementsByClassName("chatting_input_text")[0];
				chatting_box.focus();
			},
			show_tab: function(index){
				// show the tab matched by the button
				if (this.function_box == index){
					this.input_text_height = "90%"
					this.function_box = -1
					this.function_logo = [initialize_emoji_logo(),"","",""]
				}
				else {
					this.input_text_height = "50%"
					this.function_logo = [initialize_emoji_logo(),"","",""]
					this.function_box = index
					this.function_logo[index] = ''
				}
			},
			sendPost: function(){
				// send the post when clicking the send button
				if(user.username==""){
					alert("请先点右上角头像登录！");
				}
				else{
					let message = this.post_message;
					if(message.trim() === ''){
						alert("别空着阿(#`O′)！");
						return;
					}
					postManage.write_new_post('good',message,user.username);
					$("#top").scrollTop(0);
					bottom_bar.change_view();
				}

			}
		}
	})

	//This is the block for the bottom bar
	const bottom_bar = new Vue({
		el:".chatting_app_bottom",
		data:{
			button_text: ""
		},
		methods: {
			change_view: function(){
				this.button_text==""? this.button_text="":this.button_text=""
				input_block.change_input_view();
			}
		}
	})
	// Event part
	//Response to the click of the body element
	//Click this button to exit from this user || 退出web
	$("#logout").on("click", function () {
		document.cookie = 'userName=tianxianbaobao;expires=Fri, 04 Nov 2022 17:59:51 GMT';
		location.reload();
	})


	//Function piece part, definition of the function
	//Function_piece 1: Function that show message history\此处function为展示历史记录
	function display_message_history() {
		let picture_path = 'url(images/UserPhoto/randomPhoto/randompic8.jpg)'
		$('#LoginUser').css("background-image",picture_path);
		console.log(postManage)
	}
	//Function_piece 4: Initialize the emoji tab\生成表情包库
	function initialize_emojis() {
		var emoji = '😀😁😂😃😄😅😆😉😊😋😎😍😘😗😙😚😇😐😑😶😏😣😥😮😯😪😫😴😌😛😜😝😒😓😔😕😲😷😖😞😟😤😢😭😦😧😨😬😰😱😳😵😡😠😈👿👹👺💀👻👽👦👧👨👩👴👵👶👱👮👲👳👷👸💂🎅👰👼💆💇🙍🙎🙅🙆💁🙋🙇🙌🙏👤👥🚶🏃👯💃👫👬👭💏💑👪💪👈👉☝';
		let emoji_things = [];
		for (var i = 0; i < emoji.length; i += 2) {
			let emoji_singleword = emoji.substring(i, i + 2);
			emoji_things.push(emoji_singleword);
		}
		return emoji_things;
	}
	function initialize_emoji_logo() {
		let icomoon_arr = ['', '', '', '', '', '', '', '', '', ''];
		let random = icomoon_arr[Math.floor((Math.random() * 10))];
		return random
	}
	//when user login, check if user spell right username || 检查用户拼写规范(还未使用)
	function checkUser() {
		let r = /\W/;
		while ($.trim(user.name) == '' || user.username.search(r) != -1) {
			User = prompt("NickName中不能出现数字和字母以外的符号!请重新输入,也不能输入空白！");
			document.cookie = "userName=" + User;
		}
	}
	// login system
	var btn = document.getElementById("LoginUser");
	var div = document.getElementById("background");
	var close = document.getElementById("close-button");

	btn.onclick = function show() {
		div.style.display = "block";
		div.style.zIndex = 10;
	};


	window.onclick = function close(e) {
		if (e.target == div) {
			div.style.display = "none";
		}
	};


</script>
</body>

</html>