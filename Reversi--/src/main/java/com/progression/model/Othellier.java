package com.progression.model;


import com.progression.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class Othellier {

    private int id;

    private List<Case> caseList;

    public Othellier(int id, List<Case> caseList) {
        this.id = id;
        this.caseList = caseList;
    }

    public Othellier(){
        this.id = 2;
//        this.caseList = caseRepository.findAll();
        this.caseList =null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Case> getCaseList() {
        return caseList;
    }

    public void setCaseList(List<Case> caseList) {
        this.caseList = caseList;
    }

    public Case getCase(int posX,  int posY){
        int i = 0 ;
        while(i<64 && caseList.get(i).getPositionX() != posX || caseList.get(i).getPositionY() != posY ){
            i ++;
        }
        return caseList.get(i);
    }
}
