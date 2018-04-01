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
import java.text.ParseException;

/**
 * Prompts User to enter Input and validates the data entered 
 * @author "GazalaS gazalafshaikh@gmail.com"
 */
public class UserInput {

    private final PrintOutput objPrintOutput;
    private final Scanner reader;

   /**
     * This constructor Instantiates a new <code>{@link UserInput}</code>.
     * and creates <code>{@link PrintOutput}</code> object and <code>{@link controller.GroceryListController}</code>
     * @param reader Reference to the <code>{@link Scanner}</code> class created in <code>{@link startup.Main}</code>.
     */
    public UserInput(Scanner reader) {
        objPrintOutput = new PrintOutput();
        this.reader = reader;
    }

    /**
     * This method reads the users choice from the Menu option.
     * If choice is valid it returns the choice to <code>{@link MenuHandler#processMenu()}</code>
     * Loops till the choice is valid option between 1-6.
     * @return the valid choice.
     */
    public int askChoice() {
        int choice = 0;
        boolean validChoice = false;
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
   
    /**
     * Validates the choice entered by the User
     * @param choice the choice to validate entered by User
     * @return true if the choice is greater than 0
     *         false if the choice is lesser than 0
     */
    private boolean isValidChoice(int choice) {
        if (choice < 0) {
            objPrintOutput.printlnMessage("Choose option between 1-6");
            objPrintOutput.printlnMessage("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            objPrintOutput.printMessage(">>");
            return false;
        }
        return true;
    }
    
    /**
     * This method reads the Item Name entered by the User.
     * Loops till the User enter Item Name as all Alphabets space is allowed between words.
     * @return the valid Item Name
     */
    public String askItemName() {
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

    /**
     * Validates the Item Name entered by the User
     * @param itemName the item name to validate entered by the User
     * @return true if the Item Name contains all alphabets. 
     *              Space is allowed between words
     *         false if the Item Name is empty or space or numbers or aplha numeric
     */
    private boolean isValidItemName(String itemName) {
        if (itemName == null || itemName.trim().isEmpty()) {
            objPrintOutput.printlnMessage("Item Name cannot be empty. Please enter Item Name.");
            return false;
        } else if (!itemName.matches("^[ A-Za-z]+$")) {
            objPrintOutput.printlnMessage("Item Name can contain only Alphabets");
            return false;
        }
        return true;
    }
    
    /**
     * This method reads the Item Quantity entered by the User.
     * Loops till the User enter Item Quantity as number. 
     * Alphabets are allowed after number in case the user has to enter measuring unit.
     * @return the valid Item Quantity
     */
    public String askItemQuantity() {
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
    
    /**
     * Validates the Item Quantity entered by the User
     * @param quantity the item quantity to validate entered by the User
     * @return true if the Item Quantity contains number. 
     *              words are allowed after number for entering measuring unit
     *         false if the Item Quantity is empty or space or only  alphabets or start with alphabets
     */
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
    
    /**
     * This method reads the Item Purchase By Date entered by the User.
     * Loops till the User enters a Valid date with correct format(dd-mm-yyyy). 
     * @return the valid Purchase By Date
     * @throws ParseException if failed to parse the date
     */
    public String askPurchaseByDate() throws ParseException {
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
    
    /**
     * Validates the Item Purchase By Date entered by the User
     * @param purchaseByDate the item purchase by Date to validate entered by the User
     * @return true if the Item purchase by Date is a Valid date with correct format(dd-mm-yyyy)
     *         false if the Item purchase by Date is empty or Invalid Date or incorrect format or a past Date
     */
    private boolean isValidPurchaseDate(String purchaseByDate) throws ParseException {
        DateValidator dateValidator = new DateValidator();       
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date localDate = formatter.parse(formatter.format(new Date()));
        
        if (purchaseByDate == null || purchaseByDate.trim().isEmpty()) {
            objPrintOutput.printlnMessage("Purchase By Date cannot be empty. Please enter Purchase By Date.");
            return false;
        } else if (!dateValidator.validate(purchaseByDate)) {
            objPrintOutput.printlnMessage("Invalid Date. Purchase By Date Format dd-mm-yyyy");
            return false;
        } else if ((formatter.parse(purchaseByDate).compareTo(localDate) < 0)) {
            objPrintOutput.printlnMessage("Purchase By Date can not be a past Date");
            return false;
        }
        return true;
    }
    
    /**
     * This method reads and validates Item Category by the User.
     * Loops till the User enters a Valid category. 
     * @return the valid Item Category
     */
    public String askItemCategory() {
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
                        objPrintOutput.printMessage("Please select (1." + ItemCategory.EDIBLE.toString() + " 2." + ItemCategory.INEDIBLE.toString() + "): ");
                        reader.next();
                        validItemCategory = false;
                        break;
                }
            } else {
                objPrintOutput.printMessage("Please select (1." + ItemCategory.EDIBLE.toString() + " 2." + ItemCategory.INEDIBLE.toString() + "): ");
                reader.next();
                validItemCategory = false;
            }
        } while (!validItemCategory);
        return itemCategory;
    }
    
    /**
     * This method reads and validates Item Status by the User.
     * Loops till the User enters a Valid Status. 
     * @param statusInputMessage Message to display when asking input from User
     * @return the valid Item Status
     */
    public String askItemStatus(String statusInputMessage) {
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
                        validItemStatus = false;
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
    
    /**
     * This method reads the Item Index entered by the User to Edit or Remove.
     * Loops till the User enter Item Index as number. 
     * @param numberOfItems size of the grocery list
     * @param operation edit or remove the item
     * @return the valid Item Index
     */
    public int askItemIndex(int numberOfItems, String operation) {
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
    
    /**
     * Validates the Item Index  entered by the User
     * @param quantity the item quantity to validate entered by the User
     * @param itemIndex index at which the specified Item is to be updated or removed 
     * @param numberOfItems size of the grocery list
     * @return true if the Item Index contains number. 
     *         false if the Item Index is empty or zero or negative value or more than the size of the grocery list
     */
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
}
