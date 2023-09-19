/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot5;

import java.util.Scanner;

/**
 *
 * @author macbook
 */
public class Part1 {
    public static void main(String[] args) {
        boolean cont=false;
        do{
            try{
                int num;
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the number: ");
                num = sc.nextInt();
                if(num < 1) 
                    throw new Exception();
                System.out.println("The number is " + num);
                cont=false;
            } catch(Exception e) {
                System.out.println("The number is invalid");
                cont=true;
            }
        } while(cont);
    }
}

