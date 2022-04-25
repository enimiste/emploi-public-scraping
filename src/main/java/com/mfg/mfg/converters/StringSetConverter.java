package com.mfg.mfg.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Converter(autoApply = true)
public class StringSetConverter implements AttributeConverter<Set<String>, String> {

    public static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(Set<String> attribute) {
        return attribute == null ? null : attribute.stream()
                .map(s -> s.replace(DELIMITER, ""))
                .collect(Collectors.joining(DELIMITER));
    }

    @Override
    public Set<String> convertToEntityAttribute(String dbData) {
        if (dbData == null) return new HashSet<>();
        return new HashSet<>(Arrays.asList(dbData.split(DELIMITER)));
    }
}
