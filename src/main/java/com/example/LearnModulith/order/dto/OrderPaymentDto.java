package com.example.LearnModulith.order.dto;

import org.jmolecules.event.types.DomainEvent;

import java.io.Serializable;

public record OrderPaymentDto(String orderId, long amount) implements DomainEvent {
}
