package user_exist_use_case;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import post_reply_user.CommonUser;

public class UserExistCheckTest {

    CommonUser user = null;
    @BeforeEach
    void setup(){
        user = new CommonUser("Mike", "12345", null);
    }

    // Test when user exist.
    @Test
    void userExistCheckTrue() {
        UserExistCheck usernameCheck = new UserExistCheck();
        Assertions.assertEquals(true, usernameCheck.userExistCheck(user));
    }

    // Test when user does not exist.
    @Test
    void userExistCheckFalse() {
        UserExistCheck usernameCheck = new UserExistCheck();
        Assertions.assertEquals(false, usernameCheck.userExistCheck(null));
    }
}
