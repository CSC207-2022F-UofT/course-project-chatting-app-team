package post_reply_user;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

// Reply class is one of our entities. It is the reply of a post.
public class Reply {
    String userId;
    String content;
    String created_on;
    String postId;
    String id;
//    ArrayList<CommonUser> liked_by;

    public Reply( String id, String userId, String postId, String content, String created_on){

        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.content = content;
        this.created_on = created_on;
//        setLiked_by(liked_by);
        //not used at the moment

    }
    //constructor

    public Reply(String userId, String postId, String content){
        this(UUID.randomUUID().toString(), userId, postId, content, Instant.now().toString());
    }

    // getter
    public String getPostId() {
        return postId;
    }



    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public String getTime() {
        return created_on;
    }


    public String getContent() {
        return content;
    }



}
