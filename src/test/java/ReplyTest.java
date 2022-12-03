import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import post_reply_user.Post;
import post_reply_user.Reply;
import java.util.ArrayList;


public class ReplyTest {
    // set up
    Reply reply1 = new Reply("1", "userId1", "postId1", "reply1", "2022-12-01");

    @Test
    public void testGetPostId() {
        Assertions.assertEquals("postId1", reply1.getPostId());
    }

    @Test
    public void testGetUserId() {
        Assertions.assertEquals("userId1", reply1.getUserId());
    }

    @Test
    public void testGetId() {
        Assertions.assertEquals("1", reply1.getId());
    }

    @Test
    public void testGetTime() {
        Assertions.assertEquals("2022-12-01", reply1.getTime());
    }

    @Test
    public void testGetContent() {
        Assertions.assertEquals("reply1", reply1.getContent());
    }
}
