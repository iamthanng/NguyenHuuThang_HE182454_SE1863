/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import util.Validation;

/**
 *
 * @author ADMIN
 */
public class UserView {
    public int menu() {
        System.out.println("======== WELCOME TO STUDENT MANAGEMENT ========");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        Validation validation = new Validation();
        int choice = validation.getChoice("Enter your choice: ", 1, 5);
        return choice;
    }
}
