package com.taskguard.taskguard.domain.repository;

import com.taskguard.taskguard.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    void deleteById(Long id);
    void delete(User user);
    Optional<User> findByUsername(String username);
}
