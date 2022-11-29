package post_post_use_case;

import post_reply_user.Post;

public class ReturnAsPost {
    public Post returnPost(String user, String text){
        return new Post(user, text);
    }
}
