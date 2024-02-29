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
public class Fresher extends Candidate {
    private String graduationDate;
    private String graduationRank;
    private String university;

    public Fresher() {
        super();
    }


    public Fresher(String graduationDate, String graduationRank, String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int typeCandidate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    
}
