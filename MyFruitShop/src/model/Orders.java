/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Orders {

    private String Customer;
    private ArrayList<OrderDetails> list = new ArrayList<>();

    public Orders() {
    }

    public Orders(String customer, ArrayList<OrderDetails> list) {
        Customer = customer;
        this.list = list;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public ArrayList<OrderDetails> getList() {
        return list;
    }

    public void setList(ArrayList<OrderDetails> list) {
        this.list = list;
    }
}
