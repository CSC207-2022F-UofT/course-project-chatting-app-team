package post_reply_user;

import java.util.ArrayList;
class common_User extends User{

    ArrayList<post_reply_user.Post> allPost;
    ArrayList<Reply> allReply;

    public common_User(String nick_name,String pass_word, String avatar){
        super(nick_name, pass_word, avatar);
        setallPost();
        setallReply();

    }

    public void setallPost() {
        this.allPost = new ArrayList<>();
    }

    public void setallReply() {
        this.allReply = new ArrayList<>();
    }

    public String get_nickname(User user_3){
        return user_3.nickname;
    }

    public String get_password(User user_3){
        return user_3.password;
    }

    public String get_avatar(User user_3){
        return user_3.avatar;
    }

    public ArrayList<post_reply_user.Post> get_allPost(common_User user_4){
        return user_4.allPost;
    }

    public ArrayList<Reply> get_allReply(common_User user_4){
        return user_4.allReply;
    }

    public void add_post(post_reply_user.Post post){
        post.getAuther().allPost.add(post);

    }

    public void add_reply(Reply reply){
        reply.auther.allReply.add(reply);
    }

    public int total_num_post(common_User user_1){
        return user_1.allPost.size();
    }

    public int total_num_reply(common_User user_1){
        return user_1.allReply.size();
    }

    public int total_like_received(common_User user_1){
        int num = 0;
        for (Post post: this.allPost){
            num += post.likes;
        }
        return num;
    }

    public int total_reply_received(common_User user_1){
        int num = 0;
        for (Post post: this.allPost){
            num += post.gettotalReply().size();
        }
        return num;
    }

    public void delete_Post(Post post){
        this.allPost.remove(post);
    }

    public void delete_Reply(Reply reply){
        this.allReply.remove(reply);
    }
}


