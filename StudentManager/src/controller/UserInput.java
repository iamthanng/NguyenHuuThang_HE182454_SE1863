/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class UserInput {
    
    public static int getInt(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String getString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();
    }
}
