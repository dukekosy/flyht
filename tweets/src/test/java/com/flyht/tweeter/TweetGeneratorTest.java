package com.flyht.tweeter;

import com.flyht.tweeter.Tweet;
import com.flyht.tweeter.TweetGenerator;
import com.google.common.collect.Lists;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TweetGeneratorTest {

    static TweetGenerator tweetGenerator;

    @BeforeClass
    public static void setUp() throws Exception {
        tweetGenerator = new TweetGenerator(Lists.newArrayList("Crab","Fish","Whale"));
    }

    @Test
    public void generateTweet_checkIfRuns_runs() {
        Tweet tweet = tweetGenerator.generateTweet();
    }

    @Test
    public void generateTweet_checkIfTweetContainsATopic_hasOneTopicString() {
        assertTrue(tweetGenerator.generateTweet().getTweet().chars().allMatch(Character::isLetter));
    }

    @Test
    public void generateTweet_checkIfTweetDoesnotContainATopic_hasRandomText() {
        assertTrue(tweetGenerator.generateTweet().getTweet().chars().allMatch(Character::isLetter));
    }
}