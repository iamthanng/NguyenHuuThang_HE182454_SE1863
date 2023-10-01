/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question2;

/**
 *
 * @author macbook
 */
public class SpecRobot extends Robot {
    protected int step;
    
    public SpecRobot() {
        super();
    }
    
    public SpecRobot(String label, int type, int step) {
        super(label, type);
        this.step = step;
    }
    
    @Override
    public String toString() {
        return super.toString()+", "+step;
    }
    
    public void setData() {
        super.setLabel(label.substring(0,1)+step+label.substring(1));
    }

    
    public int getValue() {
        if(type < 3 && label.contains("A")) {
            return step;
        } else {
            return step + 2;
        }
    }
}