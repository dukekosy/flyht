package com.flyht.utils;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChannelFileWriterTest {

    @Test
    public void writeTweet_runsSuccessfully() throws IOException {
        new ChannelFileWriter("soccer", "Let's play ball"+"\n").writeTweet();
    }

    @Test
    public void writeTweet_readText_identicalToWritten() throws IOException {
        String fileName = "tennis";
        String tweet = "Let's play ball";
        ChannelFileWriter channelFileWriter = new ChannelFileWriter(fileName, tweet + "\n");
        channelFileWriter.writeTweet();
        assertThat(getLastLine(fileName+ ".txt"), is(tweet));
    }

    private String getLastLine(String path)
            throws IOException {

        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        String lastLine = "";
        String sCurrentLine = "";
        while ((sCurrentLine = br.readLine()) != null) {
            lastLine = sCurrentLine;
        }
        fr.close();
        br.close();
        return lastLine;
    }

}
