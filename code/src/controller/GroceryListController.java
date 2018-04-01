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
 * This is the applications only controller class. All calls to the Model pass through
 * here. Controller is responsible to handle data flow between model and view.
 *
 * @author GazalaS gazalafshaikh@gmail.com
 */
public class GroceryListController {

    private final GroceryList objGroceryList;
    private final FileHandler objFileHandler;

    /**
     * This constructor Instantiates a new <code>{@link GroceryListController}</code> and creates:
     * <code>{@link GroceryList}</code> object 
     * <code>{@link FileHandler}</code> object
     */
    public GroceryListController() {
        objGroceryList = new GroceryList();
        objFileHandler = new FileHandler();
    }

    /**
     * This method sends a <code>{@link GroceryItem}</code> to
     * <code>Model</code> to add into the <code>{@link GroceryList}</code>. 
     * Creates a <code>{@link}GroceryItem</code> 
     * populates it with the data from <code>{@link GroceryItemDTO}</code> 
     * and passes it to Model to add into the <code>{@link}GroceryList</code>
     * @param objGroceryItemDTO DTO object that holds the data to be added.
     */
    public void addItemtoGroceryList(GroceryItemDTO objGroceryItemDTO) {
        objGroceryList.addGroceryItem(createGroceryItem(objGroceryItemDTO));
    }

    /**
     * This method creates an <code>{@link GroceryItem}</code> from
     * <code>{@link GroceryItemDTO}</code> populates it with the data from
     * <code>{@link GroceryItemDTO}</code>.
     * @param objGroceryItemDTO DTO object that holds the data to be added.
     * @return groceryItem populated <code>{@link GroceryItem}</code> to be added
     *                     in to the <code>{@link GroceryList}</code>
     */
    private GroceryItem createGroceryItem(GroceryItemDTO objGroceryItemDTO) {
        GroceryItem groceryItem = new GroceryItem();
        groceryItem = populateGroceryItem(groceryItem, objGroceryItemDTO);
        return groceryItem;
    }

    /**
     * This method populates a <code>{@link GroceryItem}</code> from
     * <code>{@link GroceryItemDTO}</code> to sent it to Model.
     * @param groceryItem object <code>{@link GroceryItem}</code> in which we
     * need to populate the data
     * @param objGroceryItemDTO DTO object that holds the data to be populated.
     * @return groceryItem populated <code>{@link GroceryItem}</code> to be added
     *                     or updated in to the <code>{@link GroceryList}</code>
     */
    private GroceryItem populateGroceryItem(GroceryItem groceryItem, GroceryItemDTO objGroceryItemDTO) {
        groceryItem.setItemName(objGroceryItemDTO.getItemName());
        groceryItem.setQuantity(objGroceryItemDTO.getQuantity());
        groceryItem.setPurchaseByDate(objGroceryItemDTO.getPurchaseByDate());
        groceryItem.setCategory(objGroceryItemDTO.getCategory());
        groceryItem.setStatus(objGroceryItemDTO.getStatus());
        return groceryItem;
    }

    /**
     * This method passes <code>{@link GroceryItem}</code> object and its Index to 
     * Model to update into <code>{@link GroceryList}</code>.
     * Populates a <code>{@link GroceryItem}</code> from <code>{@link GroceryItemDTO}</code>
     * @param objGroceryItemDTO <code>{@link GroceryItemDTO}</code> object that
     *                          holds the data to edited.
     */
    public void editItemInGroceryList(GroceryItemDTO objGroceryItemDTO) {
        GroceryItem objGroceryItem;
        int itemIndex = objGroceryItemDTO.getItemIndex() - 1;
        objGroceryItem = populateGroceryItem(objGroceryList.getGroceryList().get(itemIndex), objGroceryItemDTO);
        objGroceryList.editGroceryItem(itemIndex, objGroceryItem);
    }

    /**
     * This method passes the item index Model to remove the <code>{@link GroceryItem}</code> from
     * the <code>{@link GroceryList}</code>.
     * @param itemIndex Index of the <code>{@link GroceryItem}</code>  we want to remove from <code>{@link GroceryList}</code> 
     */
    public void removeItemFromGroceryList(int itemIndex) {
        objGroceryList.removeGroceryItem(itemIndex);
    }

