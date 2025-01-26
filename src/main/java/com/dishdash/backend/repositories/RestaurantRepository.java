package com.dishdash.backend.repositories;

import com.dishdash.backend.models.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository
        extends JpaRepository<RestaurantEntity, String>
{

}

