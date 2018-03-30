/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Maintains ArrayList of <code>{@link GroceryItem}</code>
 * We can manipulate Grocery List and add, edit and remove a <code>{@link GroceryItem}</code>
 * 
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class GroceryList implements IGroceryList<GroceryItem> {

    ArrayList<GroceryItem> groceryList;
    
    /**
     * 
     */
    public GroceryList() {
        groceryList = new ArrayList<>();
    }

    /**
     * 
     * @return groceryList
     */
    @Override
    public ArrayList<GroceryItem> getGroceryList() {
        return groceryList;
    }
    
    /**
     * 
     * @param objGroceryItem 
     */
    @Override
    public void addGroceryItem(GroceryItem objGroceryItem) {
        groceryList.add(objGroceryItem);
    }
    
    /**
     * 
     * @param itemIndex
     * @param objGroceryItem 
     */
    @Override
    public void editGroceryItem(int itemIndex, GroceryItem objGroceryItem) {
        groceryList.set(itemIndex, objGroceryItem);
    }
    
    /**
     * 
     * @param itemIndex 
     */
    @Override
    public void removeGroceryItem(int itemIndex) {
        groceryList.remove(itemIndex - 1);
    }
    
    /**
     * 
     * @param status
     * @return groceryList
     */
    @Override
    public ArrayList<GroceryItem> getGroceryListByStatus(String status) {
        return groceryList.stream()
                .filter(item -> status.equals(item.getStatus()))
                .sorted((a, b) -> a.getPurchaseByDate().compareTo(b.getPurchaseByDate()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     *
     * @param strTodaysDate
     * @return groceryList
     * @throws java.text.ParseException
     */
    @Override
    public ArrayList<GroceryItem> getGroceryListByDate(String strTodaysDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date todaysDate = formatter.parse(strTodaysDate);

        return groceryList.stream()
                .filter((GroceryItem item) -> {
                    return todaysDate.compareTo(item.getPurchaseByDate()) == 0;
                })
                .sorted((a, b) -> a.getStatus().compareTo(b.getStatus()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
