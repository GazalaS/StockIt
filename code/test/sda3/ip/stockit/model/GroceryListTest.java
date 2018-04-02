/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sda3.ip.stockit.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sda3.ip.stockit.integration.ItemCategory;
import sda3.ip.stockit.integration.ItemStatus;

/**
 *
 * @author "GazalaS <gazalafshaikh@gmail.com>"
 */
public class GroceryListTest {

    GroceryItem objGroceryItem;
    GroceryItem item1;
    GroceryItem item2;
    GroceryItem item3;
    GroceryItem item4;
    GroceryItem item5;
    GroceryItem item6;

    public GroceryListTest() {
    }

    @BeforeClass
    public static void setUpClass() {

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
        objGroceryItem.setCategory(ItemCategory.EDIBLE.toString());
        objGroceryItem.setStatus(ItemStatus.RUNNING_LOW.toString());

        item1 = new GroceryItem();
        item1.setItemName("Chocochip cookies");
        item1.setPurchaseByDate(purchasebyDate);
        item1.setQuantity("2 packets");
        item1.setCategory(ItemCategory.EDIBLE.toString());
        item1.setStatus(ItemStatus.RUNNING_LOW.toString());

        item2 = new GroceryItem();
        item2.setItemName("Shampoo");
        item2.setPurchaseByDate(purchasebyDate);
        item2.setQuantity("2 bottles");
        item2.setCategory(ItemCategory.INEDIBLE.toString());
        item2.setStatus(ItemStatus.NEED_TO_BUY.toString());

        item3 = new GroceryItem();
        item3.setItemName("Oranges");
        item3.setPurchaseByDate(purchasebyDate);
        item3.setQuantity("12 pieces");
        item3.setCategory(ItemCategory.EDIBLE.toString());
        item3.setStatus(ItemStatus.RUNNING_LOW.toString());

        item4 = new GroceryItem();
        item4.setItemName("Hand Wash Liquid");
        item4.setPurchaseByDate(purchasebyDate);
        item4.setQuantity("3 bottles");
        item4.setCategory(ItemCategory.INEDIBLE.toString());
        item4.setStatus(ItemStatus.NEED_TO_BUY.toString());

        item5 = new GroceryItem();
        item5.setItemName("Banana");
        item5.setPurchaseByDate(purchasebyDate);
        item5.setQuantity("1 dozen");
        item5.setCategory(ItemCategory.EDIBLE.toString());
        item5.setStatus(ItemStatus.RUNNING_LOW.toString());

        item6 = new GroceryItem();
        item6.setItemName("Crayons");
        item6.setPurchaseByDate(purchasebyDate);
        item6.setQuantity("1 pack");
        item6.setCategory(ItemCategory.INEDIBLE.toString());
        item6.setStatus(ItemStatus.NEED_TO_BUY.toString());
    }

    @After
    public void tearDown() {
        objGroceryItem=null;
        item1=null;
        item2=null;
        item3=null;
        item4=null;
        item5=null;
        item6=null;
    }

    /**
     * Test of getGroceryList method, of class GroceryList. Grocery List is
     * empty
     */
    @Test
    public void testGetGroceryListEmpty() {
        GroceryList instance = new GroceryList();
        ArrayList<GroceryItem> expResult = new ArrayList<>();
        ArrayList<GroceryItem> result = instance.getGroceryList();
        assertEquals(expResult, result);
        assertTrue("List is Not Empty", result.isEmpty());
        assertEquals(0, result.size());
    }

    /**
     * Test of getGroceryList method, of class GroceryList. Add one Item to the
     * grocery list and check if Grocery List has the one item added
     */
    @Test
    public void testGetGroceryListOneItem() {
        GroceryList instance = new GroceryList();
        instance.addGroceryItem(objGroceryItem);
        ArrayList<GroceryItem> result = instance.getGroceryList();
        ArrayList<GroceryItem> expResult = new ArrayList<>();
        expResult.add(objGroceryItem);
        assertEquals(expResult, result);
        assertFalse("List is Empty", result.isEmpty());
        assertEquals(1, result.size());
    }

