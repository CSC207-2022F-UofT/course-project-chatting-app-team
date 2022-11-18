package post_reply_user;

import java.util.ArrayList;

public abstract class User {
    String nickname;
    String password;
    String avatar;
    //the avatar should be the link of the picture



    public User(String nickname, String password, String avatar){
        this.nickname = nickname;
        this.password = password;
        this.avatar = avatar;
    }



}
