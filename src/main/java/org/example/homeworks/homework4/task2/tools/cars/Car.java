package org.example.homeworks.homework4.task2.tools.cars;

import org.example.homeworks.homework4.task2.tools.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public abstract class Car{

    protected Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine.getEngine() +
                '}';
    }
}
