/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Task;

/**
 *
 * @author ADMIN
 */
public class Validate {

    public boolean checkInt(String input, int min, int max) {
        boolean check = false;
        try {
            int value = Integer.parseInt(input);
            if (value < min || value > max) {
                System.out.println("You need to input number in range " + min + "-" + max);
                check = false;
            } else {
                check = true;
            }
        } catch (NumberFormatException e) {
            System.out.println("You need input number");
        }
        return check;
    }

    public boolean checkString(String input, String pattern) {
        boolean check = false;
        try {
            if (input.matches(pattern)) {
                check = true;
            }
            if (input.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Cannot input blank string.");
            check = false;
        }
        return check;
    }

    public boolean checkPlan(String input) {
        boolean check = false;
        try {
            if (input.matches("^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$") && Double.parseDouble(input) >= 8.0
                    && Double.parseDouble(input) <= 17.5) {
                check = true;
            } else {
                System.out.println("Plan must be within 8.0, 8.5, 9.0, ⇔ 9.5 ...-> 17.5");
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid input");
        }
        return check;
    }

    public boolean checkExist(int id, ArrayList<Task> taskList) {
        boolean check = false;
        for (Task task : taskList) {
            if (task.getId() == id) {
                check = true;
            }
        }
        return check;
    }

    public boolean checkDate(String input, String dateFormat) throws ParseException {
        boolean check = false;
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        Date date = format.parse(input);

        try {
            if (input.equalsIgnoreCase(format.format(date))) {
                check = true;
            } else {
                System.err.println("Re-input");
            }
        } catch (NumberFormatException e) {
            System.out.println("asdcasd");
        }
        return check;
    }
}
