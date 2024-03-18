/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.*;
/**
 *
 * @author ADMIN
 */
public class Display {
    public void displayMenu(){
        System.out.println("\n======= Worker Management =======");
        System.out.println("    1. Add Worker");
        System.out.println("    2. Up salary");
        System.out.println("    3. Down salary");
        System.out.println("    4. Display Information salary");
        System.out.println("    5. Exit");
    }
    
    public void displayInformationSalary(ArrayList<AdjustedWorker> aList){
        System.out.println("--------------- Display Information Salary ------------------");
        System.out.println("Code   Name     Age         Salary        Status     Date");
        for (AdjustedWorker adjustedWorker : aList) {
         System.out.printf("%s     %s     %d         %d        %s     %s\n", adjustedWorker.getId(), adjustedWorker.getName(), adjustedWorker.getAge(), adjustedWorker.getSalary(), adjustedWorker.getStatus(), adjustedWorker.getDate());
        }
    }
}
