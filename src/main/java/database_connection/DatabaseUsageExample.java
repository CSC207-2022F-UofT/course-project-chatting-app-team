package database_connection;

import java.util.*;
import post_reply_user.*;

public class DatabaseUsageExample {
    final static String divider = "========================================================================================================";
    public static void print_divider() {
        System.out.println(divider);
    }

    public static void main(String[] args) {

        print_divider();
        // paste in connection string
        Database myDatabaseInsert = new DatabaseInsert("<connection string goes here>", "DatingAppStaging");
        Database myDatabaseRead = new DatabaseRead("<connection string goes here>", "DatingAppStaging");
        Database myDatabaseUpdate = new DatabaseUpdate("<connection string goes here>", "DatingAppStaging");
        Database myDatabaseDelete = new DatabaseDelete("<connection string goes here>", "DatingAppStaging");
        Random rand = new Random();

        // generate a random user nickname each time
        String user_nickname = "TestUser_" + UUID.randomUUID();
        String user_password = rand.nextInt(100000) + "";
        String post_content = "test_post_content_" + UUID.randomUUID();
        String reply_content = "test_reply_content_" + UUID.randomUUID();

        System.out.println("Generating User info as:");
        System.out.println("nickname: " + user_nickname);
        System.out.println("password: " + user_password);
        System.out.println("post content: " + post_content);
        System.out.println("reply content: " + reply_content);

        print_divider();
        System.out.println("Db returns:");

        // Insert a new user under the nickname "test_user1"
        CommonUser testUser = new CommonUser(user_nickname, user_password, "");
        ((DatabaseInsert) myDatabaseInsert).insertUser(testUser);

        CommonUser db_returned_user = ((DatabaseRead) myDatabaseRead).findUserById(user_nickname);
        System.out.println("User nickname: " + db_returned_user.getNickname());
        System.out.println("User password: " + db_returned_user.getPassword());


        // inserting a post into db then fetching it back from db
        Post testPost = new Post(testUser.getNickname(), post_content);
        ((DatabaseInsert) myDatabaseInsert).insertPost(testPost);

        Post db_returned_post = ((DatabaseRead) myDatabaseRead).findPostById(testPost.getId());
        System.out.println("Post content before reply: "  + db_returned_post.getContent());
        System.out.println("Post reply before reply: "  + db_returned_post.getTotalReply());

        // insert a reply to said post
        Reply testReply = new Reply(testUser.getNickname(), testPost.getId(), reply_content);
        ((DatabaseInsert) myDatabaseInsert).insertReply(testReply);
        Post db_returned_post_with_reply = ((DatabaseRead) myDatabaseRead).findPostById(testPost.getId());
        System.out.println("Post content after reply: "  + db_returned_post_with_reply.getContent());
        System.out.println("Post reply after reply: "  + db_returned_post_with_reply.getTotalReply());
        System.out.println("Reply Content: "  + db_returned_post_with_reply.getTotalReply().get(0).getContent());

        CommonUser db_returned_user_after_reply = ((DatabaseRead) myDatabaseRead).findUserById(testUser.getNickname());
        System.out.println("User Posts after reply: "  + db_returned_user_after_reply.getAllPost());

        // Add a like to our own post
        System.out.println("Test Posts likedBy before adding like: " + db_returned_post_with_reply.getLikedBy());
        ((DatabaseUpdate) myDatabaseUpdate).like(testUser.getNickname(), testPost.getId());
        Post db_returned_post_after_adding_like = ((DatabaseRead) myDatabaseRead).findPostById(testPost.getId());
        System.out.println("Test Posts likedBy after adding like: " + db_returned_post_after_adding_like.getLikedBy());
        ((DatabaseUpdate) myDatabaseUpdate).unlike(testUser.getNickname(), testPost.getId());
        Post db_returned_post_after_removing_like = ((DatabaseRead) myDatabaseRead).findPostById(testPost.getId());
        System.out.println("Test Posts likedBy after removing like: " + db_returned_post_after_removing_like.getLikedBy());

        print_divider();

        int look_up_num = 1;
        // test for find_latest_posts
        System.out.println("Looking for " + look_up_num + " most recent post(s).");
        ArrayList<Post> latest_posts = ((DatabaseRead) myDatabaseRead).findLatestPosts(look_up_num);
        System.out.println("Found " + latest_posts.size() + " post(s).");
        Post latest_post = latest_posts.get(0);
        System.out.println("Content of first post is: " + latest_post.getContent());

        print_divider();
        System.out.println("Do you want to delete the test post and its reply? (Y/N)");

        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);

        if(c == 'y' || c == 'Y' ) {
            System.out.println("deleting");
            ((DatabaseDelete) myDatabaseDelete).deletePostById(testPost.getId());
        } else {
            System.out.println("not deleting");
        }


    }
}