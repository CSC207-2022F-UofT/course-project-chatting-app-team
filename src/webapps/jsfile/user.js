//(function(window))(window): execute this code immediately after window access this page
(function(window) {
    //define an object User (can be seen as a class)
    function User(pic_path){
        //return its prototype
        return new User.prototype.init(pic_path);
    }
    User.prototype = {
        constructor: User,
        username:'',
        init: function(pic_path){
            this.init_username();
            this.init_user_password();
            this.init_user_picture(pic_path);
            this.init_login_time();
        },
        init_username: function(){
            //allow system to write this value
            let username = this.check_cookie_word('userName'); //notice here is userName not username
            Object.defineProperty(this,'username',{value:username,writable:false,configurable:false});
            if (this.username != '') $("#LoginUser").text(this.username);
        },
        init_user_picture: function(pic_path){
            let random_num = Math.floor(Math.random()*10+1);
            let picture_path = 'url(images/UserPhoto/randomPhoto/randompic8.jpg)'
            $('#LoginUser').css("background-image",picture_path);
            Object.defineProperty(this,'pic_path',{value:picture_path,writable:true,configurable:true});
        },
        init_user_password: function(){
            let password = this.check_cookie_word('password');
            Object.defineProperty(this,'password',{value:password,writable:false,configurable:false});
        },
        check_cookie_word: function(word){
            // input a string key, get the value of this string in cookie
            let value_want = ''
            let cookieIndex = document.cookie.indexOf(word);
            let nextcookie = document.cookie.indexOf(";",cookieIndex + 9);
            if (cookieIndex != -1)
            {
                if (nextcookie != -1) {value_want = document.cookie.substring(cookieIndex + 9, nextcookie);}
                else {value_want = document.cookie.substring(cookieIndex + 9);}
            }
            return value_want
        },
        init_login_time: function(){
            let dayTime = new Date();
            Object.defineProperty(this,'logintime',{value:dayTime,writable:false,configurable:false});
        }
    };
    User.prototype.init.prototype = User.prototype;
    window.User = User;
    
})(window);
