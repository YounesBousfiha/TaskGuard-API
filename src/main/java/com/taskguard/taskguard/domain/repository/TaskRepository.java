package com.taskguard.taskguard.domain.repository;

import com.taskguard.taskguard.domain.model.Task;

import java.util.Optional;
import java.util.List;

public interface TaskRepository {
    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();
    void deleteById(Long id);
    void delete(Task task);
}
