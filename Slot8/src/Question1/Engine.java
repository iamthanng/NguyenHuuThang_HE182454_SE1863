/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question1;

/**
 *
 * @author macbook
 */
public class Engine {
    protected String designer;
    protected int power;
    
    public Engine() {
        super();
    }
    
    public Engine(String designer, int power) {
        super();
        this.designer = designer;
        this.power = power;
    }

    public String getDesigner() {
        return designer.substring(0,1).toLowerCase() + designer.substring(1,3);
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}

