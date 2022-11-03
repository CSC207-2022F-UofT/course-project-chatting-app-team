package database_connection;

import org.bson.Document;
import org.bson.types.ObjectId;

public class database_usage_example {

    public static void main(String[] args) {
        // paste in connection string
        Database myDatabase = new Database("<connection string goes here>", "DatingAppStaging");

        // Use this function to insert a document into database.
        myDatabase.insert_user (new Document()
                .append("_id", new ObjectId())
                .append("user_id", "a_new_user_id")
                .append("your_own_property", "whatever value"));

        // user this to query for a user.
        Document doc = myDatabase.find_user_by_id("my_user_name_test");

        System.out.println(doc);
    }
}
// <connection string goes here>