package com.exo1.exo1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exo1.exo1.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.task WHERE u.id = :id")
    Optional<User> findByIdWithTask(@Param("id") Long id);

    List<User> findByName(String name);

    @Override
    @Query(
        "SELECT DISTINCT u " +
        "FROM User u " +
        "LEFT JOIN FETCH u.projets projets " +
        "LEFT JOIN FETCH projets.tasks tasks "
    )
    Page<User> findAll(Pageable pageable);
}
