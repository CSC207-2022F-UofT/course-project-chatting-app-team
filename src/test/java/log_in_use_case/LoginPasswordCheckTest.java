package log_in_use_case;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import post_reply_user.CommonUser;

import static org.junit.jupiter.api.Assertions.*;

class LoginPasswordCheckTest {

    private CommonUser user = null;
    @BeforeEach
    public void setup(){
        user = new CommonUser("Mike", "12345", null);
    }


    // Test when password is right.
    @Test
    void loginPasswordCheckTrue() {
        LoginPasswordCheck passwordCheck = new LoginPasswordCheck();
        Assertions.assertEquals(true, passwordCheck.loginPasswordCheck(user, user.getPassword()));
    }

    // Test when password is wrong.
    @Test
    void loginPasswordCheckFalse() {
        LoginPasswordCheck passwordCheck = new LoginPasswordCheck();
        Assertions.assertEquals(false, passwordCheck.loginPasswordCheck(user, "Mike"));
        Assertions.assertEquals(false, passwordCheck.loginPasswordCheck(user, null));
    }
}