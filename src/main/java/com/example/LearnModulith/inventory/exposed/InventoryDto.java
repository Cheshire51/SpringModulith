package com.example.LearnModulith.inventory.exposed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public record InventoryDto ( Long id, String name, String description, long price ){ }
