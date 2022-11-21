package post_reply_user;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Post {
    CommonUser author;
    String content;
    String time;
    String id;
    ArrayList<Reply> totalReply;
    ArrayList<CommonUser> likedBy;

    //constructor
    public Post(CommonUser author, String content, String id, ArrayList<Reply> replies){
        this.time = Instant.now().toString();
        this.id = id;
        this.author = author;
        this.content = content;
        this.totalReply = replies;

    }

    public Post(CommonUser author, String content, String id, String time, ArrayList<Reply> replies){
        this.time = time;
        this.id = id;
        this.author = author;
        this.content = content;
        this.totalReply = replies;

    }

    //setter
//    public void setAuthor(CommonUser author) {
//        this.author = author;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public void setTotalReply(){
//        this.totalReply = new ArrayList<Reply>();
//
//    }


    //getter
    public ArrayList<CommonUser> getLikedBy() {
        return likedBy;
    }

    public CommonUser getAuthor(){
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public ArrayList<Reply> getTotalReply() {
        return this.totalReply;
    }

    //when user click the button of like, add the user to likedBy, if the user have not like this post before;
    // or we will cancel the user's previous like.
//    public void like_post(CommonUser user_2){
//        if (this.likedBy.contains(user_2)){
//            this.likedBy.remove(user_2);
//        }
//        else {
//            this.likedBy.add(user_2);
//        }
//    }

//    //add a reply to this post
//    public void add_Reply(Reply reply){
//        this.totalReply.add(reply);
//    }
//
//    //delete a reply to this post
//    public void delete_Reply(Reply reply){
//        this.totalReply.remove(reply);
//    }

    //find the top three replies to this post (in order of number of likes)
    public ArrayList<Reply> getRepliesOrderByLikes(){
        ArrayList<Reply> result = new ArrayList<Reply>();
        result.add(this.totalReply.get(0));
        for (int i = 1; i < this.totalReply.size(); i ++){
            int j;
            for (j = 0; j <= result.size(); j ++){
                if (this.totalReply.get(i).liked_by.size() > result.get(j).liked_by.size()){
                    break;
                }
            }
            result.add(j, this.totalReply.get(i));
        }
        return result;
    }

//    //find the rest of the replies other than the top three replies
//    public ArrayList<Reply> other_than_top_three(){
//        ArrayList<Reply> lst = new ArrayList<Reply>();
//        for (Reply reply : this.totalReply) {
//            if (! top_three().contains(reply)) {
//                lst.add(reply);
//            }
//        }
//        return lst;
//    }
//

}
