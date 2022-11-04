package PostAndReply;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reply {
    // Attributes
    String ID;
    String body;
    Post post;
    ArrayList<User> whoLiked;
    LocalDateTime time;
    int likes;

    // Constructors
    public Reply(User user, String body, Post post){
        this.ID = user.getID();
        this.body = body;
        this.post = post;
        this.whoLiked = new ArrayList<>();
        this.time  = LocalDateTime.now();
        this.likes = 0;
    }

    // getter methods
    public String getBody(){
        return this.body;
    }

    public LocalDateTime getTime(){
        return this.time;
    }

    public int getLikes(){
        return this.likes;
    }

    public void likeReply(User user){
        // Check if the user clicking the like button is in the whoLiked
        // if yes, remove user from the whoLiked list and likes -1
        // if no, add user into the whoLiked list and likes + 1
        if (this.whoLiked.contains(user)){
            this.whoLiked.remove(user);
            this.likes -= 1;
        }
        else{
            this.whoLiked.add(user);
            this.likes += 1;
        }
    }



    public static void main(String[] args) {


    }
}
