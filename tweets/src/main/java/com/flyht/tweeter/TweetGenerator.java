package com.flyht.tweeter;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.Random;

public final class TweetGenerator {

    private final List<String> topics;
    private final StringBuffer sb = new StringBuffer();

    public TweetGenerator(final List<String> topics) {
        this.topics = topics;
        for(int i=0;i<10;i++) {
            sb.append(RandomStringUtils.randomAlphabetic(new Random().nextInt(15)) + " ");
        }
    }

    public Tweet generateTweet() {
        if(new Random().nextBoolean()) {//test for when topic is size 1. test for bounds for nextInt
            String topic = topics.get(new Random().nextInt(topics.size()));
            return new Tweet(topic, sb.append(topic).toString());
        }
        else
            return new Tweet("", sb.toString());
    }
}
