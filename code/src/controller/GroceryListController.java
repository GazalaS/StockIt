/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import view.*;
import model.*;
import integration.GroceryItemDTO;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class GroceryListController {
    
    GroceryList objGroceryList;
    WelcomeMessage objWelcomeMessage;
    MenuHandler objMenuHandler;
    
    public GroceryListController(){
        objGroceryList = new GroceryList();
        objMenuHandler = new MenuHandler();
        objWelcomeMessage=  new WelcomeMessage();
    }
            
    public void displayWelcomeMessage(){         
        objWelcomeMessage.printWelcomeMessage();
    }
    
    public void displayMenu(){       
        objMenuHandler.processMenu();
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
    
    public boolean printGroceryListByStatus(String status)
    {
        boolean isEmpty = true;               
        if (!objGroceryList.getGroceryListByStatus(status).isEmpty()){
            objMenuHandler.printMessage(status);
            objGroceryList.getGroceryListByStatus(status).stream()
                    .forEach((item) -> {objMenuHandler.printEachItem((objGroceryList.getGroceryList().indexOf(item) + 1) + ". " + item.printGroceryItemDetails());});
            isEmpty = false;
        }
        return isEmpty;    
    }
    
    public void printGroceryListByDate(String purchaseByDate)
    {           
        try {        
            if (!objGroceryList.getGroceryListByDate(purchaseByDate).isEmpty()){
                objMenuHandler.printMessage("Grocery Status:");
                objGroceryList.getGroceryListByDate(purchaseByDate).stream()
                        .forEach((item) -> {objMenuHandler.printEachItem((objGroceryList.getGroceryList().indexOf(item) + 1) + ". " + item.printGroceryItem());});
            }   
        } catch (ParseException ex) {
            Logger.getLogger(GroceryListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        
}
