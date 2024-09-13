package org.example.homeworks.homework3_Spring1;

import org.example.homeworks.homework3_Spring1.interfaces.EmailNotificationSerivce;
import org.example.homeworks.homework3_Spring1.interfaces.SmsNotificationSerivce;

public class EmailNotificationServiceImpl implements EmailNotificationSerivce {
    @Override
    public void sendEmailSpam(Customer customer) {
        System.out.println("Send Email spam to client " + customer.getName());
    }
}
