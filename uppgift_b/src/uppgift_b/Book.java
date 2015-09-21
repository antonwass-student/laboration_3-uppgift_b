/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift_b;

import java.util.ArrayList;

/**
 *
 * @author anton
 */
public class Book implements Comparable {
    
    private String title;
    private String isbn;


    private int edition;
    private double price;
    
    private ArrayList<Author> authors;
    
    public Book(){
    }
    
    public String getIsbn() {
        return isbn;
    }

    public int getEdition() {
        return edition;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }
    
    public String getTitle(){
        return title;
    }
    
    @Override
    public int compareTo(Object other){
        Book temp = (Book) other;
        return title.compareToIgnoreCase(temp.title);
    }

}
