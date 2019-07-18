package com.flyht.tweeter;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TweetGeneratorTest {

    @Test
    public void generateTweet_checkIfRuns_runsSuccessfully() {
        Tweet tweet = new TweetGenerator(Lists.newArrayList("Crab", "Fish", "Whale")).generateTweet();
    }

    @Test
    public void generateTweet_checkIfTweetContainsLetters_returnsTrue() {
        assertTrue(new TweetGenerator(Lists.newArrayList("Crab", "Fish", "Whale")).generateTweet()
                                                                                  .getTweet()
                                                                                  .replaceAll("\\s", "")
                                                                                  .chars()
                                                                                  .allMatch(Character::isLetter));
    }

    @Test
    public void generateTweet_checkIfTweetContainsATopic_hasOneTopicString() {
        Tweet tweet = new TweetGenerator(Lists.newArrayList("Crab", "Fish", "Whale")).generateTweet();
        assertTrue(tweet.getTweet().contains("Crab") || tweet.getTweet().contains("Fish") || tweet.getTweet().contains("Whale"));
        assertTrue(tweet.getFileName().contains("Crab") || tweet.getFileName().contains("Fish") || tweet.getFileName().contains("Whale"));
    }

    @Test
    public void generateTweet_checkIfTweetDoesnotOnlyContainsATopic_returnsTrueWhenMoreThanTopicIsPresent() {
        Tweet tweet = new TweetGenerator(Lists.newArrayList("Crab", "Fish", "Whale")).generateTweet();
        assertTrue(tweet.getTweet().contains("Crab") || tweet.getTweet().contains("Fish") || tweet.getTweet().contains("Whale"));
        assertTrue(tweet.getTweet().split(tweet.getFileName()).length > 1);
    }
}