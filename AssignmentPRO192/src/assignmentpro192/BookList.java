package assignmentpro192;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Macbook
 */
public class BookList {
    ArrayList<Book> t = new ArrayList<>();
    
    public void addBook(String code, String title, int qua, double price) throws Exception { 
        for (Book b : t) {
            if (b.code.equals(code)) {
                System.out.println("Already exists.");
                return;
            }
        }
        t.add(new Book(code, title, qua, price));
    }
    
    public void displayAllBooks() throws Exception {
        for (Book b : t) {
            System.out.println(b.code + ", " + b.title + ", " + b.qua + ", " + b.price);
        }
    }

    public void searchBook(String code) throws Exception {
        for (Book b : t) {
            if (b.code.equals(code)) {
                System.out.println(b.code + ", " + b.title + ", " + b.qua + ", " + b.price);
                return;
            }
        }
        System.out.println("Not found.");
    }

    public void updateBookPrice(String code, double price) throws Exception {
        for (Book b : t) {
            if (b.code.equals(code)) {
                b.price = price;
                return;
            }
        }
        System.out.println("Not found.");
    }

    public int findMaxPrice() throws Exception {
        if (t.isEmpty()) {
            return -1;
        }
        double maxPrice = t.get(0).price;
        int maxIndex = 0;
        for (int i = 1; i < t.size(); i++) {
            if (t.get(i).price > maxPrice) {
                maxPrice = t.get(i).price;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public void sortAscendingByCode() throws Exception {
        Collections.sort(t);
    }

    public void removeBook(String code) throws Exception {
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i).code.equals(code)) {
                t.remove(i);
                return;
            }
        }
        System.out.println("Not found.");
    }
    
    public void loadDataFromFile() throws Exception {
        
    }
    
}