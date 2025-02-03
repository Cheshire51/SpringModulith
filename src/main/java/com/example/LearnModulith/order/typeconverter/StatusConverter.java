package com.example.LearnModulith.order.typeconverter;

import com.example.LearnModulith.exception.ModulithException;
import com.example.LearnModulith.order.type.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        return Arrays.stream(Status.values())
                .filter(s->s == status)
                .map(Status::getCode)
                .findFirst().orElseThrow( () -> new ModulithException("No status found"));
    }

    @Override
    public Status convertToEntityAttribute(String code) {
        return Arrays.stream(Status.values())
                .filter(s-> s.getCode().equalsIgnoreCase(code))
                .findFirst().orElseThrow( () -> new ModulithException("No status found"));
    }
}
