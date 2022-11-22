package database_connection;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import post_reply_user.CommonUser;
import post_reply_user.Post;
import post_reply_user.Reply;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Sorts.descending;

public class DatabaseRead extends Database {

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

    public DatabaseRead(String connectionUri, String DatabaseName) {
        super(connectionUri, DatabaseName);
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
}