    /**
     * This method returns a ArrayList to View 
     * which includes all <code>{@link GroceryItemDTO}</code>.
     * Gets the <code>{@link GroceryList}</code> from the model
     * Populates List of <code>{@link GroceryItemDTO}</code> with <code>{@link GroceryItem}</code>
     * @return groceryListDTO  List of <code>{@link GroceryItemDTO}</code> which includes all items
     */
    public ArrayList<GroceryItemDTO> getGroceryListDTO() {
        ArrayList<GroceryItem> groceryList = objGroceryList.getGroceryList();
        ArrayList<GroceryItemDTO> groceryListDTO = new ArrayList<>();
        populateGroceryListDTO(groceryList, groceryListDTO);
        return groceryListDTO;
    }

    /**
     * This method returns ArrayList to View which includes all <code>{@link GroceryItemDTO}</code>
     * with the specified status.
     * Gets the <code>{@link GroceryList}</code> from the model with the specified status
     * Populates ArrayList of <code>{@link GroceryItemDTO}</code> with <code>{@link GroceryItem}</code>
     * @param status Status on which we need to filter the <code>{@link GroceryList}</code>
     * @return groceryListByStatusDTO filtered List of <code>{@link GroceryItemDTO}</code> for the specified status
     */
    public ArrayList<GroceryItemDTO> getGroceryListDTOByStatus(String status) {
        ArrayList<GroceryItem> groceryListByStatus = objGroceryList.getGroceryListByStatus(status);
        ArrayList<GroceryItemDTO> groceryListByStatusDTO = new ArrayList<>();
        populateGroceryListDTO(groceryListByStatus, groceryListByStatusDTO);
        return groceryListByStatusDTO;
    }

    /**
     * This method returns ArrayList to view which includes all <code>{@link GroceryItemDTO}</code>
     * whose Purchase by Date matches todays date
     * Gets the <code>{@link GroceryList}</code> from the model with the Todays Date
     * Populates ArrayList of <code>{@link GroceryItemDTO}</code> with <code>{@link GroceryItem}</code>
     * @return groceryListByDateDTO filtered ArrayList of <code>{@link GroceryItemDTO}</code> for the specified date
     * @throws ParseException if failed to Parse String into Date
     */
    public ArrayList<GroceryItemDTO> getGroceryListDTOByDate() throws ParseException {
        ArrayList<GroceryItem> groceryListByDate = objGroceryList.getGroceryListByDate();
        ArrayList<GroceryItemDTO> groceryListByDateDTO = new ArrayList<>();
        populateGroceryListDTO(groceryListByDate, groceryListByDateDTO);
        return groceryListByDateDTO;
    }

    /**
     * This method populates ArrayList of <code>{@link GroceryItemDTO}</code> object
     * with ArrayList of <code>{@link GroceryItem}</code> object to sent it to View
     * @param groceryList ArrayList of <code>{@link GroceryItem}</code> object that holds the data
     * @param groceryListDTO ArrayList of <code>{@link GroceryItemDTO}</code> object that needs to populated with data
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
     * When we load the application this method gets ArrayList 
     * of <code>{@link GroceryItemDTO}</code> from  
     * <code>{@link filedata.FileHandler#readFromFile()}</code>.
     * If the ArrayList has data it creates <code>{@link GroceryItem}</code> and passes it to Model to add 
     * <code>{@link GroceryItem}</code> into the <code>{@link model.GroceryList#addGroceryItem(GroceryItem)}</code> 
     * @throws ParseException if failed to Parse String into Date
     * @throws java.io.IOException if failed to Read from File 
     * @throws java.lang.ClassNotFoundException when we read object from file
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
     * Before the application exits this method saves Grocery List into File.
     * Populates list of <code>{@link GroceryItemDTO}</code> from <code>{@link GroceryItem}</code> 
     * Passed the list of <code>{@link GroceryItemDTO}</code> to <code>{@link filedata.FileHandler#saveToFile()}</code>
     * to write on to the File.
     * @throws IOException if failed to write into File
     */
    public void saveToFile() throws IOException {
        ArrayList<GroceryItemDTO> groceryListDTO = new ArrayList<>();
        populateGroceryListDTO(objGroceryList.getGroceryList(), groceryListDTO);
        objFileHandler.saveToFile(groceryListDTO);;
    }
}
