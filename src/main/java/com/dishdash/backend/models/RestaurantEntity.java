package com.dishdash.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

// Java class that maps to restaurants table in database.
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "restaurants")
public class RestaurantEntity
{

    @Id private String id;

    @NotNull @Column(unique = true) private String restaurantId;

    @NotNull private String name;

    @NotNull private String imageUrl;

    @NotNull private Double latitude;

    @NotNull private Double longitude;

    @NotNull private LocalTime opensAt;

    @NotNull private LocalTime closesAt;

    @NotNull private List<String> attributes = new ArrayList<>();
}
