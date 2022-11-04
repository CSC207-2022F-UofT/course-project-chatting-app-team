package PostAndReply;
import com.mongodb.internal.connection.DefaultDnsSrvRecordMonitorFactory;
import sun.jvm.hotspot.utilities.Hashtable;

import java.time.LocalDateTime; // Import the LocalDateTime class
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Post {
    // Attributes
    String ID;
    String body;
    ArrayList<Reply> replies;
    ArrayList<User> whoLiked;
    LocalDateTime time;
    int likes;

    // Constructors
    public Post(User user, String body){
        this.ID = user.getID();
        this.body = body;
        this.replies = new ArrayList<>();
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

    // setter
    public void setBody(String body) {
        this.body = body;
    }

    public void addReply(String reply){

    }

    // toString (needed??)
    @Override
    public String toString(){
        return this.body;
    }

    public void likePost(User user){
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

    public void addReply(Reply reply){
        this.replies.add(reply);
    }

    public void deleteReply(Reply reply){
        this.replies.remove(reply);
    }

    public ArrayList<Reply> topThreeReplies() {
        // this method returns an ArrayList of top three replies with the highest likes.
        ArrayList<Reply> topThreeList = new ArrayList<>();
        HashMap<Integer, Reply> likesToReply = new HashMap<Integer, Reply>();
        // dictionary for storing replies and likes
        // appending to the dictionary, let likes be the key and reply be the value
        for (int i = 0; i < this.replies.size(); i += 1){
            int replyLikes = this.replies.get(i).getLikes();
            Reply reply = this.replies.get(i);
            likesToReply.put(replyLikes, reply);
        }

        // convert likesToReply key set to a list
        ArrayList<Integer> allLikes = new ArrayList<>();
        allLikes.addAll(likesToReply.keySet());

        // sort list by descending order
        allLikes.sort(Collections.reverseOrder());

        // add top three to topThreeList
        for(int i = 0; i < 3; i +=1){
            likes = allLikes.get(i);
            Reply reply = likesToReply.get(likes);
            topThreeList.add(reply);
        }

        return topThreeList;
    }

    public ArrayList<Reply> otherThanTopThree(){
        ArrayList<Reply> topThreeReplies = this.topThreeReplies();
        // get a copy of this.replies
        ArrayList<Reply> newReplies = new ArrayList<>(this.replies);
        // go through the copy and remove the top three replies
        for (Reply reply : this.replies) {
            if (topThreeReplies.contains(reply)) {
                newReplies.remove(reply);
            }
        }
        return newReplies;
    }

    public static void main(String[] args) {

    }
}

