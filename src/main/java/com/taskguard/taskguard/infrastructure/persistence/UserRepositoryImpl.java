package com.taskguard.taskguard.infrastructure.persistence;

import com.taskguard.taskguard.domain.model.User;
import com.taskguard.taskguard.domain.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserRepositoryImpl  implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public User save(User user) {
        if(user.getCreatedAt() == null) {
            user.setCreatedAt(LocalDate.now());
        }
        user.setUpdatedAt(LocalDate.now());


        if(user.getId() == null) {
            entityManager.persist(user);
        } else {
            user = entityManager.merge(user);
        }

        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = entityManager.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM  User u", User.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(this::delete);
    }

    @Override
    public void delete(User user) {
        if(entityManager.contains(user)) {
            entityManager.remove(user);
        } else {
            User managedUser = entityManager.merge(user);
            entityManager.remove(managedUser);
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        try {
            TypedQuery<User> query = entityManager.createQuery(
                    "SELECT u FROM User u WHERE u.username = :username", User.class
            );
            query.setParameter("username", username);
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
