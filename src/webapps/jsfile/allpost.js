// This class initialize the object contain list of post (a post controller)
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
                url: "ServletGetPostGateway", //Servlet04
                async: false,
                success: function (data) {
                    //turn data to array type || 将数据转换成数组
                    console.log(data)
                    data.forEach(function(element,index){
                        this_pointer.postlist[index] = new Post(element);
                    })
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
                url: "sendPostGateway", //java文件名 ser03
                contentType: "application/x-www-form-urlencoded;charset:utf-8;",
                type: "get", //post, send the parameter || post传递参数
                data: { time: timeline, text: content, userName: username }, //send key:values data || 传递参数类型
                async: false,
                success: function (data) {
                    console.log(data[0])
                    new_post = new Post(data[0]);
                    this_pointer.append(new_post);
                },
                error: function (e) {
                    alert("系统出现问题,请重新登陆");
                }
            });
        }
    }
    PostManage.prototype.init.prototype = PostManage.prototype;
    window.PostManage = PostManage;




})(window)

