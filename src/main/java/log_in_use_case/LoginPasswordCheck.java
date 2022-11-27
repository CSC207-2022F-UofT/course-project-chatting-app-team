package log_in_use_case;

import org.bson.Document;
import post_reply_user.User;

// The LoginPasswordCheck works as use case for log-in.
public class LoginPasswordCheck {
    // The check method checks if the password is correct when user try to log-in.
    // Returns true iff password is correct.
    public static boolean check(User returnedUser, String password){
        boolean valid = true;
        if (returnedUser == null){
            valid = false;
        } else if (!returnedUser.getPassword().equals(password)) {
            valid = false;
        }
        return valid;
    }
}
