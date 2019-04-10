package com.progression.model;

import java.util.List;

public class Joueurs {

    private List<Joueur> joueurs;


    public Joueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public Joueurs() {
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }
}
