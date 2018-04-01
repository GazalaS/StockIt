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
 * Prints messages and formatted data on the console.
 * @author "GazalaS <gazalafshaikh@gmail.com>"
 */
public class PrintOutput {
    
    /**
     * Prints Welcome Message when application is loaded.
     * @param countRunningLow the count of <code>{@link GroceryItem}</code>  with the status as {@link ItemStatus.NEED_TO_BUY} 
     *                        the count is 0 when no <code>{@link GroceryItem}</code> in Grocery list with status Running Low  
     * @param countNeedToBuy the count of <code>{@link GroceryItem}</code>  with the status as {@link ItemStatus.NEED_TO_BUY}. 
     *                       the count is 0 when no <code>{@link GroceryItem}</code> in Grocery list with status {@link ItemStatus.NEED_TO_BUY}
     */
    public void printWelcomeMessage(int countRunningLow, int countNeedToBuy) {
        System.out.println("***********************");
        System.out.println("* Welcome to Stock It *");
        System.out.println("***********************");
        System.out.format("* %d items " + ItemStatus.RUNNING_LOW.toString() + " *\n", countRunningLow);
        System.out.format("* %d items " + ItemStatus.NEED_TO_BUY.toString() + " *\n", countNeedToBuy);
        System.out.println("***********************");
    }

    /**
     * Prints Menu with options to choose and a prompt.
     */
    public void printMenu() {
        System.out.println();
        System.out.println("~~~~~~~~ Pick an Option ~~~~~~~~");
        System.out.println("1. Show Grocery List by Status");
        System.out.println("2. Add a Grocery Item");
        System.out.println("3. Edit a Grocery Item");
        System.out.println("4. Remove a Grocery Item");
        System.out.println("5. Show Grocery List for Today");
        System.out.println("6. Save and Quit");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print(">> ");     // print prompt
    }

    /**
     * Prints the message and terminates the current line by writing the line separator string.
     * @param message <code>Message</code> to be displayed
     */
    public void printlnMessage(String message) {
        System.out.println(message);
    }
    
    /**
     * Prints the message.
     * This is used with the input message details.
     * @param message <code>Message</code> to be displayed
     */
    public void printMessage(String message) {
        System.out.print(message);
    }
    
    /**
     * Print the list of <code>{@link GroceryItemDTO}</code>.
     * Depending on the operation the <code>{@link #formatStringOutput(integration.GroceryItemDTO, String) }</code> method
     * will format the details to display
     * @param groceryListDTO List of <code>{@link GroceryItemDTO}</code> to display
     * @param operation  depending on the Operation the details will be added to the String 
     */
    public void printList(ArrayList<GroceryItemDTO> groceryListDTO, String operation) {
        groceryListDTO.stream()
                .forEach((item) -> {
                    System.out.printf(formatStringOutput(item, operation) + "\n");
                });
        System.out.println();
    }
    
    /**
     * Depending on the operation the method will format the details to display
     * @param item <code>{@link GroceryItemDTO}</code> to display
     * @param operation depending on the Operation the details will be added to the String
     *                  if operation is <code>listAll</code> it will display all the details of the <code>Item</code>.
     *                  if operation is <code>listByStatus</code> it will display all the details of the <code>Item</code> except <code>Item Status</code>.
     *                  if operation is <code>listByDate</code> it will display all <code>Item Name</code>, <code>Item Quantity</code> and <code>Item Status</code>.    
     * @return 
     */
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
