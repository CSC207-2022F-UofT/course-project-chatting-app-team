package database_connection;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

public class DatabaseUpdate extends Database {
    public DatabaseUpdate(String connectionUri, String DatabaseName) {
        super(connectionUri, DatabaseName);
    }

    public void like(String user_id, String post_id){
        MongoCollection<Document> post_collection = mongoDatabase.getCollection("post");

        // query to filter the post using post id
        Document query = new Document().append("_id",  post_id);
        Bson updates = Updates.addToSet("likes", user_id);
        UpdateOptions options = new UpdateOptions().upsert(true);
        post_collection.updateOne(query, updates, options);

    }

    public void unlike(String user_id, String post_id){
        MongoCollection<Document> post_collection = mongoDatabase.getCollection("post");

        Document query = new Document().append("_id",  post_id);
        Bson updates = Updates.pull("likes", user_id);
        UpdateOptions options = new UpdateOptions().upsert(true);
        post_collection.updateOne(query, updates, options);

    }

}
