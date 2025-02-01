package com.example.LearnModulith.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

interface InventoryRepository extends CrudRepository<Inventory, Long> {
    Optional<Inventory> getInventoryByName(String inventoryName);

    List<Inventory> getInventoriesByNameIn(List<String> inventoryNames);
}
