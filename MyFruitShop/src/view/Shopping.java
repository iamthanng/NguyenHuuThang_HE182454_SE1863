/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.*;
import model.OrderDetails;
import model.Orders;

/**
 *
 * @author ADMIN
 */
public class Shopping {

    public void info(ArrayList<Fruit> fList) {
        System.out.println("List of Fruits:");
        System.out.printf("| %10s | %10s | %10s | %10s", "++ Item ++", "++ Fruit Name ++", "++ Origin ++", "++ Price ++");
        System.out.println();
        for (int i = 0; i < fList.size(); i++) {
            System.out.printf("%7d  %13s  %15s  %12d$", i + 1, fList.get(i).getName(), fList.get(i).getOrigin(), fList.get(i).getPrice());
            System.out.println();
        }
    }

    public void order(ArrayList<Orders> oList, String name) {
        System.out.printf("%s | %s | %s | %s\n", "Product", "Quantity", "Price", "Amount");
        for (Orders orders : oList) {
            if (orders.getCustomer().equals(name)) {
                for (OrderDetails orders2 : orders.getList()) {
                    int total = 0;
                    System.out.printf("%5s  %8d  %8d  $%d\n", orders2.getFruit().getName(), orders2.getQuantity(), orders2.getFruit().getPrice(), orders2.getFruit().getPrice() * orders2.getQuantity());
                    total += orders2.getQuantity() * orders2.getFruit().getPrice();
                    System.out.println("Total: " + "$" + total);
                    System.out.println();
                }
            }

        }
    }
}
