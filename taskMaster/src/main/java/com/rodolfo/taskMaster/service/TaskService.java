package com.rodolfo.taskMaster.service;

import com.rodolfo.taskMaster.dto.TaskRequest;
import com.rodolfo.taskMaster.dto.TaskResponse;
import com.rodolfo.taskMaster.entity.Task;

import java.util.List;

public interface TaskService {

    public TaskResponse create(TaskRequest request);
    public List<TaskResponse> getAll();
}
