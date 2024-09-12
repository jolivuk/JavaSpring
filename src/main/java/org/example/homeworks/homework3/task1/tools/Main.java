package org.example.homeworks.homework3.task1.tools;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();

        EmailSender emailSender = context.getBean("emailSender", EmailSender.class);
        emailSender.sendEmail();

        SmsSender smsSender = context.getBean("smsSender", SmsSender.class);
        smsSender.sendSms();

        context.close();
    }
}
