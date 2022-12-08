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
            this.time = this.init_time(messageJson);
            this.message = messageJson.content
            // How many replies need to be displayed
            this.display_reply = this.reply.slice(0,3)
        },
        init_id: function(messageJson){
            Object.defineProperty(this,'id',{value:messageJson.id,writable:false,configurable:false})
        },
        init_nickname: function(messageJson){
            Object.defineProperty(this,'user',{value:messageJson.userId,writable:false,configurable:false})
        },
        init_hasreply: function(messageJson){
            if(messageJson.totalReply != null && messageJson.totalReply.length > 0){
                this.reply = messageJson.totalReply;
                this.has_reply = true;
            }
            else{
                this.reply = [];
                this.has_reply = false;
            }
        },
        init_has_liked: function(messageJson){
            if (messageJson.likedBy == [] || messageJson.likedBy == null){
                this.liked = [];
                this.has_liked = '';
            }
            else {
                this.liked = messageJson.likedBy;
                messageJson.likedBy.indexOf(user.username)!=-1?  this.has_liked = '': this.has_liked = '';
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
            messageJson.img == null ? this.img = [] : this.img = messageJson.img
        },
        determine_user: function(messageJson){
            messageJson.userId == user.username? this.userme = true : this.userme = false
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
        },
        init_time(messageJson){
            let database_time = messageJson.time;
            let current_time = this.get_actual_time();
            if (current_time.substring(5,10)==database_time.substring(5,10)){
                if(current_time.substring(11,13)==database_time.substring(11,13)){
                    return parseInt(current_time.substring(14,16)) - parseInt(database_time.substring(14,16)) + '分钟前'
                }
                return parseInt(current_time.substring(11,13)) - parseInt(database_time.substring(11,13)) + '小时前'
            }
            return database_time.substring(5,10)
        },
        get_actual_time(){
            let current_time = new Date();
            let year = current_time.getUTCFullYear();
            let month = current_time.getUTCMonth() + 1;
            let day = current_time.getUTCDate();
            let hour = current_time.getUTCHours();
            let minute = current_time.getUTCMinutes();
            let second = current_time.getUTCSeconds();
            if(month.length == 1){
                month = '0'+month;
            }
            if(day.length == 1){
                month = '0'+day;
            }
            if(hour.length == 1){
                month = '0'+hour;
            }
            let time = year + "-" + month + "-" + day + "-" + hour + ":" + minute + ":" + second;
            return time;
        }


    }
    Post.prototype.init.prototype = Post.prototype;
    window.Post = Post;


})(window);