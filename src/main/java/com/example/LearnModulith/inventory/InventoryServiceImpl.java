package com.example.LearnModulith.inventory;

import com.example.LearnModulith.exception.ModulithException;
import com.example.LearnModulith.inventory.exposed.InventoryDto;
import com.example.LearnModulith.inventory.exposed.InventoryService;
import com.example.LearnModulith.inventory.exposed.InventoryUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Override
    public InventoryDto fetchInventoryByName(String name) {
        return inventoryRepository.getInventoryByName(name)
                .map(InventoryUtil::mapInventoryDto)
                .orElseThrow(() -> new ModulithException("Inventory name not found"));
    }

    @Override
    public List<InventoryDto> fetchAllInName(List<String> name) {
        return inventoryRepository.getInventoriesByNameIn(name)
                .stream()
                .map(InventoryUtil::mapInventoryDto)
                .toList();
    }
}
