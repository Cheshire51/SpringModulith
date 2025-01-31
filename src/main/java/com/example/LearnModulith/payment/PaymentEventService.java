package com.example.LearnModulith.payment;

import com.example.LearnModulith.order.dto.OrderPaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentEventService {
    private final PaymentRepository paymentRepository;

    @ApplicationModuleListener
    void on (OrderPaymentDto orderPaymentDto) {
        log.info("Order payment received in : {}", orderPaymentDto);
    }
    //ApplicationModuleListener includes @Async + @TransactionalEventListener
}
