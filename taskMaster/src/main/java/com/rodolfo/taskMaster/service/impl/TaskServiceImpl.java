package com.rodolfo.taskMaster.service.impl;

import com.rodolfo.taskMaster.dto.TaskRequest;
import com.rodolfo.taskMaster.dto.TaskResponse;
import com.rodolfo.taskMaster.entity.Task;
import com.rodolfo.taskMaster.entity.User;
import com.rodolfo.taskMaster.mapper.TaskMapper;
import com.rodolfo.taskMaster.repository.TaskRepository;
import com.rodolfo.taskMaster.repository.UserRepository;
import com.rodolfo.taskMaster.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public TaskResponse create(TaskRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Task task = TaskMapper.toEntity(request, user);

        Task saved = taskRepository.save(task);

        return TaskMapper.toResponse(saved);
    }


    public List<TaskResponse> getAll() {
        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toResponse)
                .toList();
    }
}
