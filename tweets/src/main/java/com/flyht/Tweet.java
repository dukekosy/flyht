package com.flyht;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tweet {

    protected static List<String> getUserInput() {

        int maxTopics = 5, numberOfTopics = 0;
        while (numberOfTopics == 0 || numberOfTopics > maxTopics) {
            System.out.println("Enter upto " + maxTopics + " different topics");
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

    public static void main( String[] args ) {
        List<String> topics = getUserInput();
        System.out.println(topics);
    }

}
