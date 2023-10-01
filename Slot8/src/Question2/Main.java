/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question2;

import java.util.Scanner;

/**
 *
 * @author macbook
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String xLabel; int xType, xStep; int tc;
        System.out.println();
        System.out.print("Enter label: ");
        xLabel = sc.nextLine();
        System.out.print("Enter type: ");
        xType = sc.nextInt(); sc.nextLine();
        System.out.print("Enter step: ");
        xStep = sc.nextInt(); sc.nextLine();
        System.out.println("1. Test toString()");
        System.out.println("2. Test setData()");
        System.out.println("3. Test getValue()");
        
        System.out.print("Enter TC (1, 2, 3): ");
        tc = sc.nextInt(); sc.nextLine();
        System.out.println("OUTPUT:");
        
        switch(tc) {
            case 1:
                Robot a11 = new Robot(xLabel, xType);
                System.out.println(a11);
                Robot a12 = new SpecRobot(xLabel, xType, xStep);
                System.out.println(a12);
                break;
            case 2:
                SpecRobot b2 = new SpecRobot(xLabel, xType, xStep);
                b2.setData();
                String v2 = b2.getLabel();
                int k2 = b2.getType();
                System.out.printf("%s, %d\n",v2,k2);
                break;
            case 3:
                SpecRobot b3 = new SpecRobot(xLabel, xType, xStep);
                int v3 = b3.getValue();
                System.out.printf("%d\n",v3);
                break;
            default:    
                break;
        }
        System.out.println();
    }
}
