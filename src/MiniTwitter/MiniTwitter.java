package MiniTwitter;

import Common.Tweet;

import java.util.*;

public class MiniTwitter {
    HashMap<Integer, ArrayList<Tweet>> twitter;
    HashMap<Integer, HashSet<Integer>> followers;

    public MiniTwitter() {
        // initialize your data structure here.
        this.twitter = new HashMap<Integer, ArrayList<Tweet>>();
        this.followers = new HashMap<Integer, HashSet<Integer>>();
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        //  Write your code here
        Tweet temp = Tweet.create(user_id, tweet_text);

        if(!this.twitter.containsKey(user_id))
            this.twitter.put(user_id, new ArrayList<Tweet>());
        this.twitter.get(user_id).add(temp);

        return temp;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
        List<Tweet> res = new ArrayList<Tweet>();

        ArrayList<Tweet> temp = new ArrayList<Tweet>();
        temp.addAll(getTimeline(user_id));

        if(this.followers.containsKey(user_id)){
            for(Integer followed: this.followers.get(user_id))
                temp.addAll(getTimeline(followed));

            Collections.sort(temp, new Comparator<Tweet>(){
                public int compare(Tweet t1, Tweet t2){
                    return t2.id - t1.id;
                }
            });
        }

        int n = temp.size();
        for(int i = 0; i < 10 && i < n; i++)
            res.add(temp.get(i));

        return res;
    }

    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        // Write your code here
        List<Tweet> res = new ArrayList<Tweet>();
        if(!this.twitter.containsKey(user_id))
            return res;

        ArrayList<Tweet> tweets = this.twitter.get(user_id);
        int n = tweets.size();
        for(int i = 0; i < 10 && n - i - 1 >= 0; i++){
            res.add(tweets.get(n - i - 1));
        }

        return res;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
        if(!this.followers.containsKey(from_user_id))
            this.followers.put(from_user_id, new HashSet<Integer>());

        this.followers.get(from_user_id).add(to_user_id);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
        if(!this.followers.containsKey(from_user_id))
            return;

        this.followers.get(from_user_id).remove(to_user_id);
    }
}
