# flyht

The key word here is realtime. I first looked at using an event drivern pattern using queues with an Observer pattern. I wasn't sure of this. I felt the queue and observer will become a bottle neck. the number of observers are limited to the implementation at run time so I kept searching. 

I started researching realtime design patterns. Found a number of articles on concurrent patterns and remembered thread pool. Felt this would work best. Did some initial tests that proved fruitful.

Do I need to do a tweeter rest client implementation. Even if I did how would you create sufficient test data. Decided to simulation this. 

Created all the parts independently, file writing, threadpool, generating tweets and combined their use in a main method. 

I have set the threadpool size to 300 for now, ideally this would come off a property file.

to run checkout the repository, 
 
run mvn clean install, 

go to the target folder and run, 

java -cp tweets-1.0-SNAPSHOT.jar com.flyht.Tweet


 