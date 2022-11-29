package database_connection;

import java.util.*;
import post_reply_user.*;

public class databaseUsageExample {
    final static String divider = "========================================================================================================";
    public static void print_divider() {
        System.out.println(divider);
    }

    public static void main(String[] args) {

        print_divider();
        // paste in connection string
        database myDatabaseInsert = new databaseInsert("<connection string goes here>", "DatingAppStaging");
        database myDatabaseRead = new databaseRead("<connection string goes here>", "DatingAppStaging");
        database myDatabaseUpdate = new databaseUpdate("<connection string goes here>", "DatingAppStaging");
        database myDatabaseDelete = new databaseDelete("<connection string goes here>", "DatingAppStaging");
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
        commonUser testUser = new commonUser(user_nickname, user_password, "");
        ((databaseInsert) myDatabaseInsert).insertUser(testUser);

        commonUser db_returned_user = ((databaseRead) myDatabaseRead).findUserById(user_nickname);
        System.out.println("User nickname: " + db_returned_user.getNickname());
        System.out.println("User password: " + db_returned_user.getPassword());


        // inserting a post into db then fetching it back from db
        Post testPost = new Post(testUser.getNickname(), post_content);
        ((databaseInsert) myDatabaseInsert).insertPost(testPost);

        Post db_returned_post = ((databaseRead) myDatabaseRead).findPostById(testPost.getId());
        System.out.println("Post content before reply: "  + db_returned_post.getContent());
        System.out.println("Post reply before reply: "  + db_returned_post.getTotalReply());

        // insert a reply to said post
        Reply testReply = new Reply(testUser.getNickname(), testPost.getId(), reply_content);
        ((databaseInsert) myDatabaseInsert).insertReply(testReply);
        Post db_returned_post_with_reply = ((databaseRead) myDatabaseRead).findPostById(testPost.getId());
        System.out.println("Post content after reply: "  + db_returned_post_with_reply.getContent());
        System.out.println("Post reply after reply: "  + db_returned_post_with_reply.getTotalReply());
        System.out.println("Reply Content: "  + db_returned_post_with_reply.getTotalReply().get(0).getContent());

        commonUser db_returned_user_after_reply = ((databaseRead) myDatabaseRead).findUserById(testUser.getNickname());
        System.out.println("User Posts after reply: "  + db_returned_user_after_reply.getAllPost());

        // Add a like to our own post
        System.out.println("Test Posts likedBy before adding like: " + db_returned_post_with_reply.getLikedBy());
        ((databaseUpdate) myDatabaseUpdate).like(testUser.getNickname(), testPost.getId());
        Post db_returned_post_after_adding_like = ((databaseRead) myDatabaseRead).findPostById(testPost.getId());
        System.out.println("Test Posts likedBy after adding like: " + db_returned_post_after_adding_like.getLikedBy());
        ((databaseUpdate) myDatabaseUpdate).unlike(testUser.getNickname(), testPost.getId());
        Post db_returned_post_after_removing_like = ((databaseRead) myDatabaseRead).findPostById(testPost.getId());
        System.out.println("Test Posts likedBy after removing like: " + db_returned_post_after_removing_like.getLikedBy());

        print_divider();

        int look_up_num = 1;
        // test for find_latest_posts
        System.out.println("Looking for " + look_up_num + " most recent post(s).");
        ArrayList<Post> latest_posts = ((databaseRead) myDatabaseRead).findLatestPosts(look_up_num);
        System.out.println("Found " + latest_posts.size() + " post(s).");
        Post latest_post = latest_posts.get(0);
        System.out.println("Content of first post is: " + latest_post.getContent());

        print_divider();
        System.out.println("Do you want to delete the test post and its reply? (Y/N)");

        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);

        if(c == 'y' || c == 'Y' ) {
            System.out.println("deleting");
            ((databaseDelete) myDatabaseDelete).deletePostById(testPost.getId());
        } else {
            System.out.println("not deleting");
        }


    }
}
