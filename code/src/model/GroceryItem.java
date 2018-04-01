/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 * Holds the details about individual Item. 
 * @author GazalaS gazalafshaikh@gmail.com
 */
public class GroceryItem {

    private String itemName;
    private String quantity;
    private Date purchaseByDate;
    private String category;
    private String status;
    
    /**
     * This method returns the Item Name
     * @return itemName The current value of {@link #itemName} of the particular Item
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * This method returns the Purchase By Date
     * @return purchaseByDate The current value of {@link #purchaseByDate} of the
     * particular Item
     */
    public Date getPurchaseByDate() {
        return purchaseByDate;
    }
    
    /**
     * This method returns the Item Quantity
     * @return quantity The current value of {@link #quantity} of the particular Item
     */
    public String getQuantity() {
        return quantity;
    }
    
    /**
     * This method returns the Item Category
     * @return category The current value of {@link #category} of the particular Item
     */
    public String getCategory() {
        return category;
    }
    
    /**
     * This method returns the Item Status
     * @return status The current value of {@link #status} of the particular Item 
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * Changes the Item Name
     * @param itemName The new value of {@link #itemName} of the particular Item
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    /**
     * Changes the Purchase By Date 
     * @param purchaseByDate The new value of {@link #purchaseByDate} of the
     * particular Item
     */
    public void setPurchaseByDate(Date purchaseByDate) {
        this.purchaseByDate = purchaseByDate;
    }
    
    /**
     * Changes the Item Quantity 
     * @param quantity The new value of {@link #quantity} of the particular Item
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    /**
     * Changes the Item Category
     * @param category The new value {@link #category} of the particular Item
     */
    public void setCategory(String category) {
        this.category = category;
    }
    
    /**
     * Changes the Item Status
     * @param status The new value of {@link #status} of the particular Item 
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
      /**
     * Equals to compare two objects and its value.
     * @param o Object to be compared
     * @return true if both the objects are same
     *              if all the values match
     *         false if object is null
     *               if object is of a different type
     *               if any of the value is not same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GroceryItem groceryItem = (GroceryItem) o;
        if (!itemName.equals(groceryItem.itemName)) {
            return false;
        }
        if (!quantity.equals(groceryItem.quantity)) {
            return false;
        }
        if ((purchaseByDate.compareTo(groceryItem.purchaseByDate) < 0)) {
            return false;
        }
        if (!category.equals(groceryItem.category)) {
            return false;
        }
        if (!status.equals(groceryItem.status)) {
            return false;
        }
        return true;
    }
}
