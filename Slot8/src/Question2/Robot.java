/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question2;

/**
 *
 * @author macbook
 */
public class Robot {
    protected String label;
    protected int type;
    
    public Robot() {
        super();
    }
    
    public Robot(String label, int type) {
        super();
        this.label = label;
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    } 
    
    @Override
    public String toString() {
        return label + ", " + type;
    }
}
