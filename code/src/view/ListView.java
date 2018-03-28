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
 *
 * @author "GazalaS <gazalafshaikh@gmail.com>"
 */
public class ListView {

    private GroceryListController objGroceryListController;
    private PrintOutput objPrintOutput;

    public ListView(GroceryListController objGroceryListController) {
        this.objGroceryListController = objGroceryListController;
        objPrintOutput = new PrintOutput();
    }

    public void showGroceryList() throws EmptyListException {
        ArrayList<GroceryItemDTO> groceryListDTO = objGroceryListController.getGroceryList();
        if (!groceryListDTO.isEmpty()) {
            objPrintOutput.printList(groceryListDTO, "listAll");
        } else {
            throw new EmptyListException("Grocery List is empty.\nPlease select Option 2 to Add Items.");
        }
    }

    public void showGroceryListByStatus() throws EmptyListException {
        ArrayList<GroceryItemDTO> listRunningLowItems = getGroceryListByStatus(ItemStatus.RUNNING_LOW.toString());
        ArrayList<GroceryItemDTO> listNeedToBuyItems = getGroceryListByStatus(ItemStatus.NEED_TO_BUY.toString());
        ArrayList<GroceryItemDTO> listBroughtItems = getGroceryListByStatus(ItemStatus.BROUGHT.toString());

        boolean isListRunningLowEmpty = listRunningLowItems.isEmpty();
        boolean isListNeedToBuyEmpty = listNeedToBuyItems.isEmpty();
        boolean isListBroughtEmpty = listBroughtItems.isEmpty();

        if (isListRunningLowEmpty && isListNeedToBuyEmpty && isListBroughtEmpty) {
            throw new EmptyListException("Grocery List is empty.\nPlease select Option 2 to Add Items.");
        } else {
            if (isListRunningLowEmpty) {
                objPrintOutput.printlnMessage("\nNo Items with status: " + ItemStatus.RUNNING_LOW.toString());
            } else {
                objPrintOutput.printlnMessage("\n" + ItemStatus.RUNNING_LOW.toString() + " :");
                objPrintOutput.printList(listRunningLowItems, "listByStatus");
            }
            if (isListNeedToBuyEmpty) {
                objPrintOutput.printlnMessage("\nNo Items with status: " + ItemStatus.NEED_TO_BUY.toString());
            } else {
                objPrintOutput.printlnMessage("\n" + ItemStatus.NEED_TO_BUY.toString() + " :");
                objPrintOutput.printList(listNeedToBuyItems, "listByStatus");
            }
            if (isListBroughtEmpty) {
                objPrintOutput.printlnMessage("\nNo Items with status: " + ItemStatus.BROUGHT.toString());
            } else {
                objPrintOutput.printlnMessage("\n" + ItemStatus.BROUGHT.toString() + " :");
                objPrintOutput.printList(listBroughtItems, "listByStatus");
            }
        }
    }

    private ArrayList<GroceryItemDTO> getGroceryListByStatus(String status) {
        ArrayList<GroceryItemDTO> groceryListByStatusDTO = objGroceryListController.getGroceryListByStatus(status);
        return groceryListByStatusDTO;
    }

    public void showGroceryListByDate() throws ParseException, EmptyListException {
        Date localDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String strTodaysDate = formatter.format(localDate);
        ArrayList<GroceryItemDTO> groceryListByDateDTO = objGroceryListController.getGroceryListByDate(strTodaysDate);
        if (!groceryListByDateDTO.isEmpty()) {
            objPrintOutput.printlnMessage("List for Today: " + strTodaysDate);
            objPrintOutput.printList(groceryListByDateDTO, "listByDate");
        } else {
            throw new EmptyListException("No items with Purchase by Date " + strTodaysDate + ".\n" + "Please select Option 2 to Add Items.");
        }
    }
}
