package com.dishdash.backend.dto;

import com.dishdash.backend.pojo.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetRestaurantsResponse
{
    List<Restaurant> restaurants;
}