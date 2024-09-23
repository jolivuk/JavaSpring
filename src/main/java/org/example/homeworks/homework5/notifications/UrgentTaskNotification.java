package org.example.homeworks.homework5.notifications;

import org.example.homeworks.homework5.interfaces.NotificationService;
import org.example.homeworks.homework5.pojo.Task;
import org.example.homeworks.homework5.pojo.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UrgentTaskNotification {
    private final NotificationService notificationService;

    @Autowired
    public UrgentTaskNotification(NotificationService defaultNotificationService) {
        this.notificationService = defaultNotificationService;
    }

    public void notifyUrgentTasks(TaskList taskList) {
        taskList.getTasks().values().stream()
                .filter(task -> task.getPriority() == 1)
                .forEach(task -> notificationService.sendNotification("Urgent task: " + task.getTitle()));
    }

    public void notifyUrgentTasks(TaskList taskList, String typeNotification) {

        NotificationService chosenNotification =
                switch (typeNotification) {
                case "email" -> new EmailNotificationService();
                case "push" -> new PushNotificationService();
                default -> notificationService;
                };

        taskList.getTasks().values().stream()
                .filter(task -> task.getPriority() == 1)
                .forEach(task -> chosenNotification.sendNotification("Urgent task: " + task.getTitle()));
    }

    public List<Task> getUrgentTasks(TaskList taskList){
        return taskList.getTasks().values().stream()
                .filter(task -> task.getPriority() == 1).toList();
    }
}
