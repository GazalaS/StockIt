/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import integration.GroceryItemDTO;
import java.util.Scanner;
import controller.GroceryListController;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import model.ItemCategory;
import model.ItemStatus;

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

    public void processMenu() throws ParseException, IOException, ClassNotFoundException {
        MenuOption objMenu = new MenuOption();
        WelcomeMessage objWelcomeMessage = new WelcomeMessage();

        objGroceryListController.readFromFile();
        int countRunningLow = getCount("Running Low");
        int countNeedToBuy = getCount("Need to Buy");

        objWelcomeMessage.printWelcomeMessage(countRunningLow, countNeedToBuy);

        while (true) {

            objMenu.printMenu();
            int choice = reader.nextInt();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            reader.nextLine();

            switch (choice) {
                case 1:
                    printGroceryListByStatus();
                    break;
                case 2:
                    objGroceryListController.addItemtoGroceryList(createGroceryItem("add", "1.Running Low 2.Need to Buy"));
                    System.out.println("Item Added.");
                    break;
                case 3:
                    printGroceryList();
                    objGroceryListController.editItemInGroceryList(createGroceryItem("edit", "1.Running Low 2.Need to Buy 3.Brought"));
                    System.out.println("Item Edited.");
                    break;
                case 4:
                    printGroceryList();
                    objGroceryListController.removeItemFromGroceryList(removeItemFromGroceryList());
                    System.out.println("Item Removed.");
                    break;
                case 5:
                    printGroceryListByDate();
                    objGroceryListController.saveToFile();

                    System.out.println("\nHave a nice day !!");
                    //This will Exit the program
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Choice. Pick option 1-5.");
                    break;
            }
        }
    }

    private int getCount(String status) {
        ArrayList<GroceryItemDTO> groceryListByStatusDTO = objGroceryListController.getGroceryListByStatus(status);
        if (!groceryListByStatusDTO.isEmpty()) {
            return groceryListByStatusDTO.size();
        }
        return 0;
    }

    private int removeItemFromGroceryList() {
        System.out.print("\nEnter Item Number to Remove: ");
        int itemIndex = reader.nextInt();
        return itemIndex;
    }

    private GroceryItemDTO createGroceryItem(String operation, String statusInputMessage) {
        String itemName;
        String quantity;
        Date purchaseByDate = new Date();
        String category="";
        String status="";
        int itemIndex = 0;

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        if (operation.equals("edit")) {
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
        System.out.print("Enter Item Category (1.Edible 2.Inedible): ");

        switch(reader.nextInt()){
            case 1: 
                category = ItemCategory.EDIBLE.toString();
                break;
            case 2: category = ItemCategory.INEDIBLE.toString();
                break;
        }
            
        System.out.print("Enter Item Status (" + statusInputMessage + "): ");
        switch(reader.nextInt()){
            case 1: 
                status = ItemStatus.RUNNING_LOW.toString();
                break;
            case 2: 
                status = ItemStatus.NEED_TO_BUY.toString();
                break;
            case 3:
                status = ItemStatus.BROUGHT.toString();
                break;
 
        }
        
        GroceryItemDTO objGroceryItemDTO = new GroceryItemDTO(itemIndex, itemName, quantity, purchaseByDate, category, status);
        return objGroceryItemDTO;
    }

    private void printGroceryList() {
        ArrayList<GroceryItemDTO> groceryListByStatusDTO = objGroceryListController.getGroceryList();
        groceryListByStatusDTO.stream()
                .forEach((item) -> {
                    System.out.printf(getGroceryItemAllDetails(item));
                });

    }

    private void printGroceryListByStatus() {
        boolean isRunningLowEmpty = getGroceryListByStatus("Running Low");
        boolean isNeedToBuyEmpty = getGroceryListByStatus("Need to Buy");
        boolean isBroughtEmpty = getGroceryListByStatus("Brought");

        if (isRunningLowEmpty && isNeedToBuyEmpty && isBroughtEmpty) {
            System.out.println("\nGrocery List is empty. \nPlease select Option 2 to add Items");
        } else {
            if (isRunningLowEmpty) {
                System.out.println("\nNo Items with status: Running Low.");
            }
            if (isNeedToBuyEmpty) {
                System.out.println("\nNo Items with status: Need to Buy.");
            }
            if (isBroughtEmpty) {
                System.out.println("\nNo Items with status: Brought.");
            }
        }
    }

    private boolean getGroceryListByStatus(String status) {
        boolean isGroceryListEmpty = true;
        ArrayList<GroceryItemDTO> groceryListByStatusDTO = objGroceryListController.getGroceryListByStatus(status);

        if (!groceryListByStatusDTO.isEmpty()) {
            printMessage(status);
            groceryListByStatusDTO.stream()
                    .forEach((item) -> {
                        System.out.printf(item.getGroceryItemNoStatus());
                    });
            isGroceryListEmpty = false;
        }
        return isGroceryListEmpty;
    }

    private void printGroceryListByDate() throws ParseException {
        LocalDate localDate = LocalDate.now();
        String strTodaysDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(localDate);
        ArrayList<GroceryItemDTO> groceryListByDateDTO = objGroceryListController.getGroceryListByDate(strTodaysDate);
        if (!groceryListByDateDTO.isEmpty()) {
            printMessage("List for Today: " + strTodaysDate);
            groceryListByDateDTO.stream()
                    .forEach((item) -> {
                        System.out.printf(item.getGroceryItemBriefDetails());
                    });
        }
    }

    private void printMessage(String message) {
        System.out.println("\n" + message + ": ");
    }
    
    
    public String getGroceryItemAllDetails(GroceryItemDTO item){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");       
        return (String.format("%-5s",Integer.toString(item.getItemIndex())+ ". " ) + 
                String.format("%-20s",item.getItemName()) +
                String.format("%-20s",item.getQuantity()) + 
                String.format("%-20s",formatter.format(item.getPurchaseByDate())) + 
                String.format("%-20s",item.getCategory()) + 
                String.format("%-20s",item.getStatus()) + "\n");
    } 
}
