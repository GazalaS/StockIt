/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class GroceryItemDTO implements Serializable {

    private int itemIndex;
    private String itemName;
    private String quantity;
    private Date purchaseByDate;
    private String category;
    private String status;

    public GroceryItemDTO(int itemIndex, String itemName, String quantity, Date purchaseByDate, String category, String status) {
        this.itemIndex = itemIndex;
        this.itemName = itemName;
        this.quantity = quantity;
        this.purchaseByDate = purchaseByDate;
        this.category = category;
        this.status = status;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public String getItemName() {
        return itemName;
    }

    public Date getPurchaseByDate() {
        return purchaseByDate;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }
}
