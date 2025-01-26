
/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.dishdash.backend.services;

import com.dishdash.backend.dto.GetRestaurantsRequest;
import com.dishdash.backend.dto.GetRestaurantsResponse;
import com.dishdash.backend.pojo.Restaurant;
import com.dishdash.backend.repositoryservices.RestaurantRepositoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
@Log4j2
public class RestaurantServiceImpl
        implements RestaurantService
{

    private final Double peakHoursServingRadiusInKms = 3.0;
    private final Double normalHoursServingRadiusInKms = 5.0;
    @Autowired private RestaurantRepositoryService restaurantRepositoryService;

    // TODO: CRIO_TASK_MODULE_RESTAURANTSAPI - Implement findAllRestaurantsCloseby.
    // Check RestaurantService.java file for the interface contract.
    @Override
    public GetRestaurantsResponse findAllRestaurantsCloseBy(GetRestaurantsRequest getRestaurantsRequest, LocalTime currentTime)
    {
        List<Restaurant> restaurant;
        int h = currentTime.getHour();
        int m = currentTime.getMinute();
        if ((h >= 8 && h <= 9) || (h == 10 && m == 0) || (h == 13) || (h == 14 && m == 0) || (h >= 19 && h <= 20) || (h == 21 && m == 0)) {
            restaurant = restaurantRepositoryService.findAllRestaurantsCloseBy(getRestaurantsRequest.getLatitude(), getRestaurantsRequest.getLongitude(), currentTime, peakHoursServingRadiusInKms);
        }
        else {
            restaurant = restaurantRepositoryService.findAllRestaurantsCloseBy(getRestaurantsRequest.getLatitude(), getRestaurantsRequest.getLongitude(), currentTime, normalHoursServingRadiusInKms);
        }
        GetRestaurantsResponse response = new GetRestaurantsResponse(restaurant);
        log.info(response);
        return response;
    }
}
    

