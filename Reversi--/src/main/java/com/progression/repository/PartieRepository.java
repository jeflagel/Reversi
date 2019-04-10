package com.progression.repository;

import com.progression.model.Partie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartieRepository extends JpaRepository<Partie, Integer> {
	Partie findById(int id);

}
