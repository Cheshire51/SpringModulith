package com.example.LearnModulith.order.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record OrderDto (
        @NotBlank(message = "Customer's name is required")
        String customerName,
        @NotBlank(message = "Customer's email is required")
        String customerEmail,
        @Valid
        List<InventoryRequestDto> inventoryRequestDtoList) { }
