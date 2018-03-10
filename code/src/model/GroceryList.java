/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import integration.GroceryItemDTO;
import java.util.*;
/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class GroceryList {
    
    private List<GroceryItem> groceryList;
    
    public GroceryList(){
        groceryList = new ArrayList<>();       
    }
    
    
    public void addItemToGroceryList(GroceryItemDTO objGroceryItemDTO){
        GroceryItem groceryItem = new GroceryItem();
        populateGroceryItem(groceryItem,objGroceryItemDTO);
        groceryList.add(groceryItem);
    }
    
    public void editItemInGroceryList(GroceryItemDTO objGroceryItemDTO){
        GroceryItem groceryItem = new GroceryItem();
        //groceryList.remove(objGroceryItemDTO.getItemCount()-1);
       
        //groceryItem = new GroceryItem();
        populateGroceryItem(groceryItem,objGroceryItemDTO);
        groceryList.set(objGroceryItemDTO.getItemCount()-1, groceryItem);
        //groceryList.add(groceryItem);
    }
    
    public void removeItemFromGroceryList(int itemIndex){
        groceryList.remove(itemIndex - 1);
    }
    
    public void printGroceryList(){
        
        if (!groceryList.isEmpty()){   
            System.out.println("Running Low:");
            groceryList.stream()
                        .filter(item -> "Running Low".equals(item.getStatus()) )
                        .forEach((item) -> {
                            System.out.println((groceryList.indexOf(item) + 1) + ". " + item.printEachItem()+ "\t");
                        });
            System.out.println("\nNeed to Buy:");
            groceryList.stream()
                        .filter(item -> "Need to Buy".equals(item.getStatus()) )
                        .forEach((item) -> {
                            System.out.println((groceryList.indexOf(item) + 1) + ". " + item.printEachItem()+ "\t");
                        });
            System.out.println("\nBrought");
            groceryList.stream()
                        .filter(item -> "Brought".equals(item.getStatus()) )
                        .forEach((item) -> {
                            System.out.println((groceryList.indexOf(item) + 1) + ". " + item.printEachItem()+ "\t");
                        });
        }
        else{
           System.out.println("Grocey List is empty. \nPlease select Option 2 to add Items");
        }
    }
    
    private void populateGroceryItem(GroceryItem groceryItem, GroceryItemDTO objGroceryItemDTO){
           
        groceryItem.setItemCount(objGroceryItemDTO.getItemCount());
        groceryItem.setItemName(objGroceryItemDTO.getItemName());
        groceryItem.setQuantity(objGroceryItemDTO.getQuantity());
        groceryItem.setPurchaseByDate(objGroceryItemDTO.getPurchaseByDate());
        groceryItem.setCategory(objGroceryItemDTO.getCategory());
        groceryItem.setStatus(objGroceryItemDTO.getStatus());
        
    }
            
}