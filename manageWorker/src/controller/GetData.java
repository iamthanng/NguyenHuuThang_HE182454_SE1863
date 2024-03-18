/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import util.*;
import model.*;
/**
 *
 * @author ADMIN
 */
public class GetData {
    private Scanner scanner = new Scanner(System.in);
    private Validate validate = new Validate();
    
    public int takeChoice(){
        String choice;
        while(true){
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
            if(validate.checkInt(choice, 1, 5)){
                break;
            }
        }
        return Integer.parseInt(choice);
    }
    
    public String findID(ArrayList<Worker> wList){
        String id=" ";
        if(wList.isEmpty()){
            System.out.println("List is empty.");
        }
        else{
            System.out.print("Enter worker code: ");
            id = scanner.nextLine();
            if(validate.checkString(id, "[a-zA-Z0-9]+")){
                if(validate.checkExist(id, wList)){
                    return id;
                }else{
                    System.out.println("Worker does not in database.");
                    id = " ";
                }
            }
        }
        return id;
    }
    
    public String takeID(ArrayList<Worker> wList){
        String id;
        while(true){
            System.out.print("Enter worker code: ");
            id = scanner.nextLine();
            if(validate.checkString(id, "[a-zA-Z0-9]+")){
                if(!validate.checkExist(id, wList)){
                    break;
                }else{
                    System.out.println("Worker is already exist, please input again.");
                }
            }
        }
        return id;
    }
    
    public String takeName(){
        String name;
        while(true){
            System.out.print("Enter worker's name: ");
            name = scanner.nextLine();
            if(validate.checkString(name, "[a-zA-Z]+")){
                break;
            }
        }
        return name;
    }
    
    public int takeAge(){
        String age;
        while(true){
            System.out.print("Enter worker's age: ");
            age = scanner.nextLine();
            if(validate.checkInt(age, 18, 50)){
                break;
            }
        }
        return Integer.parseInt(age);
    }
    
    public int takeSalary(){
        String salary;
        while(true){
            System.out.print("Enter worker's salary: ");
            salary = scanner.nextLine();
            if(validate.checkInt(salary, 1, Integer.MAX_VALUE)){
                break;
            }
        }
        return Integer.parseInt(salary);
    }
    
    public String takeLocation(){
        String location;
        while(true){
            System.out.print("Enter work location: ");
            location = scanner.nextLine();
            if(validate.checkString(location, "[a-zA-Z]+")){
                break;
            }
        }
        return location;
    }
    
    public int takeDecrease(Worker worker){
        String salary;
        while(true){
            System.out.print("Enter enter amount to cut: ");
            salary = scanner.nextLine();
            if(validate.checkInt(salary, 1, worker.getSalary())){
                break;
            }
        }
        return Integer.parseInt(salary);
    }
    
    public int takeIncrease(Worker worker){
        String salary;
        while(true){
            System.out.print("Enter enter amount to raise: ");
            salary = scanner.nextLine();
            if(validate.checkInt(salary, 1, Integer.MAX_VALUE)){
                break;
            }
        }
        return Integer.parseInt(salary);
    }
    
    public String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
}
