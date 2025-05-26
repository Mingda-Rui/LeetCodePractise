package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class LC0355DesignTwitter {}

class LC0355Twitter {

  private Map<Integer, Tweet> tweets;
  private Map<Integer, Set<Integer>> followeeMap;
  private int timestamp;
  private static final int FEED_LIMIT = 10;

  public LC0355Twitter() {
    this.tweets = new HashMap<>();
    this.followeeMap = new HashMap<>();
    this.timestamp = 0;
  }

  public void postTweet(int userId, int tweetId) {
    Tweet tweetHistory = tweets.get(userId);
    Tweet tweet = new Tweet(timer(), tweetId, tweetHistory);
    // tweet.next = tweetHistory;
    tweets.put(userId, tweet);

    followeeMap.putIfAbsent(userId, new HashSet<>());
    followeeMap.get(userId).add(userId);
  }

  public List<Integer> getNewsFeed(int userId) {
    List<Integer> result = new LinkedList<>();
    if (!followeeMap.containsKey(userId)) return result;

    Comparator<Tweet> comparator = Comparator.comparingInt(tweet -> tweet.ts);
    Queue<Tweet> queue = new PriorityQueue<>(comparator.reversed());
    for (int followee : followeeMap.get(userId)) {
      Tweet userTweet = tweets.get(followee);
      if (userTweet != null) queue.add(userTweet);
    }

    while (result.size() < FEED_LIMIT && !queue.isEmpty()) {
      Tweet mostRecent = queue.poll();
      if (mostRecent.next != null) queue.add(mostRecent.next);
      result.add(mostRecent.tId);
    }
    return result;
  }

  public void follow(int followerId, int followeeId) {
    if (!followeeMap.containsKey(followerId)) {
      followeeMap.put(followerId, new HashSet<>());
      followeeMap.get(followerId).add(followerId);
    }
    followeeMap.get(followerId).add(followeeId);
  }

  public void unfollow(int followerId, int followeeId) {
    if (followerId == followeeId) return;
    if (followeeMap.containsKey(followerId)) followeeMap.get(followerId).remove(followeeId);
  }

  private int timer() {
    return timestamp++;
  }

  class Tweet {
    Tweet next;
    private final int ts;
    final int tId;

    public Tweet(int ts, int tId, Tweet next) {
      this.ts = ts;
      this.tId = tId;
      this.next = next;
    }
  }
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId); List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId); obj.unfollow(followerId,followeeId);
 */
