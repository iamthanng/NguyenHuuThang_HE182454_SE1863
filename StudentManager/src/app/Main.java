/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.Manager;
import java.util.ArrayList;
import model.Student;
import view.UserView;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Student> listS = new ArrayList<>();
        Manager manager = new Manager();
        UserView user = new UserView();
        while (true) {
            int choice = user.menu();
            switch (choice) {
                case 1:
                    manager.createStudent(listS);
                    break;
                case 2:
                    manager.findAndSort(listS);
                    break;
                case 3:
                    manager.updateAndDelete(listS);
                    break;
                case 4:

                    break;
                case 5:
                    return;
            }
        }
    }
}
