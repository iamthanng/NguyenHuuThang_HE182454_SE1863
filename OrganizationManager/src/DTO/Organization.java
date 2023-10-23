/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author macbook
 */
public abstract class Organization {
    int size;

    public Organization() {
    }

    public Organization(int size) {
        this.size = size;
    }
    
    public abstract void communicateByTool();
    @Override
    public String toString() {
        return "the organization's size is " + size;
    }
    
}
