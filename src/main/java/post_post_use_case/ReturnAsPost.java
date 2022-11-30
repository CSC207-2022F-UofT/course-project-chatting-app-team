package post_post_use_case;

import post_reply_user.Post;

// the class has a method that can return information to be a post.
public class ReturnAsPost {
    public Post returnPost(String user, String text){
        return new Post(user, text);
    }
}