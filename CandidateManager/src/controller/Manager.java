/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Calendar;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Internship;
import util.Validation;

/**
 *
 * @author ADMIN
 */
public class Manager {

    public void createCandidate(ArrayList<Candidate> candidates, int type) {
        while (true) {
            System.out.print("Enter id: ");
            String id = Validation.checkString();
            System.out.print("Enter first name: ");
            String firstName = Validation.checkString();
            System.out.print("Enter last name: ");
            String lastName = Validation.checkString();
            System.out.print("Enter birth date: ");
            int birthDate = Validation.checkLimit(1900,
                    Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Enter address: ");
            String address = Validation.checkString();
            System.out.print("Enter phone: ");
            String phone = Validation.checkPhone();
            System.out.print("Enter email: ");
            String email = Validation.checkEmail();
            Candidate candidate = new Candidate(id, firstName, lastName,
                    birthDate, address, phone, email, type);
            if (checkIdExist(candidates, id)) {
                switch (type) {
                    case 0:
                        createExperience(candidates, candidate);
                        break;
                    case 1:
                        createFresher(candidates, candidate);
                        break;
                    case 2:
                        createInternship(candidates, candidate);
                        break;
                }
            } else {
                return;
            }
            System.out.print("Do you want to continue (Y/N): ");
            //check user want to create new candidate or not
            if (!Validation.checkInputYN()) {
                return;
            }

        }
    }

    boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exist.");
                return false;
            }
        }
        return true;
    }

    public void createExperience(ArrayList<Candidate> candidates,
            Candidate candidate) {
        System.out.print("Enter year of experience: ");
        int yearExperience = Validation.checkInputExprience(candidate.getBirthDate());
        System.out.print("Enter professional skill: ");
        String professionalSkill = Validation.checkString();
        candidates.add(new Experience(yearExperience, professionalSkill,
                candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    //allow user create fresher
    public void createFresher(ArrayList<Candidate> candidates,
            Candidate candidate) {
        System.out.print("Enter graduation date: ");
        String graduationDate = Validation.checkString();
        System.out.print("Enter graduation rank: ");
        String graduationRank = Validation.checkGraduationRank();
        candidates.add(new Fresher(graduationDate, graduationRank, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    //allow user create internship
    public void createInternship(ArrayList<Candidate> candidates,
            Candidate candidate) {
        System.out.print("Enter major: ");
        String major = Validation.checkString();
        System.out.print("Enter semester: ");
        int semester = Validation.checkLimit(1, 9);
        System.out.print("Enter university: ");
        String university = Validation.checkString();
        candidates.add(new Internship(major, semester, university, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    //allow user search candidate by name
    public void searchCandidate(ArrayList<Candidate> candidates) {
        printListNameCandidate(candidates);
        System.out.print("Enter andidate name (First name or Last name): ");
        String nameSearch = Validation.checkString();
        System.out.print("Enter type of candidate: ");
        int typeCandidate = Validation.checkLimit(0, 2);
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == typeCandidate
                    && candidate.getFirstName().contains(nameSearch)
                    || candidate.getLastName().contains(nameSearch)) {
                System.out.println(candidate.toString());
            }
        }
    }

    //display list name candidate
    public void printListNameCandidate(ArrayList<Candidate> candidates) {
        System.err.println("Experience Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.err.println("Fresher Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.err.println("Internship Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
    }
}
