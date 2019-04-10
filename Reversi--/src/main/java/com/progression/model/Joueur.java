package com.progression.model;

import com.progression.business.SessionUtilisation;
import org.springframework.data.domain.Auditable;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.persistence.*;

@Entity
@Table(name = "joueur")
public class Joueur {

	@Id
	@Column(name = "id", length = 255, nullable = false)
	private int id;

	@Column(name = "nom", length = 255, nullable = false)
	private String nom;

	@Column(name = "prenom", length = 255, nullable = false)
	private String prenom;

	@Column(name= "score", length = 255, nullable = false)
	private int score;


	@Transient
	private String token;

	@Transient
	private final List<SessionUtilisation> sessionsUtilisations = new CopyOnWriteArrayList<SessionUtilisation>();
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Joueur() {
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Joueur(int id, String nom, String prenom, int score, String token) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.score = score;
		this.token = token;
	}
	public Joueur(String nom){
		this.nom = nom;
	}

	public Joueur(String nom, String prenom, String token) {
		this.nom = nom;
		this.prenom = prenom;
		this.token = token;
	}

	public Joueur(int id, String nom, String prenom, String token) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.token = token;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	public void terminerSession(SessionUtilisation sessionUtilisation) {
		sessionsUtilisations.remove(sessionUtilisation);
	}

	public SessionUtilisation ouvrirSessionUtilisation() {
		final SessionUtilisation su = new SessionUtilisation(this);
		sessionsUtilisations.add(su);
		return su;
	}
}
