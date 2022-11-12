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

import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
import org.bson.conversions.Bson;
import com.mongodb.client.model.Updates;

public class Database {

    String connection_uri = "";
    MongoDatabase mongo_database;
    MongoClient mongoClient;

    public Database(String connection_uri, String DatabaseName) {
        this.connection_uri = connection_uri;
        mongoClient = MongoClients.create(connection_uri);
        mongo_database = mongoClient.getDatabase(DatabaseName);

    }

    public void insert_post(String user_nickname, String post_content) {
        MongoCollection<Document> post_collection = mongo_database.getCollection("post");
        String uuid = UUID.randomUUID().toString();
        Document post = new Document();
        String UTC_time = Instant.now().toString();
        post.append("_id", uuid)
            .append("user_nickname", user_nickname)
            .append("content", post_content)
            .append("created_on", UTC_time);
        post_collection.insertOne(post);
    }

    public void insert_reply(String parent_post_id, String user_nickname, String reply_content){
        MongoCollection<Document> reply_collection = mongo_database.getCollection("reply");
        String uuid = UUID.randomUUID().toString();
        Document reply = new Document();
        String UTC_time = Instant.now().toString();
        reply.append("_id", uuid)
            .append("parent_post_id", parent_post_id)
            .append("user_nickname", user_nickname)
            .append("content", reply_content)
            .append("created_on", UTC_time);
        reply_collection.insertOne(reply);
    }

    public Document find_post_by_id(String post_id) {
        MongoCollection<Document> post_collection = mongo_database.getCollection("post");

        Document doc = post_collection.aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.eq("_id", post_id)),
                        Aggregates.lookup("reply", "_id", "parent_post_id", "replies")
                )
        ).first();

        return doc;
    }

    public List<Document> find_latest_posts(int num, int offset) {
        MongoCollection<Document> post_collection = mongo_database.getCollection("post");

        List<Document> docs = new ArrayList<>();
        post_collection.aggregate(
                Arrays.asList(
                        Aggregates.lookup("reply", "_id", "parent_post_id", "replies"),
                        Aggregates.sort(descending("created_on")),
                        Aggregates.skip(offset),
                        Aggregates.limit(num)
                )
        ).into(docs);

        return docs;
    }

    public List<Document> find_latest_posts(int num) {
        return find_latest_posts(num, 0);
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

    public List<Document> find_latest_posts_by_user_id(int num, int offset, String user_id) {
        MongoCollection<Document> post_collection = mongo_database.getCollection("post");

        List<Document> docs = new ArrayList<>();
        post_collection.aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.eq("user_nickname", user_id)),
                        Aggregates.lookup("reply", "_id", "parent_post_id", "replies"),
                        Aggregates.sort(descending("created_on")),
                        Aggregates.skip(offset),
                        Aggregates.limit(num)
                )
        ).into(docs);

        return docs;
    }

    public List<Document> find_latest_posts_by_user_id(int num, String user_id) {
        return find_latest_posts_by_user_id(num, 0, user_id);
    }

    public void like(String user_id, String post_id){
        MongoCollection<Document> post_collection = mongo_database.getCollection("post");

        // query to filter the post using post id
        Document query = new Document().append("_id",  post_id);
        Bson updates = Updates.addToSet("likes", user_id);
        UpdateOptions options = new UpdateOptions().upsert(true);
        UpdateResult result = post_collection.updateOne(query, updates, options);

        // Optional
        // return Result
    }

    public void unlike(String user_id, String post_id){
        MongoCollection<Document> post_collection = mongo_database.getCollection("post");

        Document query = new Document().append("_id",  post_id);
        Bson updates = Updates.pull("likes", user_id);
        UpdateOptions options = new UpdateOptions().upsert(true);
        UpdateResult result = post_collection.updateOne(query, updates, options);

    }
}
