package org.example.homeworks.homework3_Spring1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class Dev {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext20240906.xml");

        Customer customer1 = context.getBean("customerBean", Customer.class);

        customer1.setId(1L);
        customer1.setName("Bob");
        customer1.setDateOfLastNotification(LocalDate.now());
        customer1.setPhone("19138445656");
        System.out.println(customer1);

        Customer customer2 = context.getBean("customerBean", Customer.class);
        customer2.setId(2L);
        customer2.setName("Sarah");
        customer2.setDateOfLastNotification(LocalDate.of(2024,01,16));
        customer2.setPhone("+19158455617");
        customer2.setEmail("sarah-sweet@candy.com");
        System.out.println(customer2);

        NotificationService notificationService = context.getBean("notificationServiceBean", NotificationService.class);
        notificationService.sendSpam(customer2);
        context.close();
    }
}

/**
 * 1.1 Создайте класс Customer с полями id, name, dateOfLastNotification, phone, email, геттрамии сеттерами.
 * В приложении создайте два бина типа Customer(используйте scope Prototype). Получите биныиз контекста и
 * установите первому параметры {1L, “Bob”,LocalDate.now(), “+19138445656”, null }, второму {2L, “Sarah”,
 * 2024-16-01, “+19158455617”, ”sarah-sweet@candy.com”}.
 * 1.2 Создайте класс NotificationService, который выполняет оповещение клиентов с помощью метода
 * sendSpam(Customer customer):если с последней отправки прошло больше 30 дней, то он отправляет
 * спам по имеющимся контактам(метод делегирует эту работу классам от которых зависит
 * -SmsNotificationService и EmailNotificationService). Получите Notification Service из контекста и
 * передайте ему бины клиентов. SmsNotificationService и EmailNotificationService должны внедряться
 * в NotificationService.
 * 1.3 Создайте класс SmsNotificationServiceImpl, следующий интерфейсу SmsNotificationService,
 * и класс EmailNotificationServiceImpl, следующий интерфейсу EmailNotificationService.
 */
