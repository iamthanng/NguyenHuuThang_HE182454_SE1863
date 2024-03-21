/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.Task;

/**
 *
 * @author ADMIN
 */
public class Menu {

    public void Menu() {
        System.out.println("======== Task program ========");
        System.out.println("    1. Add Task");
        System.out.println("    2. Delete Task");
        System.out.println("    3. Display Task");
        System.out.println("    4. Exit");
        System.out.print("Enter your choice: ");
    }

    public void showTask(ArrayList<Task> taskList) {
        System.out.println("-------------------------Task-------------------------");
        System.out.printf("%5s  %10s  %15s  %10s  %10s   %10s  %10s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.printf("%5s  %10s  %15s  %10s  %10s   %10s  %10s\n",
                    taskList.get(i).getId(),
                    taskList.get(i).getRequireName(),
                    taskList.get(i).getTaskTypeID(),
                    taskList.get(i).getDate(),
                    Double.parseDouble(taskList.get(i).getPlanTo()) - Double.parseDouble(taskList.get(i).getPlanFrom()),
                    taskList.get(i).getAssignee(),
                    taskList.get(i).getReviewer());
        }
    }

}
