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


    private CommonUser docs_to_user(Document user_doc) {
        String userId = user_doc.getString("user_id");
        String password = user_doc.getString("password");
        String avatar = user_doc.getString("avatar");
        ArrayList<Post> posts = find_posts_by_user_id(userId);

        return new CommonUser(userId, password, avatar, posts);
    }
    private Post doc_to_post(Document post_doc) {

        ArrayList<Document> reply_docs = post_doc.get("replies", new ArrayList<>());

        String id = post_doc.getString("_id");
        String userId = post_doc.getString("user_nickname");
        String content = post_doc.getString("content");

        // using an empty ArrayList as the default value here
        // old records inside db does not come with "likes" array
        // thus using the default value to prevent null pointer exception
        ArrayList<String> likedBy = post_doc.get("likes", new ArrayList<>());
        String createdOn = post_doc.getString("created_on");

        ArrayList<Reply> replies = new ArrayList<>();
        for (Document reply_doc: reply_docs) {
            replies.add(doc_to_reply(reply_doc));
        }

        return new Post(id, userId, content, replies, likedBy, createdOn);
    }

    private Reply doc_to_reply(Document reply_doc) {
        String id = reply_doc.getString("_id");
        String user_id = reply_doc.getString("user_nickname");
        String parent_post_id = reply_doc.getString("parent_post_id");
        String content = reply_doc.getString("content");
        String created_on = reply_doc.getString("created_on");

        return new Reply(id, user_id, parent_post_id, content, created_on);
    }

    public Database(String connectionUri, String DatabaseName) {
        this.connectionUri = connectionUri;
        mongoClient = MongoClients.create(this.connectionUri);
        mongoDatabase = mongoClient.getDatabase(DatabaseName);
    }

    public void insert_post(Post post) {
        MongoCollection<Document> post_collection = mongoDatabase.getCollection("post");
        Document post_doc = new Document();
        post_doc.append("_id", post.getId())
            .append("user_nickname", post.getUserId())
            .append("content", post.getContent())
            .append("likes", new ArrayList<String>())
            .append("created_on", post.getTime());
        post_collection.insertOne(post_doc);
    }

    public void insert_reply(Reply reply){
        MongoCollection<Document> reply_collection = mongoDatabase.getCollection("reply");
        Document reply_doc = new Document()
            .append("_id", reply.getId())
            .append("parent_post_id", reply.getPostId())
            .append("user_nickname", reply.getUserId())
            .append("content", reply.getContent())
            .append("created_on", reply.getTime());

        reply_collection.insertOne(reply_doc);
    }

    public Post find_post_by_id(String post_id) {
        MongoCollection<Document> post_collection = mongoDatabase.getCollection("post");

        Document doc = post_collection.aggregate(
            Arrays.asList(
                Aggregates.match(Filters.eq("_id", post_id)),
                Aggregates.lookup("reply", "_id", "parent_post_id", "replies")
            )
        ).first();

     return doc == null ? null : doc_to_post(doc);
    }

    public ArrayList<Post> find_latest_posts(int num, int offset) {
        MongoCollection<Document> post_collection = mongoDatabase.getCollection("post");

        List<Document> post_docs = new ArrayList<>();
        post_collection.aggregate(
            Arrays.asList(
                Aggregates.lookup("reply", "_id", "parent_post_id", "replies"),
                Aggregates.sort(descending("created_on")),
                Aggregates.skip(offset),
                Aggregates.limit(num)
            )
        ).into(post_docs);

        ArrayList<Post> posts = new ArrayList<>();
        for (Document post_doc: post_docs) {
            posts.add(doc_to_post(post_doc));
        }

        return posts;
    }

    public ArrayList<Post> find_latest_posts(int num) {
        return find_latest_posts(num, 0);
    }

    public CommonUser find_user_by_id(String user_id){
        // Maybe the collection can be moved to an instance variable, need double-checking
        MongoCollection<Document> user_collection = mongoDatabase.getCollection("user");
        Document user_doc = user_collection.find(eq("user_id", user_id)).first();
        return user_doc == null ? null : docs_to_user(user_doc);
    }

    public void insert_user(CommonUser user) {
        MongoCollection<Document> user_collection = mongoDatabase.getCollection("user");

        Document user_doc = new Document()
                .append("user_id", user.getNickname())
                .append("password", user.getPassword());

        user_collection.insertOne(user_doc);
    }

    public ArrayList<Post> find_posts_by_user_id(String user_id) {
        MongoCollection<Document> post_collection = mongoDatabase.getCollection("post");

        ArrayList<Document> post_docs = new ArrayList<>();
        post_collection.aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.eq("user_nickname", user_id)),
                        Aggregates.lookup("reply", "_id", "parent_post_id", "replies"),
                        Aggregates.sort(descending("created_on"))
                )
        ).into(post_docs);

        ArrayList<Post> posts = new ArrayList<>();
        for (Document post_doc: post_docs) {
            posts.add(doc_to_post(post_doc));
        }

        return posts;
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

    public void delete_post_by_id(String post_id) {

        MongoCollection<Document> post_collection = mongoDatabase.getCollection("post");
        MongoCollection<Document> reply_collection = mongoDatabase.getCollection("reply");

        // post_id should be unique inside post collection, using deleteOne
        post_collection.deleteOne(Filters.eq("_id", post_id));
        reply_collection.deleteMany(Filters.eq("parent_post_id", post_id));

    }
}
