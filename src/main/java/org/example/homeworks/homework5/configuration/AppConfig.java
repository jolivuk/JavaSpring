package org.example.homeworks.homework5.configuration;

import org.example.homeworks.homework5.interfaces.NotificationService;
import org.example.homeworks.homework5.notifications.EmailNotificationService;
import org.example.homeworks.homework5.notifications.PushNotificationService;
import org.example.homeworks.homework5.notifications.SmsNotificationService;
import org.example.homeworks.homework5.pojo.Task;
import org.example.homeworks.homework5.pojo.TaskList;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

@Configuration
@ConfigurationProperties(prefix = "tasks")
@ComponentScan(basePackages = "org.example.homeworks.homework5")
@PropertySource("classpath:application.properties")
@EnableAsync
public class AppConfig {

    @Bean
    public HashMap<Integer, Task> taskMap() {
        HashMap<Integer, Task> taskMap = new HashMap<>();
        Properties properties = new Properties();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Error! No file with properties");
                return taskMap;
            }

            properties.load(input);
            int size = Integer.parseInt(properties.getProperty("tasklist.size"));

            // reading tasks from file application.properties
            for (int i = 0; i < size; i++) {
                Task task = new Task();
                task.setTitle(properties.getProperty("task[" + i + "].title"));
                task.setDescription(properties.getProperty("task[" + i + "].description"));
                task.setPriority(Integer.parseInt(properties.getProperty("task[" + i + "].priority")));
                taskMap.put(i, task);
            }

        } catch (IOException ex) {
            System.out.println("Error: cannot read properties file");
        }

        return taskMap;
    }

    @Bean
    public TaskList taskList() {
        return new TaskList(taskMap());
    }

    @Bean
    public NotificationService emailNotificationService() {
        return new EmailNotificationService();
    }

    @Bean
    @Primary
    public NotificationService smsNotificationService() {
        return new SmsNotificationService();
    }

    @Bean
    public NotificationService pushNotificationService() {
        return new PushNotificationService();
    }

}