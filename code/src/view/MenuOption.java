/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class MenuOption {
    
    public void printMenu(){
        
        System.out.println();
        System.out.println("~~~~~~~ Pick an Option ~~~~~~");
        System.out.println("1. Show Grocery List by Status");
        System.out.println("2. Add an Grocery Item");
        System.out.println("3. Edit an Grocery Item");
        System.out.println("4. Remove an Grocery Item");
        System.out.println("5. Save and Quit");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print(">> ");     // print prompt
    }
    
}