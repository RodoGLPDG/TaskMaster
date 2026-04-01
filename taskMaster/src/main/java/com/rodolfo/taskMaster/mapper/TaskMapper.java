package com.rodolfo.taskMaster.mapper;


import com.rodolfo.taskMaster.dto.TaskRequest;
import com.rodolfo.taskMaster.dto.TaskResponse;
import com.rodolfo.taskMaster.entity.Task;
import com.rodolfo.taskMaster.entity.User;

public class TaskMapper {

    // 🔹 Request → Entity
    public static Task toEntity(TaskRequest request, User user) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());

        task.setCompleted(
                request.getCompleted() != null ? request.getCompleted() : false
        );

        task.setUser(user);

        return task;
    }

    // 🔹 Entity → Response
    public static TaskResponse toResponse(Task task) {
        TaskResponse response = new TaskResponse();

        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setCompleted(task.isCompleted());
        response.setUserId(task.getId());

        if (task.getUser() != null) {
            response.setName(task.getUser().getName());
        }

        return response;
    }

    public static void updateEntity(Task task, TaskRequest request) {
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());

        if (request.getCompleted() != null) {
            task.setCompleted(request.getCompleted());
        }
    }
}