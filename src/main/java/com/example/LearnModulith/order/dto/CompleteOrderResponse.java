package com.example.LearnModulith.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;


public record CompleteOrderResponse(boolean paymentComplete) {
}
