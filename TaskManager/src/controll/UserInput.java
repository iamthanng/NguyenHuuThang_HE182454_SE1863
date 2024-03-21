/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Task;
import utils.Validate;

/**
 *
 * @author ADMIN
 */
public class UserInput {

    public Scanner scanner = new Scanner(System.in);
    public Validate valid = new Validate();

    public int takeUserChoice() {
        String userChoice;
        while (true) {
            userChoice = scanner.nextLine();
            if (valid.checkInt(userChoice, 1, 4)) {
                break;
            }
        }
        return Integer.parseInt(userChoice);
    }

    public int takeID(ArrayList<Task> taskList) {
        String id;
        while (true) {
            System.out.print("Enter ID: ");
            id = scanner.nextLine();
            if (valid.checkInt(id, 1, taskList.size())) {
                break;
            }
        }
        return Integer.parseInt(id);
    }

    public String takeTaskTypeID() {
        String takeTaskTypeID;
        while (true) {
            System.out.print("Task Type: ");
            takeTaskTypeID = scanner.nextLine();
            if (valid.checkInt(takeTaskTypeID, 1, 4)) {
                break;
            }
        }
        switch (Integer.parseInt(takeTaskTypeID)) {
            case 1:
                takeTaskTypeID = "Code";
                break;
            case 2:
                takeTaskTypeID = "Test";
                break;
            case 3:
                takeTaskTypeID = "Manager";
                break;
            case 4:
                takeTaskTypeID = "Learn";
        }
        return takeTaskTypeID;
    }

    public String takeRequireName() {
        String requireName;
        while (true) {
            System.out.print("Require Name: ");
            requireName = scanner.nextLine();
            if (valid.checkString(requireName, "^[a-zA-Z]+$")) {
                break;
            }
        }
        return requireName;
    }

    public String takeDate() throws ParseException {
        String date;
        while (true) {
            System.out.print("Date: ");
            date = scanner.nextLine();
            if (valid.checkDate(date, "dd-MM-yyyy")) {
                break;
            }
        }
        return date;
    }

    public String takePlan() {
        String plan;
        while (true) {
            plan = scanner.nextLine();
            if (valid.checkPlan(plan)) {
                break;
            }
        }
        return plan;
    }

    public String takeAssignee() {
        String assignee;
        while (true) {
            System.out.print("Assignee: ");
            assignee = scanner.nextLine();
            if (valid.checkString(assignee, "^[a-zA-Z]+$")) {
                break;
            }
        }
        return assignee;
    }

    public String takeReviewer() {
        String requireName;
        while (true) {
            System.out.print("Reviewer: ");
            requireName = scanner.nextLine();
            if (valid.checkString(requireName, "^[a-zA-Z]+$")) {
                break;
            }
        }
        return requireName;
    }
}
