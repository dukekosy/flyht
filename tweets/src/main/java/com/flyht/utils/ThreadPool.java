package com.flyht.utils;

import com.flyht.tweeter.Tweet;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class ThreadPool {

    private final ExecutorService executorService;

    public ThreadPool(int workers) {
        executorService = Executors.newFixedThreadPool(workers);
    }

    public void run(Tweet tweet) {
        Runnable runnableTask = () -> {
            try {
                try {
                    new ChannelFileWriter(tweet.getFileName(), tweet.getTweet()).writeTweet();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executorService.execute(runnableTask);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
