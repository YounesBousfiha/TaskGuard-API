package com.taskguard.taskguard.infrastructure.persistence;

import com.taskguard.taskguard.domain.model.Task;
import com.taskguard.taskguard.domain.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

public class TaskRepositoryImpl  implements TaskRepository {
    @Override
    public Task save(Task task) {
        return null;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(Task task) {

    }
}
