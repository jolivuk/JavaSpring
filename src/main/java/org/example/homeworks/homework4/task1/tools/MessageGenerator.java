package org.example.homeworks.homework4.task1.tools;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope("prototype")
public class MessageGenerator {
    private String message;

    public MessageGenerator() {
        LocalDateTime localDateTime = LocalDateTime.now();
        this.message = "Message " + localDateTime.toString();
    }

    @Override
    public String toString() {
        return message;
    }
}
/**
 *1 Создайте класс MessageGenerator, который генерирует уникальные сообщения с временной меткой. Каждый раз, когда бин
 * запрашивается из контекста, создаётся новый экземпляр MessageGenerator. Внедрите этот бин в биныкласса EmailSenderи
 * SmsSender. Используйте аннотации.
 */