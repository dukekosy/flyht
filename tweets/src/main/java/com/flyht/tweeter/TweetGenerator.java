package com.flyht.tweeter;

import org.apache.commons.lang3.RandomStringUtils;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;

public final class TweetGenerator {

    private final List<String> topics;
    private final StringBuffer sb = new StringBuffer();

    public TweetGenerator(final List<String> topics) {
        if(topics.size() == 0) {
            System.out.println("Incorrect topic size");
            throw new IllegalArgumentException("Topic is empty");
        }
        this.topics = topics;
        for (int i = 0; i < 10; i++) {
            sb.append(RandomStringUtils.randomAlphabetic(new Random().nextInt(15)) + " ");
        }
    }

    public Tweet generateTweet() {//test for size
        String topic = topics.get(new Random().nextInt(topics.size()));
        return new Tweet(topic, sb.append(topic).append("\n").toString());
    }

}
