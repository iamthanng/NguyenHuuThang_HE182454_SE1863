/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Example1;

/**
 *
 * @author macbook
 */
public class Bottle {
    protected String maker;
    protected int volume;
    
    public Bottle() {
        super();
    }
    
    public Bottle(String maker, int volume) {
        super();
        this.maker = maker;
        this.volume = volume;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
