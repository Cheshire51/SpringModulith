package com.example.LearnModulith.order;

import com.example.LearnModulith.order.dto.CompleteOrder;
import com.example.LearnModulith.order.dto.CompleteOrderResponse;
import com.example.LearnModulith.order.dto.OrderDto;
import com.example.LearnModulith.order.dto.OrderResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody @Valid OrderDto orderDto) {
        return new ResponseEntity<>(orderService.createOrder(orderDto), HttpStatus.OK);
    }
    //@Value must be placed after @RequestBody
    @PostMapping("/complete")
    public ResponseEntity<CompleteOrderResponse> completeOrder(@RequestBody CompleteOrder completeOrder)
    {
        return new ResponseEntity<CompleteOrderResponse>(orderService.completePayment(completeOrder), HttpStatus.OK);
    }
}
