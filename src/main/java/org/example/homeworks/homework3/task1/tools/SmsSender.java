package org.example.homeworks.homework3.task1.tools;

import org.springframework.stereotype.Component;

@Component
public class SmsSender {
    private MessageGenerator messageGenerator;

    public SmsSender(MessageGenerator messageGenerator) {

    this.messageGenerator = messageGenerator;
}

    public void sendSms(){
        System.out.println("Sending sms " + messageGenerator);
    }
}