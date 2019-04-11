package com.progression.controller.api;

import com.progression.business.InitConfiguration;
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

	@Autowired
	private InitConfiguration initConfiguration;



	@GetMapping("/{idPartie}")
	public ModelAndView displayOthellier(@PathVariable String idPartie) {
		return getOthellier(Integer.parseInt(idPartie));
	}



	@GetMapping("/continue")
	public int continueGame(){
		int idPartie;
		List<Partie> listPartie=  partieRepository.findAll();
		if(listPartie.size() != 0) idPartie = listPartie.get(0).getId();
		else {
			initConfiguration.initJoueurs();
			idPartie = initConfiguration.initPartie();
			initConfiguration.initAllCases();
		}
		return  idPartie;
	}

	@GetMapping("/init")
	public int beginNewGame(){
		int idPartie;
		initConfiguration.deleteAll();
		initConfiguration.initJoueurs();
		idPartie = initConfiguration.initPartie();
		initConfiguration.initAllCases();

		return  idPartie;
	}


	public ModelAndView getOthellier(int idPartie) {
		ModelAndView mav = new ModelAndView("jeu");
		Othellier o = new Othellier();
		o.setCaseList(caseRepository.findAll());
		Partie p = partieRepository.findById(idPartie);
		Joueur j1 = joueurRepository.findById(0);
		Joueur j2 = joueurRepository.findById(1);
		mav.addObject("othellier", o);
		mav.addObject("partie", p);
		mav.addObject("j1", j1);
		mav.addObject("j2", j2);
		return mav;
	}


	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ModelAndView getTest() {
		ModelAndView mav = new ModelAndView("jeu");
		mav.addObject("test", 2);
		return mav;
	}

	public Case avancer(Case c, Direction d){
		return caseRepository.findByPositionXAndPositionY(c.getPositionX()+d.getX(), c.getPositionY()+d.getY());
	}
	@GetMapping("/jouer")
	public boolean getPlay(@RequestParam int idCase, @RequestParam int idJoueur , @RequestParam int idPartie){
		Partie partie = partieRepository.findById(idPartie);
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
			System.out.println("-------------");
			for (Direction dir : directions
			) {
				if (dir.getRetournement() != 0) {

					c = caseJoue;
					c = avancer(c, dir);
					System.out.println(dir.getRetournement());
					for(int i= 0 ; i< dir.getRetournement(); i++) {
						c.setEtat(idJoueur);
						caseRepository.save(c);
						c = avancer(c, dir);
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
		boolean nonCaseVide = true;
		Case caseJoue = caseRepository.findById(idCase);
		if(caseJoue.getEtat()==-1){
			Othellier oth = new Othellier();
			oth.setCaseList(caseRepository.findAll());
			Case c = caseJoue;
			int idJ2 = (idjoueur == 1) ? 0 : 1 ;
			int retournement = 0;
			int sommeRetournements = 0;
			for (Direction dir : directions
				 ) {
				c= caseJoue;
				c = avancer(c, dir);

				while (c != null && c.getEtat() != idjoueur && nonCaseVide) {
					if(c.getEtat()==-1) nonCaseVide=false;
					sommeRetournements++;
					retournement ++;
					c = avancer(c, dir);

				}
				if (c!=null && nonCaseVide) dir.setRetournement(retournement);
				else dir.setRetournement(0);
				retournement = 0;
				nonCaseVide = true;
			}}
		return directions;

	}



}
