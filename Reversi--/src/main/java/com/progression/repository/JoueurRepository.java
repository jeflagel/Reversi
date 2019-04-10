package com.progression.repository;

import com.progression.model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository extends JpaRepository<Joueur, Integer> {
	Joueur findById(int id);


}