    /**
     * Test of addGroceryItem method, of class GroceryList. Grocery List add an
     * empty Grocery Item
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
     * Test of addGroceryItem method, of class GroceryList. Grocery List add an
     * one Grocery Item Check if the same item is added
     */
    @Test
    public void testAddOneGroceryItem() {
        GroceryList instance = new GroceryList();
        instance.addGroceryItem(objGroceryItem);
        GroceryItem expResult = instance.groceryList.get(0);
        assertEquals(expResult, objGroceryItem);
    }

    /**
     * Test of addGroceryItem method, of class GroceryList. Grocery List add an
     * Multiple Grocery Item Check if the same item are added
     */
    @Test
    public void testAddOneGroceryItemMultiple() {
        GroceryList instance = new GroceryList();
        instance.addGroceryItem(item1);
        instance.addGroceryItem(item2);
        instance.addGroceryItem(item3);
        instance.addGroceryItem(item4);
        instance.addGroceryItem(item5);
        instance.addGroceryItem(item6);
        
        assertThat(instance.groceryList, hasItems(item1, item2, item3, item4, item5, item6));
        assertEquals(6, instance.groceryList.size());
        
        assertEquals(instance.groceryList.get(0), item1);
        assertEquals(instance.groceryList.get(1), item2);
        assertEquals(instance.groceryList.get(2), item3);
        assertEquals(instance.groceryList.get(3), item4);
        assertEquals(instance.groceryList.get(4), item5);
        assertEquals(instance.groceryList.get(5), item6);
    }
    
    /**
     * Test of editGroceryItem method, of class GroceryList. Edit an Item in an
     * Empty List
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testEditGroceryItemInAEmptyList() {
        int itemIndex = 0;
        GroceryList instance = new GroceryList();
        instance.editGroceryItem(itemIndex, objGroceryItem);
    }

    /**
     * Test of editGroceryItem method, of class GroceryList. Edit an Item in an
     * One Grocery Item Check if the same item is updated
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
        groceryItem.setCategory(ItemCategory.EDIBLE.toString());
        groceryItem.setStatus(ItemStatus.BROUGHT.toString());
        instance.editGroceryItem(itemIndex, groceryItem);
        GroceryItem expResult = instance.getGroceryList().get(0);
        assertEquals(expResult, groceryItem);
        assertEquals(1, instance.groceryList.size());
    }
    
    /**
     * Test of editGroceryItem method, of class GroceryList. Edit an Item in an
     * Multiple Grocery Item Check if the same item is updated
     * Edited first, last and one from middle
     */
    @Test
    public void testEditMultipleGroceryItem() throws ParseException {
        int itemIndex = 0;
        GroceryList instance = new GroceryList();
        GroceryItem expResult = new GroceryItem();
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date purchasebyDate = formatter.parse(formatter.format(new Date()));
                
        instance.addGroceryItem(item1);
        instance.addGroceryItem(item2);
        instance.addGroceryItem(item3);
        instance.addGroceryItem(item4);
        instance.addGroceryItem(item5);
        instance.addGroceryItem(item6);
        
        item1.setItemName("Red Apples");
        item1.setQuantity("12 pieces");
        item1.setPurchaseByDate(purchasebyDate);
        item1.setCategory(ItemCategory.EDIBLE.toString());
        item1.setStatus(ItemStatus.BROUGHT.toString());
        
        instance.editGroceryItem(itemIndex, item1);
        expResult = instance.getGroceryList().get(0);
        assertEquals(expResult, item1);
        
        item3.setItemName("Oranges");
        item3.setPurchaseByDate(purchasebyDate);
        item3.setQuantity("6 pieces");
        item3.setCategory(ItemCategory.EDIBLE.toString());
        item3.setStatus(ItemStatus.BROUGHT.toString());
        
        instance.editGroceryItem(itemIndex, item3);
        expResult = instance.getGroceryList().get(2);
        assertEquals(expResult, item3);
        
        item6.setItemName("Sketch Pens");
        item6.setPurchaseByDate(purchasebyDate);
        item6.setQuantity("1 pack");
        item6.setCategory(ItemCategory.INEDIBLE.toString());
        item6.setStatus(ItemStatus.BROUGHT.toString());
        
        instance.editGroceryItem(itemIndex, item6);
        expResult = instance.getGroceryList().get(5);
        assertEquals(expResult, item6);
        
        assertEquals(6, instance.groceryList.size());
    }

