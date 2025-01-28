package com.example.LearnModulith.inventory.exposed;

import com.example.LearnModulith.inventory.Inventory;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InventoryUtil {
    public InventoryDto mapInventoryDto(Inventory inventory) {
        return InventoryDto.builder()
                .id(inventory.getId())
                .name(inventory.getName())
                .description(inventory.getDescription())
                .price(inventory.getPrice())
                .build();
    }
}
