package register_use_case;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import post_reply_user.User;

import static org.junit.jupiter.api.Assertions.*;

class ReturnAsUserTest {

    // check returnPost method return a user in all situations
    @Test
    void returnUser() {
        ReturnAsUser re = new ReturnAsUser();
        Assertions.assertEquals(true, re.returnUser(null, null, null) instanceof User);
        Assertions.assertEquals(true, re.returnUser("", "", null) instanceof User);
        Assertions.assertEquals(true, re.returnUser("K", "Hi", null) instanceof User);
    }
}