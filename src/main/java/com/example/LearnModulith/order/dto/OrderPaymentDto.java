package com.example.LearnModulith.order.dto;

import com.example.LearnModulith.eventaction.action.Action;
import com.example.LearnModulith.eventaction.action.CustomEventMarker;
import org.jmolecules.event.types.DomainEvent;


@CustomEventMarker(eventAction = Action.PAYMENT)
public record OrderPaymentDto(String orderId, long amount) implements DomainEvent {
}