    /**
     * Test of editGroceryItem method, of class GroceryList. 
     * Remove an Item in an Empty List
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveGroceryItemInAEmptyList() {
        int itemIndex = 0;
        GroceryList instance = new GroceryList();
        instance.removeGroceryItem(itemIndex);
    }

    /**
     * Test of removeGroceryItem method, of class GroceryList. Remove from an
     * list itemIndex is 1 as the list displayed for user to choose Item to
     * remove starts numbering from 1.
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
        groceryItem.setCategory(ItemCategory.EDIBLE.toString());
        groceryItem.setStatus(ItemStatus.BROUGHT.toString());
        instance.removeGroceryItem(itemIndex);
        ArrayList<GroceryItem> result = instance.getGroceryList();
        assertTrue("Item is not removed", result.isEmpty());
        assertEquals(0, result.size());
    }

    /**
     * Test of removeGroceryItem method, of class GroceryList. Remove from an
     * list itemIndex is 6,3,1(last,middle and first) as the list displayed 
     * for user to choose Item to remove starts numbering from 1.
     */
    @Test
    public void testRemoveMulipleGroceryItem() {
       GroceryList instance = new GroceryList();
        
        instance.addGroceryItem(item1);
        instance.addGroceryItem(item2);
        instance.addGroceryItem(item3);
        instance.addGroceryItem(item4);
        instance.addGroceryItem(item5);
        instance.addGroceryItem(item6);
        
        instance.removeGroceryItem(6);
        instance.removeGroceryItem(3);
        instance.removeGroceryItem(1);

        ArrayList<GroceryItem> result = instance.getGroceryList();
        assertTrue("Item is not removed", !result.isEmpty());
        assertEquals(3, result.size());
    }
    
    /**
     * Test of getGroceryListByStatus method, of class GroceryList. If no items
     * with status return an empty list
     */
    @Test
    public void testGetGroceryListByStatusEmpty() {
        String status = ItemStatus.RUNNING_LOW.toString();
        GroceryList instance = new GroceryList();
        ArrayList<GroceryItem> expResult = new ArrayList<>();
        ArrayList<GroceryItem> result = instance.getGroceryListByStatus(status);
        assertEquals(expResult, result);
        assertTrue("List is Not Empty", result.isEmpty());
        assertEquals(0, result.size());
    }

