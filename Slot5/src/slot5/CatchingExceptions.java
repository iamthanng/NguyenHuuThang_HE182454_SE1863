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
public class CatchingExceptions {
    public static int inputInteger() throws Exception{
    Scanner in = new Scanner(System.in);
    System.out.print("Enter a whole number: ");
    int n = Integer.parseInt(in.nextLine());
    if( n<10 || n>50) throw new Exception();
    return n;
}
    public static void main(String[] args){

    boolean cont=true; int n=0;
    do { 
        try{ n= inputInteger();
        cont=false;
    } catch(Exception e){
    System.out.println("Required integer!"); }
    } while(cont==true);
    System.out.print("Number:"+ n);
    }
}
