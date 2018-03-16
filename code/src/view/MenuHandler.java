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
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class MenuHandler {
    
    private Scanner reader;
    private GroceryListController objGroceryListController;
    
    public MenuHandler(GroceryListController objGroceryListController) {
        reader = new Scanner(System.in);
        this.objGroceryListController = objGroceryListController;
    }
    
    public void processMenu() throws ParseException{
        MenuOption objMenu = new MenuOption();
        WelcomeMessage objWelcomeMessage = new WelcomeMessage();
        
        objGroceryListController.readFromFile();
        
        int countRunningLow =  getCount("Running Low");
        int countNeedToBuy =  getCount("Need to Buy");
        objWelcomeMessage.printWelcomeMessage(countRunningLow, countNeedToBuy);
               
        while(true){
            
            objMenu.printMenu();
            int choice = reader.nextInt();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            reader.nextLine();
            
            switch(choice){
                    case 1:  showGroceryListByStatus();
                             break;
                    case 2:  objGroceryListController.addItemtoGroceryList(createGroceryItem("add","Running Low/Need to Buy"));
                             System.out.println("Item Added.");
                             break;
                    case 3:  showGroceryList();
                             objGroceryListController.editItemInGroceryList(createGroceryItem("edit","Running Low/Need to Buy/Brought"));
                             System.out.println("Item Edited.");
                             break;
                    case 4:  showGroceryList();
                             objGroceryListController.removeItemFromGroceryList(removeItemFromGroceryList());
                             System.out.println("Item Removed.");
                             break;
                    case 5:  showGroceryListByDate(); 
                             System.out.println("\nHave a nice day !!");
                             //This will Exit the program
                             System.exit(0);
                             break;
                    default: System.out.println("Wrong Choice. Pick option 1-5.");
                             break;
                }
        }   
    }
        
    private int getCount(String status){  
        ArrayList<GroceryItemDTO> groceryListByStatusDTO = objGroceryListController.getGroceryListByStatus(status);
        if (!groceryListByStatusDTO.isEmpty()){
            return groceryListByStatusDTO.size();
        }            
        return 0;
    } 

    private int removeItemFromGroceryList(){
        System.out.print("\nEnter Item Number to Remove: ");
        int itemIndex = reader.nextInt();
        return itemIndex;
    }
    
    private GroceryItemDTO createGroceryItem(String operation, String statusInputMessage){
        String itemName;
        String quantity;
        Date purchaseByDate = new Date();
        String category;
        String status;
        int itemIndex = 0;
         
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
        System.out.print("Enter Purchase By Date(dd-MMM-yyyy): ");
        try {
            purchaseByDate = formatter.parse(reader.nextLine());
        } catch (ParseException ex) {
            System.out.println("Please enter date in format (16-March-2018)");
        }
        System.out.print("Enter Item Category (Edible/Inedible): ");
        category = reader.nextLine();
        System.out.print("Enter Item Status (" + statusInputMessage +"): ");
        status = reader.nextLine();
        GroceryItemDTO objGroceryItemDTO = new GroceryItemDTO(itemIndex,itemName,quantity, purchaseByDate, category, status);
        return objGroceryItemDTO;
    }
    
    private void showGroceryList(){
        ArrayList<GroceryItemDTO> groceryListByStatusDTO = objGroceryListController.getGroceryList();
        groceryListByStatusDTO.stream()
                    .forEach((item) -> {System.out.printf(item.getGroceryItemAllDetails());});
    
    }
    
    private void showGroceryListByStatus(){
        
        boolean isRunningLowEmpty = printGroceryListByStatus("Running Low");
        boolean isNeedToBuyEmpty = printGroceryListByStatus("Need to Buy");
        boolean isBroughtEmpty = printGroceryListByStatus("Brought");

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
    
    private boolean printGroceryListByStatus(String status){
        boolean isGroceryListEmpty = true;
        ArrayList<GroceryItemDTO> groceryListByStatusDTO = objGroceryListController.getGroceryListByStatus(status);
 
        if (!groceryListByStatusDTO.isEmpty()){
            printMessage(status);
            groceryListByStatusDTO.stream()
                    .forEach((item) -> {System.out.printf(item.getGroceryItemNoStatus());});
            isGroceryListEmpty = false;
        }
        return isGroceryListEmpty;
    }
    
    private void showGroceryListByDate() throws ParseException {
            LocalDate localDate = LocalDate.now();
            String strTodaysDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(localDate);
            ArrayList<GroceryItemDTO> groceryListByDateDTO = objGroceryListController.getGroceryListByDate(strTodaysDate);
            if (!groceryListByDateDTO.isEmpty()){
                printMessage("List for Today: " + strTodaysDate );
                groceryListByDateDTO.stream()
                    .forEach((item) -> {System.out.printf(item.getGroceryItemBriefDetails());}); 
        }
    }
    
    private void printMessage(String message){
        System.out.println("\n" + message + ": "  );
    }
    
}
