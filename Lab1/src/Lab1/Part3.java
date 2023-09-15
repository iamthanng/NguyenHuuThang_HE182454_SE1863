/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

import java.util.Scanner;

/**
 *
 * @author macbook
 */
public class Part3 {
    public static void main(String[] args) {
        String[] list=new String[10];
        for(int i=0; i<10; i++) {
            Scanner sc = new Scanner(System.in);
            list[i] = sc.nextLine();
        }
        System.out.println();
        System.out.println("Uppercase Name: ");
        for(int i=0; i<10; i++) {
            list[i] = list[i].toUpperCase();
            System.out.println(list[i]);
        }
    }
}
