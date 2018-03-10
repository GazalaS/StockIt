/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class GroceryItem {
    private int itemCount;
    private String itemName;
    private String quantity;
    private String purchaseByDate;
    private String category;
    private String status;
    
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
    
    public void setItemCount(int itemCount){
        this.itemCount = itemCount;
    }
    
    public void setItemName(String itemName){
        this.itemName = itemName;
    }
    
    public void setPurchaseByDate(String purchaseByDate){
        this.purchaseByDate = purchaseByDate;
    }
    
    public void setQuantity(String quantity){
        this.quantity = quantity;
    }
    
    public void setCategory(String category){
        this.category = category; 
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public String printEachItem(){
        return (getItemName() + " " + getQuantity() + " " + getPurchaseByDate());
    }
}
