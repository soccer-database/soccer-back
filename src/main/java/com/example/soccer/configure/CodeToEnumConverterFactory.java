package com.example.soccer.configure;

import com.example.soccer.domain.classes.SquadName;
import java.util.Arrays;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

public class CodeToEnumConverterFactory implements ConverterFactory<String, SquadName> {

    @Override
    public <T extends SquadName> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToEnumsConverter<>(targetType);
    }

    private static final class StringToEnumsConverter<T extends SquadName> implements
        Converter<String, T> {

        private final Class<T> enumType;
        private final boolean constantEnum;

        public StringToEnumsConverter(Class<T> enumType) {
            this.enumType = enumType;
            this.constantEnum = Arrays.stream(enumType.getInterfaces())
                .anyMatch(i -> i == SquadName.class);
        }

        @Override
        public T convert(String source) {
            if (source.isEmpty()) {
                return null;
            }

            T[] constants = enumType.getEnumConstants();
            for (T c : constants) {
                if (c.name.equals(source.trim())) {
                    return c;
                }
                if (c.name().equals(source.trim())) {
                    return c;
                }
            }
            return null;
        }
    }
}
