package assignmentpro192;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BookList b = new BookList();
        int choice;
        
        do {
            System.out.println("1. Input & add book(s) to the end.");
            System.out.println("2. Display all books.");
            System.out.println("3. Search a book for given code.");
            System.out.println("4. Update the book’s price for given code.");
            System.out.println("5. Find the (first) max price value.");
            System.out.println("6. Sort the list ascendingly by code.");
            System.out.println("7. Remove the book having given code.");
            System.out.println("8. Load data from file.");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt(); sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter code: ");
                    String code = sc.nextLine();
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    int qua = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble(); sc.nextLine();
                    b.addBook(code, title, qua, price);
                    break;
                
                case 2:
                    b.displayAllBooks();
                    break;
                
                case 3:
                    System.out.print("Enter code: ");
                    String searchCode = sc.nextLine();
                    b.searchBook(searchCode);
                    break;
                
                case 4:
                    System.out.print("Enter code: ");
                    String updateCode = sc.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble(); sc.nextLine();
                    b.updateBookPrice(updateCode, newPrice);
                    break;
                
                case 5:
                    int maxPriceIndex = b.findMaxPrice();
                    if (maxPriceIndex != -1) {
                        System.out.println(b.t.get(maxPriceIndex).code + ", " + b.t.get(maxPriceIndex).title + ", " + b.t.get(maxPriceIndex).qua + ", " + b.t.get(maxPriceIndex).price);
                    } else {
                        System.out.println("Not found.");
                    }
                    break;
                
                case 6:
                    b.sortAscendingByCode();
                    b.displayAllBooks();
                    break;
                    
                case 7:
                    System.out.print("Enter code: ");
                    String removeCode = sc.nextLine();
                    b.removeBook(removeCode);
                    break;
                
                case 8:
 
                case 0:
                    System.out.println("Exiting..");
                    break;
                
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while(choice != 0);
    }
}
