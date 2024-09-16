package org.example.homeworks.homework4.task2.tools.cars;

import org.example.homeworks.homework4.task2.tools.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("electricCar")
public class ElectricCar extends Car{

    @Autowired
    public ElectricCar(@Qualifier("electricEngine") Engine engine) {
        super(engine);
    }

    @Override
    public String toString() {
        return "It's ElecticCar";
    }
}
