/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import integration.GroceryItemDTO;
import java.util.Scanner;
/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class MenuHandler {
    
    String itemName;
    String quantity;
    String purchaseByDate;
    String category;
    String status;
    int itemCount;
    
    private Scanner reader;
    GroceryItemDTO objGroceryItemDTO;
    
    public MenuHandler(){
        reader = new Scanner(System.in);
    }
    public GroceryItemDTO addToGroceryList(){
        parseInput("add","Running Low/Need to Buy");
        itemCount++;
        objGroceryItemDTO = new GroceryItemDTO(itemName,quantity, purchaseByDate, category, status, itemCount);
        return objGroceryItemDTO;
    }
    
    public GroceryItemDTO editItemInGroceryList(){
        parseInput("edit","Running Low/Need to Buy/Brought");
        objGroceryItemDTO = new GroceryItemDTO(itemName,quantity, purchaseByDate, category, status, itemCount);
        return objGroceryItemDTO;
    }
    
    public int removeItemFromGroceryList(){
        System.out.print("Enter Item Number to Remove: ");
        itemCount = reader.nextInt();
        return itemCount;
    }
    
    private void parseInput(String operation, String statusInputMessage){
        if (operation.equals("edit")){
            System.out.print("Enter Item Number to Edit: ");  
            itemCount = reader.nextInt();
            reader.nextLine();
        }   
        System.out.print("Enter Item Name: ");
        itemName = reader.nextLine();
        System.out.print("Enter Item Quantity: ");
        quantity = reader.nextLine();
        System.out.print("Enter Purchase By Date: ");
        purchaseByDate = reader.nextLine();
        System.out.print("Enter Item Category (Edible/Inedible): ");
        category = reader.nextLine();
        System.out.print("Enter Item Status (" + statusInputMessage +"): ");
        status = reader.nextLine();

    }

}
