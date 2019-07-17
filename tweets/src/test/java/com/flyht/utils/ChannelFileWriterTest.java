package com.flyht.utils;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ChannelFileWriterTest {

    @Test
    public void writeTweet_runsSuccessfully() throws IOException {
       new ChannelFileWriter("soccer", "Let's play ball").writeTweet();
    }

    @Test
    public void writeTweet_readText_identicalToWritten() throws IOException {
        ChannelFileWriter channelFileWriter = new ChannelFileWriter("tennis", "Let's play ball");
        channelFileWriter.writeTweet();
    }
}
