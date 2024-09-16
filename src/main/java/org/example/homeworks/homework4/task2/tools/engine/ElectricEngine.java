package org.example.homeworks.homework4.task2.tools.engine;

import org.springframework.stereotype.Component;

@Component("electricEngine")
public class ElectricEngine implements Engine {
    @Override
    public String getEngine() {
        return "Electric Engine";
    }

}
