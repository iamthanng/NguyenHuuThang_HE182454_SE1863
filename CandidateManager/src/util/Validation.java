/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import controller.UserInput;
import java.util.Calendar;

/**
 *
 * @author ADMIN
 */
public class Validation {

    public static int checkLimit(int min, int max) {
        while (true) {
            try {
                int choice = UserInput.getInt();
                if (choice < min || choice > max) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch (NumberFormatException e) {
                System.err.println("Input must be in range [" + min + ", " + max + "]");
            }
        }
    }

    public static String checkString() {
        String inputString;
        while (true) {
            inputString = UserInput.getString();
            if (inputString.isEmpty()) {
                System.err.println("Not empty");
                System.out.println("Enter again: ");
            }
            return inputString;
        }
    }

    //check user input y/Y or n/N
    public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkString();
            //check user input y/Y or n/N
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    //check phone is number with minimum 10 characters
    public static String checkPhone() {
        while (true) {
            String result = checkString();
            //check user input phone valid
            if (result.matches("^\\d{10}\\d*$")) {
                return result;
            } else {
                System.err.println("Phone is number with minimum 10 characters");
                System.out.print("Enter again: ");
            }
        }
    }   //check email with format <account name>@<domain>. (eg: annguyen@fpt.edu.vn)

    public static String checkEmail() {
        //loop until user input correct
        while (true) {
            String result = checkString();
            //check user input email valid
            if (result.matches("[a-zA-Z0-9_.]+@[a-zA-Z]+\\.[a-zA-Z]{2,4}$")) {
                return result;
            } else {
                System.err.println("Email with format <account name>@<domain>");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input graduation rank
    public static String checkGraduationRank() {
        while (true) {
            String result = checkString();
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }

    //check experience must be smaller then age
    public static int checkInputExprience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = checkLimit(1, 100);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }
    }
}
