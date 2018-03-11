/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import integration.GroceryItemDTO;
import java.util.Scanner;
import controller.GroceryListController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.time.format.DateTimeFormatter;
/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class MenuHandler {
    
    private Scanner reader;
    
    public MenuHandler(){
        reader = new Scanner(System.in);
    }
    
    public void processMenu(){
        Menu objMenu = new Menu();
        WelcomeMessage objWelcomeMessage = new WelcomeMessage();
        GroceryListController objGroceryListController = new GroceryListController();
        objWelcomeMessage.printWelcomeMessage();
        while(true){  
            objMenu.printMenu();
            int choice = reader.nextInt();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            reader.nextLine();
            
            switch(choice){
                    case 1: printGroceryList(objGroceryListController);
                            break;
                    case 2:  objGroceryListController.addItemtoGroceryList(createGroceryItemDTO("add","Running Low/Need to Buy"));
                             System.out.println("Item Added.");
                             break;
                    case 3:  objGroceryListController.editItemInGroceryList(createGroceryItemDTO("edit","Running Low/Need to Buy/Brought"));
                             System.out.println("Item Edited.");
                             break;
                    case 4:  objGroceryListController.removeItemFromGroceryList(removeItemFromGroceryList());
                             System.out.println("Item Removed.");
                             break;
                    case 5:  printGroceryListByDate(objGroceryListController); 
                             System.out.println("\nHave a nice day !!");
                             //This will Exit the program
                             System.exit(0);
                             break;
                    default: System.out.println("Wrong Choice. Pick option 1-5.");
                             break;
                }
        }   
    }
        
    public int removeItemFromGroceryList(){
        System.out.print("\nEnter Item Number to Remove: ");
        int itemIndex = reader.nextInt();
        return itemIndex;
    }
    
    private GroceryItemDTO createGroceryItemDTO(String operation, String statusInputMessage){
        String itemName;
        String quantity;
        Date purchaseByDate = new Date();
        String category;
        String status;
        int itemIndex = 0;
        GroceryItemDTO objGroceryItemDTO;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        if (operation.equals("edit")){
            System.out.print("\nEnter Item Number to Edit: ");  
            itemIndex = reader.nextInt();
            reader.nextLine();
        }   
        System.out.print("\nEnter Item Name: ");
        itemName = reader.nextLine();
        System.out.print("Enter Item Quantity: ");
        quantity = reader.nextLine();
        System.out.print("Enter Purchase By Date: ");
        try {
            purchaseByDate = formatter.parse(reader.nextLine());
        } catch (ParseException ex) {
            Logger.getLogger(MenuHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("Enter Item Category (Edible/Inedible): ");
        category = reader.nextLine();
        System.out.print("Enter Item Status (" + statusInputMessage +"): ");
        status = reader.nextLine();
        objGroceryItemDTO = new GroceryItemDTO(itemName,quantity, purchaseByDate, category, status, itemIndex);
        return objGroceryItemDTO;
    }
    
    private void printGroceryList(GroceryListController objGroceryListController){
        
        boolean isRunningLowEmpty = objGroceryListController.printGroceryListByStatus("Running Low");
        boolean isNeedToBuyEmpty = objGroceryListController.printGroceryListByStatus("Need to Buy");
        boolean isBroughtEmpty = objGroceryListController.printGroceryListByStatus("Brought");
        
        if (isRunningLowEmpty && isNeedToBuyEmpty && isBroughtEmpty) {
            System.out.println("\nGrocery List is empty. \nPlease select Option 2 to add Items");
        }
         else {
            if (isRunningLowEmpty){
                System.out.println("\nNo Items with status: Running Low.");
            } 
            if (isNeedToBuyEmpty){
                System.out.println("\nNo Items with status: Need to Buy.");  
            }  
            if (isBroughtEmpty){
                System.out.println("\nNo Items with status: Brought."); 
            } 
        }
    }
    
    public void printEachItem(String groceryitem){        
        System.out.println(groceryitem);
    }
    
    public void printMessage(String message){
        System.out.println("\n" + message + ": "  );
    }
    
    public void printGroceryListByDate(GroceryListController objGroceryListController){
        LocalDate localDate = LocalDate.now();
        objGroceryListController.printGroceryListByDate(DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(localDate));
    }
}
