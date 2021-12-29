package main.java.com.bilgeadam.connection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class City {
    @BsonProperty (value = "city_name")
    private String name;
    @BsonProperty (value = "latitude")
    private double latitude;
    @BsonProperty (value = "longitude")
    private double longitude;
    @BsonProperty (value = "altitude")
    private double altitude;
    @BsonProperty (value = "city_population")
    private long population;
    @BsonProperty (value = "city_code")
    private String cityCode;

}
