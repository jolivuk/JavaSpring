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

    //    public static <T> String toJson(T obj) {
//        Map<String, ?> fieldNameValue =
//                Arrays.stream(obj.getClass().getDeclaredFields())
//                        .peek(field -> field.setAccessible(true))
//                        .collect(Collectors.toMap(field -> field.getName(), field -> {
//                            try {
//                                return field.get(obj);
//                            } catch (IllegalAccessException e) {
//                                throw new RuntimeException(e);
//                            }
//                        }));
////        String sb = "{" + fieldNameValue.entrySet().stream()
////                .map(pair -> ("\"" + pair.getKey() + "\": " + prepareValue(pair.getValue())))
////                .collect(Collectors.joining(",")) +
////                //  fieldNameValue.forEach((k, v) -> sb.append("\"" + k + "\": " + prepareValue(v)));
////                "}";
//
//
//
//
//        return jsonString;
//    }
    public static <T> String toJson(T obj) {
        // Создаем отображение имен полей и их значений
        Map<String, ?> fieldNameValue =
                Arrays.stream(obj.getClass().getDeclaredFields())
                        .peek(field -> field.setAccessible(true))
                        .collect(Collectors.toMap(
                                field -> field.getName(),
                                field -> {
                                    try {
                                        return field.get(obj);
                                    } catch (IllegalAccessException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                        ));
        String jsonString = "{" + fieldNameValue.entrySet().stream()
                .map(pair -> "\"" + pair.getKey() + "\": " + prepareValue(pair.getValue()))
                .collect(Collectors.joining(", ")) +
                "}";
        return jsonString;
    }


    private static String prepareValue(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof String) {
            return "\"" + value + "\"";
        } else if (value instanceof Number || value instanceof Boolean) {
            return value.toString();
        } else if (value instanceof Object){
            return toJson(value);
        } else throw new IllegalArgumentException("Error");
    }

}
