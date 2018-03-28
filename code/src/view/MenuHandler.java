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
import java.util.ArrayList;
import java.util.Date;
import integration.ItemStatus;

/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class MenuHandler {

    private Scanner reader;
    private GroceryListController objGroceryListController;
    private PrintOutput objPrintOutput;
    private UserInput objUserInput;
    private ListView objListView;

    public MenuHandler(GroceryListController objGroceryListController) {
        reader = new Scanner(System.in);
        this.objGroceryListController = objGroceryListController;
        objPrintOutput = new PrintOutput();
        objUserInput = new UserInput();
        objListView = new ListView(objGroceryListController);
    }

    public void processMenu() throws ParseException, IOException, ClassNotFoundException {
        objGroceryListController.readFromFile();

        int countRunningLow = getCount(ItemStatus.RUNNING_LOW.toString());
        int countNeedToBuy = getCount(ItemStatus.NEED_TO_BUY.toString());

        objPrintOutput.printWelcomeMessage(countRunningLow, countNeedToBuy);

        while (true) {
            try {
                //objPrintOutput.printMessage("\nPress Enter for Menu.");
                //reader.nextLine();
                objPrintOutput.printMenu();
                int choice = reader.nextInt();
                objPrintOutput.printMessage("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                reader.nextLine();

                String statusInputMessage;
                switch (choice) {
                    case 1:
                        objListView.showGroceryListByStatus();
                        break;
                    case 2:
                        statusInputMessage = "1." + ItemStatus.RUNNING_LOW.toString() + " 2." + ItemStatus.NEED_TO_BUY.toString();
                        objGroceryListController.addItemtoGroceryList(createGroceryItemDTO("add", statusInputMessage));
                        objPrintOutput.printMessage("Item Added.");
                        break;
                    case 3:
                        statusInputMessage = "1." + ItemStatus.RUNNING_LOW.toString() + " 2." + ItemStatus.NEED_TO_BUY.toString() + " 3." + ItemStatus.BROUGHT.toString();
                        objGroceryListController.editItemInGroceryList(createGroceryItemDTO("edit", statusInputMessage));
                        objPrintOutput.printMessage("Item Edited.");
                        break;
                    case 4:
                        objGroceryListController.removeItemFromGroceryList(removeItemFromGroceryList());
                        objPrintOutput.printMessage("Item Removed.");
                        break;
                    case 5:
                        objListView.showGroceryListByDate();
                        break;
                    case 6:
                        objGroceryListController.saveToFile();
                        objPrintOutput.printMessage("Have a nice day !!\n");
                        //This will Exit the program
                        System.exit(0);
                        break;
                    default:
                        objPrintOutput.printMessage("Wrong Choice. Pick option 1-5.");
                        break;
                }
            } catch (EmptyListException ex) {
                objPrintOutput.printMessage(ex.getMessage());
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

    private int removeItemFromGroceryList() throws EmptyListException {
        int itemIndex = 0;
        int numberOfItems = objGroceryListController.getGroceryList().size();
        if (numberOfItems > 0) {
            objListView.showGroceryList();
            itemIndex = objUserInput.askItemIndexToRemove(reader, numberOfItems);
        } else {
            throw new EmptyListException("No Items to Remove.\nPlease select Option 2 to Add Items");
        }
        return itemIndex;
    }

    private GroceryItemDTO createGroceryItemDTO(String operation, String statusInputMessage) throws ParseException, EmptyListException {
        int itemIndex = 0;
        if (operation.equals("edit")) {
            int numberOfItems = objGroceryListController.getGroceryList().size();
            if (numberOfItems > 0) {
                objListView.showGroceryList();
                itemIndex = objUserInput.askItemIndexToEdit(reader, numberOfItems);
            } else {
                throw new EmptyListException("No Items to Edit.\nPlease select Option 2 to Add Items");
            }
        }

        String itemName;
        String quantity;
        Date purchaseByDate;
        String category = "";
        String status = "";

        itemName = objUserInput.askItemName(reader);
        quantity = objUserInput.askItemQuantity(reader);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        purchaseByDate = formatter.parse(objUserInput.askPurchaseByDate(reader));
        category = objUserInput.askItemCategory(reader);
        status = objUserInput.askItemStatus(reader, statusInputMessage);

        GroceryItemDTO objGroceryItemDTO = new GroceryItemDTO(itemIndex, itemName, quantity, purchaseByDate, category, status);
        return objGroceryItemDTO;
    }
}
