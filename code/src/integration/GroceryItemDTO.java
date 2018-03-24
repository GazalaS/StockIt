/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;

/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class GroceryItemDTO implements Serializable{
    private int itemIndex ;
    private String itemName;
    private String quantity;
    private Date purchaseByDate;
    private String category;
    private String status;
    
    
    public GroceryItemDTO(int itemIndex,String itemName, String quantity, Date purchaseByDate, String category, String status){
        this.itemIndex = itemIndex;
        this.itemName = itemName;
        this.quantity = quantity;
        this.purchaseByDate = purchaseByDate;
        this.category = category;
        this.status = status;  
    }
    
    public int getItemIndex(){
        return itemIndex;
    }
    
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
    
    public String getGroceryItemAllDetails(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");       
        return (String.format("%-5s",Integer.toString(getItemIndex())+ ". " ) + 
                String.format("%-20s",getItemName()) +
                String.format("%-20s",getQuantity()) + 
                String.format("%-20s",formatter.format(getPurchaseByDate())) + 
                String.format("%-20s",getCategory()) + 
                String.format("%-20s",getStatus()) + "\n");
    } 
   
    public String getGroceryItemNoStatus(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy"); 
        return (String.format("%-5s",Integer.toString(getItemIndex())+ ". " ) + 
                String.format("%-20s",getItemName()) + 
                String.format("%-20s",getQuantity()) + 
                String.format("%-20s",formatter.format(getPurchaseByDate())) + 
                String.format("%-20s",getCategory()) + 
                String.format("%-20s",getStatus()) + "\n");
    } 
        
    public String getGroceryItemBriefDetails(){
        return (String.format("%-5s",Integer.toString(getItemIndex())+ ". " ) +
                String.format("%-20s",getItemName()) + 
                String.format("%-20s",getQuantity()) +  
                String.format("%-20s",getStatus()) + "\n");
    }
}
