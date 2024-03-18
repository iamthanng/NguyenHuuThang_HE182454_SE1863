/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class OrderDetails {

    private int Quantity;
    private Fruit fruit;

    public OrderDetails() {
    }

    public OrderDetails(int quantity, Fruit fruit) {
        Quantity = quantity;
        this.fruit = fruit;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

}
