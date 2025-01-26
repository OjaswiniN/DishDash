package com.dishdash.backend.config;

import com.dishdash.backend.models.ItemEntity;
import com.dishdash.backend.models.RestaurantEntity;
import com.dishdash.backend.repositories.ItemRepository;
import com.dishdash.backend.repositories.RestaurantRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// To import the json data into the database.
@Component
public class SetupDataLoader
        implements ApplicationListener<ContextRefreshedEvent>
{

    @Autowired RestaurantRepository restaurantRepository;
    @Autowired ItemRepository itemRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        try {
            loadRestaurantDataIntoDatabase();
            loadItemsDataIntoDatabase();
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to load json data into database", e);
        }
    }

    // function to load restaurant.json data into restaurants table
    private void loadRestaurantDataIntoDatabase()
            throws IOException
    {
        // insert only if restaurants table is empty
        if (restaurantRepository.count() == 0) {
            Resource resource = new ClassPathResource("data/restaurants.json");
            InputStream inputStream = resource.getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule()); // Register Java 8 Date/Time support
            List<RestaurantEntity> restaurantEntityList = objectMapper.readValue(inputStream, new TypeReference<>() {});
            restaurantRepository.saveAll(restaurantEntityList);
        }
    }

    private void loadItemsDataIntoDatabase()
            throws IOException
    {
        if (itemRepository.count() == 0) {
            Resource resource = new ClassPathResource("data/items.json");
            InputStream inputStream = resource.getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            List<ItemEntity> itemEntityList = objectMapper.readValue(inputStream, new TypeReference<>() {});
            itemRepository.saveAll(itemEntityList);
        }
    }
}
