(function(window){
    function PostManage(){
        return new PostManage.prototype.init()
    }
    PostManage.prototype = {
        constructor: PostManage,
        init: function(){
            this_pointer = this
            this.postlist = []
            this.init_post_list()
        },
        append: function(post){
            this.postlist.unshift(post)
        },
        delete: function(index){
            this.postlist.splice(index,1);
        },
        init_post_list: function(){
            console.log("start the point")
            $.ajax({
                type: "get",
                url: "Servlet04", //Servlet04
                async: false,
                success: function (data) {
                    //turn data to array type || 将数据转换成数组
                    console.log(data);
                    let messageArr = data.split("tbs010143fniwufwifnj+)4733&3uoghqgushvsjcvbjbke3bfb34uofuvhduvwb1=f");
                    for (var i = 0; i <= messageArr.length - 2; i++) {
                        //Vue data
                        this_pointer.postlist[i] = new Post(messageArr, i);
                    }
                    //Make the scrollbar top || 让滚动条处于最顶部(最顶部展示最新消息)
                    $("#top").scrollTop(0);
                },
                error: function (e) {
                    //If request history message fails, return error || 如果请求失败,返回错误问题
                    console.log(e);
                    return;
                }
            });
        },
        write_new_post: function(timeline, content, username){
            $.ajax({
                url: "ser05", //java文件名 ser03
                contentType: "application/x-www-form-urlencoded;charset:utf-8;",
                type: "get", //post, send the parameter || post传递参数
                data: { time: timeline, text: content, userName: username }, //send key:values data || 传递参数类型
                async: false,
                success: function (data) {
                    let messageArr = data.split("tbs010143fniwufwifnj+)4733&3uoghqgushvsjcvbjbke3bfb34uofuvhduvwb1=f");
                    console.log(messageArr)
                    new_post = new Post(messageArr,0);
                    this_pointer.append(new_post);
                },
                error: function (e) {
                    console.log("出现错误:" + e);
                }
            });
        }
    }
    PostManage.prototype.init.prototype = PostManage.prototype;
    window.PostManage = PostManage;




})(window)

