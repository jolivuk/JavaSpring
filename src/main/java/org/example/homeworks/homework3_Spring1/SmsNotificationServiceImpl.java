package org.example.homeworks.homework3_Spring1;

import org.example.homeworks.homework3_Spring1.interfaces.SmsNotificationSerivce;

public class SmsNotificationServiceImpl implements SmsNotificationSerivce {
    @Override
    public void sendSmsSpam(Customer customer) {
        System.out.println("Send SMS spam to client " + customer.getName());
    }
}
