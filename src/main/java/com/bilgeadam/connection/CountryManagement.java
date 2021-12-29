package main.java.com.bilgeadam.connection;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class CountryManagement {
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private List<Country> countries;

    public CountryManagement() {
        this.client = new MongoClient("localhost", 27017);
        this.database = client.getDatabase("first_db");
        this.collection = database.getCollection("countries");
        this.countries = new ArrayList<>();
    }
    public static void main(String[] args) {
        CountryManagement countryManagement = new CountryManagement();



    }
}
