package com.progression.business;

import com.progression.model.Case;
import com.progression.model.Joueur;
import com.progression.model.Partie;
import com.progression.repository.CaseRepository;
import com.progression.repository.JoueurRepository;
import com.progression.repository.PartieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitConfiguration {

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private PartieRepository partieRepository;

    @Autowired
    private JoueurRepository joueurRepository;


    public void initJoueurs(){
        Joueur j1 = new Joueur(0,"p1","",2,"");
        joueurRepository.save(j1);
        Joueur j2 = new Joueur(1,"p2","",2,"");
        joueurRepository.save(j2);
    }

    public void initAllCases(){
        Case c;
        for(int i = 1; i<=8; i++){
            for(int j =1; j<=8; j++){
                if (i==j && (i==4 || i==5)){
                    c = new Case(0,i,j,1);
                }
                else if ((i==4 && j==5) || (i==5 && j==4)){
                    c = new Case(1,i,j,1);
                }
                else {
                    c = new Case(-1,i,j,1);
                }
                caseRepository.save(c);
            }
        }
    }

    public int initPartie(){
        Partie p = new Partie(1,0,0,0,30);
        p = partieRepository.save(p);
        return p.getId();
    }

    public void deleteAll(){
        partieRepository.deleteAll();
        caseRepository.deleteAll();
        joueurRepository.deleteAll();
    }
}
