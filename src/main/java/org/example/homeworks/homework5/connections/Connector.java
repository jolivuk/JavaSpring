package org.example.homeworks.homework5.connections;

/**
 * * 1.3 Приложение должно отправлять данные на сервер. Создайте бин класса Connector, который эмулирует подключение
 *  * к серверу. Подключение занимает длительное время, поэтому не должно замедлять запуск программы.
 *  */

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component

public class Connector {

    @Async
    public void connectToServer(){
        try {
            System.out.println("Connecting to server...");
            Thread.sleep(5000);
            System.out.println("Connected to server");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

     }

     public void disconnectFromServer(){
         System.out.println("Disconnected from server");
     }

    @Async
     public void sendData(String data){

         try {
             System.out.println("Sending data to Server" );
             Thread.sleep(5000);
             System.out.println("Data sent to Server: " + data);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }

     }
}
