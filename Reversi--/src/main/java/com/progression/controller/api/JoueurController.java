package com.progression.controller.api;

import com.progression.model.Joueur;
import com.progression.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

//import com.progression.progression.validators.UserValidator;

@CrossOrigin
@RestController
@RequestMapping("/joueur")
public class JoueurController {


	@Autowired
	private JoueurRepository joueurRepository;


	@GetMapping("/all")
	public Iterable<Joueur> list(@PageableDefault(page = 0, size = 10) @SortDefault("id") Pageable pageable) {
		return joueurRepository.findAll();
	}

	@GetMapping("/{id}")
	public Joueur getJoueur(@PathVariable int id) {
		return joueurRepository.findById(id);
	}

	@PostMapping("/save")
	public Joueur saveJoueur(@RequestBody Joueur joueur) {
		return joueurRepository.save(joueur);
	}

	@DeleteMapping("/{id}")
	public void deleteJoueur(@PathVariable Joueur j) {
		joueurRepository.delete(j);
	}


}
