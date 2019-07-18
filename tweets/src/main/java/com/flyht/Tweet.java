package com.flyht;

import com.flyht.utils.ThreadPool;
import com.flyht.tweeter.TweetGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tweet {

    protected static List<String> getUserInput() {

        int maxTopics = 5, numberOfTopics = 0;
        while (numberOfTopics == 0 || numberOfTopics > maxTopics) {
            System.out.println("Enter number of topics, upto " + maxTopics + " different topics");
            Scanner sc = new Scanner(System.in);
            numberOfTopics = sc.nextInt();
        }
        List<String> topics = new ArrayList<>();
        for(int i = 0; i < numberOfTopics; i++) {
            System.out.println("Enter your a topic: ");
            Scanner scanner = new Scanner(System.in);
            topics.add(scanner.nextLine());
        }
        return topics;
    }

    public static void main( String[] args ) throws IOException {
        TweetGenerator tweetGenerator = new TweetGenerator(getUserInput());
        ThreadPool threadPool = new ThreadPool(300);
        System.out.println("Hit Enter to stop");
        while(true){
            com.flyht.tweeter.Tweet tweet = tweetGenerator.generateTweet();
            threadPool.run(tweet);
        }
    }

}
