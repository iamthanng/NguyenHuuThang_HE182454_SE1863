/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question1;

import java.util.Scanner;

/**
 *
 * @author macbook
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String xDesigner; int xPower, xPower2; int tc;
        xPower2 = 0;
        System.out.println();
        System.out.print("Enter designer: ");
        xDesigner = sc.nextLine();
        System.out.print("Enter power: ");
        xPower = sc.nextInt(); sc.nextLine();
        
        System.out.println("1. Test getDesigner()");
        System.out.println("2. Test setPower()");
        
        System.out.print("Enter TC(1 or 2): ");
        tc = sc.nextInt(); sc.nextLine();
        
        Engine t = new Engine(xDesigner, xPower);
        
        if(tc == 2) {
            System.out.println("Enter new power: ");
            xPower2 = sc.nextInt(); sc.nextLine();
            t.setPower(xPower2);
        }
        
        System.out.println("OUTPUT:");
        
        switch(tc) {
            case 1:
                String u = t.getDesigner();
                System.out.printf("%s\r\n",u);
                break;
            case 2:
                int v = t.getPower();
                System.out.printf("%d\r\n",v);
                break;
            default:
                return;
        }
        System.out.println();
    }
}
