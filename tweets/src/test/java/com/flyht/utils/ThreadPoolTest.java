package com.flyht.utils;

import com.flyht.tweeter.Tweet;
import org.junit.Test;

import java.util.concurrent.RejectedExecutionException;

public class ThreadPoolTest {


    @Test
    public void run_runsSuccessfully() {
        ThreadPool threadPool = new ThreadPool(300);
        threadPool.run(new Tweet("golf", "Golf is great"));
        threadPool.shutdown();
    }

    @Test(expected = RejectedExecutionException.class)
    public void shutdown_testIfShutDown() {
        ThreadPool threadPool = new ThreadPool(300);
        threadPool.run(new Tweet("golf", "Golf is great"));
        threadPool.shutdown();
        threadPool.run(new Tweet("tennis", "ball"));
    }
}
