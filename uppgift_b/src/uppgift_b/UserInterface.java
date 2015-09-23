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
    private CollectionOfBooks registry;
    private Scanner scanner;
    private String booksPath;
    
    public UserInterface()
    {
        registry = new CollectionOfBooks();
        scanner = new Scanner(System.in);
    }
    public void start(String booksPath)
    {
        this.booksPath = booksPath;
        //registry.loadFromFile(booksPath);
        menu();
    }
    
    private void menu()
    {
        boolean quit = false;
        
        while(!quit){
            quit = menuOptions();
        }
    }
    
    private void printMenuOptions()
    {
        System.out.println("---Main menu---");
        System.out.println("  1:\tAdd a book.");
        System.out.println("  2:\tSearch for books.");
        System.out.println("  3:\tShow all books.");
        System.out.println("  10:\tSave registry and quit.");   
    }
    
    private boolean menuOptions()
    {
        int option = 0;
        boolean quit = false;
        
        printMenuOptions();
        
        System.out.println("--------------");
        System.out.print("Make a choice: ");
        option = scanner.nextInt();

        switch(option){
            case 1:
                addBook();
                break;
            case 2:
                searchBooks();
                break;
            case 3:
                printBooks(registry.getCollection());
                break;
            case 10:
                quit = true;
                registry.saveToFile(booksPath);
                break;
            default:
                System.out.println("Incorrect option.");
                break;
        }
        return quit;
    }
    
    private void selectBook(ArrayList<Book> books){
        int choice;
        System.out.println("Enter the number of a book to select it.");
        System.out.println("(0 to return)");
        
        choice = scanner.nextInt();
        if(choice == 0)
            return;
        
        bookOptions(books.get(choice - 1));
        
        
    }
    
    private void bookOptions(Book book){
        int choice;
        System.out.println("--------------------------");
        System.out.println("What would you like to do?");
        System.out.println("1: Remove the book from the registry");
        System.out.println("2: Return");
        
        choice = scanner.nextInt();
        
        switch(choice){
            case 1:
                registry.removeBook(book);
                break;
            case 2:
                break;
            default:
                break;
        }
    }
    
    private void addBook()
    {
        Book book;
        String title, isbn, authorStr = "";
        int edition;
        double price;
        Author author;
        
        System.out.println("------------------");
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
        
        book = new Book(title, isbn, edition, price); 
        
        System.out.println("Authors (type '!' when done.)");
        scanner.nextLine();
        while(!authorStr.contains("!")){

            authorStr = scanner.nextLine();
            if(authorStr.contains("!"))
                break;
            author = new Author(authorStr);
            book.addAuthor(author);
        }
        
        registry.addBook(book);
    }
    
    private void searchBooks(){
        int choice = 0;
        ArrayList<Book> searchResults;
        
        System.out.println("--------------");
        System.out.println("Search book by:");
        System.out.println("  1:\tTitle");
        System.out.println("  2:\tAuthor");
        System.out.println("  3:\tIsbn");
        System.out.println("--------------");
        System.out.println("  4:\tReturn to menu");
        
        choice = scanner.nextInt();
        
        System.out.print("Enter ");
        
        switch(choice){
            case 1:
                System.out.print("title: ");
                scanner.nextLine();
                searchResults = registry.getBooksByTitle(scanner.nextLine());
                printBooks(searchResults);
                break;
            case 2:
                System.out.print("author: ");
                scanner.nextLine();
                searchResults = registry.getBooksByAuthor(scanner.nextLine());
                printBooks(searchResults);
                break;
            case 3:
                System.out.print("isbn: ");
                scanner.nextLine();
                searchResults = registry.getBooksByIsbn(scanner.nextLine());
                printBooks(searchResults);
                break;
            case 4:
                break;
            default:
                searchBooks();
                break; 
        }
        
        
    }
    
    private void printBooks(ArrayList<Book> books){
        System.out.println("---------------");
        System.out.println("Search results:");
        for(int i = 0; i < books.size(); i ++){
            System.out.println("---Book number (" + (i + 1) + ")---" );
            System.out.println("Title: " + books.get(i).getTitle());
            System.out.println("Edition: " + books.get(i).getEdition() + ".");
            System.out.println("Isbn: " + books.get(i).getIsbn() + ".");
            
            System.out.println("Author(s):");
            for(Author a : books.get(i).getAuthors()){
                System.out.println("  " + a.getName());
            }
           
        }
        System.out.println("--------------");
        
        selectBook(books);
    }
    
}