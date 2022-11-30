package send_reply_use_case;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import post_reply_user.Reply;

import static org.junit.jupiter.api.Assertions.*;

class ReturnAsReplyTest {

    // check returnPost method return a reply in all situations
    @Test
    void returnReply() {
        ReturnAsReply re = new ReturnAsReply();
        Assertions.assertEquals(true, re.returnReply(null, null, null) instanceof Reply);
        Assertions.assertEquals(true, re.returnReply("", "", "") instanceof Reply);
        Assertions.assertEquals(true, re.returnReply("K", "1", "hi") instanceof Reply);
    }
}