/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import model.Fruit;

/**
 *
 * @author ADMIN
 */
public class Validate {

    public boolean checkInt(String input, int min, int max) {
        boolean check = false;
        try {
            int value = Integer.parseInt(input);
            if (value < min || value > max) {
                System.out.println("You need to input number in range " + min + "-" + max);
                check = false;
            } else {
                check = true;
            }
        } catch (NumberFormatException e) {
            System.out.println("You need input number");
            check = false;
        }
        return check;
    }

    public boolean checkString(String input, String pattern) {
        boolean check = false;
        try {
            if (input.matches(pattern)) {
                check = true;
            }
            if (input.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Cannot input blank string.");
            check = false;
        }
        return check;
    }

    public boolean checkExist(String input, ArrayList<Fruit> fList) {
        boolean check = false;
        for (Fruit fruit : fList) {
            if (fruit.getID().equalsIgnoreCase(input) || fruit.getName().equalsIgnoreCase(input)) {
                check = true;
            }
        }
        return check;
    }

    public boolean checkYN(String input) {
        boolean check = false;
        try {
            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
                check = true;
            }
            if (input.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Cannot input blank string.");
            check = false;
        }
        return check;
    }
}
