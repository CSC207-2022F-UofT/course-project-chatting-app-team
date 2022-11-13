package database_connection;

import java.util.UUID;
import java.time.Instant;

import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;


import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import java.util.List;
import java.util.ArrayList;

import java.util.Arrays;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Sorts.descending;

public class database_usage_example {

    public static void main(String[] args) {
        // paste in connection string
        // <connection string goes here>
        Database myDatabase = new Database("<connection string goes here>", "DatingAppStaging");

        //test for insert_post
        myDatabase.insert_post("input_username", "input_post_content");

        //test for insert_reply
        myDatabase.insert_reply("_id","input_username", "input_reply_content");

        //test for find_post_by_id
        Document doc1 = myDatabase.find_post_by_id("3f653fa3-45d6-45c6-9382-cf9272baad21");
        System.out.println(doc1);

        //test for find_latest_posts
        List<Document> doc2 = myDatabase.find_latest_posts(1);
        System.out.println(doc2);


        // Use this function to insert a document into database.
        myDatabase.insert_user (new Document()
                .append("_id", new ObjectId())
                .append("user_id", "a_new_user_id")
                .append("your_own_property", "whatever value"));

        // user this to query for a user.
        Document doc3 = myDatabase.find_user_by_id("my_user_name_test");

        System.out.println(doc3);

        //test for find_latest_posts
        List<Document> doc4 = myDatabase.find_latest_posts_by_user_id(32, "123asdf");
        System.out.println(doc4);

        //test for like
        myDatabase.like("123asdf", "3f653fa3-45d6-45c6-9382-cf9272baad21");

        //test for unlike
        myDatabase.unlike("123asdf", "3f653fa3-45d6-45c6-9382-cf9272baad21");

        //test for delete_post_by_id
        myDatabase.delete_post_by_id("18596e9d-8b7e-4238-9948-c4e114cc9930");
    }
}
