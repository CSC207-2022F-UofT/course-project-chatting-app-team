package database_connection;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import post_reply_user.CommonUser;
import post_reply_user.Post;
import post_reply_user.Reply;

import java.util.ArrayList;

public class DatabaseInsert extends Database{

    public DatabaseInsert(String connectionUri, String DatabaseName) {
        super(connectionUri, DatabaseName);
    }

    public void insert_user(CommonUser user) {
        MongoCollection<Document> user_collection = mongoDatabase.getCollection("user");

        Document user_doc = new Document()
                .append("user_id", user.getNickname())
                .append("password", user.getPassword());

        user_collection.insertOne(user_doc);
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
}
