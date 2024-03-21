/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import java.util.ArrayList;
import model.Task;

/**
 *
 * @author ADMIN
 */
public class Controller {

    UserInput ui = new UserInput();

    public void addTask(ArrayList<Task> taskList, int id) {
        String requirementName = ui.takeRequireName();
        String taskTypeId = ui.takeTaskTypeID();
        String date = ui.takeDate();
        while (true) {
            System.out.print("Plan from: ");
            String planFrom = ui.takePlan();
            System.out.print("Plan to: ");
            String planTo = ui.takePlan();
            if(Double.parseDouble(planFrom) < Double.parseDouble(planTo)){
                break;
            } else {
                System.out.println("Plan From must be less than Plan To");
            }
        }
        String assign = ui.takeAssignee();
        String reviewer = ui.takeReviewer();
        taskList.add(new Task(id, taskTypeId, requirementName, date, assign, date, assign, reviewer));
        System.out.println("Add task success!");
    }
    
    public void deleteTask(ArrayList<Task> taskList){
        if(taskList.isEmpty()){
            System.out.println("List empty");
            return;
        }
        int indexDel = findTaskExist(taskList);
        if(indexDel != -1){
            taskList.remove(indexDel);
            for(int i = indexDel; i<taskList.size(); i++){
                taskList.get(i).setId(taskList.get(i).getId()-1);
            }
        }
    }
    
    public int findTaskExist(ArrayList<Task> taskList) {
        System.out.print("Enter id: ");
        int id = ui.takeID(taskList);
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getId() == id) {
                return i;
            }
        }
        System.err.println("Not found.");
        return -1;
    }
}
