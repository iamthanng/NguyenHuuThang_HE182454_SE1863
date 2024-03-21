package utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author admin
 */
public class Validate {

    public static String formatOneSpaceSpecial(String line, String character) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = line.split("\\s*\\" + character + "\\s*");
        
        for (String oneWord : strings) {
            stringBuilder.append(oneWord + " " + character);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim().substring(0, stringBuilder.length()-3);
    }

    public static String formatOneSpace(String line) {
        line = line.toLowerCase();
        line = line.replaceAll("\\s+", " ");
        line = formatOneSpaceSpecial(line, ".");
        line = formatOneSpaceSpecial(line, ",");
        line = formatOneSpaceSpecial(line, ":");
        line = formatOneSpaceSpecial(line, "\"");        
        return line.trim();
    }

    public static String noSpacesBeforeSpecial(String line) {
        StringBuilder stringBuilder = new StringBuilder(line);
        for (int i = 0; i < stringBuilder.length() - 1; i++) {
            if (stringBuilder.charAt(i) == ' '
                    && stringBuilder.charAt(i + 1) == '.'
                    || stringBuilder.charAt(i + 1) == ','
                    || stringBuilder.charAt(i + 1) == ':') {
                stringBuilder.deleteCharAt(i);
            }
        }
        return stringBuilder.toString().trim();
    }

    public static String afterDotUppercase(String line) {
        StringBuilder stringBuilder = new StringBuilder(line);
        int lengthLine = stringBuilder.length();
        //check from first to last after . then UpperCase
        for (int i = 0; i < lengthLine - 2; i++) {
            if (stringBuilder.charAt(i) == '.') {
                char afterDot = stringBuilder.charAt(i + 2);
                stringBuilder.setCharAt(i + 2, Character.toUpperCase(afterDot));
            }
        }
        return stringBuilder.toString().trim();
    }

    static int countQuetes = 0;

    public static String noSpaceInQuotes(String line) {
        StringBuilder stringBuilder = new StringBuilder(line);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '"' && countQuetes % 2 == 0) {
                stringBuilder.deleteCharAt(i + 1);
                countQuetes++;
            } else if (stringBuilder.charAt(i) == '"' && countQuetes % 2 == 1
                    && i != 0) {
                stringBuilder.deleteCharAt(i - 1);
                countQuetes++;
            }
        }
        return stringBuilder.toString().trim();
    }

    public static String firstCharUpercase(String line) {
        StringBuilder stringBuilder = new StringBuilder(line);
        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                stringBuilder.setCharAt(i, Character.toUpperCase(line.charAt(i)));
                break;
            }
        }
        return stringBuilder.toString().trim();
    }

    public static String lastAddDot(String line) {
        if (line.endsWith(".")) {
            return line;
        } else {
            return line + ".";
        }
    }

    public static boolean isLineEmpty(String line) {
        if (line.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int countLine() {
        int countLine = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt", true)));
            String line;
            //write until end file
            while ((line = br.readLine()) != null) {
                //check line empty
                if (isLineEmpty(line)) {
                    continue;
                }
                countLine++;
            }
            br.close();
            pw.close();

        } catch (FileNotFoundException ex) {
            System.err.println("Can't found.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return countLine;
    }
}
