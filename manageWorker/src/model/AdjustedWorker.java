/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class AdjustedWorker extends Worker{
    private String status;
    private String date;

    public AdjustedWorker() {
    }

    public AdjustedWorker(String id, String name, int age, int salary, int location, String status, String date) {
        super(id, name, age, salary, location);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
