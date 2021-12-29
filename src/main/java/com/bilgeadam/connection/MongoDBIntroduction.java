package main.java.com.bilgeadam.connection;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDBIntroduction {
    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> collection;

    public MongoDBIntroduction() {
        this.client = null;
        this.database = null;
        this.collection = null;
    }
    public static void main(String[] args) {
       MongoDBIntroduction intro = new MongoDBIntroduction();
       intro.init();
       intro.addSingleDocument();
       intro.addMultipleDocuments();
       /*intro.deleteDocument();
       intro.deleteMultipleDocuments();*/
       intro.listDocuments();
       intro.updateDocuments();

    }

    private void updateDocuments() {
        /*this.collection.updateMany(Filters.eq("title","test completed"), new Document("$set",new Document("title","test in progress")));*/
        this.collection.updateMany(Filters.eq("title", "test in progress"), Updates.set("properties", "Istanbul"));
        System.out.println("Update Completed");
    }

    private void listDocuments() {
        FindIterable<Document> documents = this.collection.find();
        MongoCursor<Document> documentMongoCursor = documents.iterator();
        while (documentMongoCursor.hasNext()) {
            System.out.println(documentMongoCursor.next());
        }
    }

    private void deleteMultipleDocuments() {
        this.collection.deleteMany(Filters.eq("title","My Mongo DB"));
        System.out.println("Multiple documents deleted.");
    }

    private void deleteDocument() {
        this.collection.deleteOne(Filters.eq("title","Test element"));
        System.out.println("Single document deleted.");
    }

    private void addMultipleDocuments(){
        List<Document> myDocuments = new ArrayList<>();
        myDocuments.add(new Document("title","Test element"));
        myDocuments.add(new Document("title", "another test").append("description","when i was a young boy"));
        myDocuments.add(new Document("title", "final test").append("properties","I am a property"));
        this.collection.insertMany(myDocuments);
        System.out.println("Documents Added.");
    }

    private void addSingleDocument(){
        Document document = new Document("title", "My Mongo DB");
        this.collection.insertOne(document);
        System.out.println("First document added");
    }

    private void init(){
        this.client = new MongoClient("localhost", 27017);
        this.database = client.getDatabase("first_db");
        System.out.println("MongoDB connection is successful");

        this.collection = database.getCollection("first_collection");
        System.out.println("Collection is created");
    }
}
