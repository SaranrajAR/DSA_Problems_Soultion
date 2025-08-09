public class Tweet{
    int id;
    int time;
    Tweet(int id,int time){
        this.id=id;
        this.time=time;
    }
}
class Twitter {
    public HashMap<Integer,HashSet<Integer>> map;
    private static int timeStamp;
    public HashMap<Integer,List<Tweet>> tweets;

    public Twitter() {
        map=new HashMap<>();
        timeStamp=0;
        tweets=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId,new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId,timeStamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        map.putIfAbsent(userId,new HashSet<>());
        map.get(userId).add(userId);
        PriorityQueue<Tweet> allTweets=new PriorityQueue<>((a,b)->b.time-a.time); //here instead we use list also
        for(int followe:map.get(userId)){
            if(tweets.containsKey(followe)){
                allTweets.addAll(tweets.get(followe));
            }
        }
        
        List<Integer> res=new ArrayList<>();
        // for(int i=0;i<Math.min(10,allTweets.size());i++){
        //     res.add(allTweets.get(i).id);
        // }
        int count=10;
        while(!allTweets.isEmpty() && count > 0){
            res.add(allTweets.poll().id);
            count--;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        map.putIfAbsent(followerId,new HashSet<>());
        map.get(followerId).add(followeeId);

    }
    
    public void unfollow(int followerId, int followeeId) {
        if(map.containsKey(followerId)){
            map.get(followerId).remove(followeeId);
        }
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
