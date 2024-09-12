package org.example.homeworks.homework4.task2.tools.cars;

import org.example.homeworks.homework4.task2.tools.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ExrCarBean")
public class ExrCar extends Car{
    private Engine engine;

    @Autowired
    public ExrCar(@Qualifier("GasEngineBean") Engine engine) {
        super(engine);
    }

    @Override
    public String toString() {
        return "It's ExrCar";
    }
}
