package com.exo1.exo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exo1.exo1.entity.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
	List<Projet> findByName(String name);
}
