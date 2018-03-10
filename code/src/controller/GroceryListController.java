/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import view.*;
import model.*;
import integration.GroceryItemDTO;
/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class GroceryListController {
    
    GroceryList objGroceryList;
    WelcomeMessage objWelcomeMessage;
    Menu objMenu;
    
    public GroceryListController(){
        objGroceryList = new GroceryList();
        objMenu = new Menu();
        objWelcomeMessage=  new WelcomeMessage();
    }
            
    public void displayWelcomeMessage(){         
        objWelcomeMessage.printWelcomeMessage();
    }
    
    public void displayMenu(){
        
        objMenu.printMenu();
    }
    
    public void addItemtoGroceryList(GroceryItemDTO objGroceryItemDTO){
        objGroceryList.addItemToGroceryList(objGroceryItemDTO);
    }
    
    public void editItemInGroceryList(GroceryItemDTO objGroceryItemDTO){
        objGroceryList.editItemInGroceryList(objGroceryItemDTO);
    }
    
    public void removeItemFromGroceryList(int itemIndex){
        objGroceryList.removeItemFromGroceryList(itemIndex);
    }
    
    public void printGroceryList()
    {
        objGroceryList.printGroceryList();
    }
         
}
