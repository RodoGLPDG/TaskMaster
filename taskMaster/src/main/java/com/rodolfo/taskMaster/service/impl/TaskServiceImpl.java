package com.rodolfo.taskMaster.service.impl;

import com.rodolfo.taskMaster.entity.Task;
import com.rodolfo.taskMaster.entity.User;
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

    public Task createTask(Task task, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("usuario no encontrado"));

        task.setUser(user);

        return taskRepository.save(task);
    }


    public List<Task> getUserTasks(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("usuario no encontrado"));

        return taskRepository.findByUserId(user.getId());
    }
}
