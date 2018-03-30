/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author "GazalaS <gazalafshaikh@gmail.com>"
 */
public class GroceryListTest {
    private GroceryItem objGroceryItem;
    
    public GroceryListTest() {
    }
    
    @BeforeClass
    public static void setUpClass(){

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date purchasebyDate = formatter.parse(formatter.format(new Date()));
        objGroceryItem = new GroceryItem();
        objGroceryItem.setItemName("Apples");
        objGroceryItem.setPurchaseByDate(purchasebyDate);
        objGroceryItem.setQuantity("2 kgs");
        objGroceryItem.setCategory("Edible");
        objGroceryItem.setStatus("Running Low");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getGroceryList method, of class GroceryList.
     * Grocery List is empty
     */
    @Test
    public void testGetGroceryListEmpty() {
        GroceryList instance = new GroceryList();
        ArrayList<GroceryItem> expResult = new ArrayList<>();
        ArrayList<GroceryItem> result = instance.getGroceryList();
        assertEquals(expResult, result);
        assertTrue("List is Not Empty",result.isEmpty());
    }

    /**
     * Test of getGroceryList method, of class GroceryList.
     * Add one Item to the grocery list and check if 
     * Grocery List has the one item added
     */
    @Test
    public void testGetGroceryListOneItem() {
        GroceryList instance = new GroceryList();
        instance.addGroceryItem(objGroceryItem);
        ArrayList<GroceryItem> result = instance.getGroceryList();
        ArrayList<GroceryItem> expResult = new ArrayList<>();
        expResult.add(objGroceryItem);
        assertEquals(expResult, result);
        assertFalse("List is Empty",result.isEmpty());
        assertTrue("List has more than one Item",result.size()==1);
    }

    /**
     * Test of addGroceryItem method, of class GroceryList.
     * Grocery List add an empty Grocery Item
     */
    @Test
    public void testAddEmptyGroceryItem() {
        GroceryItem emptyGroceryItem = new GroceryItem();
        GroceryList instance = new GroceryList();
        instance.addGroceryItem(emptyGroceryItem);
        GroceryItem expResult = instance.groceryList.get(0);
        assertEquals(expResult, emptyGroceryItem);
    }
    
    /**
     * Test of addGroceryItem method, of class GroceryList.
     * Grocery List add an one Grocery Item 
     * Check if the same item is added
     */
    
    @Test
    public void testAddOneGroceryItem() {
        GroceryList instance = new GroceryList();
        instance.addGroceryItem(objGroceryItem);
        GroceryItem expResult = instance.groceryList.get(0);
        assertEquals(expResult, objGroceryItem);
    }

    /**
     * Test of editGroceryItem method, of class GroceryList.
     * Edit an Item in an Empty List
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testEditGroceryItemInAEmptyList() {
        int itemIndex = 0;
        GroceryList instance = new GroceryList();
        instance.editGroceryItem(itemIndex, objGroceryItem);
    }
  
    /**
     * Test of editGroceryItem method, of class GroceryList.
     * Edit an Item in an List
     */
    @Test
    public void testEditOneGroceryItem() {
        int itemIndex = 0;
        GroceryList instance = new GroceryList();
        GroceryItem groceryItem = new GroceryItem();
        instance.addGroceryItem(groceryItem);
        groceryItem.setItemName("Red Apples");
        groceryItem.setQuantity("12 pieces");
        groceryItem.setPurchaseByDate(new Date());
        groceryItem.setCategory("Edible");
        groceryItem.setStatus("Brought");
        instance.editGroceryItem(itemIndex,groceryItem);
        GroceryItem expResult = instance.getGroceryList().get(0);
        assertEquals(expResult, groceryItem);
    }

    /**
     * Test of editGroceryItem method, of class GroceryList.
     * Edit an Item in an Empty List
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveGroceryItemInAEmptyList() {
        int itemIndex = 0;
        GroceryList instance = new GroceryList();
        instance.removeGroceryItem(itemIndex);
    }
    
    /**
     * Test of removeGroceryItem method, of class GroceryList.
     * Remove from an list
     * itemIndex is 1  as the list displayed for user to choose Item 
     * to remove starts numbering from 1.
     */
    @Test
    public void testRemoveOneGroceryItem() {
        int itemIndex = 1;
        GroceryList instance = new GroceryList();
        GroceryItem groceryItem = new GroceryItem();
        instance.addGroceryItem(groceryItem);
        groceryItem.setItemName("Red Apples");
        groceryItem.setQuantity("12 pieces");
        groceryItem.setPurchaseByDate(new Date());
        groceryItem.setCategory("Edible");
        groceryItem.setStatus("Brought");
        instance.removeGroceryItem(itemIndex);
        ArrayList<GroceryItem> result = instance.getGroceryList();
        assertTrue("Item is not removed",result.isEmpty());
    }

    /**
     * Test of getGroceryListByStatus method, of class GroceryList.
     * If no items with status return an empty list
     */
    @Test
    public void testGetGroceryListByStatusEmpty() {
        String status = "Running Low";
        GroceryList instance = new GroceryList();
        ArrayList<GroceryItem> expResult = new ArrayList<>();
        ArrayList<GroceryItem> result = instance.getGroceryListByStatus(status);
        assertEquals(expResult, result);
        assertTrue("List is Not Empty",result.isEmpty());
    }

    /**
     * Test of getGroceryListByStatus method, of class GroceryList.
     * If one item with status return list
     */
    @Test
    public void testGetGroceryListByStatus() {
        String status = "Running Low";
        GroceryList instance = new GroceryList();
        instance.addGroceryItem(objGroceryItem);
        ArrayList<GroceryItem> expResult = new ArrayList<>();
        expResult.add(objGroceryItem);
        ArrayList<GroceryItem> result = instance.getGroceryListByStatus(status);
        assertEquals(expResult, result);
        assertFalse("List is Empty",result.isEmpty());
    }
    
    /**
     * Test of getGroceryListByDate method, of class GroceryList.
     */
    @Test
    public void testGetGroceryListByDateEmpty() throws Exception {
        GroceryList instance = new GroceryList();
        ArrayList<GroceryItem> expResult = new ArrayList<>();
        ArrayList<GroceryItem> result = instance.getGroceryListByDate();
        assertEquals(expResult, result);
        assertTrue("List is Not Empty",result.isEmpty());
    }
    
    /**
     * Test of getGroceryListByDate method, of class GroceryList.
     */
    @Test
    public void testGetGroceryListByDate() throws Exception {
        GroceryList instance = new GroceryList();
        instance.addGroceryItem(objGroceryItem);
        ArrayList<GroceryItem> expResult = new ArrayList<>();
        expResult.add(objGroceryItem);
        ArrayList<GroceryItem> result = instance.getGroceryListByDate();
        assertEquals(expResult, result);
        assertFalse("List is Empty",result.isEmpty());
    }
    
}
