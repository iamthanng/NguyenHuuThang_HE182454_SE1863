/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import java.util.ArrayList;
import java.util.Scanner;
import model.Fruit;
import util.Validate;

/**
 *
 * @author ADMIN
 */
public class UserInput {
    public Scanner sc = new Scanner(System.in);
    public Validate valid = new Validate();

    public int takeUserChoice(){
        String userChoice;
        while(true){
            userChoice = sc.nextLine();
            if(valid.checkInt(userChoice, 1, 4)) break;
        }
        return Integer.parseInt(userChoice);
    }

    public int takeUserShopping(ArrayList<Fruit> fList){
        String userShopping;
        while(true){
            userShopping = sc.nextLine();
            if(valid.checkInt(userShopping, 1, fList.size())) break;
        }
        return Integer.parseInt(userShopping);
    }

    public int takeQuantity(int maxQuan){
        String input;
        while(true){
            input = sc.nextLine();
            if(valid.checkInt(input, 1, maxQuan)) break;
        }
        return Integer.parseInt(input);
    }
    
    public String takeID(){
        String fruitID;
        while(true){
            System.out.print("Enter fruit's ID: ");
            fruitID = sc.nextLine();
            if(valid.checkString(fruitID, "[a-zA-Z1-9]+")) break;
        }
        return fruitID;
    }

    public String takeName(){
        String fruitName;
        while(true){
            System.out.print("Enter fruit's name: ");
            fruitName = sc.nextLine();
            if(valid.checkString(fruitName, "[a-zA-Z1-9]+")) break;
        }
        return fruitName;
    }

    public String takeUserName(){
        String Name;
        while(true){
            System.out.print("Enter your name: ");
            Name = sc.nextLine();
            if(valid.checkString(Name, "[a-zA-Z1-9]+")) break;
        }
        return Name;
    }

    public int takePrice(){
        String fruitPrice;
        while(true){
            System.out.print("Enter fruit's price: ");
            fruitPrice = sc.nextLine();
            if(valid.checkInt(fruitPrice, Integer.MIN_VALUE, Integer.MAX_VALUE)) break;
        }
        return Integer.parseInt(fruitPrice);
    }

    public int takeQuantity(){
        String fruitPrice;
        while(true){
            System.out.print("Enter fruit's quantity: ");
            fruitPrice = sc.nextLine();
            if(valid.checkInt(fruitPrice, Integer.MIN_VALUE, Integer.MAX_VALUE)) break;
        }
        return Integer.parseInt(fruitPrice);
    }

    public String takeOrigin(){
        String fruitOrigin;
        while(true){
            System.out.print("Enter fruit's Origin: ");
            fruitOrigin = sc.nextLine();
            if(valid.checkString(fruitOrigin, "[a-zA-Z1-9]+")) break;
        }
        return fruitOrigin;
    }

    public String takeChoice(){
        String choice;
        while(true){
            choice = sc.nextLine();
            if(valid.checkYN(choice)) break;
        }
        return choice;
    }
    public void close(){
        sc.close();
    }
}
