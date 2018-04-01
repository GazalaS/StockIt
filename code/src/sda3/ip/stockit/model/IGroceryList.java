/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sda3.ip.stockit.model;

import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
interface IGroceryList<T> {

    void addGroceryItem(T t);

    void editGroceryItem(int itemIndex, T t);

    void removeGroceryItem(int itemIndex);

    ArrayList<T> getGroceryList();

    ArrayList<T> getGroceryListByStatus(String status);

    ArrayList<T> getGroceryListByDate() throws ParseException;
}
