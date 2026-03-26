package com.rodolfo.taskMaster.controller;

import com.rodolfo.taskMaster.entity.Task;
import com.rodolfo.taskMaster.service.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "tasks", description = "tasks Api")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return taskService.createTask(task, email);
    }

    @GetMapping
    public List<Task> getTasks() {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return taskService.getUserTasks(email);
    }

}
