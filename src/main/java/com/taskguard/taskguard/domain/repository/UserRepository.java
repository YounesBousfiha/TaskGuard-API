package com.taskguard.taskguard.domain.repository;

import com.taskguard.taskguard.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public User save(User user);
    public Optional<User> findById(Long id);
    public List<User> findAll();
    public void deleteById(Long id);
    public void delete(User user);
    Optional<User> findByUsername(String username);
}
