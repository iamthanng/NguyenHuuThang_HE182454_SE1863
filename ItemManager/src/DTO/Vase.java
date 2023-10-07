/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author macbook
 */
public class Vase extends Item {
    private int height;
    private String material;

    public Vase() {
    }

    public Vase(int height, String material) {
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public String getMaterial() {
        return material;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
        
    public void inputVase() { 
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter height: ");
        this.height = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter material: ");
        this.material = sc.nextLine();
    }
    
    public void outputVase() {
        super.output();
        System.out.println("Height: " + this.height);
        System.out.println("Material: " + this.material);
    }

}
