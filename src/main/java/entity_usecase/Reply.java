package entity_usecase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Reply {
    User.random_User auther;
    String context;
    int likes;
    String time;
    Post post;
    ArrayList<User.random_User> liked_by;

    public void setPost(Post post) {
        this.post = post;
    }

    public void setLiked_by(ArrayList<User.random_User> liked_by) {
        this.liked_by = liked_by;
    }

    public void setLikes(){
        this.likes = 0;
    }

    public void setAuther(User.random_User auther) {
        this.auther = auther;
    }

    public void setTime(String time) {
        this.time = String.valueOf(new Date());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        this.time = dateFormat.format(time);
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void like_reply(User.random_User user_1){
        this.likes += 1;
        this.liked_by.add(user_1);

    }

}
