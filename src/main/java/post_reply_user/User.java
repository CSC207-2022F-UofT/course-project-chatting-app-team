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
    // constructor of the abstract class User

    public String getNickname(){
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getAvatar() {
        return avatar;
    }


}
