package com.progression.business;

import com.progression.model.Joueur;

public class SessionUtilisation {
    private final Joueur utilisateur;

    /**
     * Le nombre de citation vu pour cette session
     */

    public SessionUtilisation(Joueur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Joueur getUtilisateur() {
        return utilisateur;
    }



    public void terminer() {
        utilisateur.terminerSession(this);
    }
}
