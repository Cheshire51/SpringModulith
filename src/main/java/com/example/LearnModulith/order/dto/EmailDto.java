package com.example.LearnModulith.order.dto;

import com.example.LearnModulith.eventaction.action.Action;
import com.example.LearnModulith.eventaction.action.CustomEventMarker;

@CustomEventMarker(eventAction = Action.EMAIL)
public record EmailDto (String email, String customerName, String orderIdentifier, long totalAmount, boolean orderCompleted){
}
