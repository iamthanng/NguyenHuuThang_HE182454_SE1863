
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author macbook
 */
public class MyRobot implements IRobot {

    @Override
    public int f1(List<Robot> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if(!(list.get(i).getLabel().contains("A")) && !(list.get(i).getLabel().contains("B"))) {
                sum += list.get(i).getStep();
            }
        }
        return sum;
    }

    @Override
    public void f2(List<Robot> list) {
        int indexMax = getIndexMax(list);
        list.remove(indexMax);
    }

    @Override
    public void f3(List<Robot> list) {
        Comparator<Robot> comparator = new Comparator<Robot>() {
            @Override
            public int compare(Robot t1, Robot t2) {
                int alphabet = t2.getLabel().compareTo(t1.getLabel());
                
                if(alphabet == 0) {
                    if(t1.getStep() > t2.getStep()) {
                        return -1;
                    } else if(t1.getStep() == t2.getStep()) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    return alphabet;
                }
            }
        };
        Collections.sort(list, comparator);
    }

    private int getIndexMax(List<Robot> list) {
        int indexMax = list.get(0).getStep();
        int valueMax = 0;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).getStep() > valueMax) {
                valueMax = list.get(i).getStep();
                indexMax = i;
            }
        }
        return indexMax;
    }
}
