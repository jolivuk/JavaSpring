package org.example.homeworks.homework4.task2.tools.cars;

import org.example.homeworks.homework4.task2.tools.engine.Engine;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("dieselCarBean")
public class DieselCar extends Car{

    public DieselCar(@Qualifier("dieselEngineBean") Engine engine) {
        super(engine);
    }

    @Override
    public String toString() {
        return "It's DieselCar";
    }
}
