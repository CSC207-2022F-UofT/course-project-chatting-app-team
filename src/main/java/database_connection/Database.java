package database_connection;

import com.mongodb.client.*;

import static com.mongodb.client.model.Filters.eq;

import static com.mongodb.client.model.Sorts.descending;


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
