package com.example.LearnModulith.payment.typeconverter;

import com.example.LearnModulith.payment.type.PaymentStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter(autoApply = true)
public class PaymentStatusConverter implements AttributeConverter<PaymentStatus, String> {

    @Override
    public String convertToDatabaseColumn(PaymentStatus paymentStatus) {
        if (paymentStatus == null) throw new NullPointerException("PaymentStatus can not be null");
        return paymentStatus.getCode();
    }

    @Override
    public PaymentStatus convertToEntityAttribute(String code) {
        if (code == null) throw new NullPointerException("PaymentStatus can not be null");
        return Arrays.stream(PaymentStatus.values())
                .filter(s->s.getCode().equalsIgnoreCase(code))
                .findFirst().orElseThrow(()->new IllegalArgumentException("Invalid PaymentStatus code: " + code));
    }
}
