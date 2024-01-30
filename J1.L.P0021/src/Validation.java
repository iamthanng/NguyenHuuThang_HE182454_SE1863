
import java.util.ArrayList;
import java.util.Scanner;

public class Validation {

    Scanner sc = new Scanner(System.in);

    //Check số nhập vào nằm trong khoảng
    public int getChoice(String msg, int min, int max) {
        int choice;
        while (true) {
            System.out.print(msg);
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < min || choice > max) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch (NumberFormatException e) {
                System.err.println("Input must be in range [" + min + ", " + max + "]");
            }
        }
    }
    //Check nhập Yes/NO
    public boolean checkInputYN(String msg) {
        String c;
        while (true) {
            System.out.print(msg);
            c = sc.nextLine().trim();
            if (!c.isEmpty()) {
                if (c.equalsIgnoreCase("Y")) {
                    return true;
                } else if (c.equalsIgnoreCase("N")) {
                    return false;
                }
                System.err.println("You must choose Yes(Y/y) or No(N/n)!");
            } else {
                System.err.println("Cannnot be empty, please input again");
            }
        }
    }
    //Check nhập Update/ Delete
    public boolean checkInputUD(String msg) {
        String c;
        while (true) {
            System.out.print(msg);
            c = sc.nextLine().trim();
            if (!c.isEmpty()) {
                if (c.equalsIgnoreCase("U")) {
                    return true;
                } else if (c.equalsIgnoreCase("D")) {
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
        String n;
        while (true) {
            System.out.print(msg);
            n = sc.nextLine();
            if (!n.matches(regex)) {
                System.err.println("Invalid input, please input again");
                continue;
            }
            return n.toUpperCase();
        }
    }

    //Check nhập một trong 3 course java, net, c/c++
    public String checkInputCourse(String msg) {
        String n;
        while (true) {
            System.out.print(msg);
            n = sc.nextLine().trim();
            if (n.equalsIgnoreCase("Java")) {
                return n.substring(0, 1).toUpperCase() + n.substring(1, n.length());
            } else if (n.equalsIgnoreCase(".Net")) {
                return n.substring(0, 1) + n.substring(1, 2).toUpperCase() + n.substring(2, n.length());
            } else if (n.equalsIgnoreCase("C/C++")) {
                return n.substring(0, 1).toUpperCase() + n.substring(1, 2) + n.substring(2, 3).toUpperCase() + n.substring(3, n.length());
            } else {
                System.err.println("There are only three courses: Java, .Net, C/C++");
            }
        }
    }
}
