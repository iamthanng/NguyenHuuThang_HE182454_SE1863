/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import java.util.ArrayList;
import model.Fruit;
import model.OrderDetails;
import model.Orders;
import util.Validate;
import view.*;

/**
 *
 * @author ADMIN
 */
public class Controller {

    public ArrayList<Fruit> fList = new ArrayList<>();
    public ArrayList<Fruit> oList = new ArrayList<>();
    public UserInput ui = new UserInput();
    public Validate validate = new Validate();
    public Shopping shopping = new Shopping();
    private ViewOrder viewOrder = new ViewOrder();

    ArrayList<Orders> showOrderList = new ArrayList<>();

    public void creatFruit() {
        String ID;
        String name;
        int price;
        int quantity;
        String origin;
        while (true) {
            while (true) {
                ID = ui.takeID();
                if (validate.checkExist(ID, fList)) {
                    System.out.println("The ID is already exist, please enter another ID.");
                } else {
                    break;
                }
            }
            name = ui.takeName();
            price = ui.takePrice();
            quantity = ui.takeQuantity();
            origin = ui.takeOrigin();
            Fruit fr = new Fruit(ID, name, price, quantity, origin);
            fList.add(fr);
            System.out.println("Do you want to continue (Y/N)?");
            String choice = ui.takeChoice();
            if (choice.equalsIgnoreCase("n")) {
                shopping.info(fList);
                break;
            }
        }
    }

    public void viewOrder() {
        viewOrder.viewOrder(showOrderList);
    }

    public void Shopping() {
        int choice, quantity, maxQuan;
        String name;
        ArrayList<OrderDetails> uList = new ArrayList<>();
        if (fList.isEmpty()) {
            System.out.println("Have no fruit!");
            return;
        }
        while (true) {
            shopping.info(fList);
            System.out.print("Select item: ");
            choice = ui.takeUserShopping(fList);
            maxQuan = fList.get(choice - 1).getQuantity();

            Fruit fruit = fList.get(choice - 1);

            System.out.println("You selected: " + fruit.getName());

            System.out.print("Please input quantity: ");
            quantity = ui.takeQuantity(maxQuan);
            fruit.setQuantity(fruit.getQuantity() - quantity);

            System.out.println("Do you want to order now (Y/N)?");
            String choiceCont = ui.takeChoice();

            if (!choiceCont.equalsIgnoreCase("y")) {
                continue;
            }
            name = ui.takeUserName();

            OrderDetails uO = new OrderDetails(quantity, fruit);
            uList.add(uO);
            Orders orders = new Orders(name, uList);
            showOrderList.add(orders);
            break;
        }
        shopping.order(showOrderList, name);// name -> showOrderList.size() 
    }

    public void test() {
        Fruit fr1 = new Fruit("app", "apple", 5, 1000, "US");
        Fruit fr2 = new Fruit("bnn", "banana", 3, 2000, "VN");
        Fruit fr3 = new Fruit("kw", "kiwi", 7, 500, "NewZealand");
        Fruit fr4 = new Fruit("ccn", "coconut", 2, 1000, "VietNam");
        Fruit fr5 = new Fruit("grp", "grape", 6, 1000, "Fance");

        fList.add(fr1);
        fList.add(fr2);
        fList.add(fr3);
        fList.add(fr4);
        fList.add(fr5);
    }
}
