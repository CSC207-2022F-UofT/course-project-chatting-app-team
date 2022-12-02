package post_post_use_case;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import post_reply_user.Post;

import static org.junit.jupiter.api.Assertions.*;

class ReturnAsPostTest {

    // check returnPost method return a post in all situations
    @Test
    void returnPost() {
        ReturnAsPost rePost = new ReturnAsPost();
        Assertions.assertEquals(true, rePost.returnPost(null, null) instanceof Post);
        Assertions.assertEquals(true, rePost.returnPost("", "") instanceof Post);
        Assertions.assertEquals(true, rePost.returnPost("Mike", "Hi") instanceof Post);
    }
}