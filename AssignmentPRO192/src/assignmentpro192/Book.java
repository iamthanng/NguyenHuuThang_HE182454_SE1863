package assignmentpro192;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Macbook
 */
public class Book implements Comparable<Book>{
    String code;
    String title;
    int qua;
    double price;

    public Book() {
    }

    public Book(String code, String title, int qua, double price) {
        this.code = code;
        this.title = title;
        this.qua = qua;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQua() {
        return qua;
    }

    public void setQua(int qua) {
        this.qua = qua;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Book o) {
        if(this.getCode().compareToIgnoreCase(o.getCode()) == 0)
            return 0;
        else if(this.getCode().compareToIgnoreCase(o.getCode()) > 0)
            return 1;
        else
            return -1;
    }

}