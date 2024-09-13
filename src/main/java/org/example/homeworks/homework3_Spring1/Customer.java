package org.example.homeworks.homework3_Spring1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

/**
 * 1.1 Создайте класс Customer с полями id, name, dateOfLastNotification, phone, email, геттрамии сеттерами.
 */
@Getter
@Setter
@ToString
public class Customer {
    private Long id;
    private String name;
    private LocalDate dateOfLastNotification;
    private String phone;
    private String email;
}
