/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Example2;

/**
 *
 * @author macbook
 */
public class Brick {
   protected String place;
    protected int price;
    
    public Brick() {
        super();
    }
    
    public Brick(String place, int price) {
        super();
        this.place = place;
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return place + ", " + price;
    } 
}
