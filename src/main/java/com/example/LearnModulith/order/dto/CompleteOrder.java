package com.example.LearnModulith.order.dto;

import com.example.LearnModulith.eventaction.action.Action;
import com.example.LearnModulith.eventaction.action.CustomEventMarker;
import jakarta.validation.constraints.NotBlank;
import org.jmolecules.event.types.DomainEvent;


@CustomEventMarker(eventAction = Action.COMPLETE_PAYMENT)
public record CompleteOrder(
        @NotBlank(message = "OrderId is required")
        String orderIdentifier, boolean paymentComplete) implements DomainEvent {
}
