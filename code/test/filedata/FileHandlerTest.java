/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedata;

import integration.GroceryItemDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author "GazalaS <gazalafshaikh@gmail.com>"
 */
public class FileHandlerTest {
    
    public FileHandlerTest(){

    }

    @BeforeClass
    public static void setUpClass() throws NoSuchFieldException {
 
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
     * Test of readFromFile method, of class FileHandler. Test when File has
     * data and it returns the ArrayList<code>{@link GroceryItemDTO}</code> size
     * of the list should be greater than 0 so its not empty If Test Fails then
     * File has No Data If Test Passes then File has Data list is not empty
     *
     * @throws java.lang.Exception if we failed to read file
     */
    @Test
    public void testReadFromFileGroceryList() throws Exception {
        FileHandler instance = new FileHandler();
        ArrayList<GroceryItemDTO> result = instance.readFromFile();
        assertFalse("No Data in File", result.isEmpty());
    }

    /**
     * Test of readFromFile method, of class FileHandler. Test when File has no
     * data and it returns the ArrayList<code>{@link GroceryItemDTO}</code> size
     * of the list should be 0 so its empty If Test Fails then File has Data If
     * Test Passes then File has No Data list is empty
     *
     * @throws java.lang.Exception if we failed to read file
     */
    @Test
    public void testReadFromFileEmptyGroceryList() throws Exception {
        FileHandler instance = new FileHandler();
        ArrayList<GroceryItemDTO> result = instance.readFromFile();
        assertTrue("File has Data", result.isEmpty());
    }

    /**
     * Test of saveToFile method, of class FileHandler.
     * Save ArrayList<code>{@link GroceryItemDTO}</code> to file
     * Read ArrayList<code>{@link GroceryItemDTO}</code> from file
     * Check if it has same Data as Saved
     * @throws java.lang.Exception if we failed to save to file
     */
    @Test
    public void testSaveToFileGroceryListReadFromFileSameData() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        ArrayList<GroceryItemDTO> groceryList = new ArrayList<>();
        GroceryItemDTO item1 = new GroceryItemDTO(
                0,
                "Apples",
                "2 kgs",
                formatter.parse("31-03-2018"),
                "Edible",
                "Running Low");
        groceryList.add(item1);

        GroceryItemDTO item2 = new GroceryItemDTO(
                0,
                "Shampoo",
                "1 Bottle",
                formatter.parse("31-03-2018"),
                "Inedible",
                "Brought");
        groceryList.add(item2);

        FileHandler instance = new FileHandler();
        instance.saveToFile(groceryList);
        
        ArrayList<GroceryItemDTO> result = instance.readFromFile();
        assertEquals(groceryList, result);
    }
}
