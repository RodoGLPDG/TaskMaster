package com.rodolfo.taskMaster.service;

import com.rodolfo.taskMaster.entity.Task;

import java.util.List;

public interface TaskService {

    public Task createTask(Task task, String email);
    public List<Task> getUserTasks(String email);
}
