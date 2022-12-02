package database_connection;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class DatabaseDelete extends Database {

    public DatabaseDelete(String connectionUri, String DatabaseName) {
        super(connectionUri, DatabaseName);
    }

    public void deletePostById(String post_id) {

        MongoCollection<Document> post_collection = mongoDatabase.getCollection("post");
        MongoCollection<Document> reply_collection = mongoDatabase.getCollection("reply");

        // post_id should be unique inside post collection, using deleteOne
        post_collection.deleteOne(Filters.eq("_id", post_id));
        reply_collection.deleteMany(Filters.eq("parent_post_id", post_id));

    }
}
