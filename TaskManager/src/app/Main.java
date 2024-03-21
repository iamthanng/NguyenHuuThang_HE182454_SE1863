/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controll.Controller;
import controll.UserInput;
import java.util.ArrayList;
import model.Task;
import view.Menu;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args){
        Menu display = new Menu();
        UserInput ui = new UserInput();
        Controller method = new Controller();
        ArrayList<Task> taskList = new ArrayList<>();                
        int choice;
        int id = 1;
        while(true){
            display.Menu();
            choice = ui.takeUserChoice();
            switch(choice){
                case 1:
                    method.addTask(taskList, id);
                    id++;
                    break;
                case 2:
                    method.deleteTask(taskList);
                    break;
                case 3:
                    display.showTask(taskList);
                    break;
                case 4:
                    return;
            }
        }
    }
}
