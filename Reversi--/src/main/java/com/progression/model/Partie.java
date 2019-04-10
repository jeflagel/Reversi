package com.progression.model;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "partie")
public class Partie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", length = 255, nullable = false)
    private int id;


    @Column(name = "id_joueur1", length = 255, nullable = false)
    private int idJoueur1;


    @Column(name = "id_joueur2", length = 255, nullable = false)
    private int idJoueur2;


    @Column(name = "tour", length = 255, nullable = false)
    private int tour;


    @Column(name = "num_tour", length = 255, nullable = false)
    private int numTour;


    @Column(name = "timeout", length = 255, nullable = false)
    private int timeout;

    public Partie() {
    }

    public Partie(int id, int idJoueur1, int idJoueur2, int tour, int numTour, int timeout) {
        this.id = id;
        this.idJoueur1 = idJoueur1;
        this.idJoueur2 = idJoueur2;
        this.tour = tour;
        this.numTour = numTour;
        this.timeout = timeout;
    }

    public Partie( int idJoueur1, int idJoueur2, int tour, int numTour, int timeout) {
        this.idJoueur1 = idJoueur1;
        this.idJoueur2 = idJoueur2;
        this.tour = tour;
        this.numTour = numTour;
        this.timeout = timeout;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getIdJoueur1() {
        return idJoueur1;
    }

    public void setIdJoueur1(int idJoueur1) {
        this.idJoueur1 = idJoueur1;
    }

    public int getIdJoueur2() {
        return idJoueur2;
    }

    public void setIdJoueur2(int idJoueur2) {
        this.idJoueur2 = idJoueur2;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public int getNumTour() {
        return numTour;
    }

    public void setNumTour(int numTour) {
        this.numTour = numTour;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
