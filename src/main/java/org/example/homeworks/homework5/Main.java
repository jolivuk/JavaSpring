package org.example.homeworks.homework5;

import org.example.homeworks.homework5.configuration.AppConfig;
import org.example.homeworks.homework5.notifications.UrgentTaskNotification;
import org.example.homeworks.homework5.pojo.Task;
import org.example.homeworks.homework5.pojo.TaskList;
import org.example.homeworks.homework5.pojo.TaskServerManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(org.example.homeworks.homework5.configuration.AppConfig.class);

        TaskList taskList = context.getBean(TaskList.class);
        taskList.printTasks();

        UrgentTaskNotification notification = context.getBean(UrgentTaskNotification.class);

        notification.notifyUrgentTasks(taskList);
        System.out.println("------------------------------");
        notification.notifyUrgentTasks(taskList,"email");
        System.out.println("------------------------------");
        notification.notifyUrgentTasks(taskList,"push");


        TaskServerManager taskServerManager = context.getBean(TaskServerManager.class);

        taskServerManager.connectToServerAndSendData("There ara Urgent Tasks" + notification.getUrgentTasks(taskList));

        context.close();
    }
}

/**
 * Решите задания, используя Spring и изученные аннотации.
 * 1.1 Напишите простое приложение для управления задачами (To-DoList). Создайте бины Задач, Список задач и т.д.
 * Размер списка задач, их приоритеты, заголовок и описание по умолчанию должны быть взяты из файла настроек.
 * 1.2 Дополните приложение. Приложение должно отправлять уведомления о срочных задачах. Создайте интерфейс
 * NotificationService, который будет иметь несколько реализаций для отправки уведомлений по электронной почте,
 * SMS и push. Используйте аннотации @Component, @Qualifier, @Primary и другие для настройки внедрения зависимостей.
 * 1.3 Приложение должно отправлять данные на сервер. Создайте бин класса Connector, который эмулирует подключение
 * к серверу. Подключение занимает длительное время, поэтому не должно замедлять запуск программы.
 */
