/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import controller.UserInput;

/**
 *
 * @author ADMIN
 */
public class validation {
    //Check số nằm trong khoảng
    public int getChoice(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
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

    //Check input Yes/No
    public boolean checkInputYN(String msg) {
        String inputYN;
        while (true) {
            System.out.print(msg);
            inputYN = UserInput.getString();
            if (!inputYN.isEmpty()) {
                if (inputYN.equalsIgnoreCase("Y")) {
                    return true;
                } else if (inputYN.equalsIgnoreCase("N")) {
                    return false;
                }
                System.err.println("You must choose Yes(Y/y) or No(N/n)!");
            } else {
                System.err.println("Cannnot be empty, please input again");
            }
        }
    }

    public boolean checkInputUD(String msg) {
        String inputUD;
        while (true) {
            System.out.print(msg);
            inputUD = UserInput.getString();
            if (!inputUD.isEmpty()) {
                if (inputUD.equalsIgnoreCase("U")) {
                    return true;
                } else if (inputUD.equalsIgnoreCase("D")) {
                    return false;
                }
                System.err.println("You must choose Update(U/u) or Delete(D/d)!");
            } else {
                System.err.println("Cannnot be empty, please input again");
            }
        }
    }

    //Check nhập string dùng regex expression
    public String checkInputString(String msg, String regex) {
        String inputString;
        while (true) {
            System.out.print(msg);
            inputString = UserInput.getString();
            if (!inputString.matches(regex)) {
                System.err.println("Invalid input, please input again");
                continue;
            }
            return inputString.toUpperCase();
        }
    }

    //Check nhập một trong 3 course java, net, c/c++
    public String checkInputCourse(String msg) {
        String inputCourse;
        while (true) {
            System.out.print(msg);
            inputCourse = UserInput.getString();
            if (inputCourse.equalsIgnoreCase("Java")) {
                return inputCourse.substring(0, 1).toUpperCase() + inputCourse.substring(1, inputCourse.length());
            } else if (inputCourse.equalsIgnoreCase(".Net")) {
                return inputCourse.substring(0, 1) + inputCourse.substring(1, 2).toUpperCase() + inputCourse.substring(2, inputCourse.length());
            } else if (inputCourse.equalsIgnoreCase("C/C++")) {
                return inputCourse.substring(0, 1).toUpperCase() + inputCourse.substring(1, 2) + inputCourse.substring(2, 3).toUpperCase() + inputCourse.substring(3, inputCourse.length());
            } else {
                System.err.println("There are only three courses: Java, .Net, C/C++");
            }
        }
    }
}
