package com.example.LearnModulith.inventory.exposed;

import java.util.List;

public interface InventoryService {
    InventoryDto fetchInventoryByName(String name);
    List<InventoryDto> fetchAllInName(List<String> name);
}
