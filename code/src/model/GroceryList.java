/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import integration.GroceryItemDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class GroceryList {
    
    ArrayList<GroceryItem> groceryList;
    
    public GroceryList(){
        groceryList = new ArrayList<>();       
    }
    
    public ArrayList<GroceryItem> getGroceryList(){
        return groceryList;
    }
    public void addItemToGroceryList(GroceryItemDTO objGroceryItemDTO){      
        groceryList.add(createGroceryItem(objGroceryItemDTO));
    }
    
    public void editItemInGroceryList(GroceryItemDTO objGroceryItemDTO){
        updateGroceryItem(groceryList.get(objGroceryItemDTO.getItemIndex()-1),objGroceryItemDTO);
    }
    
    public void removeItemFromGroceryList(int itemIndex){
        groceryList.remove(itemIndex - 1);
    }
    
    public ArrayList<GroceryItem> getGroceryListByStatus(String status){
        return groceryList.stream()
                .filter(item -> status.equals(item.getStatus()) )
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    /**
     *
     * @param purchaseByDate
     * @return 
     * @throws ParseException
     */
    public ArrayList<GroceryItem> getGroceryListByDate(String purchaseByDate) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date todaysDate = formatter.parse(purchaseByDate);
        
        return groceryList.stream()
                .filter((GroceryItem item) -> {                   
                    return todaysDate.compareTo(item.getPurchaseByDate()) == 0;                    
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }
        
    private GroceryItem createGroceryItem(GroceryItemDTO objGroceryItemDTO){
        GroceryItem groceryItem = new GroceryItem();   
        updateGroceryItem(groceryItem, objGroceryItemDTO);
        return groceryItem;
    }
    
    private void updateGroceryItem(GroceryItem groceryItem, GroceryItemDTO objGroceryItemDTO){
        groceryItem.setItemName(objGroceryItemDTO.getItemName());
        groceryItem.setQuantity(objGroceryItemDTO.getQuantity());
        groceryItem.setPurchaseByDate(objGroceryItemDTO.getPurchaseByDate());
        groceryItem.setCategory(objGroceryItemDTO.getCategory());
        groceryItem.setStatus(objGroceryItemDTO.getStatus());
    }
            
}