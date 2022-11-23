// This class initialize the Post object
(function(window){
    function Post(messageJson){
        return new Post.prototype.init(messageJson)
    }
    Post.prototype = {
        constructor: Post,
        init: function(messageJson){
            this.init_id(messageJson);
            this.init_nickname(messageJson);
            this.init_has_liked(messageJson);
            this.init_user_pictures(messageJson);
            this.determine_user(messageJson);
            this.init_hasreply(messageJson);
            this.init_post_img(messageJson);
            this.time = messageJson.created_on;
            this.message = messageJson.content
            // How many replies need to be displayed
            this.display_reply = this.reply.slice(0,3)
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
                messageJson.likes.indexOf(user.username)!=-1?  this.has_liked = '': this.has_liked = '';
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
        },
        // choose how many replies to display
        display_replies: function(index){
            if(this.display_reply.length==3 || index == 1){
                this.display_reply = this.reply
            }
            else if (this.display_reply.length == this.reply.length){
                this.display_reply = this.reply.slice(0,3)
            }
            else{

            }
        }


    }
    Post.prototype.init.prototype = Post.prototype;
    window.Post = Post;


})(window);