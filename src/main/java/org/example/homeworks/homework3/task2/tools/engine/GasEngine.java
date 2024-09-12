package org.example.homeworks.homework3.task2.tools.engine;

import org.springframework.stereotype.Component;

@Component("gasEngineBean")
public class GasEngine implements Engine {
    @Override
    public String getEngine() {
        return "Gas Engine";
    }
}
