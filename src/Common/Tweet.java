package Common;

public class Tweet {
    public int id;
    public int user_id;
    public String text;
    public static Tweet create(int user_id, String tweet_text) {
        return new Tweet(user_id, tweet_text);
    }
    private Tweet(int user_id, String text){
        this.user_id = user_id;
        this.text = text;
    }
}
