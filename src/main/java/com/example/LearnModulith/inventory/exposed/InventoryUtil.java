package com.example.LearnModulith.inventory.exposed;

import com.example.LearnModulith.inventory.Inventory;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InventoryUtil {
    public InventoryDto mapInventoryDto(Inventory inventory) {
        return new InventoryDto(inventory.getId(), inventory.getName(), inventory.getDescription(), inventory.getPrice());
    }
}
