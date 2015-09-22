/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift_b;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author anton
 */
public class UserInterface {
    CollectionOfBooks registry;
    Scanner scanner;
    
    public UserInterface()
    {
        registry = new CollectionOfBooks();
        scanner = new Scanner(System.in);
        
        menu();
        
        printBooks(registry.getBooksByAuthor("anton"));
    }
    
    private void menu()
    {
        boolean quit = false;
        
        while(!quit){
            printOptions();
            quit = userSelection();
        }
    }
    
    private void printOptions()
    {
        System.out.println("What would you like to do?");
        System.out.println("  1:\tAdd a book to the registry.");
        System.out.println("  2:\tRemove a book from the registry.");
        System.out.println("  3:\tSearch the registry for books.");
        System.out.println("  10:\tSave registry and quit.");   
    }
    
    private boolean userSelection()
    {
        int option = 0;
        boolean quit = false;
        
        System.out.println("Make a choice: ");
        option = scanner.nextInt();

        switch(option){
            case 1:
                addBook();
                break;
            case 2:
                //Remove book from registry
                break;
            case 3:
                //Search registry
                break;
            case 10:
                quit = true;
                break;
            default:
                System.out.println("Incorrect option.");
                break;
        }
        return quit;
    }
    private void addBook()
    {
        Book book;
        String title, isbn;
        int edition;
        double price;
        Author author;
        
        System.out.println("____________________");
        System.out.println("Adding a new book.");
        
        System.out.print("  Title:");
        scanner.nextLine();
        title = scanner.nextLine();
        
        System.out.print("  Isbn:");
        isbn = scanner.nextLine();
        
        System.out.print("  Edition:");
        edition = (int)scanner.nextInt();
        
        System.out.print("  Price:");
        price = (double)scanner.nextDouble();
        
        System.out.print("  Author:");
        scanner.nextLine();
        author = new Author(scanner.nextLine());
        
        book = new Book(title, isbn, edition, price); 
        book.addAuthor(author);
        
         System.out.println("____________________");
        
        registry.addBook(book);
    }
    
    private void printBooks(ArrayList<Book> books){
        System.out.println("_____________");
        for(int i = 0; i < books.size(); i ++){
            System.out.println((i+1) + ": " + books.get(i).getTitle());
        }

    }
    
}