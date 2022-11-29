package log_in_use_case;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import post_reply_user.CommonUser;

public class LoginUserExistCheckTest {

    CommonUser user = null;
    @BeforeEach
    void setup(){
        user = new CommonUser("Mike", "12345", null);
    }

    // Test when user exist.
    @Test
    void loginUserExistCheckTrue() {
        LoginUserExistCheck usernameCheck = new LoginUserExistCheck();
        Assertions.assertEquals(true, usernameCheck.loginUserExistCheck(user));
    }

    // Test when user does not exist.
    @Test
    void loginUserExistCheckFalse() {
        LoginUserExistCheck usernameCheck = new LoginUserExistCheck();
        Assertions.assertEquals(false, usernameCheck.loginUserExistCheck(null));
    }
}
