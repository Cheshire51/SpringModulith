package com.example.LearnModulith.order;

import com.example.LearnModulith.inventory.exposed.InventoryDto;
import com.example.LearnModulith.inventory.exposed.InventoryService;
import com.example.LearnModulith.order.dto.InventoryRequestDto;
import com.example.LearnModulith.order.dto.OrderDto;
import com.example.LearnModulith.order.dto.OrderResponseDto;
import com.example.LearnModulith.order.type.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final InventoryService inventoryService;
    private final OrderRepository orderRepository;
    private final OrderInventoryRepo orderInventoryRepo;

    public OrderResponseDto createOrder(OrderDto orderDto) {

        //get request inventories' name
        List<String> list =orderDto.inventoryRequestDtoList().stream()
                .map(InventoryRequestDto::inventoryName)
                .toList();

        //get inventories
        List<InventoryDto> inventoryDtoList= inventoryService.fetchAllInName(list);

        //persist the order
        Order order = buildAndPersistOrder(orderDto);
        log.info("Order created + {} ", order);
        //build and persist the orderInventory
        final AtomicLong amount = new AtomicLong();
        buildAndPersistOrderInventory(orderDto, inventoryDtoList, order.getId(), amount);
        return new OrderResponseDto("Order Currently Processed", 102);
    }

    private void buildAndPersistOrderInventory (OrderDto orderDto, List<InventoryDto> inventories, long orderIdentifier, AtomicLong amount) {
        List<OrderInventory> orderInventories = new ArrayList<>(inventories.size());
        inventories.forEach(inventoryDto -> {
            OrderInventory orderInventory = new OrderInventory();
            InventoryRequestDto inventoryRequestDto = getInventoryRequestDtoByName(inventoryDto.name(), orderDto.inventoryRequestDtoList());
            orderInventory.setOrderId(orderIdentifier);
            orderInventory.setInventoryId(inventoryDto.id());
            orderInventory.setQuantity(inventoryRequestDto.qty());

            long total = inventoryDto.price()*inventoryRequestDto.qty();
            orderInventory.setTotalQtyPrice(total);
            orderInventories.add(orderInventory);
            amount.addAndGet(total);
        });

        log.info("Order Inventories persisted {}", orderInventories);
        orderInventoryRepo.saveAll(orderInventories);
    }

    private static InventoryRequestDto getInventoryRequestDtoByName (String inventoryName, List<InventoryRequestDto> inventoryRequestDtoList)
    {
        return inventoryRequestDtoList.stream()
                .filter(inventoryRequestDto -> inventoryRequestDto.inventoryName().equals(inventoryName))
                .findFirst().orElse(null);
    }

    private Order buildAndPersistOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderIdentifier(UUID.randomUUID().toString());
        order.setCustomerName(orderDto.customerName());
        order.setCustomerEmail(orderDto.customerEmail());
        order.setStatus(Status.COMPLETED);
        return orderRepository.save(order);
    }
}
