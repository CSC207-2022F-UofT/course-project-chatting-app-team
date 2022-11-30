package user_exist_use_case;

import post_reply_user.User;

// The LoginUsernameCheck works as use case for log-in.
public class UserExistCheck {
    // The method checks if the user exist.
    // Returns true iff user exist.
    public boolean userExistCheck(User returnedUser){
        boolean valid = true;
        if (returnedUser == null){
            valid = false;
        }
        return valid;
    }
}