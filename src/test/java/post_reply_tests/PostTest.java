package post_reply_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import post_reply_user.CommonUser;
import post_reply_user.Post;
import post_reply_user.Reply;
import java.util.ArrayList;


public class PostTest {
    // set up replies for the ArrayList of replies in test cases.
    Reply reply1 = null;
    Reply reply2 = null;
    Reply reply3 = null;
    Reply reply4 = null;
    Reply reply5 = null;
    Reply reply6 = null;

    @BeforeEach
    public void setup(){
        reply1 = new Reply("1","userId1","postId2","reply1","2022-12-01");
        reply2 = new Reply("2","userId2","postId3","reply2","2021-12-01");
        reply3 = new Reply("3","userId3","postId3","reply3","2020-12-01");
        reply4 = new Reply("4","userId4","postId3","reply4","2022-11-01");
        reply5 = new Reply("5","userId5","postId3","reply5","2021-11-01");
        reply6 = new Reply("6","userId6","postId3","reply6","2020-11-01");

    }

    // Test GetLikedBy
    // Since LikedBy is a ArrayList, we will test three scenarios:
    // no user liked the post, one user liked the post, multiple users liked the post.
    @Test
    public void testGetLikedByNoUser() {
        ArrayList<String> likedBy2 = new ArrayList<>();
        Post post2 = new Post("postId2", "userId2", "post2 content", null, likedBy2,
                "2022-12-01");
        Assertions.assertEquals(likedBy2, post2.getLikedBy());
    }

    @Test
    public void testGetLikedByOneUser() {
        ArrayList<String> likedBy1 = new ArrayList<>();
        likedBy1.add("user1");
        Post post1 = new Post("postId1", "userId1", "post1 content", null, likedBy1,
                "2022-12-01");
        Assertions.assertEquals(likedBy1, post1.getLikedBy());
    }

    @Test
    public void testGetLikedByMultipleUsers() {
        ArrayList<String> likedBy3 = new ArrayList<>();
        Post post3 = new Post("postId3", "userId3", "post3 content", null, likedBy3,
                "2022-12-01");
        likedBy3.add("user2");
        likedBy3.add("user3");
        likedBy3.add("user4");
        Assertions.assertEquals(likedBy3, post3.getLikedBy());
    }

    @Test
    public void testGetUserId() {
        Post post1 = new Post("postId1", "userId1", "post1 content", null, null,
                "2022-12-01");
        Assertions.assertEquals("userId1", post1.getUserId());
    }

    @Test
    public void testGetContent() {
        Post post1 = new Post("postId1", "userId1", "post1 content", null, null,
                "2022-12-01");
        Assertions.assertEquals("post1 content", post1.getContent());
    }

    @Test
    public void testGetId() {
        Post post1 = new Post("postId1", "userId1", "post1 content", null, null,
                "2022-12-01");
        Assertions.assertEquals("postId1", post1.getId());
    }

    @Test
    public void testGetTime() {
        Post post1 = new Post("postId1", "userId1", "post1 content", null, null,
                "2022-12-01");
        Assertions.assertEquals("2022-12-01", post1.getTime());
    }

    // Test GetTotalReply
    // Since TotalReply is a ArrayList, we will test three scenarios:
    // No reply, one reply, multiple replies.
    @Test
    public void testGetNoReply() {
        ArrayList<Reply> replies1 = new ArrayList<>();
        Post post1 = new Post("postId1", "userId1", "post1 content", replies1, null,
                "2022-12-01");
        Assertions.assertEquals(replies1, post1.getTotalReply());
    }

    @Test
    public void testGetOneReply() {
        ArrayList<Reply> replies2 = new ArrayList<>();
        replies2.add(reply1);
        Post post2 = new Post("postId2", "userId2", "post2 content", replies2, null,
                "2022-12-01");
        Assertions.assertEquals(replies2, post2.getTotalReply());

    }

    @Test
    public void testGetMultipleReplies() {
        ArrayList<Reply> replies3 = new ArrayList<>();
        replies3.add(reply2);
        replies3.add(reply3);
        replies3.add(reply4);
        replies3.add(reply5);
        replies3.add(reply6);
        Post post3 = new Post("postId3", "userId3", "post3 content", replies3, null,
                "2022-12-01");
        Assertions.assertEquals(replies3, post3.getTotalReply());
    }
}

