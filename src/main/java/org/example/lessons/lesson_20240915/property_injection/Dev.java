package org.example.lessons.lesson_20240915.property_injection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Dev {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext_propertyInjection.xml");
    }
}

/**
 * Создайте Spring-приложение, которое получает настройки host, port и
 * token из файла application.properties, используя @Value.
 */