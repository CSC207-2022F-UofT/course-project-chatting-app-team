package register_use_case;

import org.bson.Document;
import post_reply_user.User;

// The RegisterUsernameCheck works as use case for register.
public class RegisterUsernameCheck {
    // The method checks to make sure the username is not yet exist.
    // Returns true iff username not yet exist.
    public static boolean check(User returnedUser){
        boolean valid = false;
        if (returnedUser == null){
            valid = true;
        }
        return valid;
    }
}
