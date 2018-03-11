/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class GroceryItem {
    private String itemName;
    private String quantity;
    private Date purchaseByDate;
    private String category;
    private String status;
    
    public String getItemName(){
        return itemName;
    }

    public Date getPurchaseByDate(){
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
        
    public void setItemName(String itemName){
        this.itemName = itemName;
    }
    
    public void setPurchaseByDate(Date purchaseByDate){
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
    
    public String printGroceryItemDetails(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy"); 
        return (getItemName() + "\t" + getQuantity() + "\t" + getCategory() + "\t" + formatter.format(getPurchaseByDate()));
    } 
    public String printGroceryItem(){
        return (getItemName() + "\t" + getQuantity() + "\t" + getStatus());
    }
}
