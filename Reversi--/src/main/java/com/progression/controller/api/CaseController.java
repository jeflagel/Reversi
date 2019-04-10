package com.progression.controller.api;

import com.progression.model.Case;
import com.progression.repository.CaseRepository;
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
@RequestMapping("/case")
public class CaseController {


	@Autowired
	private CaseRepository caseRepository;


	@GetMapping("/all")
	@ModelAttribute("othellier")
	public Iterable<Case> list(@PageableDefault(page = 0, size = 10) @SortDefault("id") Pageable pageable) {
		return caseRepository.findAll();
	}

	@GetMapping("/{id}")
	public Case getCase(@PathVariable int id) {
		return caseRepository.findById(id);
	}

	@GetMapping("/getByPosition")
	public Case getCase(@RequestParam int PosX, @RequestParam int PosY) {
		return caseRepository.findByPositionXAndPositionY(PosX, PosY);
	}

	@PostMapping("/save")
	public Case saveCase(@RequestBody Case c) {
		return caseRepository.save(c);
	}

	@GetMapping("/saveAllCases")
	public void saveAllCases(){
		for(int i = 1; i<=8; i++){
			for(int j =1; j<=8; j++){
				Case c = new Case(-1,i,j,1);
				caseRepository.save(c);
			}
		}
	}
	@DeleteMapping("/{id}")
	public void deleteCase(@PathVariable Case c) {
		caseRepository.delete(c);
	}

	@PostMapping("/case/update")
	@Modifying(clearAutomatically = true)
	@Transactional
	public Case update(@RequestBody Case c){
		Case newC = caseRepository.findById(c.getId());
		newC.setEtat(c.getEtat());
		return caseRepository.save(newC);

	}
}
