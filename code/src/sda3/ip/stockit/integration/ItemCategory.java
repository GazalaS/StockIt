/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sda3.ip.stockit.integration;

/**
 * 
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public enum ItemCategory {
    EDIBLE("Edible"), INEDIBLE("Inedible");
    private final String category;

    /**
     * This constructor Instantiates a new <code>{@link ItemCategory}</code>
     * @param category 
     */
    ItemCategory(String category) {
        this.category = category;
    }
    
    /**
     * This method returns the category
     * @return category The current value of category
     */
    @Override
    public String toString() {
        return category;
    }
}
