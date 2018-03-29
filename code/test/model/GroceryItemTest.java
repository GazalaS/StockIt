/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.GroceryItem;
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
    
    public GroceryItemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getItemName method, of class GroceryItem.
     */
    @Test
    public void testGetItemName() {
        System.out.println("getItemName");
        GroceryItem instance = new GroceryItem();
        String expResult = "";
        String result = instance.getItemName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPurchaseByDate method, of class GroceryItem.
     */
    @Test
    public void testGetPurchaseByDate() {
        System.out.println("getPurchaseByDate");
        GroceryItem instance = new GroceryItem();
        Date expResult = null;
        Date result = instance.getPurchaseByDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuantity method, of class GroceryItem.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        GroceryItem instance = new GroceryItem();
        String expResult = "";
        String result = instance.getQuantity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategory method, of class GroceryItem.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        GroceryItem instance = new GroceryItem();
        String expResult = "";
        String result = instance.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class GroceryItem.
     */
    @Test
    public void testGetStatusEmpty() {
        System.out.println("getStatus");
        GroceryItem instance = new GroceryItem();
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of getStatus method, of class GroceryItem.
     */
    @Test
    public void testGetStatusWithTitle() {
        System.out.println("getStatus");
        GroceryItem item = new GroceryItem();
        String expResult = "";
        String result = item.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setItemName method, of class GroceryItem.
     */
    @Test
    public void testSetItemName() {
        System.out.println("setItemName");
        String itemName = "Apples";
        GroceryItem instance = new GroceryItem();
        instance.setItemName(itemName);
    }

    /**
     * Test of setPurchaseByDate method, of class GroceryItem.
     */
    @Test
    public void testSetPurchaseByDate() {
        System.out.println("setPurchaseByDate");
        Date purchaseByDate = null;
        GroceryItem instance = new GroceryItem();
        instance.setPurchaseByDate(purchaseByDate);
    }

    /**
     * Test of setQuantity method, of class GroceryItem.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        String quantity = "";
        GroceryItem instance = new GroceryItem();
        instance.setQuantity(quantity);
    }

    /**
     * Test of setCategory method, of class GroceryItem.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        String category = "";
        GroceryItem instance = new GroceryItem();
        instance.setCategory(category);
    }

    /**
     * Test of setStatus method, of class GroceryItem.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        GroceryItem instance = new GroceryItem();
        instance.setStatus(status);
    }
    
}
