package register_use_case;

import org.bson.Document;
import java.util.List;

public class UsernameCheck {
    public static boolean check(Document returnedUsername){
        boolean valid = false;
        if (returnedUsername == null){
            valid = true;
        }
        return valid;
    }
}
