package com.example.LearnModulith.order.dto;

import com.example.LearnModulith.eventaction.action.Action;
import com.example.LearnModulith.eventaction.action.CustomEventMarker;
import org.jmolecules.event.types.DomainEvent;

@CustomEventMarker(eventAction = Action.EMAIL)
public record EmailDto (String email, String customerName, String orderIdentifier, long totalAmount, boolean orderCompleted)
    implements DomainEvent {
}
