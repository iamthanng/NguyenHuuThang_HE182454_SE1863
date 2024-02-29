/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.Manager;
import java.util.ArrayList;
import model.Candidate;
import view.UserView;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String args[]){
        ArrayList<Candidate> candidates = new ArrayList<>();
        Manager manager = new Manager();
         while (true) {
            int choice = UserView.menu();
            switch (choice) {
                case 1:
                    manager.createCandidate(candidates, 0);
                    break;
                case 2:
                    manager.createCandidate(candidates, 1);
                    break;
                case 3:
                    manager.createCandidate(candidates, 2);
                    break;
                case 4:
                    manager.searchCandidate(candidates);
                    break;
                case 5:
                    return;
            }
    }    
}
}
