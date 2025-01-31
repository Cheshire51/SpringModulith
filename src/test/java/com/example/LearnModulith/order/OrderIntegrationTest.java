package com.example.LearnModulith.order;

import com.example.LearnModulith.order.dto.InventoryRequestDto;
import com.example.LearnModulith.order.dto.OrderDto;
import com.example.LearnModulith.order.dto.OrderResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest(mode = ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES)
class OrderIntegrationTest {

    @Autowired
    OrderService orderService;

    @Test
    void verify()
    {

    }

    @Test
    void createOrder() {
        List<InventoryRequestDto> inventoryDtoList = List.of(
                new InventoryRequestDto("ruler", 4),
                new InventoryRequestDto("pencil",3)
        );
        OrderDto orderDto = new OrderDto("Customer's name", "testtest123@gmail.com", inventoryDtoList);
        OrderResponseDto order = orderService.createOrder(orderDto);
        assertThat(order.message()).isEqualTo("Order Currently Processed");
        assertThat(order.statusCode()).isEqualTo(102);
    }
}