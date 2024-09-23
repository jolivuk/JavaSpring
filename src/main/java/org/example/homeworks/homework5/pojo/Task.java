package org.example.homeworks.homework5.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
    private String title;
    private String description;
    private int priority;

    @Override
    public String toString() {
        return "Task [title=" + title + ", description=" + description + ", priority=" + priority + "]";
    }
}