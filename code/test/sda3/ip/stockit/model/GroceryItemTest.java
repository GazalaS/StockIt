/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sda3.ip.stockit.model;

import sda3.ip.stockit.model.GroceryItem;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
       
        expected.setCategory("Edible");
        expected.setStatus("Running Low");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetItemNameNull() {
        GroceryItem instance = new GroceryItem();
        String expResult = null;
        String result = instance.getItemName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getItemName method, of class GroceryItem.
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
     */
    @Test
    public void testGetPurchaseByDateNull() {
        GroceryItem instance = new GroceryItem();
        Date expResult = null;
        Date result = instance.getPurchaseByDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuantity method, of class GroceryItem.
     */
    @Test
    public void testGetQuantityNull() {
        GroceryItem instance = new GroceryItem();
        String expResult = null;
        String result = instance.getQuantity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategory method, of class GroceryItem.
     */
    @Test
    public void testGetCategoryNull() {
        GroceryItem instance = new GroceryItem();
        String expResult = null;
        String result = instance.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class GroceryItem.
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
     */
    @Test
    public void testSetItemName() {
        String itemName = "";
        GroceryItem instance = new GroceryItem();
        instance.setItemName(itemName);
    }

    /**
     * Test of setPurchaseByDate method, of class GroceryItem.
     */
    @Test
    public void testSetPurchaseByDate() {
        Date purchaseByDate = null;
        GroceryItem instance = new GroceryItem();
        instance.setPurchaseByDate(purchaseByDate);
    }

    /**
     * Test of setQuantity method, of class GroceryItem.
     */
    @Test
    public void testSetQuantity() {
        String quantity = "";
        GroceryItem instance = new GroceryItem();
        instance.setQuantity(quantity);
    }

    /**
     * Test of setCategory method, of class GroceryItem.
     */
    @Test
    public void testSetCategory() {
        String category = "";
        GroceryItem instance = new GroceryItem();
        instance.setCategory(category);
    }

    /**
     * Test of setStatus method, of class GroceryItem.
     */
    @Test
    public void testSetStatus() {
        String status = "";
        GroceryItem instance = new GroceryItem();
        instance.setStatus(status);
    }
    
}
