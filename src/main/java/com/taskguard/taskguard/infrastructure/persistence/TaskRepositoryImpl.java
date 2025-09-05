package com.taskguard.taskguard.infrastructure.persistence;

import com.taskguard.taskguard.domain.model.Task;
import com.taskguard.taskguard.domain.repository.TaskRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryImpl  implements TaskRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Task save(Task task) {
        if(task.getCreatedAt() == null) {
            task.setCreatedAt(LocalDate.now());
        }
        task.setUpdatedAt(LocalDate.now());

        if(task.getId() == null) {
            entityManager.persist(task);
        } else {
            task = entityManager.merge(task);
        }
        return task;
    }

    @Override
    public Optional<Task> findById(Long id) {
        Task task = entityManager.find(Task.class, id);
        return Optional.ofNullable(task);
    }

    @Override
    public List<Task> findAll() {
        TypedQuery<Task> query = entityManager.createQuery("SELECT t FROM Task t", Task.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(this::delete);
    }

    @Override
    public void delete(Task task) {
        if(entityManager.contains(task)) {
            entityManager.remove(task);
        } else {
            Task managedTask = entityManager.merge(task);
            entityManager.remove(managedTask);
        }
    }
}
