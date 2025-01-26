package com.dishdash.backend.controller;

import com.dishdash.backend.dto.GetRestaurantsRequest;
import com.dishdash.backend.dto.GetRestaurantsResponse;
import com.dishdash.backend.pojo.Restaurant;
import com.dishdash.backend.services.RestaurantService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("api/v1/restaurants")
public class RestaurantController
{
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<GetRestaurantsResponse> getRestaurants(
            GetRestaurantsRequest getRestaurantsRequest) {
        log.info("GET RestaurantsRequest : {}", getRestaurantsRequest);
        GetRestaurantsResponse getRestaurantsResponse;
        if (getRestaurantsRequest.getLatitude() != null && getRestaurantsRequest.getLongitude() != null
                && getRestaurantsRequest.getLatitude() >= -90 && getRestaurantsRequest.getLatitude() <= 90
                && getRestaurantsRequest.getLongitude() >= -180
                && getRestaurantsRequest.getLongitude() <= 180) {
            getRestaurantsResponse = restaurantService
                    .findAllRestaurantsCloseBy(getRestaurantsRequest, LocalTime.now());
            log.info("GET RestaurantsRequest returned {}", getRestaurantsResponse);

            List<Restaurant> restaurants = getRestaurantsResponse.getRestaurants();
            for (Restaurant r : restaurants) {
                String s = r.getName().replaceAll("[Â©éí]", "e");
                r.setName(s);
            }
            getRestaurantsResponse.setRestaurants(restaurants);
            return ResponseEntity.ok().body(getRestaurantsResponse);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
