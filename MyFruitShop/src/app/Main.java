/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controll.Controller;
import controll.UserInput;
import view.Menu;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        Menu display = new Menu();
        Controller method = new Controller();
        UserInput input = new UserInput();

        int choice;
        method.test();
        do {
            display.displayMenu();
            choice = input.takeUserChoice();
            switch (choice) {
                case 1:
                    method.creatFruit();
                    break;
                case 2:
                    method.viewOrder();
                    break;
                case 3:
                    method.Shopping();
                    break;
                case 4:
                    return;
            }
        } while (1 <= choice && choice <= 4);
    }
}
