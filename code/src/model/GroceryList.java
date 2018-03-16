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
    public void addGroceryItem(GroceryItemDTO objGroceryItemDTO){      
        groceryList.add(createGroceryItem(objGroceryItemDTO));
    }
    
    public void editGroceryItem(GroceryItemDTO objGroceryItemDTO){
        updateGroceryItem(groceryList.get(objGroceryItemDTO.getItemIndex()-1),objGroceryItemDTO);
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
    
    public void removeGroceryItem(int itemIndex){
        groceryList.remove(itemIndex - 1);
    }
    
    public ArrayList<GroceryItem> getGroceryListByStatus(String status){
        return groceryList.stream()
                .filter(item -> status.equals(item.getStatus()) )
                .sorted((a,b)-> a.getPurchaseByDate().compareTo(b.getPurchaseByDate()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    /**
     *
     * @param purchaseByDate
     * @return 
     * @throws ParseException
     */
    public ArrayList<GroceryItem> getGroceryListByDate(String strTodaysDate) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date todaysDate = formatter.parse(strTodaysDate);
        
        return groceryList.stream()
                .filter((GroceryItem item) -> {                   
                    return todaysDate.compareTo(item.getPurchaseByDate()) == 0;                    
                })
                .sorted((a,b)-> a.getStatus().compareTo(b.getStatus()))
                .collect(Collectors.toCollection(ArrayList::new));
    }   
}