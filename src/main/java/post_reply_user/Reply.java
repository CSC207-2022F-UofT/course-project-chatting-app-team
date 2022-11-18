package post_reply_user;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;


public class Reply {
    common_User auther;
    String context;
    int likes;
    String time;
    post_reply_user.Post post;
    ArrayList<post_reply_user.common_User> liked_by;

    public void setPost(post_reply_user.Post post) {
        this.post = post;
    }

    public void setLiked_by(ArrayList<post_reply_user.common_User> liked_by) {
        this.liked_by = liked_by;
    }

    public void setLikes(){
        this.likes = 0;
    }

    public void setAuther(post_reply_user.common_User auther) {
        this.auther = auther;
    }

    public void setTime(String time) {
        this.time = String.valueOf(LocalDateTime.now());
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void like_reply(post_reply_user.common_User user_1){
        this.likes += 1;
        this.liked_by.add(user_1);

    }

}
