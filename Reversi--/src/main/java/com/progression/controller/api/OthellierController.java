package com.progression.controller.api;

import com.progression.model.*;
import com.progression.repository.CaseRepository;
import com.progression.repository.JoueurRepository;
import com.progression.repository.PartieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
//import com.progression.progression.validators.UserValidator;

@CrossOrigin
@RestController
@RequestMapping("/oth")
public class OthellierController {


	@Autowired
	private CaseRepository caseRepository;

	@Autowired
	private JoueurRepository joueurRepository;

	@Autowired
	private PartieRepository partieRepository;




	@GetMapping
	public ModelAndView displayOthellier() {
		return getOthellier();
	}



	public ModelAndView getOthellier() {
		ModelAndView mav = new ModelAndView("index");
		Othellier o = new Othellier();
		o.setCaseList(caseRepository.findAll());
		Partie p = partieRepository.findById(1);
		mav.addObject("othellier", o);
		mav.addObject("partie", p);
		return mav;
	}


	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ModelAndView getTest() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("test", 2);
		return mav;
	}

	public Case avancer(Case c, Direction d){
		return caseRepository.findByPositionXAndPositionY(c.getPositionX()+d.getX(), c.getPositionY()+d.getY());
	}
	@GetMapping("/jouer")
	public boolean getPlay(@RequestParam int idCase, @RequestParam int idJoueur){
		Partie partie = partieRepository.findById(1);
		int somme = 0;
		Joueur j2;
		boolean aJoue = false;
		List<Direction> directions = verifValidity(idCase, idJoueur);
		for (Direction d : directions
			 ) {
			somme += d.getRetournement();
		}
		if (somme != 0){

			aJoue=true;
			Joueur j = joueurRepository.findById(idJoueur);
			int idJ2;
			if(idJoueur == 0)
				idJ2 =1 ;
			else idJ2 = 0;
			j2 = joueurRepository.findById(idJ2);
			partie.setNumTour(partie.getNumTour()+1);
			partie.setTour(idJ2);

			j.setScore(j.getScore()+somme+1);
			j2.setScore(j2.getScore()-somme);
			Case caseJoue = caseRepository.findById(idCase);
			caseJoue.setEtat(idJoueur);
			caseRepository.save(caseJoue);
			Case c = caseJoue;
			for (Direction dir : directions
			) {
				if (dir.getRetournement() != 0) {

					c = caseJoue;
					c = avancer(c, dir);
					for(int i= 0 ; i< dir.getRetournement(); i++) {
						c.setEtat(idJoueur);
						caseRepository.save(c);
						avancer(c, dir);
					}
				}
			}

		}


		return aJoue;
	}

	public List<Direction> verifValidity(int idCase, int idjoueur){
		List<Direction> directions = new ArrayList<>();
		directions.add(new Direction(0, 1,0));
		directions.add(new Direction(1, 0,0));
		directions.add(new Direction(1, 1,0));
		directions.add(new Direction(0, -1,0));
		directions.add(new Direction(-1, -1,0));
		directions.add(new Direction(-1, 0,0));
		directions.add(new Direction(-1, 1,0));
		directions.add(new Direction(1, -1,0));

		Case caseJoue = caseRepository.findById(idCase);
		if(caseJoue.getEtat()==-1){
			Othellier oth = new Othellier();
			oth.setCaseList(caseRepository.findAll());
			Case c = caseJoue;

			int retournement = 0;
			int sommeRetournements = 0;
			for (Direction dir : directions
				 ) {
				c= caseJoue;
				c = avancer(c, dir);

				while (c != null && c.getEtat() != idjoueur) {
					sommeRetournements++;
					retournement ++;
					c = avancer(c, dir);
				}
				if (c!=null) dir.setRetournement(retournement);
				retournement = 0;
			}}
		return directions;

	}



}
