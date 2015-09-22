/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift_b;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author anton & fredrik
 */
public class CollectionOfBooks {
    
    private ArrayList<Book> collection;
    
    public CollectionOfBooks(){
        /*
        TODO:
        Load books from a file.
        */
        
        collection = new ArrayList();
    }
    
    /**
     * Adds a book to the collection.
     * @param book the book to be added to the collection.
     */
    public void addBook(Book book){
        collection.add(book);
    }
    
    /**
     * Removes a book from the collection.
     * @param book the book to be removed
     * @return true if the book was removed successfully, false if not.
     */
    public boolean removeBook(Book book){
        return collection.remove(book);
    }
    
    /**
     *  ArrayList of all the books in the collection that contains
     *  the search phrase.
     * 
     * @param title the titlte to search for.
     * @return an ArrayList containing the books that contains the title.
     */
    public ArrayList<Book> getBooksByTitle(String title){
        ArrayList<Book> searchResult = new ArrayList();
        title = title.trim();
        
        for(Book b : collection){
            if(b.getTitle().contains(title)){
                searchResult.add(b);
            }
        }
        
        Collections.sort(searchResult);
        
        return searchResult;
    }
    
    /**
     * Searches for all books with matching ISBN in the collection.
     * 
     * @param isbn the isbn to be searched for
     * @return an ArrayList containing all the matched books. 
     */
    public ArrayList<Book> getBooksByIsbn(String isbn){
        ArrayList<Book> searchResult = new ArrayList();
        isbn = isbn.trim();
        
        for(Book b : collection){
            if(b.getIsbn().equalsIgnoreCase(isbn)){
                searchResult.add(b);
            }
        }
        
        Collections.sort(searchResult);
        
        return searchResult;
    }
    
    /**
     * Searches for books in the collection that are written by an author.
     * 
     * @param author the author of the books to find.
     * @return an ArrayList containing the books with the specified author.
     */
    public ArrayList<Book> getBooksByAuthor(String author){
        ArrayList<Book> searchResult = new ArrayList();
        author = author.trim();
        
        for(Book b : collection){
            ArrayList<Author> authors = b.getAuthors();
            
            for(Author a : authors){
                if(a.getName().contains(author)){
                    searchResult.add(b);
                }
            }
        }
        
        Collections.sort(searchResult);
        
        return searchResult;
    }
    
}
