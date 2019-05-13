package com.gce.salesapi.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Document
public class Location {

    @Id
    private String id;
    private String country;
    private String city;
    private List<Double> gpsCoorinates = new ArrayList<>();

    public String getId() {
        return id;
    }

    @Builder
    public Location(String country, String city, List<Double> gpsCoorinates) {
        this.country = country;
        this.city = city;
        this.gpsCoorinates = gpsCoorinates;
    }
}
