package database_connection;

import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class Database {

    String connection_uri = "";
    MongoDatabase mongo_database;
    MongoClient mongoClient;

    public Database(String connection_uri, String DatabaseName) {
        this.connection_uri = connection_uri;
        mongoClient = MongoClients.create(connection_uri);
        mongo_database = mongoClient.getDatabase(DatabaseName);

    }

    public Document find_user_by_id(String user_id){

        // Maybe this can be moved to an instance variable, need double-checking
        MongoCollection<Document> user_collection = mongo_database.getCollection("user");
        Document doc = user_collection.find(eq("user_id", user_id)).first();
        return doc;

    };

    public void insert_user(Document doc) {
        MongoCollection<Document> user_collection = mongo_database.getCollection("user");
        user_collection.insertOne(doc);
    }


}
