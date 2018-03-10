/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class GroceryItemDTO {
    private String itemName;
    private String quantity;
    private String purchaseByDate;
    private String category;
    private String status;
    private int itemCount ;
    
    public GroceryItemDTO(){
    }
    
    public GroceryItemDTO(int itemCount){
            this.itemCount = itemCount;
    }
    
    public GroceryItemDTO(String itemName,String quantity, String purchaseByDate, String category, String status,int itemCount){
        this.itemName = itemName;
        this.quantity = quantity;
        this.purchaseByDate = purchaseByDate;
        this.category = category;
        this.status = status;
        this.itemCount = itemCount;
    }
    
    public int getItemCount(){
        return itemCount;
    }
    
    public String getItemName(){
        return itemName;
    }

    public String getPurchaseByDate(){
        return purchaseByDate;
    }
    
    public String getQuantity(){
        return quantity;
    }
    
    public String getCategory(){
        return category;
    }
    
    public String getStatus(){
        return status;
    }
}
