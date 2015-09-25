/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift_b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anton & fredrik
 */
public class CollectionOfBooks {

    private ArrayList<Book> collection;

    public CollectionOfBooks() {
        /*
         TODO:
         Load books from a file.
         */

        collection = new ArrayList();
    }

    public void saveToFile(String path) {
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;

        try {
            /*
             if(!file.exists()){
             file.createNewFile();
             }*/
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(collection);

        } catch (Exception e) {
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
            }
        }
    }

    public void loadFromFile(String path) {
        FileInputStream fin = null;
        ObjectInputStream oin = null;

        try {
            fin = new FileInputStream(path);
            oin = new ObjectInputStream(fin);

            Object o = oin.readObject();
            if (o instanceof ArrayList) {
                collection = (ArrayList<Book>) o;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Database not loaded.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oin.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public ArrayList<Book> getCollection() {
        return collection;
    }

    /**
     * Adds a book to the collection.
     *
     * @param book the book to be added to the collection.
     */
    public void addBook(Book book) {
        collection.add(book);
    }

    /**
     * Removes a book from the collection.
     *
     * @param book the book to be removed
     * @return true if the book was removed successfully, false if not.
     */
    public boolean removeBook(Book book) {
        return collection.remove(book);
    }

    /**
     * ArrayList of all the books in the collection that contains the search
     * phrase.
     *
     * @param title the titlte to search for.
     * @return an ArrayList containing the books that contains the title.
     */
    public ArrayList<Book> getBooksByTitle(String title) {
        ArrayList<Book> searchResult = new ArrayList();
        title = title.trim();
        title = title.toLowerCase();

        for (Book b : collection) {
            if (b.getTitle().contains(title)) {
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
    public ArrayList<Book> getBooksByIsbn(String isbn) {
        ArrayList<Book> searchResult = new ArrayList();
        isbn = isbn.trim();

        for (Book b : collection) {
            if (b.getIsbn().equalsIgnoreCase(isbn)) {
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
    public ArrayList<Book> getBooksByAuthor(String author) {
        ArrayList<Book> searchResult = new ArrayList();
        author = author.trim();

        for (Book b : collection) {
            ArrayList<Author> authors = b.getAuthors();

            for (Author a : authors) {
                if (a.getName().contains(author)) {
                    searchResult.add(b);
                }
            }
        }

        Collections.sort(searchResult);

        return searchResult;
    }

}
