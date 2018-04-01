/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sda3.ip.stockit.integration;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO used to transfer data between layers.
 * @author GazalaS gazalafshaikh@gmail.com
 */
public class GroceryItemDTO implements Serializable {

    private final int itemIndex;
    private final String itemName;
    private final String quantity;
    private final Date purchaseByDate;
    private final String category;
    private final String status;

    /**
     * Instantiates a new <code>{@link GroceryItemDTO}</code>
     *
     * @param itemIndex Index of the Item
     * @param itemName Name of the Item
     * @param quantity Quantity of the Item
     * @param purchaseByDate Purchase By Date of the Item
     * @param category Category of the Item
     * @param status Status of the Item
     */
    public GroceryItemDTO(int itemIndex, String itemName, String quantity, Date purchaseByDate, String category, String status) {
        this.itemIndex = itemIndex;
        this.itemName = itemName;
        this.quantity = quantity;
        this.purchaseByDate = purchaseByDate;
        this.category = category;
        this.status = status;
    }

    /**
     * This method returns the Item Index 
     * @return itemIndex The current value of {@link #itemIndex} of the
     * particular Item
     */
    public int getItemIndex() {
        return itemIndex;
    }

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
     * @return quantity The current value of  {@link #quantity} of the particular Item
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
        GroceryItemDTO groceryItemDTO = (GroceryItemDTO) o;
        if (!itemName.equals(groceryItemDTO.itemName)) {
            return false;
        }
        if (!quantity.equals(groceryItemDTO.quantity)) {
            return false;
        }
        if ((purchaseByDate.compareTo(groceryItemDTO.purchaseByDate) < 0)) {
            return false;
        }
        if (!category.equals(groceryItemDTO.category)) {
            return false;
        }
        if (!status.equals(groceryItemDTO.status)) {
            return false;
        }
        return true;
    }
}
