package send_reply_use_case;

import post_reply_user.Reply;

public class ReturnAsReply {
    public Reply returnReply(String userId, String postId, String content){
        return new Reply(userId, postId, content);
    }
}
