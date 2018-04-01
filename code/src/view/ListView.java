/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GroceryListController;
import integration.GroceryItemDTO;
import integration.ItemStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Displays the List of <code>{@link GroceryItem}</code>.
 * Entire list, list filtered on status and list filtered on todays date.
 * @author "GazalaS <gazalafshaikh@gmail.com>"
 */
public class ListView {

    private final GroceryListController objGroceryListController;
    private final PrintOutput objPrintOutput;

    /**
     * This constructor Instantiates a new <code>{@link GroceryListController}</code>.
     * and creates <code>{@link PrintOutput}</code> object and <code>{@link GroceryListController}</code>
     * @param objGroceryListController Reference to the <code>{@link GroceryListController}</code> class 
     *                                 created in <code>{@link startup.Main}</code>.
     */
    public ListView(GroceryListController objGroceryListController) {
        this.objGroceryListController = objGroceryListController;
        objPrintOutput = new PrintOutput();
    }
    
    /**
     * Displays the entire Grocery List with all the details.
     * @throws EmptyListException when grocery list is empty 
     */
    public void showGroceryList() throws EmptyListException {
        ArrayList<GroceryItemDTO> groceryListDTO = objGroceryListController.getGroceryListDTO();
        if (!groceryListDTO.isEmpty()) {
            objPrintOutput.printList(groceryListDTO, "listAll");
        } else {
            throw new EmptyListException("Grocery List is empty.\nPlease select Option 2 to Add Items.");
        }
    }
    
    /**
     * Displays the entire Grocery List filtered as per status.
     * If List available for a status it will display list or 
     * displays message if no Items with that particular status.
     * @throws EmptyListException thrown if grocery list is empty with a message that describes what went wrong.
     */
    public void showGroceryListByStatus() throws EmptyListException {
        ArrayList<GroceryItemDTO> listRunningLowItems = getGroceryListDTOByStatus(ItemStatus.RUNNING_LOW.toString());
        ArrayList<GroceryItemDTO> listNeedToBuyItems = getGroceryListDTOByStatus(ItemStatus.NEED_TO_BUY.toString());
        ArrayList<GroceryItemDTO> listBroughtItems = getGroceryListDTOByStatus(ItemStatus.BROUGHT.toString());

        boolean isListRunningLowEmpty = listRunningLowItems.isEmpty();
        boolean isListNeedToBuyEmpty = listNeedToBuyItems.isEmpty();
        boolean isListBroughtEmpty = listBroughtItems.isEmpty();

        if (isListRunningLowEmpty && isListNeedToBuyEmpty && isListBroughtEmpty) {
            throw new EmptyListException("Grocery List is empty.\nPlease select Option 2 to Add Items.");
        } else {
            if (isListRunningLowEmpty) {
                objPrintOutput.printlnMessage("No Items with status: " + ItemStatus.RUNNING_LOW.toString());
            } else {
                objPrintOutput.printlnMessage(ItemStatus.RUNNING_LOW.toString() + " :");
                objPrintOutput.printList(listRunningLowItems, "listByStatus");
            }
            if (isListNeedToBuyEmpty) {
                objPrintOutput.printlnMessage("No Items with status: " + ItemStatus.NEED_TO_BUY.toString());
            } else {
                objPrintOutput.printlnMessage(ItemStatus.NEED_TO_BUY.toString() + " :");
                objPrintOutput.printList(listNeedToBuyItems, "listByStatus");
            }
            if (isListBroughtEmpty) {
                objPrintOutput.printlnMessage("No Items with status: " + ItemStatus.BROUGHT.toString());
            } else {
                objPrintOutput.printlnMessage( ItemStatus.BROUGHT.toString() + " :");
                objPrintOutput.printList(listBroughtItems, "listByStatus");
            }
        }
    }
    
    /**
     * This method returns filtered Grocery List as per status.
     * List would contain items who's status matches the specified status  
     * @param status filter the list with item that has the status specified 
     * @return groceryListByStatusDTO filtered ArrayList of <code>{@link GroceryItem}</code> 
     */
    private ArrayList<GroceryItemDTO> getGroceryListDTOByStatus(String status) {
        ArrayList<GroceryItemDTO> groceryListByStatusDTO = objGroceryListController.getGroceryListDTOByStatus(status);
        return groceryListByStatusDTO;
    }
    
    /**
     * Displays the Grocery List filtered for todays Date.
     * If List available for a status it will display list or 
     * displays message if no Items with that particular status.
     * @throws EmptyListException thrown if grocery list is empty with a message that describes what went wrong.
     * @throws ParseException
     */
    public void showGroceryListByDate() throws ParseException, EmptyListException {
        Date localDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String strTodaysDate = formatter.format(localDate);
        ArrayList<GroceryItemDTO> groceryListByDateDTO = objGroceryListController.getGroceryListDTOByDate();
        if (!groceryListByDateDTO.isEmpty()) {
            objPrintOutput.printlnMessage("List for Today: " + strTodaysDate);
            objPrintOutput.printList(groceryListByDateDTO, "listByDate");
        } else {
            throw new EmptyListException("No items with Purchase by Date " + strTodaysDate + ".\n" + "Please select Option 2 to Add Items.");
        }
    }
}
