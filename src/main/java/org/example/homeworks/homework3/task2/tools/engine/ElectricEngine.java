package org.example.homeworks.homework3.task2.tools.engine;

import org.springframework.stereotype.Component;

@Component("electricEngineBean")
public class ElectricEngine implements Engine {
    @Override
    public String getEngine() {
        return "Electric Engine";
    }

}
