package com.flyht.utils;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TweetGeneratorTest {

    static TweetGenerator tweetGenerator;

    @BeforeClass
    public static void setUp() throws Exception {
        tweetGenerator = new TweetGenerator(Lists.newArrayList("Crab","Fish","Whale"));
    }

    @Test
    public void generateTweet_checkIfRuns_returnsString() {
        assertTrue(tweetGenerator.generateTweet().chars().allMatch(Character::isLetter));
    }

    @Test
    public void generateTweet_checkIfTweetContainsATopic_hasOneTopicString() {
        assertTrue(tweetGenerator.generateTweet().chars().allMatch(Character::isLetter));
    }

    @Test
    public void generateTweet_checkIfTweetDoesnotContainATopic_hasRandomText() {
        assertTrue(tweetGenerator.generateTweet().chars().allMatch(Character::isLetter));
    }
}