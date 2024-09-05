package org.example.homeworks.Homework1.json;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.example.homeworks.Homework1.ConstantsTypes.*;

public class JsonConverter {


    public JsonConverter() {

    }

    public static <T> String toJson(T obj) {
        Map<String, ?> fieldNameValue =
                Arrays.stream(obj.getClass().getDeclaredFields())
                        .peek(field -> field.setAccessible(true))
                        .collect(Collectors.toMap(field -> field.getName(), field -> {
                            try {
                                return field.get(obj);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }));
        String sb = "{" + fieldNameValue.entrySet().stream()
                .map(pair -> ("\"" + pair.getKey() + "\": " + prepareValue(pair.getValue())))
                .collect(Collectors.joining(",")) +
                //  fieldNameValue.forEach((k, v) -> sb.append("\"" + k + "\": " + prepareValue(v)));
                "}";


        return sb;
    }

    private static <V> String prepareValue(V value) {
        Class<?> clazz = value.getClass();
        if (value == null) {
            return "null";
        }

        if (value instanceof Collection<?>) {
            return "[" + ((Collection<?>) value).stream()
                    .map(e -> prepareValue(e))
                    .collect(Collectors.joining(", ")) + "]";
        }


        return switch (clazz.getSimpleName()) {
            case STRING_TYPE -> "\"" + value + "\": ";
            case INTEGER_TYPE, BOOLEAN_TYPE, DOUBLE_TYPE, FLOAT_TYPE, LONG_TYPE, CHAR_TYPE, BYTE_TYPE ->
                    value.toString();
            case LOCAL_DATE_TYPE -> ((LocalDate) value).format(FORMATTER);
            default -> throw new RuntimeException("Unknown type");
        };
    }
}
