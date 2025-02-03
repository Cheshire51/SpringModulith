package com.example.LearnModulith.order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record InventoryRequestDto(
        @NotBlank(message = "Inventory's name is required")
        String inventoryName,
        @Min(value = 1L, message = "Quantity must be greater than zero")
        int qty) { }
