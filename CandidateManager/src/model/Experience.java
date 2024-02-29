/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Experience extends Candidate{
    private int yearExp;
    private String proSkill;

    public Experience() {
        super();
    }

    public Experience(int yearExp, String proSkill) {
        this.yearExp = yearExp;
        this.proSkill = proSkill;
    }

    public Experience(int yearExp, String proSkill, String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int typeCandidate) {
        super(id, firstName, lastName, birthDate, address, phone, email, typeCandidate);
        this.yearExp = yearExp;
        this.proSkill = proSkill;
    }

    public int getYearExp() {
        return yearExp;
    }

    public void setYearExp(int yearExp) {
        this.yearExp = yearExp;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
    
    
}
