package com.dishdash.backend.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant
{
    @JsonProperty("restaurantId") private String restaurantId;
    @JsonProperty("name") private String name;
    @JsonProperty("city") private String city;
    @JsonProperty("imageUrl") private String imageUrl;
    @JsonProperty("latitude") private double latitude;
    @JsonProperty("longitude") private double longitude;
    @JsonProperty("opensAt") private String opensAt;
    @JsonProperty("closesAt") private String closesAt;
    @JsonProperty("attributes") private List<String> attributes;
}
