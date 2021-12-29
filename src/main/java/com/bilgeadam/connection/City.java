package main.java.com.bilgeadam.connection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@AllArgsConstructor
@ToString
@Builder
public class City {
    private String name;
    private double latitude;
    private double longtitude;
    private double altitude;
    private long population;
    private String cityCode;

    public City(String name) {
        super();
        this.name = name;
    }
}
