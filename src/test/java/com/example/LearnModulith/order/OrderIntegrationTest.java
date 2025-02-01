package com.example.LearnModulith.order;

import com.example.LearnModulith.order.dto.InventoryRequestDto;
import com.example.LearnModulith.order.dto.OrderDto;
import com.example.LearnModulith.order.dto.OrderPaymentDto;
import com.example.LearnModulith.order.dto.OrderResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import java.util.List;
import java.util.UUID;

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

    @Test
    void publishOrderPaymentDto(Scenario scenario) {
        scenario.publish(new OrderPaymentDto(UUID.randomUUID().toString(), 5000L))
                .andWaitForEventOfType(OrderPaymentDto.class)
                .matching(event -> event.amount() == 5000L)
                .toArriveAndVerify(ev -> System.out.println(ev.amount()));
    }
}