package send_reply_use_case;

import post_reply_user.Reply;

// the class has a method that can return information to be a reply.
public class ReturnAsReply {
    public Reply returnReply(String userId, String postId, String content){
        return new Reply(userId, postId, content);
    }
}