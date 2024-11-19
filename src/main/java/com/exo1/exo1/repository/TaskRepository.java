package com.exo1.exo1.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exo1.exo1.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByTitle(String title);

	@Override
	@Query(
		"SELECT DISTINCT task " +
		"FROM Task task "
	)
    Page<Task> findAll(Pageable pageable);
}
