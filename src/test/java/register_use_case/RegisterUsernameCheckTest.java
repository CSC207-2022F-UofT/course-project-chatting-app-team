package register_use_case;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import post_reply_user.CommonUser;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUsernameCheckTest {
    CommonUser user = null;
    @BeforeEach
    void setup(){
        user = new CommonUser("Mike", "12345", null);
    }

    // Test when user exist.
    @Test
    void registerUsernameCheckTrue() {
        RegisterUsernameCheck usernameCheck = new RegisterUsernameCheck();
        Assertions.assertEquals(true, usernameCheck.registerUsernameCheck(null));
    }

    // Test when user does not exist.
    @Test
    void registerUsernameCheckFalse() {
        RegisterUsernameCheck usernameCheck = new RegisterUsernameCheck();
        Assertions.assertEquals(false, usernameCheck.registerUsernameCheck(user));
    }
}