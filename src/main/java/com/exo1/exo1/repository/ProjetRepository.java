package com.exo1.exo1.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exo1.exo1.entity.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
	List<Projet> findByName(String name);

	@Override
	@Query(
		"SELECT DISTINCT projet " +
		"FROM Projet projet " +
		"LEFT JOIN FETCH projet.tasks task "
	)
    Page<Projet> findAll(Pageable pageable);
}
