package com.example.LearnModulith.order;

import com.example.LearnModulith.order.dto.OrderPaymentDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderEventService {
    private final ApplicationEventPublisher applicationEventPublisher;
    @Transactional
    public void createOrder(final OrderPaymentDto orderPaymentDto) {
        log.info("Completing order payment with details: {}", orderPaymentDto);
        applicationEventPublisher.publishEvent(orderPaymentDto);
    }
    //Don't know why i have to put @Transactional before publishEvent
}
