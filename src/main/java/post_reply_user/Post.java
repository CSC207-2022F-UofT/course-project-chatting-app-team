package post_reply_user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Post {
    common_User auther;
    String content;
    int likes;
    String time;
    ArrayList<common_User> replyedBy;
    ArrayList<Reply> totalReply;
    ArrayList<common_User> likedBy;

    public void setAuther(common_User auther) {
        this.auther = auther;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime() {
        this.time = String.valueOf(new Date());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        this.time = dateFormat.format(time);
    }

    public void setReply_by(){
        this.replyedBy = new ArrayList<common_User>();
        this.totalReply = new ArrayList<Reply>();

    }

    public void like_this(common_User user){
        this.likedBy.add(user);
        this.likes += 1;

    }

    public ArrayList<common_User> getLike_by() {
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

    public void like_post(common_User user_2){
        if (this.likedBy.contains(user_2)){
            this.likedBy.remove(user_2);
        }
        else {
            this.likedBy.add(user_2);
        }
    }

    public void add_Reply(Reply reply){
        this.totalReply.add(reply);
    }

    public void delete_Reply(Reply reply){
        this.totalReply.remove(reply);
    }

    public ArrayList<Reply> top_three(){
        ArrayList<Reply> result = new ArrayList<Reply>();
        result.add(this.totalReply.get(0));
        for (int i = 1; i < this.totalReply.size(); i ++){
            for (int j = 0; j <= result.size(); j ++){
                if (this.totalReply.get(i).likes <= result.get(j).likes){
                    result.add(j+1, this.totalReply.get(i));
                    break;
                }
            }
        }
        return (ArrayList<Reply>) result.subList(0,3);
    }

    public ArrayList<Reply> other_than_top_three(){
        ArrayList<Reply> lst = this.totalReply;
        for (Reply reply : this.totalReply) {
            if (top_three().contains(reply)) {
                lst.remove(reply);
            }
        }
        return lst;
    }


}
