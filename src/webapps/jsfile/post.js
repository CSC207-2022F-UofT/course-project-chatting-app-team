
(function(window){
    function Post(messageArray, n){
        return new Post.prototype.init(messageArray,n)
    }
    Post.prototype = {
        constructor: Post,
        init: function(messageArray,n){
            let messageJson = eval("(" + messageArray[n] + ")");
            this.init_id(messageJson);
            this.init_nickname(messageJson);
            this.init_has_liked(messageJson);
            this.init_user_pictures(messageJson);
            this.determine_user(messageJson);
            this.init_hasreply(messageJson);
            this.init_post_img(messageJson);
            this.time = messageJson.created_on;
            this.message = messageJson.content
        },
        init_id: function(messageJson){
            Object.defineProperty(this,'id',{value:messageJson._id,writable:false,configurable:false})
        },
        init_nickname: function(messageJson){
            Object.defineProperty(this,'user',{value:messageJson.user_nickname,writable:false,configurable:false})
        },
        init_hasreply: function(messageJson){
            if(messageJson.replies!=null && messageJson.replies.length > 0){
                this.reply = messageJson.replies;
                this.has_reply = true;
            }
            else{
                this.reply = [];
                this.has_reply = false;
            }
        },
        init_has_liked: function(messageJson){
            if (messageJson.likes == null){
                this.liked = [];
                this.has_liked = '';
            }
            else {
                this.liked = messageJson.likes;
                this.has_liked = '';
            }
        },
        init_user_pictures: function(messageJson){
            if (messageJson.user_pic == null){
                let random_num = Math.floor(Math.random()*10+1)
                let picture_path = 'url(images/UserPhoto/randomPhoto/randompic'+random_num+'.jpg)'
                this.user_pic = picture_path;
                if (messageJson.user_nickname == "tianxianbaobao"){
                    this.user_pic = 'url(images/UserPhoto/tianxianbaobao/headpic.jpg)'
                }
            }
        },
        init_post_img: function(messageJson){
            messageJson == null ? this.img = [] : this.img = messageJson.img
        },
        determine_user: function(messageJson){
            messageJson.user_nickname == user.username? this.userme = true : this.userme = false
        }

    }
    Post.prototype.init.prototype = Post.prototype;
    window.Post = Post;


})(window);

