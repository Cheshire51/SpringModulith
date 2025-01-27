package com.example.LearnModulith.order.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    OPEN("0"), COMPLETED("C");
    private final String code;
}
