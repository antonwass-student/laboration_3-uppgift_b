/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift_b;

/**
 * This class contains a string with the name of an author.
 * @author anton & fredrik
 */
public class Author {
    private String name;
    
    public Author(String name){
        this.name = name;
    }
    
    /**
     * Returns the name of the author.
     * @return String
     */
    public String getName(){
        return name;
    }
    
}
