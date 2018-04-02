/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sda3.ip.stockit.model;

import java.util.Date;
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
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class GroceryItemTest {
    private GroceryItem expected;
    
    public GroceryItemTest() {
        expected = new GroceryItem(); 
        
    }
    
    @BeforeClass
    public static void setUpClass() {   
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        expected.setItemName("Apples");
        expected.setQuantity("2 kgs");
        expected.setPurchaseByDate(new Date());
        expected.setCategory(ItemCategory.EDIBLE.toString());
        expected.setStatus(ItemStatus.NEED_TO_BUY.toString());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getItemName method, of class GroceryItem.
     * Item Name is null
     */
    @Test
    public void testGetItemNameNull() {
        GroceryItem instance = new GroceryItem();
        String expResult = null;
        String result = instance.getItemName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getItemName method, of class GroceryItem.
     * Item Name has data
     */
    @Test
    public void testGetItemName() {
        GroceryItem instance = expected;
        String expResult = expected.getItemName();
        String result = instance.getItemName();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of getPurchaseByDate method, of class GroceryItem.
     * Purchase by date is null
     */
    @Test
    public void testGetPurchaseByDateNull() {
        GroceryItem instance = new GroceryItem();
        Date expResult = null;
        Date result = instance.getPurchaseByDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPurchaseByDate method, of class GroceryItem.
     * Purchase by date has data
     */
    @Test
    public void testGetPurchaseByDate() {
        GroceryItem instance = expected;
        Date expResult = expected.getPurchaseByDate();
        Date result = instance.getPurchaseByDate();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getQuantity method, of class GroceryItem.
     * Item Quantity is null
     */
    @Test
    public void testGetQuantityNull() {
        GroceryItem instance = new GroceryItem();
        String expResult = null;
        String result = instance.getQuantity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuantity method, of class GroceryItem.
     * Item Quantity has data
     */
    @Test
    public void testGetQuantity() {
        GroceryItem instance = expected;
        String expResult = expected.getQuantity();
        String result = instance.getQuantity();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getCategory method, of class GroceryItem.
     * Item Category is null
     */
    @Test
    public void testGetCategoryNull() {
        GroceryItem instance = new GroceryItem();
        String expResult = null;
        String result = instance.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategory method, of class GroceryItem.
     * Item Category is null
     */
    @Test
    public void testGetCategory() {
        GroceryItem instance = expected;
        String expResult = expected.getCategory();
        String result = instance.getCategory();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getStatus method, of class GroceryItem.
     * Status is null
     */
    @Test
    public void testGetStatusNull() {
        GroceryItem instance = new GroceryItem();
        String expResult = null;
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }
       
    /**
     * Test of getStatus method, of class GroceryItem.
     * Status has Data
     */
    @Test
    public void testGetStatus() {
        GroceryItem instance = expected;
        String expResult = expected.getStatus();
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setItemName method, of class GroceryItem.
     * Item Name is null
     */
    @Test
    public void testSetItemNameNull() {
        String itemName = null;
        GroceryItem instance = new GroceryItem();
        instance.setItemName(itemName);
        assertEquals(itemName, instance.getItemName());
        
    }
    
    /**
     * Test of setItemName method, of class GroceryItem.
     * Item Name has data
     */
    @Test
    public void testSetItemName() {
        String itemName = "Apples";
        GroceryItem instance = new GroceryItem();
        instance.setItemName(itemName);
        assertEquals(itemName, instance.getItemName());
        
    }

    /**
     * Test of setPurchaseByDate method, of class GroceryItem.
     * Item Purchase By Date is null
     */
    @Test
    public void testSetPurchaseByDateNull() {
        Date purchaseByDate = null;
        GroceryItem instance = new GroceryItem();
        instance.setPurchaseByDate(purchaseByDate);
        assertEquals(purchaseByDate, instance.getPurchaseByDate());
    }

    /**
     * Test of setPurchaseByDate method, of class GroceryItem.
     * Item Purchase By Date has data
     */
    @Test
    public void testSetPurchaseByDate() {
        Date purchaseByDate = new Date();
        GroceryItem instance = new GroceryItem();
        instance.setPurchaseByDate(purchaseByDate);
        assertEquals(purchaseByDate, instance.getPurchaseByDate());
    }
    
    /**
     * Test of setQuantity method, of class GroceryItem.
     * Item Quantity is null
     */
    @Test
    public void testSetQuantityNull() {
        String quantity = null;
        GroceryItem instance = new GroceryItem();
        instance.setQuantity(quantity);
        assertEquals(quantity,instance.getQuantity());
    }

    /**
     * Test of setQuantity method, of class GroceryItem.
     * Item Quantity has data
     */
    @Test
    public void testSetQuantity() {
        String quantity = "2 Kgs";
        GroceryItem instance = new GroceryItem();
        instance.setQuantity(quantity);
        assertEquals(quantity,instance.getQuantity());
    }
    
    /**
     * Test of setCategory method, of class GroceryItem.
     * Item Category is null
     */
    @Test
    public void testSetCategoryNull() {
        String category = null;
        GroceryItem instance = new GroceryItem();
        instance.setCategory(category);
        assertEquals(category,instance.getCategory());
    }
    
    /**
     * Test of setCategory method, of class GroceryItem.
     * Item Category has Data
     */
    @Test
    public void testSetCategory() {
        String category = ItemCategory.EDIBLE.toString();
        GroceryItem instance = new GroceryItem();
        instance.setCategory(category);
        assertEquals(category,instance.getCategory());
    }

    /**
     * Test of setStatus method, of class GroceryItem.
     * Item Status is null
     */
    @Test
    public void testSetStatusNull() {
        String status = null;
        GroceryItem instance = new GroceryItem();
        instance.setStatus(status);
        assertEquals(status,instance.getStatus());
    }
    
    /**
     * Test of setStatus method, of class GroceryItem.
     * Item Status has data
     */
    @Test
    public void testSetStatus() {
        String status = ItemStatus.NEED_TO_BUY.toString();
        GroceryItem instance = new GroceryItem();
        instance.setStatus(status);
        assertEquals(status,instance.getStatus());
    }
    
}
