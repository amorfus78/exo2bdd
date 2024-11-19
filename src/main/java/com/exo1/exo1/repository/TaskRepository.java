package com.exo1.exo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exo1.exo1.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByTitle(String title);
}