    /**
     * Test of getGroceryListByStatus method, of class GroceryList. If one item
     * with status return list
     */
    @Test
    public void testGetGroceryListByStatusOneItem() {
        String status = ItemStatus.RUNNING_LOW.toString();
        GroceryList instance = new GroceryList();
        instance.addGroceryItem(objGroceryItem);
        ArrayList<GroceryItem> expResult = new ArrayList<>();
        expResult.add(objGroceryItem);
        ArrayList<GroceryItem> result = instance.getGroceryListByStatus(status);
        assertEquals(expResult, result);
        assertFalse("List is Empty", result.isEmpty());
        assertEquals(1, result.size());
    }
    /**
     * Test of getGroceryListByStatus method, of class GroceryList. 
     * If multiple items with status return list
     */
    @Test
    public void testGetGroceryListByStatusMultipleItem() {
        String status ;   
        ArrayList<GroceryItem> result = new ArrayList<>();
        
        GroceryList instance = new GroceryList();
        instance.addGroceryItem(item1);
        instance.addGroceryItem(item2);
        instance.addGroceryItem(item3);
        instance.addGroceryItem(item4);
        instance.addGroceryItem(item5);
        instance.addGroceryItem(item6);
        
        status = ItemStatus.RUNNING_LOW.toString();
        result = instance.getGroceryListByStatus(status);
        assertFalse("List is Empty", result.isEmpty());
        assertEquals(3, result.size());
        
        status = ItemStatus.NEED_TO_BUY.toString();
        result = instance.getGroceryListByStatus(status);
        assertFalse("List is Empty", result.isEmpty());
        assertEquals(3, result.size());
        
        status = ItemStatus.BROUGHT.toString();
        result = instance.getGroceryListByStatus(status);
        assertTrue("List is Empty", result.isEmpty());
        assertEquals(0, result.size());
        
        item1.setItemName("Red Apples");
        item1.setQuantity("12 pieces");
        item1.setPurchaseByDate(new Date());
        item1.setCategory(ItemCategory.EDIBLE.toString());
        item1.setStatus(ItemStatus.BROUGHT.toString());
        instance.editGroceryItem(0, item1);
        
        item6.setItemName("Sketch Pens");
        item6.setPurchaseByDate(new Date());
        item6.setQuantity("1 pack");
        item6.setCategory(ItemCategory.INEDIBLE.toString());
        item6.setStatus(ItemStatus.BROUGHT.toString()); 
        instance.editGroceryItem(5, item6);
        
        status = ItemStatus.RUNNING_LOW.toString();
        result = instance.getGroceryListByStatus(status);
        assertFalse("List is Empty", result.isEmpty());
        assertEquals(2, result.size());
        
        status = ItemStatus.NEED_TO_BUY.toString();
        result = instance.getGroceryListByStatus(status);
        assertFalse("List is Empty", result.isEmpty());
        assertEquals(2, result.size());
        
        status = ItemStatus.BROUGHT.toString();
        result = instance.getGroceryListByStatus(status);
        assertFalse("List is Empty", result.isEmpty());
        assertEquals(2, result.size());
    }
    
    /**
     * Test of getGroceryListByDate method, of class GroceryList.
     * No item with
     */
    @Test
    public void testGetGroceryListByDateEmpty() throws Exception {
        GroceryList instance = new GroceryList();
        ArrayList<GroceryItem> expResult = new ArrayList<>();
        ArrayList<GroceryItem> result = instance.getGroceryListByDate();
        assertEquals(expResult, result);
        assertTrue("List is Not Empty", result.isEmpty());
        assertEquals(0, result.size());
    }

    /**
     * Test of getGroceryListByDate method, of class GroceryList.
     */
    @Test
    public void testGetGroceryListByDateOneItem() throws Exception {
        GroceryList instance = new GroceryList();
        instance.addGroceryItem(objGroceryItem);
        ArrayList<GroceryItem> expResult = new ArrayList<>();
        expResult.add(objGroceryItem);
        ArrayList<GroceryItem> result = instance.getGroceryListByDate();
        assertEquals(expResult, result);
        assertFalse("List is Empty", result.isEmpty());
        assertEquals(1, result.size());
    }

    /**
     * Test of getGroceryListByDate method, of class GroceryList.
     */
    @Test
    public void testGetGroceryListByDateMultipleItems() throws Exception {
        GroceryList instance = new GroceryList();
        instance.addGroceryItem(item1);
        instance.addGroceryItem(item2);
        instance.addGroceryItem(item3);
        instance.addGroceryItem(item4);
        instance.addGroceryItem(item5);
        instance.addGroceryItem(item6);
        
        ArrayList<GroceryItem> result = instance.getGroceryListByDate();
        assertFalse("List is Empty", result.isEmpty());
        assertEquals(6, result.size());
    }
}
