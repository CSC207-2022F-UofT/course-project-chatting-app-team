package register_use_case;

import org.bson.Document;

public class RegisterUsernameCheck {
    public static boolean check(Document returnedUser){
        boolean valid = false;
        if (returnedUser == null){
            valid = true;
        }
        return valid;
    }
}
