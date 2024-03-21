/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import utils.Validate;

/**
 *
 * @author admin
 */
public class NormalizeText {
    /**
     * Handle file text
     */
    public void normalizeText() {
        try {
            int countLine = Validate.countLine();
            int count = 1;
            
            BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            String line;
            while((line = br.readLine()) != null) {
                if(Validate.isLineEmpty(line)) {
                    continue;
                }
                line = Validate.formatOneSpace(line);
                line = Validate.noSpacesBeforeSpecial(line);
                line = Validate.afterDotUppercase(line);
                line = Validate.noSpaceInQuotes(line);
                line = Validate.firstCharUpercase(line);
                line = Validate.lastAddDot(line);
                pw.print(line);
                
                if(count<countLine) {
                    pw.print("\n"); // thay bang \r\n van chay duoc
                }
                count++;
            }
            br.close();
            pw.close();
            System.out.println("Successfully");
            
        } catch(FileNotFoundException e) {
            System.err.println("Can't found");
        } catch(IOException e) {
            e.printStackTrace();
            
        }
    }
}
