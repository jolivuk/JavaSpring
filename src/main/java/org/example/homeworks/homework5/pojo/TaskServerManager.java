package org.example.homeworks.homework5.pojo;

import org.example.homeworks.homework5.connections.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskServerManager {
    private final Connector connector;

    @Autowired
    public TaskServerManager(Connector connector) {
        this.connector = connector;
    }

    public void connectToServerAndSendData(String data){
        connector.connectToServer();
        connector.sendData(data);
    }
}
