/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author macbook
 */
public class BeeColony extends Colony implements Role {
    private String type;

    public BeeColony() {
        super();
    }

    public BeeColony(int size, String place, String type) {
        super(place, size);
        this.type = type;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "the colony’s type is " + this.type + ", size is about " + this.size + ", and the place is " + this.place;
    }
    
    @Override
    public void createWorker() {
        System.out.println("Worker bees perform all the work of the bees");
    }   
}
