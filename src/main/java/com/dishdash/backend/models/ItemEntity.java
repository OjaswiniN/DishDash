package com.dishdash.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "items")
public class ItemEntity
{

    @Id private String id;

    @NotNull @Column(unique = true) private String itemId;

    @NotNull private String name;

    @NotNull private String imageUrl;

    @NotNull private Double price;

    @NotNull private List<String> attributes = new ArrayList<>();
}
