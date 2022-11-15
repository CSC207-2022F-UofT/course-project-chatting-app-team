package register_use_case;

import javax.swing.text.Document;
import java.util.List;

public class UsernameCheck {
    public boolean check(List<Document> allUsername, String username){
        boolean valid = false;
        for (Document e : allUsername){
            if (username == e.toString()){ // 假设
                valid = true;
            }
        }
        return valid;
    }
}
