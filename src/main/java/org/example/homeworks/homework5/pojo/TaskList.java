package org.example.homeworks.homework5.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class TaskList {
    private HashMap<Integer, Task> tasks;

    public TaskList(HashMap<Integer, Task> tasks) {
        this.tasks = tasks;
    }

    public void printTasks() {
        if (tasks == null || tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            tasks.forEach((key, task) -> System.out.println("ID: " + key + ", " + task)); // Вывод всех задач
        }
    }
}