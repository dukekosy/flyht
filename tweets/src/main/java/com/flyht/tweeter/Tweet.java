package com.flyht.tweeter;

import java.util.Objects;

public class Tweet {

    private String fileName;
    private String tweet;

    public Tweet(String fileName, String tweet) {
        this.fileName = fileName;
        this.tweet = tweet;
    }

    public String getFileName() {
        return fileName;
    }

    public String getTweet() {
        return tweet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tweet)) {
            return false;
        }
        Tweet tweet1 = (Tweet) o;
        return Objects.equals(fileName, tweet1.fileName) &&
                Objects.equals(tweet, tweet1.tweet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, tweet);
    }
}
