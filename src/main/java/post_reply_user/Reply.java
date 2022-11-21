package post_reply_user;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;


public class Reply {
    common_User auther;
    String context;
    String time;
    post_reply_user.Post post;
    ArrayList<post_reply_user.common_User> liked_by;

    public Reply(common_User auther, String context, String time, Post post, ArrayList<common_User> liked_by){
        this.time = String.valueOf(LocalDateTime.now());
        setPost(post);
        setAuther(auther);
        setContext(context);
        setLiked_by(liked_by);

    }
    //constructor



    //setter
    public void setPost(post_reply_user.Post post) {
        this.post = post;
    }

    public void setLiked_by(ArrayList<post_reply_user.common_User> liked_by) {
        this.liked_by = liked_by;
    }


    public void setAuther(post_reply_user.common_User auther) {
        this.auther = auther;
    }


    public void setContext(String context) {
        this.context = context;
    }


    //user_1 likes this reply.
    public void like_reply(post_reply_user.common_User user_1){
        this.liked_by.add(user_1);

    }

}
