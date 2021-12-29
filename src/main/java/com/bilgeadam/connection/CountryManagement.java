package main.java.com.bilgeadam.connection;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

public class CountryManagement {
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private List<Country> countries;

    public CountryManagement() {
        this.client = new MongoClient("localhost", 27017);
        this.database = client.getDatabase("mongoDB");
        this.collection = database.getCollection("countries");
        this.countries = new ArrayList<>();
    }
    public static void main(String[] args) {
        CountryManagement countryManager = new CountryManagement();
        countryManager.init();
        countryManager.insertData();
    }

    private void insertData() {
        PojoCodecProvider codecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),CodecRegistries.fromProviders(codecProvider));

        MongoCollection<Country> countryDocuments = database.withCodecRegistry(pojoCodecRegistry).getCollection("country",Country.class);
        countryDocuments.insertMany(countries);
    }

    private void init() {
        ArrayList<City> cities = new ArrayList<>();
        City city = City.builder().name("Ankara")
                .cityCode("06").population(5639076)
                .altitude(938).latitude(39.925533)
                .longitude(32.866287).build();
        City city2 = City.builder().name("İstanbul")
                .cityCode("34").population(15462452)
                .altitude(40).latitude(41.015137)
                .longitude(28.979530).build();
        City city3 = City.builder().name("Malatya")
                .cityCode("44").population(806156)
                .altitude(977).latitude(38.356869)
                .longitude(38.309669).build();
        City city4 = City.builder().name("İzmir")
                .cityCode("35").population(806156)
                .altitude(2).latitude(38.356869)
                .longitude(38.309669).build();
        cities.add(city);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);

        Country country = Country.builder().name("Turkey")
                .countryCode("TR").telCode(90)
                .capital(city).population(84342836).cities(cities).build();
        this.countries.add(country);
    }
}
