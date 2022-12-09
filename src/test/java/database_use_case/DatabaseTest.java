package database_use_case;

import database_connection.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import post_reply_user.CommonUser;
import post_reply_user.Post;
import post_reply_user.Reply;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class DatabaseTest {

    DatabaseInsert myDatabaseInsert;
    DatabaseRead myDatabaseRead;
    DatabaseUpdate myDatabaseUpdate;
    DatabaseDelete myDatabaseDelete;
    CommonUser testUser;

    @BeforeEach
    public void connectionString() {
        String databaseConnectionString = System.getenv("DatabaseConnectionString");
        String databaseCollection = System.getenv("DatabaseCollection");
        this.myDatabaseInsert = new DatabaseInsert(databaseConnectionString, databaseCollection);
        this.myDatabaseRead = new DatabaseRead(databaseConnectionString, databaseCollection);
        this.myDatabaseUpdate = new DatabaseUpdate(databaseConnectionString, databaseCollection);
        this.myDatabaseDelete = new DatabaseDelete(databaseConnectionString, databaseCollection);

    }

    @BeforeEach
    public void setUser(){
        this.testUser = new CommonUser("testUser1", "password1", "");
    }

    @Test
    public void testInsertUser(){
        myDatabaseInsert.insertUser(testUser);
        CommonUser db_returned_user = myDatabaseRead.findUserById("testUser1");
        Assertions.assertEquals("testUser1", db_returned_user.getNickname());
        Assertions.assertEquals("password1", db_returned_user.getPassword());
    }

    @Test
    public void testInsertPost(){
        Post testPost = new Post(testUser.getNickname(), "Post1");
        myDatabaseInsert.insertPost(testPost);

        Post db_returned_post = myDatabaseRead.findPostById(testPost.getId());
        Assertions.assertEquals("Post1", db_returned_post.getContent());
        Assertions.assertEquals(true, db_returned_post.getTotalReply().isEmpty());
    }

    @Test
    public void testInsertReply(){
        Post testPost = new Post(testUser.getNickname(), "Post2");
        Reply testReply = new Reply(testUser.getNickname(), testPost.getId(), "Reply2");
        myDatabaseInsert.insertPost(testPost);
        myDatabaseInsert.insertReply(testReply);

        Post db_returned_post = myDatabaseRead.findPostById(testPost.getId());
        Post db_returned_post_with_reply = myDatabaseRead.findPostById(testPost.getId());
        Assertions.assertEquals("Post2", db_returned_post.getContent());
        Assertions.assertEquals(1, db_returned_post.getTotalReply().size());
        Assertions.assertEquals("Reply2", db_returned_post_with_reply.getTotalReply().get(0).getContent());
    }

    @Test
    public void testLike(){
        Post testPost = new Post(testUser.getNickname(), "Post3");
        Reply testReply = new Reply(testUser.getNickname(), testPost.getId(), "Reply3");
        myDatabaseInsert.insertPost(testPost);
        myDatabaseInsert.insertReply(testReply);
        Post db_returned_post_with_reply = myDatabaseRead.findPostById(testPost.getId());

        Assertions.assertEquals(true, db_returned_post_with_reply.getLikedBy().isEmpty());
        myDatabaseUpdate.like(testUser.getNickname(), testPost.getId());
        Post db_returned_post_after_adding_like =  myDatabaseRead.findPostById(testPost.getId());
        Assertions.assertEquals("testUser1", db_returned_post_after_adding_like.getLikedBy().get(0));
        myDatabaseUpdate.unlike(testUser.getNickname(), testPost.getId());
        Post db_returned_post_after_removing_like = myDatabaseRead.findPostById(testPost.getId());
        Assertions.assertEquals(true, db_returned_post_after_removing_like.getLikedBy().isEmpty());
    }

    @Test
    public void testFindLatestPost() {
        Post testPost = new Post(testUser.getNickname(), "Post5");
        Reply testReply = new Reply(testUser.getNickname(), testPost.getId(), "Reply5");
        myDatabaseInsert.insertPost(testPost);
        myDatabaseInsert.insertReply(testReply);

        int look_up_num = 1;
        ArrayList<Post> latest_posts = myDatabaseRead.findLatestPosts(look_up_num);
        Post latest_post = latest_posts.get(0);
        Assertions.assertEquals("Post5", latest_post.getContent());
    }

    @Test
    public void testDeletePost() {
        Post testPost = new Post(testUser.getNickname(), "Post6");
        myDatabaseInsert.insertPost(testPost);
        String post_id = testPost.getId();
        Post db_before_deleted_post = myDatabaseRead.findPostById(testPost.getId());
        Assertions.assertEquals("Post6", db_before_deleted_post.getContent());
        myDatabaseDelete.deletePostById(testPost.getId());
        Post db_after_deleted_post = myDatabaseRead.findPostById(post_id);
        Assertions.assertEquals(null, db_after_deleted_post);

    }



}
