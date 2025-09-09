package com.taskguard.taskguard.application;

import com.taskguard.taskguard.domain.model.Task;
import com.taskguard.taskguard.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        task.setCreatedAt(LocalDate.now());
        task.setUpdatedAt(LocalDate.now());
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(existingTask -> {
                    existingTask.setTitle(updatedTask.getTitle());
                    existingTask.setDescription(updatedTask.getDescription());
                    existingTask.setPriority(updatedTask.getPriority());
                    existingTask.setStatus(updatedTask.getStatus());
                    existingTask.setDueDate(updatedTask.getDueDate());
                    existingTask.setUpdatedAt(LocalDate.now());
                    return taskRepository.save(existingTask);
                })
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
