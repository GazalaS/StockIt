/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Generic Type Interface for GroceryList
 * @param <T> This describes my type parameter
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
interface IGroceryList<T> {

    /**
     * Adds the specified type to end of the List
     * @param t Type to be added to the list
     */
    void addGroceryItem(T t);

    /**
     * Updates the specified type at the specified position in this list.
     * @param itemIndex index at which the specified element is to be updated
     * @param t type to be updated
     */
    void editGroceryItem(int itemIndex, T t);

    /**
     * Removes the type at the specified position in this list
     * @param itemIndex  the index of the type to be removed
     */
    void removeGroceryItem(int itemIndex);

    /**
     * Returns the entire ArrayList of type .
     * @return ArrayList of type
     */
    ArrayList<T> getGroceryList();
    
    /**
     * Returns the ArrayList of type with the specified status.
     * @param status status on which we need to filter the list
     * @return the element at the specified position in this list
     */
    ArrayList<T> getGroceryListByStatus(String status);
    
    /**
     * Returns the ArrayList of type with Date.
     * @return the element at the specified position in this list
     * @throws ParseException if failed to parse the Date
     */
    ArrayList<T> getGroceryListByDate() throws ParseException;
}
