/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import model.*;

/**
 *
 * @author ADMIN
 */
public class Validate {
    
    public boolean checkInt(String input, int min, int max){
        boolean check = false;
        if(!input.isEmpty()){
            try{
                int number = Integer.parseInt(input);
                if(min<=number && number <= max){
                    check = true;
                }else{
                    throw new Exception();
                }
            }catch(NumberFormatException e){
                System.out.println("input need to be number");
            }catch(Exception ex){
                System.out.println("input number in range " + min + " " + max);
            }
        }else{
            System.out.println("Cannot input blank.");
        }
        return check;
    }
    
    public boolean checkString(String input, String pattern){
        boolean check = false;
        if(!input.isEmpty()){
            if(input.matches(input)){
                check = true;
            }else{
                System.out.println("input wrong format.");
            }
        }else{
            System.out.println("Cannot input blank.");
        }
        return check;
    }
    
    public boolean checkExist(String id, ArrayList<Worker> wList){
        boolean check = false;
        for (Worker worker : wList) {
            if(worker.getId().equalsIgnoreCase(id)){
                check = true;
            }
        }
        return check;
    }
}
