/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import filedata.FileHandler;
import model.GroceryList;
import integration.GroceryItemDTO;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import model.GroceryItem;

/**
 * This is the applications only controller. All calls to the Model pass through
 * here. Controller is responsible to handle data flow between model and view.
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class GroceryListController {

    private GroceryList objGroceryList;
    private FileHandler objFileHandler;

    /**
     * Instantiates a new Controller and creates: <code>{@Link}Grocery List
     * </code> object <code>{@Link}FileHandler </code> object
     */
    public GroceryListController() {
        objGroceryList = new GroceryList();
        objFileHandler = new FileHandler();
    }

    /**
     * Passes DTO object to Model to add a Grocery Item to the Grocery List.
     *
     * @param objGroceryItemDTO DTO object that holds the data to added.
     */
    public void addItemtoGroceryList(GroceryItemDTO objGroceryItemDTO) {
        objGroceryList.addGroceryItem(createGroceryItem(objGroceryItemDTO));
    }

    /**
     * Passes DTO object to Model to edit a Grocery Item to the Grocery List.
     *
     * @param objGroceryItemDTO DTO object that holds the data to edited.
     */
    public void editItemInGroceryList(GroceryItemDTO objGroceryItemDTO) {
        GroceryItem objGroceryItem;
        int itemIndex = objGroceryItemDTO.getItemIndex() - 1;
        objGroceryItem = populateGroceryItem(objGroceryList.getGroceryList().get(itemIndex), objGroceryItemDTO);
        objGroceryList.editGroceryItem(itemIndex, objGroceryItem);
    }

    /**
     * Passes the item index to remove the Grocery Item from the Grocery List.
     *
     * @param itemIndex
     */
    public void removeItemFromGroceryList(int itemIndex) {
        objGroceryList.removeGroceryItem(itemIndex);
    }

    /**
     * Returns a list all Grocery Items in a Grocery List.
     *
     * @return ArrayList<GroceryItemDTO>
     */
    public ArrayList<GroceryItemDTO> getGroceryList() {
        ArrayList<GroceryItem> groceryList = objGroceryList.getGroceryList();
        ArrayList<GroceryItemDTO> groceryListDTO = new ArrayList<>();
        populateGroceryListDTO(groceryList, groceryListDTO);
        return groceryListDTO;
    }

    /**
     *
     * @param status
     * @return groceryListByStatusDTO
     */
    public ArrayList<GroceryItemDTO> getGroceryListByStatus(String status) {
        ArrayList<GroceryItem> groceryListByStatus = objGroceryList.getGroceryListByStatus(status);
        ArrayList<GroceryItemDTO> groceryListByStatusDTO = new ArrayList<>();
        populateGroceryListDTO(groceryListByStatus, groceryListByStatusDTO);
        return groceryListByStatusDTO;
    }

    /**
     * Get Grocery List based on Purchase by Date that matches todays date
     *
     * @param strTodaysDate
     * @return
     * @throws ParseException
     */
    public ArrayList<GroceryItemDTO> getGroceryListByDate(String strTodaysDate) throws ParseException {
        ArrayList<GroceryItem> groceryListByDate = objGroceryList.getGroceryListByDate(strTodaysDate);
        ArrayList<GroceryItemDTO> groceryListByDateDTO = new ArrayList<>();
        populateGroceryListDTO(groceryListByDate, groceryListByDateDTO);
        return groceryListByDateDTO;
    }

    /**
     * Populates the GroceryList object with GroceryListDTO object
     *
     * @param groceryList
     * @param groceryListDTO
     */
    private void populateGroceryListDTO(ArrayList<GroceryItem> groceryList, ArrayList<GroceryItemDTO> groceryListDTO) {
        for (GroceryItem groceryItem : groceryList) {
            GroceryItemDTO groceryItemDTO = new GroceryItemDTO(
                    groceryList.indexOf(groceryItem) + 1,
                    groceryItem.getItemName(),
                    groceryItem.getQuantity(),
                    groceryItem.getPurchaseByDate(),
                    groceryItem.getCategory(),
                    groceryItem.getStatus());
            groceryListDTO.add(groceryItemDTO);
        }
    }

    /**
     * Reads Grocery List from file and populates GroceryListDTO object
     *
     * @throws ParseException
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public void readFromFile() throws ParseException, IOException, ClassNotFoundException {        
      ArrayList<GroceryItemDTO> groceryListFromFile = objFileHandler.readFromFile();
        
        if (!groceryListFromFile.isEmpty()) {
            groceryListFromFile.forEach((groceryItemDTO) -> {
                objGroceryList.addGroceryItem(createGroceryItem(groceryItemDTO));
            });
        }        
    }

    /**
     * Saves Grocery List to file upon exits.
     *
     * @throws IOException
     */
    public void saveToFile() throws IOException {
        ArrayList<GroceryItemDTO> groceryListDTO = new ArrayList<>();
        populateGroceryListDTO(objGroceryList.getGroceryList(), groceryListDTO);
        objFileHandler.saveToFile(groceryListDTO);;
    }

    private GroceryItem createGroceryItem(GroceryItemDTO objGroceryItemDTO) {
        GroceryItem groceryItem = new GroceryItem();
        groceryItem = populateGroceryItem(groceryItem, objGroceryItemDTO);
        return groceryItem;
    }

    private GroceryItem populateGroceryItem(GroceryItem groceryItem, GroceryItemDTO objGroceryItemDTO) {
        groceryItem.setItemName(objGroceryItemDTO.getItemName());
        groceryItem.setQuantity(objGroceryItemDTO.getQuantity());
        groceryItem.setPurchaseByDate(objGroceryItemDTO.getPurchaseByDate());
        groceryItem.setCategory(objGroceryItemDTO.getCategory());
        groceryItem.setStatus(objGroceryItemDTO.getStatus());
        return groceryItem;
    }
}
