package org.example.homeworks.homework5.notifications;

import org.example.homeworks.homework5.interfaces.NotificationService;
import org.springframework.stereotype.Component;


public class PushNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {

        System.out.println("Sending Push Notification \"" + message + "\"");
    }
}
