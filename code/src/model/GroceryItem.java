/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    
    /**
     * 
     * @return 
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 
     * @return 
     */
    public Date getPurchaseByDate() {
        return purchaseByDate;
    }
    
    /**
     * 
     * @return 
     */
    public String getQuantity() {
        return quantity;
    }
    
    /**
     * 
     * @return 
     */
    public String getCategory() {
        return category;
    }
    
    /**
     * 
     * @return 
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * 
     * @param itemName 
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    /**
     * 
     * @param purchaseByDate 
     */
    public void setPurchaseByDate(Date purchaseByDate) {
        this.purchaseByDate = purchaseByDate;
    }
    
    /**
     * 
     * @param quantity 
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    /**
     * 
     * @param category 
     */
    public void setCategory(String category) {
        this.category = category;
    }
    
    /**
     * 
     * @param status 
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
