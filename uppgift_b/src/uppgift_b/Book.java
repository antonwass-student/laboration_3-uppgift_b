/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift_b;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a book.
 * 
 * @author anton
 */
public class Book implements Comparable<Book>, Serializable {
    
    private String title;
    private String isbn;
    private int edition;
    private double price;
    
    private ArrayList<Author> authors;
    
    public Book(String title, String isbn, int edition, double price){
        this.title = title;
        this.isbn = isbn;
        this.edition = edition;
        this.price = price;
        
        this.authors = new ArrayList();
    }
    
    public void addAuthor(Author author){
        authors.add(author);
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
    public int compareTo(Book other){
        if(other instanceof Book)
        {
            Book temp = (Book) other;
            return title.compareToIgnoreCase(temp.title);
        }
        else
            return 0;
    }

}
