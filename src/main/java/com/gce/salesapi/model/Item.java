package com.gce.salesapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonPropertyOrder({"resourceId"})
@NoArgsConstructor
@Document(collection = "items")
public class Item {

    @Id
    private String id;
    private String title;
    private String description;
    private Double price;
    private Integer stock;
    private Location location;
    private List<String> comments = new ArrayList<>();

    @Builder
    public Item(String id, String title, String description, Double price, Integer stock, Location location, List<String> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.location = location;
        this.comments = comments;
    }

    public String getResourceId() {
        return id;
    }

}

