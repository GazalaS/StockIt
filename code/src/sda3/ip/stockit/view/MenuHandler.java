/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sda3.ip.stockit.view;

import sda3.ip.stockit.integration.GroceryItemDTO;
import java.util.Scanner;
import sda3.ip.stockit.controller.GroceryListController;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import sda3.ip.stockit.integration.ItemStatus;

/**
 * This is an important class of View.
 * It handles processing of Menu Option selected by the User
 * @author GazalaS gazalafshaikh@gmail.com
 */
public class MenuHandler {
    private final Scanner reader;
    private final GroceryListController objGroceryListController;
    private final PrintOutput objPrintOutput;
    private final UserInput objUserInput;
    private final ListView objListView;
    
    /**
     * This constructor Instantiates a new <code>{@link MenuHandler}</code> and creates:
     * <code>{@link Scanner}</code> object 
     * <code>{@link GroceryListController}</code> object
     * <code>{@link PrintOutput}</code> object 
     * <code>{@link UserInput}</code> object
     * <code>{@link ListView}</code> object
     * @param objGroceryListController Reference to the <code>{@link GroceryListController}</code> class 
     *                                 created in <code>{@link startup.Main}</code>.
     */
    public MenuHandler(GroceryListController objGroceryListController) {
        reader = new Scanner(System.in);
        this.objGroceryListController = objGroceryListController;
        objPrintOutput = new PrintOutput();
        objUserInput = new UserInput(reader);
        objListView = new ListView(objGroceryListController);
    }
    
    /**
     * Handles the processing of the Menu Option.
     * It take required action depending on the Choice entered by the User
     * @throws ParseException if failed to Parse the Date
     * @throws IOException if failed to access File
     * @throws ClassNotFoundException if failed to read and write objects
     */
    public void processMenu() throws ParseException, IOException, ClassNotFoundException {
        objGroceryListController.readFromFile();

        int countRunningLow = getCount(ItemStatus.RUNNING_LOW.toString());
        int countNeedToBuy = getCount(ItemStatus.NEED_TO_BUY.toString());

        objPrintOutput.printWelcomeMessage(countRunningLow, countNeedToBuy);

        while (true) {
            try {
                objPrintOutput.printMenu();
                int choice = objUserInput.askChoice();
                
                objPrintOutput.printlnMessage("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                reader.nextLine();

                String statusInputMessage;
                switch (choice) {
                    case 1:
                        objListView.showGroceryListByStatus();
                        break;
                    case 2:
                        statusInputMessage = "1." + ItemStatus.RUNNING_LOW.toString() + " 2." + ItemStatus.NEED_TO_BUY.toString();
                        objGroceryListController.addItemtoGroceryList(createGroceryItemDTO("Add", statusInputMessage));
                        objPrintOutput.printlnMessage("Item Added.");
                        break;
                    case 3:
                        statusInputMessage = "1." + ItemStatus.RUNNING_LOW.toString() + " 2." + ItemStatus.NEED_TO_BUY.toString() + " 3." + ItemStatus.BROUGHT.toString();
                        objGroceryListController.editItemInGroceryList(createGroceryItemDTO("Edit", statusInputMessage));
                        objPrintOutput.printlnMessage("Item Edited.");
                        break;
                    case 4:
                        objGroceryListController.removeItemFromGroceryList(getItemIndex("Remove"));
                        objPrintOutput.printlnMessage("Item Removed.");
                        break;
                    case 5:
                        objListView.showGroceryListByDate();
                        break;
                    case 6:
                        objGroceryListController.saveToFile();
                        objPrintOutput.printlnMessage("Have a nice day !!\n");
                        //This will Exit the program
                        System.exit(0);
                        break;
                    default:
                        objPrintOutput.printlnMessage("Wrong Choice. Pick option 1-5.");
                        break;
                }
            } catch (EmptyListException ex) {
                objPrintOutput.printlnMessage(ex.getMessage());
            }
        }
    }
    
    /**
     * The count of <code>{@link GroceryItemDTO}</code> with the specified status
     * @param status filter the list with item that has the status specified
     * @return the list size if not empty
     *         0 if the list is empty
     */
    private int getCount(String status) {
        ArrayList<GroceryItemDTO> groceryListByStatusDTO = objGroceryListController.getGroceryListDTOByStatus(status);
        if (!groceryListByStatusDTO.isEmpty()) {
            return groceryListByStatusDTO.size();
        }
        return 0;
    }
    
    /**
     * It collects the input from the User and creates an <code>{@link integration.GroceryItemDTO}</code> 
     * to be passed to Model to add or edit an Item. In case of Edit it will also the Item Index.
     * @param operation add or edit an Item
     * @param statusInputMessage Message to display when asking input from User
     * @return objGroceryItemDTO DTO objects that holds the data to be added or updated.
     * @throws ParseException if failed to Parse a Date
     * @throws EmptyListException if the Grocery List is empty and operation is edit.
     */
    private GroceryItemDTO createGroceryItemDTO(String operation, String statusInputMessage) throws ParseException, EmptyListException {
        int itemIndex = 0;
        if (operation.equals("Edit")) {
            itemIndex = getItemIndex(operation);
        }

        String itemName;
        String quantity;
        Date purchaseByDate;
        String category;
        String status;

        itemName = objUserInput.askItemName();
        quantity = objUserInput.askItemQuantity();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        purchaseByDate = formatter.parse(objUserInput.askPurchaseByDate());
        category = objUserInput.askItemCategory();
        status = objUserInput.askItemStatus(statusInputMessage);

        GroceryItemDTO objGroceryItemDTO = new GroceryItemDTO(itemIndex, itemName, quantity, purchaseByDate, category, status);
        return objGroceryItemDTO;
    }
    
    /**
     * It collects the input for Item Index to be edited or removed.
     * @param operation edit or remove
     * @return itemIndex Index at which the specified Item is to be updated or removed 
     * @throws EmptyListException if the Grocery List is empty and operation is edit or remove
     */
    private int getItemIndex(String operation) throws EmptyListException {
        int itemIndex = 0;
        int numberOfItems = objGroceryListController.getGroceryListDTO().size();
        if (numberOfItems > 0) {
            objListView.showGroceryList();
            itemIndex = objUserInput.askItemIndex(numberOfItems, operation);
        } else {
            throw new EmptyListException("No Items to " + operation + ".\nPlease select Option 2 to Add Items.");
        }
        return itemIndex;
    }
}
