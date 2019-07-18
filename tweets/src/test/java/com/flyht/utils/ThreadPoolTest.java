package com.flyht.utils;

import com.flyht.tweeter.Tweet;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class ThreadPoolTest {

    private ChannelFileWriter channelFileWriter;
    private ExecutorService executorService;

    @Before
    public void setup() {
        executorService = mock(ExecutorService.class);
    }

    @Test
    public void run_runsSuccessfully() {
        ThreadPool threadPool = new ThreadPool(300);
        threadPool.run(new Tweet("golf", "Golf is great"));
        threadPool.shutdown();
    }

    @Test
    public void run_confirmExecutorServiceRuns() {
        ThreadPool threadPool = new ThreadPool(300);
        threadPool.run(new Tweet("golf", "Golf is great"));
        threadPool.shutdown();
        verify(executorService).execute(Matchers.any(Runnable.class));
    }

    @Test
    public void run_confirmChannelFileWriterRuns() throws IOException {

        channelFileWriter = mock(ChannelFileWriter.class);
        ThreadPool threadPool = new ThreadPool(300);
        threadPool.run(new Tweet("golf", "Golf is great"));
        verify(channelFileWriter).writeTweet();
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
