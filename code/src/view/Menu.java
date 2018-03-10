/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GroceryListController;
import java.util.Scanner;
import integration.GroceryItemDTO;

/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class Menu {
    
    private Scanner reader;
    private MenuHandler objMenuHandler;
    
    /**
     * Create a Menu to read from the terminal window.
     */
    public Menu() 
    {
        reader = new Scanner(System.in);
        objMenuHandler = new MenuHandler();
        
    }
    public void printMenu(){
        GroceryItemDTO objGroceryItemDTO = new GroceryItemDTO();
        GroceryListController objGroceryListController = new GroceryListController();
        int choice;   
        do{
            System.out.println();
            System.out.println("Pick an Option:");
            System.out.println("1. Show Grocery List");
            System.out.println("2. Add an Grocery Item");
            System.out.println("3. Edit an Grocery Item");
            System.out.println("4. Remove an Grocery Item");
            System.out.println("5. Save and Quit");

            System.out.print("> ");     // print prompt
            choice = reader.nextInt();

                switch(choice){
                    case 1: objGroceryListController.printGroceryList();
                            break;
                    case 2:  objGroceryItemDTO = objMenuHandler.addToGroceryList();
                             objGroceryListController.addItemtoGroceryList(objGroceryItemDTO);
                             System.out.println("Item Added. Press Enter.");
                             
                             break;
                    case 3:  objGroceryItemDTO = objMenuHandler.editItemInGroceryList();
                             objGroceryListController.editItemInGroceryList(objGroceryItemDTO);
                             System.out.println("Item Edited.");
                             break;
                    case 4:  objGroceryListController.removeItemFromGroceryList(objMenuHandler.removeItemFromGroceryList());
                             System.out.println("Item Removed.");
                             break;
                    case 5:  System.out.println("Have a nice day !!");
                             //This will Exit the program
                             System.exit(0);
                             break;
                    default: System.out.println("Wrong Choice. Pick option 1-5.");
                             break;
                }
        }while (choice !=5);
    }
}
