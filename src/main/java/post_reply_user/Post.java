package post_reply_user;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Post {
    common_User auther;
    String content;
    String time;
    ArrayList<common_User> replyedBy;
    ArrayList<Reply> totalReply;
    ArrayList<common_User> likedBy;

    //constructor
    public Post(common_User auther, String content, String time){
        this.time = String.valueOf(LocalDateTime.now());
        setAuther(auther);
        setReplyBy();
        setContent(content);
        setLikedBy();
        setTotalReply();

    }

    //setter
    public void setAuther(common_User auther) {
        this.auther = auther;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public void setReplyBy(){
        this.replyedBy = new ArrayList<common_User>();
    }

    public void setTotalReply(){
        this.totalReply = new ArrayList<Reply>();

    }

    public void setLikedBy() {
        this.likedBy = new ArrayList<common_User>();
    }

    //getter
    public ArrayList<common_User> getLikedBy() {
        return likedBy;
    }

    public common_User getAuther(){
        return auther;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public ArrayList<Reply> gettotalReply() {
        return this.totalReply;
    }

    //when user click the button of like, add the user to likedBy, if the user have not like this post before;
    // or we will cancel the user's previous like.
    public void like_post(common_User user_2){
        if (this.likedBy.contains(user_2)){
            this.likedBy.remove(user_2);
        }
        else {
            this.likedBy.add(user_2);
        }
    }

    //add a reply to this post
    public void add_Reply(Reply reply){
        this.totalReply.add(reply);
    }

    //delete a reply to this post
    public void delete_Reply(Reply reply){
        this.totalReply.remove(reply);
    }

    //find the top three replies to this post (in order of number of likes)
    public ArrayList<Reply> top_three(){
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
        return (ArrayList<Reply>) result.subList(0,3);
    }

    //find the rest of the replies other than the top three replies
    public ArrayList<Reply> other_than_top_three(){
        ArrayList<Reply> lst = new ArrayList<Reply>();
        for (Reply reply : this.totalReply) {
            if (! top_three().contains(reply)) {
                lst.add(reply);
            }
        }
        return lst;
    }


}
