package database_connection;

import com.mongodb.client.*;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Sorts.descending;

import com.mongodb.client.model.UpdateOptions;
import org.bson.conversions.Bson;
import com.mongodb.client.model.Updates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import post_reply_user.*;


public class Database {

    String connectionUri;
    MongoDatabase mongoDatabase;
    MongoClient mongoClient;


    public Database(String connectionUri, String DatabaseName) {
        this.connectionUri = connectionUri;
        mongoClient = MongoClients.create(this.connectionUri);
        mongoDatabase = mongoClient.getDatabase(DatabaseName);
    }

    public void close() {
        mongoClient.close();
    }
}
