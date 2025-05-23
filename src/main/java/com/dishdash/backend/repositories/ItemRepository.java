package com.dishdash.backend.repositories;

import com.dishdash.backend.models.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository
        extends JpaRepository<ItemEntity, String>
{

}

