package log_in_use_case;

import org.bson.Document;

// The LoginUsernameCheck works as use case for log-in.
public class LoginUsernameCheck {
    // The method checks if the username exist when user try to log-in.
    // Returns true iff username is correct.
    public static boolean check(Document returnedUser){
        boolean valid = true;
        if (returnedUser == null){
            valid = false;
        }
        return valid;
    }
}
