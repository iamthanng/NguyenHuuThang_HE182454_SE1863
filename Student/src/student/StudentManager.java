/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

/**
 *
 * @author macbook
 */
public class StudentManager {
    public static void main(String[] args) {
        String[] options = { "Add new student", "Search a student", "Update name and mark",
            "Remove a student", "List all", "Quit"};
        int choice = 0;
        StudentList list = new StudentList();
        do {
            System.out.println("\nStuden managing Program");
            choice = Menu.getChoice(options);
            switch(choice) {
                case 1: list.addStudent(); break;
                case 2: list.searchStudent(); break;
                case 3: list.updateStudent(); break;
                case 4: list.removeStudent(); break;
                case 5: list.printAll(); break;
                default: System.out.println("Bye!");
            }
        }
        while(choice > 0 && choice < 6);
    }
}
