package post_reply_user;

import java.util.ArrayList;
class common_User extends User{

    ArrayList<post_reply_user.Post> allPost;
    ArrayList<Reply> allReply;

    public common_User(String nickname,String password, String avatar){
        super(nickname, password, avatar);
        setallPost();
        setallReply();
        // constructor for common_User

    }

    public void setallPost() {
        this.allPost = new ArrayList<>();
    }
    // set an array list of all posts that this user posted

    public void setallReply() {
        this.allReply = new ArrayList<>();
    }
    //set an array list of all replies that this user replied

    public String get_nickname(){
        return super.nickname;
    }
    //get the nickname of this user

    public String get_password(){
        return super.password;
    }
    //get the password

    public String get_avatar(){
        return super.avatar;
    }
    //get the avatar

    public ArrayList<post_reply_user.Post> get_allPost(){
        return this.allPost;
    }
    //get the list of all posts of this user

    public ArrayList<Reply> get_allReply(){
        return this.allReply;
    }
    //get the list of all replies of this user

    public void add_post(post_reply_user.Post post){
        post.getAuther().allPost.add(post);

    }
    //when user published a post

    public void add_reply(Reply reply){
        reply.auther.allReply.add(reply);
    }
    //when user post a reply

    public int total_num_post(){
        return this.allPost.size();
    }
    //get the number of total posts by the user

    public int total_num_reply(){
        return this.allReply.size();
    }
    //get the number of total replies by the user

    public int total_like_received(){
        int num = 0;
        for (Post post: this.allPost){
            num += post.likedBy.size();
        }
        return num;
    }
    //count the total like that user get from all of their posts.

    public int total_reply_received(common_User user_1){
        int num = 0;
        for (Post post: this.allPost){
            num += post.gettotalReply().size();
        }
        return num;
    }
    //count the total number of reply that they receive from all of their posts.

    public void delete_Post(Post post){
        this.allPost.remove(post);
    }
    //the user delete a post

    public void delete_Reply(Reply reply){
        this.allReply.remove(reply);
    }
    //the user delete a reply


}



