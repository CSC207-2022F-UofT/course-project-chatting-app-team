package post_reply_user;

import java.util.ArrayList;
// Common user class is one of our entities. It is the user of our web.
public class CommonUser extends User{

    ArrayList<Post> allPost;

    public CommonUser(String nickname, String password, String avatar) {
        this(nickname, password, avatar, new ArrayList<>());
    }
    public CommonUser(String nickname, String password, String avatar, ArrayList<Post> posts){
        super(nickname, password, avatar);
        this.allPost = posts;

        // constructor for CommonUser

    }
    public String getNickname(){
        return super.getNickname();
    }

    public String getPassword() {
        return super.getPassword();
    }

    public String getAvatar() {
        return super.getAvatar();
    }

    public ArrayList<Post> getAllPost(){
        return this.allPost;
    }
    //get the list of all posts of this user


    public int total_num_post(){
        return this.allPost.size();
    }
    //get the number of total posts by the user

    public int total_like_received(){
        int num = 0;
        for (Post post: this.allPost){
            num += post.likedBy.size();
        }
        return num;
    }
    //count the total like that user get from all of their posts.

    public int total_reply_received(){
        int num = 0;
        for (Post post: this.allPost){
            num += post.getTotalReply().size();
        }
        return num;
    }
    //count the total number of reply that they receive from all of their posts.


}