package org.example.homeworks.homework4.task2.tools.engine;

import org.springframework.stereotype.Component;

@Component("GasEngineBean")
public class GasEngine implements Engine {
    @Override
    public String getEngine() {
        return "Gas Engine";
    }
}
