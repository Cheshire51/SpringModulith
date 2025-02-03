package com.example.LearnModulith.eventaction.action;

import com.example.LearnModulith.exception.ModulithException;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter(autoApply = true)
public class ActionConverter implements AttributeConverter<Action, String> {

    @Override
    public String convertToDatabaseColumn(Action action) {
        if (action == null) throw new ModulithException("action is null");
        return action.getCode();
    }

    @Override
    public Action convertToEntityAttribute(String s) {
        if (s == null) throw new RuntimeException("code is null");
        return Arrays.stream(Action.values())
                .filter(action-> action.getCode().equalsIgnoreCase(s))
                .findFirst().orElseThrow(()->new ModulithException("action not found"));
    }
}
