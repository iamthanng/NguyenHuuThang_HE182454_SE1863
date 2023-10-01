/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Example1;

import java.util.Scanner;

/**
 *
 * @author macbook
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String xMaker; int xVolume, xVolume2; int tc;
        xVolume2 = 0;
        System.out.println();
        System.out.print("Enter maker: ");
        xMaker = sc.nextLine();
        System.out.print("Enter volume: ");
        xVolume = sc.nextInt(); sc.nextLine();
        
        System.out.println("1. Test getMaker()");
        System.out.println("2. Test setVolume()");
        
        System.out.print("Enter TC (1 or 2): ");
        tc = sc.nextInt(); sc.nextLine();
        
        Bottle t = new Bottle(xMaker, xVolume);
        if(tc == 2) {
            System.out.print("Enter new volume: ");
            xVolume2 = sc.nextInt(); sc.nextLine();
            t.setVolume(xVolume2);
        }
        
        System.out.println("OUTPUT:");
        
        switch(tc) {
            case 1:
                String u = t.getMaker();
                System.out.printf("%s\r\n", u);
                break;
            case 2:
                int v = t.getVolume();
                System.out.printf("%d\r\n", v);
                break;
            default:
                return;
        }
        System.out.println();
    }
}
