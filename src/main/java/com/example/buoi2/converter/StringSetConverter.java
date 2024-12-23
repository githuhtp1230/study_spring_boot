package com.example.buoi2.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Converter
public class StringSetConverter implements AttributeConverter<Set<String>, String> {

    @Override
    public String convertToDatabaseColumn(Set<String> attribute) {
        // Chuyển Set thành chuỗi, ngăn cách bởi dấu phẩy
        return attribute != null ? String.join(",", attribute) : null;
    }

    @Override
    public Set<String> convertToEntityAttribute(String dbData) {
        // Chuyển chuỗi từ database thành Set
        return dbData != null && !dbData.isEmpty()
                ? new HashSet<>(Arrays.asList(dbData.split(",")))
                : new HashSet<>();
    }
}