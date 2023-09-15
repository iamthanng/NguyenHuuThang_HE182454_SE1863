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
public class Part1 {
    public static void main(String[] args) {
        int rows;
        int cols;
        int matrix[][];
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        cols = sc.nextInt();
        matrix = new int[rows][cols];
        System.out.println("Enter the matrix");
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                System.out.print("m[" + i + "][" + j + "]=");
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Matrix inputted:");
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                System.out.format("%3d", matrix[i][j]);
            }
            System.out.println();
        }
        //Sum
        int sum=0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println("Sum: " + sum);
        
        //Average
        System.out.println("Average: " + (float)sum/(rows*cols));
    }
}
