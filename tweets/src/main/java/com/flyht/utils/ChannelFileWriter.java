package com.flyht.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public final class ChannelFileWriter {

    private final String fileName;
    private final String tweet;

    public ChannelFileWriter(String fileName, String tweet) {
        this.fileName = fileName;
        this.tweet = tweet;
    }

    public void writeTweet() throws IOException {

        byte [] inputBytes = tweet.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(inputBytes);

        FileOutputStream fos = null;
        FileChannel fileChannel = null;
        try {
            fos = new FileOutputStream(fileName + ".txt", true);
            fileChannel = fos.getChannel();
            fileChannel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileChannel.close();
            fos.close();
        }
    }
}
