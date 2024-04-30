package com.switchfully.eurder.item.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
    @Override
    Optional<Item> findById(UUID uuid);

    Optional<Item> findByName(String name);
    //Must verify if it works
    @Query("SELECT i.price FROM Item i WHERE i.id = ?1")
    public double getPriceById(UUID uuid);
}
