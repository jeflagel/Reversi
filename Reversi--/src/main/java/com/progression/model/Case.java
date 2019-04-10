package com.progression.model;


import javax.persistence.*;

@Entity
@Table(name = "case")
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", length = 255, nullable = false)
    private int id;

    @Column(name = "etat", length = 255, nullable = false)
    private int etat;

    @Column(name = "position_x", length = 255, nullable = false)
    private int positionX;

    @Column(name = "position_y", length = 255, nullable = false)
    private int positionY;


    @Column(name = "id_othellier", length = 255, nullable = false)
    private int idOthellier;

    public Case(int etat, int positionX, int positionY, int idOthellier) {
        this.etat = etat;
        this.positionX = positionX;
        this.positionY = positionY;
        this.idOthellier = idOthellier;
    }

    public Case() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getIdOthellier() {
        return idOthellier;
    }

    public void setIdOthellier(int idOthellier) {
        this.idOthellier = idOthellier;
    }


}
