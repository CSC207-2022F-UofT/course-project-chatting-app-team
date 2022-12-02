package register_use_case;

import post_reply_user.CommonUser;
import post_reply_user.User;

// the class has a method that can return information to be a user.
public class ReturnAsUser {
    public CommonUser returnUser(String nickname, String password, String avatar){
        return new CommonUser(nickname, password, avatar);
    }
}