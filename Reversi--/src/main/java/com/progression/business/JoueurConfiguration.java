package com.progression.business;

import com.progression.model.Joueur;
import com.progression.model.Joueurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class JoueurConfiguration {

    @Bean
    @SessionScope
    @ApplicationScope
    @Autowired
    public Joueurs utilisateurs(HttpSession httpSession) {
        Joueur j = new Joueur((String) httpSession.getAttribute("username"));
        Joueurs jj = new Joueurs();
        List<Joueur> ll = new ArrayList<>();
        ll.add(j);
        jj.setJoueurs(ll);
        return new Joueurs();
    }

    @Bean
    @SessionScope
    public SessionUtilisation sessionUtilisation(Joueur utilisateur) {
        return utilisateur.ouvrirSessionUtilisation();
    }

    @Bean
    @SessionScope
    @Autowired
    public Joueur utilisateur(HttpSession httpSession) {
        return new Joueur((String) httpSession.getAttribute("username") );
    }
}
