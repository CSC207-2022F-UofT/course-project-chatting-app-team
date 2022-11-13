package entity_usecase;

import java.util.ArrayList;

public abstract class User {
    String nickname;
    String password;
    String avatar;
    //the avatar should be the link of the picture


    public User(String nickname, String password, String avatar){
        this.nickname = nickname;
        this.password = password;
        this.avatar = avatar;
    }

    static class random_User extends User{

        ArrayList<Post> All_Post;
        ArrayList<Reply> All_Reply;

        public random_User(String nick_name,String pass_word, String avatar){
            super(nick_name, pass_word, avatar);
            setAll_Post();
            setAll_Reply();

        }

        public void setAll_Post() {
            this.All_Post = null;
        }

        public void setAll_Reply() {
            this.All_Reply = null;
        }

        public String get_nickname(User user_3){
            return user_3.nickname;
        }

        public String get_password(User user_3){
            return user_3.password;
        }

        public String get_avatar(User user_3){
            return user_3.avatar;
        }

        public void setAll_Post(random_User user_4) {
            ArrayList<Post> lst = null;

        }

        public void setAll_Reply(random_User user_4){
            ArrayList<Reply> lst = null;
        }

        public ArrayList<Post> get_All_Post(random_User user_4){
            return user_4.All_Post;
        }

        public ArrayList<Reply> getAll_Reply(random_User user_4){
            return user_4.All_Reply;
        }

        public void add_post(Post post){
            post.getAuther().All_Post.add(post);

        }

        public void add_reply(Reply reply){
            reply.auther.All_Reply.add(reply);
        }

        public int total_num_post(random_User user_1){
            return user_1.All_Post.size();
        }

        public int total_num_reply(random_User user_1){
            return user_1.All_Reply.size();
        }

        public int total_like_received(random_User user_1){
            int num = 0;
            for (int i = 0; i < user_1.All_Post.size(); i++){
                num += user_1.All_Post.get(i).likes;
            }
            return num;
        }

        public int total_reply_received(random_User user_1){
            int num = 0;
            for (int i = 0; i < user_1.All_Post.size(); i++){
                num += user_1.All_Post.get(i).getAll_Reply().size();
            }
            return num;
        }

        public void delete_Post(Post post){
            this.All_Post.remove(post);
        }

        public void delete_Reply(Reply reply){
            this.All_Reply.remove(reply);
        }
    }

}
