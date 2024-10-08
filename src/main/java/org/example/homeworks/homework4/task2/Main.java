package org.example.homeworks.homework4.task2;

import org.example.homeworks.homework4.task2.tools.cars.DieselCar;
import org.example.homeworks.homework4.task2.tools.cars.ElectricCar;
import org.example.homeworks.homework4.task2.tools.configuration.MyConfig;
import org.example.homeworks.homework4.task2.tools.cars.ExrCar;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
   //     AnnotationConfigApplicationContext context =
   //             new AnnotationConfigApplicationContext(MyConfig.class);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_task2.xml");

        ElectricCar car = context.getBean(ElectricCar.class);
        System.out.println(car);

        ExrCar car1 = context.getBean(ExrCar.class);
        System.out.println(car1);

        DieselCar car2 = context.getBean(DieselCar.class);
        System.out.println(car2);

        context.close();
    }
}


/**
 * 2 Ваш абстрактный класс Car зависит от интерфейса Engine. Создайте несколько реализаций интерфейса
 * Engine(например, GasEngine и ElectricEngine). Аннотируйте их с помощью @Component с названием бинов.
 * Создайте наследников Car (ExrCar и ElectricCar),пометьте их аннотацией @Component. При внедрении бина
 * Engine с помощью @Autowired укажите название подходящего двигателяс помощью @Qualifier, чтобы можно
 * было выбрать тип двигателя во время компиляции.Получите биныобоих видов автомобилей и выведите тип
 * двигателя в консоль.
 */