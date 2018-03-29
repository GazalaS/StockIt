/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import integration.GroceryItemDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import integration.ItemStatus;

/**
 *
 * @author "GazalaS <gazalafshaikh@gmail.com>"
 */
public class PrintOutput {

    public void printWelcomeMessage(int countRunningLow, int countNeedToBuy) {
        System.out.println("***********************");
        System.out.println("* Welcome to Stock It *");
        System.out.println("***********************");
        System.out.format("* %d items " + ItemStatus.RUNNING_LOW.toString() + " *\n", countRunningLow);
        System.out.format("* %d items " + ItemStatus.NEED_TO_BUY.toString() + " *\n", countNeedToBuy);
        System.out.println("***********************");
    }

    public void printMenu() {
        System.out.println();
        System.out.println("~~~~~~~~ Pick an Option ~~~~~~~~");
        System.out.println("1. Show Grocery List by Status");
        System.out.println("2. Add an Grocery Item");
        System.out.println("3. Edit an Grocery Item");
        System.out.println("4. Remove an Grocery Item");
        System.out.println("5. Show Grocery List for Today");
        System.out.println("6. Save and Quit");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print(">> ");     // print prompt
    }

    public void printlnMessage(String message) {
        System.out.println(message);
    }
    
    public void printMessage(String message) {
        System.out.print(message);
    }
    
    public void printList(ArrayList<GroceryItemDTO> groceryListDTO, String operation) {
        groceryListDTO.stream()
                .forEach((item) -> {
                    System.out.printf(formatStringOutput(item, operation) + "\n");
                });
        System.out.println();
    }

    public String formatStringOutput(GroceryItemDTO item, String operation) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder stringBuilder = new StringBuilder();
        if (operation.equals("listByDate") || operation.equals("listByStatus") || operation.equals("listAll")) {
            stringBuilder.append(String.format("%-5s ", Integer.toString(item.getItemIndex()) + ". "));
            stringBuilder.append(String.format("%-20s ", item.getItemName()));
            stringBuilder.append(String.format("%-20s ", item.getQuantity()));
        }
        if (operation.equals("listByStatus") || operation.equals("listAll")) {
            stringBuilder.append(String.format("%-20s ", formatter.format(item.getPurchaseByDate())));
            stringBuilder.append(String.format("%-20s ", item.getCategory()));
        }
        if (operation.equals("listByDate") || operation.equals("listAll")) {
            stringBuilder.append(String.format("%-20s ", item.getStatus()));
        }
        return stringBuilder.toString();
    }
}
