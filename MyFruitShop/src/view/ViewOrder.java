/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.OrderDetails;
import model.Orders;

/**
 *
 * @author ADMIN
 */
public class ViewOrder {

    public void viewOrder(ArrayList<Orders> oList) {
        if (oList.isEmpty()) {
            System.out.println("Have no orders!");
            return;
        }
        for (Orders orders : oList) {
            System.out.println(orders.getCustomer());
            System.out.printf("%s | %s | %s | %s\n", "Product", "Quantity", "Price", "Amount");
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
