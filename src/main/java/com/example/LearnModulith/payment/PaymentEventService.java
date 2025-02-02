package com.example.LearnModulith.payment;

import com.example.LearnModulith.order.dto.CompleteOrder;
import com.example.LearnModulith.order.dto.OrderPaymentDto;
import com.example.LearnModulith.payment.type.PaymentStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentEventService {
    private final PaymentRepository paymentRepository;

    @ApplicationModuleListener
    void on (OrderPaymentDto orderPaymentDto) {
        log.info("Order payment received in : {}", orderPaymentDto);

        Payment payment = new Payment();
        payment.setOrderId(orderPaymentDto.orderId());
        payment.setAmount(orderPaymentDto.amount());
        paymentRepository.save(payment);
    }

    @ApplicationModuleListener
    void on (final CompleteOrder completeOrder) {
        log.info("Complete order received in : {}", completeOrder);
        Optional<Payment> paymentOptional = paymentRepository.getPaymentByOrderId(completeOrder.orderIdentifier());
        if (paymentOptional.isPresent()) {
            Payment payment = paymentOptional.get();
            payment.setStatus(PaymentStatus.COMPLETED);
            paymentRepository.save(payment);
        }
    }
    //ApplicationModuleListener includes @Async + @TransactionalEventListener
}
