package entity_usecase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

public class Post {
    User.random_User auther;
    String content;
    int likes;
    String time;
    ArrayList<User.random_User> replyed_by;
    ArrayList<Reply> all_Reply;
    ArrayList<User.random_User> liked_by;

    public void setAuther(User.random_User auther) {
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
        this.replyed_by = null;
        this.all_Reply = null;

    }

    public void like_this(User.random_User user){
        this.liked_by.add(user);
        this.likes += 1;

    }

    public ArrayList<User.random_User> getLike_by() {
        return liked_by;
    }

    public User.random_User getAuther(){
        return auther;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public ArrayList<Reply> getAll_Reply() {
        return all_Reply;
    }

    public void like_post(User.random_User user_2){
        if (this.liked_by.contains(user_2)){
            this.liked_by.remove(user_2);
        }
        else {
            this.liked_by.add(user_2);
        }
    }

    public void add_Reply(Reply reply){
        this.all_Reply.add(reply);
    }

    public void delete_Reply(Reply reply){
        this.all_Reply.remove(reply);
    }

    public ArrayList<Reply> top_three(){
        ArrayList<Reply> result = new ArrayList<Reply>(this.all_Reply.get(0));
        for (int i = 1; i < this.all_Reply.size(); i ++){
            for (int j = 0; j <= result.size(); j ++){
                if (this.all_Reply.get(i) <= result.get(j)){
                    result.add(j+1, this.all_Reply.get(i));
                    break;
                }
            }
        }
        return (ArrayList<Reply>) result.subList(0,3);
    }

    public ArrayList<Reply> other_than_top_three(){
        ArrayList<Reply> result = new ArrayList<Reply>(this.all_Reply.get(0));
        for (int i = 1; i < this.all_Reply.size(); i ++){
            for (int j = 0; j <= result.size(); j ++){
                if (this.all_Reply.get(i) <= result.get(j)){
                    result.add(j+1, this.all_Reply.get(i));
                    break;
                }
            }
        }
        return (ArrayList<Reply>) result.subList(3, result.size());
    }

}
