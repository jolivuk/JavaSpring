package org.example.homeworks.homework4.task1.tools;

import org.springframework.stereotype.Component;

@Component("emailSender")
public class EmailSender {

    private MessageGenerator messageGenerator;

    public EmailSender(MessageGenerator messageGenerator) {

        this.messageGenerator = messageGenerator;
    }

    public void sendEmail(){

        System.out.println("Sending email " + messageGenerator);
    }
}
