package main.java.com.bilgeadam.connection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@ToString
@Builder
public class Country {
    private String name;
    private City capital;
    private int telCode;
    private String countryCode;
    private ArrayList<City> cities;
    private long population;
}
