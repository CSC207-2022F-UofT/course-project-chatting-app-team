package post_reply_user;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Post {
    String id;
    String userId;
    String content;
    ArrayList<Reply> totalReply;
    ArrayList<String> likedBy;
    String createdOn;

    // constructors
    // most default/barebone constructor, use as many default value as possible. Good for initializing a brand-new post
    public Post(String userId, String content) {
        this(UUID.randomUUID().toString(), userId, content, new ArrayList<>(), new ArrayList<>());
    }
    public Post(String id, String userId, String content, ArrayList<Reply> replies, ArrayList<String> likedBy){
        this(id, userId, content, replies, likedBy, Instant.now().toString());
    }

    public Post(String id, String userId, String content, ArrayList<Reply> replies, ArrayList<String> likedBy, String createdOn){
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.totalReply = replies;
        this.likedBy = likedBy;
        this.createdOn = createdOn;
    }



    //getter
    public ArrayList<String> getLikedBy() {
        return likedBy;
    }

    public String getUserId(){
        return userId;
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }

    public String getTime() {
        return createdOn;
    }

    public ArrayList<Reply> getTotalReply() {
        return this.totalReply;
    }

}