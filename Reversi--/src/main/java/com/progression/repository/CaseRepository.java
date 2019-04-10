package com.progression.repository;

import com.progression.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Case, Integer> {
	Case findById(int id);
	Case findByPositionXAndPositionY(int positionX, int positionY);

}
