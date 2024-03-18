/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.*;
import view.*;
/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        Controller method = new Controller();
        GetData input = new GetData();
        
        int choice;
//        method.test();
        do{
            display.displayMenu();
            choice  = input.takeChoice();
            switch (choice) {
                case 1:
                    method.addWorker();
                    break;
                case 2:
                    method.increaseSalary();
                    break;
                case 3:
                    method.decreaseSalary();
                    break;
                case 4:
                    method.showAdjusted();
                    break;
                case 5:
                    return;
            }
        }while(1<=choice && choice <=5);
    }
}
