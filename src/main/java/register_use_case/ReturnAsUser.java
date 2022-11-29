package register_use_case;

import post_reply_user.CommonUser;
import post_reply_user.User;

public class ReturnAsUser {
    public CommonUser returnUser(String nickname, String password, String avatar){
        return new CommonUser(nickname, password, avatar);
    }
}
