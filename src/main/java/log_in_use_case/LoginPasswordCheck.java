package log_in_use_case;

import org.bson.Document;

public class LoginPasswordCheck {
    public static boolean check(Document returnedUser, String password){
        boolean valid = true;
        if (returnedUser == null){
            valid = false;
        } else if (!returnedUser.getString("password").equals(password)) { // key = password?
            valid = false;
        }
        return valid;
    }
}
