/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import integration.ItemCategory;
import integration.ItemStatus;

/**
 *
 * @author "GazalaS <gazalafshaikh@gmail.com>"
 */
public class UserInput {

    private PrintOutput objPrintOutput;

    public UserInput() {
        objPrintOutput = new PrintOutput();
    }
    
    public int askChoice(Scanner reader){
        int choice = 0;
        boolean validChoice= false;
        do {
            if (reader.hasNextInt()) {
                choice = reader.nextInt();
                validChoice = isValidChoice(choice);
            } else {
                objPrintOutput.printlnMessage("Choose option between 1-6");
                objPrintOutput.printlnMessage("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                objPrintOutput.printMessage(">>");
                reader.next();
                validChoice = false;
            }
        } while (!validChoice);
        return choice;
    }
    
    private boolean isValidChoice(int choice){
        if (choice < 0) {
            objPrintOutput.printlnMessage("Choose option between 1-6");
            objPrintOutput.printlnMessage("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            objPrintOutput.printMessage(">>");
            return false;
        }
        return true;
    }
    
    public String askItemName(Scanner reader) {
        String itemName = "";
        boolean validItemName = false;
        do {
            objPrintOutput.printMessage("Enter Item Name: ");
            if (reader.hasNextLine()) {
                itemName = reader.nextLine();
                validItemName = isValidItemName(itemName);
            }
        } while (!validItemName);
        return itemName;
    }

    private boolean isValidItemName(String itemName) {
        if (itemName == null || itemName.trim().isEmpty()) {
            objPrintOutput.printlnMessage("Item Name cannot be empty. Please enter Item Name.");
            return false;
        } else if (!itemName.matches("[a-zA-Z]+ *[a-zA-Z]*")) {
            objPrintOutput.printlnMessage("Item Name can only contain Alphabets");
            return false;
        }
        return true;
    }

    public String askItemQuantity(Scanner reader) {
        String quantity = "";
        boolean validQuantity = false;
        do {
            objPrintOutput.printMessage("Enter Item Quantity: ");
            if (reader.hasNextLine()) {
                quantity = reader.nextLine();
                validQuantity = isValidQuantity(quantity);
            }
        } while (!validQuantity);
        return quantity;
    }

    private boolean isValidQuantity(String quantity) {
        if (quantity == null || quantity.trim().isEmpty()) {
            objPrintOutput.printlnMessage("Item Quantity cannot be empty. Please enter Item Quantity.");
            return false;
        } else if (!quantity.matches("[1-9][0-9]* *[A-Za-z]*")) {
            objPrintOutput.printlnMessage("Item Quantity must have digit.");
            return false;
        }
        return true;
    }

    public String askPurchaseByDate(Scanner reader) {
        String purchaseByDate = "";
        boolean validPurchaseByDate = false;
        do {
            objPrintOutput.printMessage("Enter Purchase By Date (dd-mm-yyyy): ");
            if (reader.hasNextLine()) {
                purchaseByDate = reader.nextLine();
                validPurchaseByDate = isValidPurchaseDate(purchaseByDate);
            }
        } while (!validPurchaseByDate);
        return purchaseByDate;
    }

    private boolean isValidPurchaseDate(String purchaseByDate) {
        DateValidator dateValidator = new DateValidator();
        Date localDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String strTodaysDate = formatter.format(localDate);
        if (purchaseByDate == null || purchaseByDate.trim().isEmpty()) {
            objPrintOutput.printlnMessage("Purchase By Date cannot be empty. Please enter Purchase By Date.");
            return false;
        } else if (!dateValidator.validate(purchaseByDate)) {
            objPrintOutput.printlnMessage("Invalid Date. Purchase By Date Format dd-mm-yyyy");
            return false;
        } else if ((purchaseByDate.compareTo(strTodaysDate) < 0)) {
            objPrintOutput.printlnMessage("Purchase By Date can not be a past Date");
            return false;
        }
        return true;
    }

    public int askItemIndex(Scanner reader, int numberOfItems, String operation) {
        int itemIndex = 0;
        boolean validItemIndex = false;
        do {
            objPrintOutput.printMessage("Enter Item Number to " + operation + " : ");
            if (reader.hasNextInt()) {
                itemIndex = reader.nextInt();
                validItemIndex = isValidItemIndex(itemIndex, numberOfItems);
            } else {
                objPrintOutput.printlnMessage("Item Number must be a digit");
                reader.next();
                validItemIndex = false;
            }
        } while (!validItemIndex);
        reader.nextLine();
        return itemIndex;
    }

    private boolean isValidItemIndex(int itemIndex, int numberOfItems) {
        if (itemIndex <= 0) {
            objPrintOutput.printlnMessage("Item Number can not be zero or negative value");
            return false;
        }
        if (itemIndex > numberOfItems) {
            if (numberOfItems > 1) {
                objPrintOutput.printlnMessage("Please Enter Item Number between 1 to " + numberOfItems);
                return false;
            } else {
                objPrintOutput.printlnMessage("Please Enter Item Number as " + numberOfItems);
                return false;
            }
        }
        return true;
    }

    public String askItemCategory(Scanner reader) {
        String itemCategory = "";
        boolean validItemCategory = false;
        do {
            objPrintOutput.printMessage("Enter Item Category (1." + ItemCategory.EDIBLE.toString() + " 2." + ItemCategory.INEDIBLE.toString() + "): ");
            if (reader.hasNextInt()) {
                switch (reader.nextInt()) {
                    case 1:
                        itemCategory = ItemCategory.EDIBLE.toString();
                        validItemCategory = true;
                        break;
                    case 2:
                        itemCategory = ItemCategory.INEDIBLE.toString();
                        validItemCategory = true;
                        break;
                    default:
                        objPrintOutput.printMessage("Please select 1." + ItemCategory.EDIBLE.toString() + " 2." + ItemCategory.INEDIBLE.toString() + "): ");
                        reader.next();
                        validItemCategory = false;
                        break;
                }
            } else {
                objPrintOutput.printMessage("Please select 1." + ItemCategory.EDIBLE.toString() + " 2." + ItemCategory.INEDIBLE.toString() + "): ");
                reader.next();
                validItemCategory = false;
            }
        } while (!validItemCategory);
        return itemCategory;
    }

    public String askItemStatus(Scanner reader, String statusInputMessage) {
        String itemStatus = "";
        boolean validItemStatus = false;
        do {
            objPrintOutput.printMessage("Enter Item Status (" + statusInputMessage + "): ");
            if (reader.hasNextInt()) {
                switch (reader.nextInt()) {
                    case 1:
                        itemStatus = ItemStatus.RUNNING_LOW.toString();
                        validItemStatus = true;
                        break;
                    case 2:
                        itemStatus = ItemStatus.NEED_TO_BUY.toString();
                        validItemStatus = true;
                        break;
                    case 3:
                        itemStatus = ItemStatus.BROUGHT.toString();
                        validItemStatus = true;
                        break;
                    default:
                        objPrintOutput.printMessage("Please select (" + statusInputMessage + "): ");
                        break;
                }
            } else {
                objPrintOutput.printMessage("Please select (" + statusInputMessage + "): ");
                reader.next();
                validItemStatus = false;
            }
        } while (!validItemStatus);
        return itemStatus;
    }
}
