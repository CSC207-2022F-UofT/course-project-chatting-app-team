package post_reply_user;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Reply {
    CommonUser author;
    String content;
    String time;
    Post post;
    String id;
//    ArrayList<CommonUser> liked_by;

    public Reply(CommonUser author, String content, String id, String time, Post post){
        this.time = time;
        this.post = post;
        this.author = author;
        this.content = content;
        this.id = id;
//        setLiked_by(liked_by);
        //not used at the moment

    }
    //constructor

    public Reply(CommonUser author, String content, String id, Post post){
        this.time = Instant.now().toString();
        this.post = post;
        this.author = author;
        this.content = content;
        this.id = id;
//        setLiked_by(liked_by);
        //not used at the moment

    }



    //setter
    public Post getPost() {
        this.post = post;
    }

//    public void setLiked_by(ArrayList<CommonUser> liked_by) {
//        this.liked_by = liked_by;
//    }


    public String getAuthor() {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getTime() {
        return time;
    }


    public String getContent() {
        this.content = content;
    }


//    //user_1 likes this reply.
//    public void like_reply(CommonUser user_1){
//        this.liked_by.add(user_1);
//
//    }

}
