package org.example.homeworks.homework4.task2.tools.cars;

import org.example.homeworks.homework4.task2.tools.engine.Engine;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("electricCarBean")
public class ElectricCar extends Car{

    public ElectricCar(@Qualifier("electricEngineBean") Engine engine) {
        super(engine);
    }

    @Override
    public String toString() {
        return "It's ElecticCar";
    }
}
