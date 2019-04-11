package com.progression.controller.api;

import com.progression.model.Partie;
import com.progression.repository.PartieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
//import com.progression.progression.validators.UserValidator;

@CrossOrigin
@RestController
@RequestMapping("/partie")
public class PartieController {


	@Autowired
	private PartieRepository partieRepository;


	@GetMapping("/all")
	public Iterable<Partie> list(@PageableDefault(page = 0, size = 10) @SortDefault("id") Pageable pageable) {
		return partieRepository.findAll();
	}

	@GetMapping("/{id}")
	public Partie getPartie(@PathVariable int id) {
		return partieRepository.findById(id);
	}

	@PostMapping("/save")
	public Partie savePartie(@RequestBody Partie p) {
		return partieRepository.save(p);
	}

	@DeleteMapping("/{id}")
	public void deletePartie(@PathVariable Partie p) {
		partieRepository.delete(p);
	}


	@PostMapping("/partie/update")
	@Modifying(clearAutomatically = true)
	@Transactional
	public Partie update(@RequestBody Partie p){
		Partie newP = partieRepository.findById(p.getId());
		newP.setTour(p.getTour());
		newP.setNumTour(p.getNumTour());
		return partieRepository.save(newP);

	}
}
