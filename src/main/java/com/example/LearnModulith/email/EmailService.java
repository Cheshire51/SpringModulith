package com.example.LearnModulith.email;

import com.example.LearnModulith.order.dto.EmailDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    @ApplicationModuleListener
    void sendEmail(final EmailDto emailDto)
    {
        log.info("Email properties received ");
        if (!emailDto.orderCompleted())
        {
            String body = "Dear" +emailDto.customerName()+ ", \n" +
                    "An order has been initialize with id: " + emailDto.orderIdentifier()+
                    " and total sum of: "+ emailDto.totalAmount();
            log.info("Initialize order with order details: {}", body);
        }
        else {
            String body = "Dear" +emailDto.customerName()+ ", \n" +
                    "Your order with id: " + emailDto.orderIdentifier()+
                    " and total sum of: "+ emailDto.totalAmount() + "has completed successfully";
            log.info("Email completed details: {}", body);
        }
        log.info("Email sent to: {}", emailDto.email());
    }
}
