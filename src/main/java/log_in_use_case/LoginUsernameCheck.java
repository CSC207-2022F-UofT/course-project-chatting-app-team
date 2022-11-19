package log_in_use_case;

import org.bson.Document;

public class LoginUsernameCheck {
    public static boolean check(Document returnedUser){
        boolean valid = true;
        if (returnedUser == null){
            valid = false;
        }
        return valid;
    }
}
