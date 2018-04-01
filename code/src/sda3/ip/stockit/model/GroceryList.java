/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sda3.ip.stockit.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Maintains ArrayList of <code>{@link GroceryItem}</code>.
 * Implementation of {<code>{@link IGroceryList} interface</code>
 * Add, edit and remove a <code>{@link GroceryItem}</code>
 * Filter list based on Status and Purchase by date
 * @author GazalaS gazalafshaikh@gmail.com
 */
public class GroceryList implements IGroceryList<GroceryItem> {

    ArrayList<GroceryItem> groceryList;
    
    /**
     * This constructor Instantiates a <code>{@link GroceryList}</code> 
     * and creates an ArrayList <code>{@link GroceryItem}</code> 
     */
    public GroceryList() {
        groceryList = new ArrayList<>();
    }

    /**
     * This methods returns the entire GroceryList
     * @return groceryList ArrayList of <code>{@link GroceryItem}</code>
     */
    @Override
    public ArrayList<GroceryItem> getGroceryList() {
        return groceryList;
    }
    
    /**
     * This method adds <code>{@link GroceryItem}</code> to end of the GroceryList
     * @param objGroceryItem Item to be added into the List
     */
    @Override
    public void addGroceryItem(GroceryItem objGroceryItem) {
        groceryList.add(objGroceryItem);
    }
    
    /**
     * This method updates <code>{@link GroceryItem}</code> to the GroceryList
     * @param itemIndex index at which the specified Item is to be updated 
     * @param objGroceryItem the item to be updated
     */
    @Override
    public void editGroceryItem(int itemIndex, GroceryItem objGroceryItem) {
        groceryList.set(itemIndex, objGroceryItem);
    }
    
    /**
     * This method removes <code>{@link GroceryItem}</code> to the GroceryList
     * @param itemIndex Index location of the Item to be removed
     */
    @Override
    public void removeGroceryItem(int itemIndex) {
        groceryList.remove(itemIndex - 1);
    }
    
    /**
     * This method returns filtered Grocery List as per status.
     * List would contain items who's status matches the specified status  
     * @param status filter the list with item that has the status specified 
     * @return groceryList filtered ArrayList of <code>{@link GroceryItem}</code> 
     */
    @Override
    public ArrayList<GroceryItem> getGroceryListByStatus(String status) {
        return groceryList.stream()
                .filter(item -> status.equals(item.getStatus()))
                .sorted((a, b) -> a.getPurchaseByDate().compareTo(b.getPurchaseByDate()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * This method return filtered Grocery List as per todays Date.
     * List would contain items who purchase date is Todays Date
     * @return groceryList filtered ArrayList of <code>{@link GroceryItem}</code> 
     * @throws java.text.ParseException if failed to Parse Todays Date
     */
    @Override
    public ArrayList<GroceryItem> getGroceryListByDate() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date todaysDate = formatter.parse(formatter.format(new Date()));

        return groceryList.stream()
                .filter((GroceryItem item) -> {
                    return todaysDate.compareTo(item.getPurchaseByDate()) == 0;
                })
                .sorted((a, b) -> a.getStatus().compareTo(b.getStatus()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
