package log_in_use_case;

import post_reply_user.User;

// The LoginUsernameCheck works as use case for log-in.
public class LoginUserExistCheck {
    // The method checks if the username exist when user try to log-in.
    // Returns true iff username is correct.
    public boolean loginUserExistCheck(User returnedUser){
        boolean valid = true;
        if (returnedUser == null){
            valid = false;
        }
        return valid;
    }
}
