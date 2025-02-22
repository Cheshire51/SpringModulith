package com.example.LearnModulith.order;

import com.example.LearnModulith.order.dto.CompleteOrder;
import com.example.LearnModulith.order.dto.EmailDto;
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
    public void createOrder(final OrderPaymentDto orderPaymentDto, EmailDto emailDto) {
        log.info("Completing order payment with details: {}", orderPaymentDto);
        applicationEventPublisher.publishEvent(orderPaymentDto);

        log.info("Sending email for order {}", emailDto);
        applicationEventPublisher.publishEvent(emailDto);
    }

    @Transactional
    public void completePayment(CompleteOrder completeOrder, EmailDto emailDto) {
        log.info("Attempting to complete payment: {}", completeOrder);
        applicationEventPublisher.publishEvent(completeOrder);

        log.info("Completing payment Email: {}", emailDto);
        applicationEventPublisher.publishEvent(emailDto);
    }
    //Don't know why i have to put @Transactional before publishEvent
}
