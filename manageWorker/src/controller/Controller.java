/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.*;
import view.*;
/**
 *
 * @author ADMIN
 */
public class Controller {
    private GetData getData = new GetData();
    private ArrayList<Worker> wList = new ArrayList<>();
    private ArrayList<AdjustedWorker> aList = new ArrayList<>();
    private Display display = new Display();
    
    public void addWorker(){
        System.out.println("---------- Add Worker ------------");
        String id, name, location;
        int age, salary;
        id = getData.takeID(wList);
        name = getData.takeName();
        age = getData.takeAge();
        salary = getData.takeSalary();
        location = getData.takeLocation();
        
        Worker worker = new Worker(id, name, age, salary, salary);
        
        wList.add(worker);
    }
    
    public void increaseSalary(){
        System.out.println("------------ Up/Down Salary ------------");
        String id;
        int amount;
        id = getData.findID(wList);
        if(id.equalsIgnoreCase(" ")){
            return;
        }
        Worker worker = null;
        for (Worker fworker : wList) {
            if(fworker.getId().equalsIgnoreCase(id)){
                worker = fworker;
            }
        }
        amount = getData.takeIncrease(worker);
        worker.setSalary(worker.getSalary() + amount);
        
        AdjustedWorker aWorker = new AdjustedWorker(id, worker.getName(), worker.getAge(), worker.getSalary(), worker.getLocation(), "UP", getData.getDate());
        aList.add(aWorker);
    }
    
    public void decreaseSalary(){
        System.out.println("------------ Up/Down Salary ------------");
        String id;
        int amount;
        id = getData.findID(wList);
        if(id.equalsIgnoreCase(" ")){
            return;
        }
        Worker worker = null;
        for (Worker fworker : wList) {
            if(fworker.getId().equalsIgnoreCase(id)){
                worker = fworker;
            }
        }
        amount = getData.takeDecrease(worker);
        worker.setSalary(worker.getSalary() - amount);
        
        AdjustedWorker aWorker = new AdjustedWorker(id, worker.getName(), worker.getAge(), worker.getSalary(), worker.getLocation(), "DOWN", getData.getDate());
        aList.add(aWorker);
    }
    
    public void showAdjusted(){
        Collections.sort(aList, new Comparator<AdjustedWorker>() {
            @Override
            public int compare(AdjustedWorker o1, AdjustedWorker o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        
        display.displayInformationSalary(aList);
    }
}
