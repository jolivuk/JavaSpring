package org.example.homeworks.homework3_Spring1;

import org.example.homeworks.homework3_Spring1.interfaces.EmailNotificationSerivce;
import org.example.homeworks.homework3_Spring1.interfaces.SmsNotificationSerivce;
import org.example.homeworks.homework4.task1.tools.EmailSender;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class NotificationService {
    private final EmailNotificationSerivce emailNotificationSerivce;
    private final SmsNotificationSerivce smsNotificationSerivce;

    public NotificationService(EmailNotificationSerivce emailNotificationSerivce, SmsNotificationSerivce smsNotificationSerivce) {
        this.emailNotificationSerivce = emailNotificationSerivce;
        this.smsNotificationSerivce = smsNotificationSerivce;
    }


    public void sendSpam(Customer customer) {
        if (DAYS.between(customer.getDateOfLastNotification(), LocalDate.now()) > 30) {

            emailNotificationSerivce.sendEmailSpam(customer);
            smsNotificationSerivce.sendSmsSpam(customer);

            //Change date of lastNotification
            customer.setDateOfLastNotification(LocalDate.now());
        }
    }
}
