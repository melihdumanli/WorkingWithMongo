package main.java.com.bilgeadam.connection;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Connect2Database {
    public static void main(String[] args) {
        try(MongoClient client = new MongoClient("localhost", 27017)) {
            MongoDatabase database = client.getDatabase("first_db");
            System.out.println("MongoDB connection is successful");
        } catch (Exception e) {
            System.out.println("MongoDB connection is failed");
            e.printStackTrace();
        }
        //test
    }
}
