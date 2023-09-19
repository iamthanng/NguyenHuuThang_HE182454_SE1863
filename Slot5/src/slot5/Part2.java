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
public class Part2 {
    public static void main(String[] args) {
        boolean cont=false;
        do{
            try{
                String s = "";
                String pattern = "SE\\d{3}";
                Scanner sc = new Scanner(System.in);
                System.out.println("enter the string:");
                s=sc.nextLine();
                if( ! s.matches(pattern))
                    throw new Exception();
                System.out.println("The string is "+ s);
                cont = false;
            }catch(Exception e) {
                System.out.println("The string is invalid");
                cont = true;
            }
        }while(cont);
    }
}
            
