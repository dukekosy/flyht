package com.flyht.utils;

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

    public String generateTweet() {
        if(new Random().nextBoolean())
            return sb.append(topics.get(new Random().nextInt(topics.size()-1))).toString();
        else
            return sb.toString();
    }
}
