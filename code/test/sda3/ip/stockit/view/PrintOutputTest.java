/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sda3.ip.stockit.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
import org.junit.Ignore;
import sda3.ip.stockit.controller.GroceryListController;
import sda3.ip.stockit.integration.GroceryItemDTO;
import sda3.ip.stockit.integration.ItemCategory;
import sda3.ip.stockit.integration.ItemStatus;

/**
 *
 * @author "GazalaS <gazalafshaikh@gmail.com>"
 */
public class PrintOutputTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;

    GroceryItemDTO item1;
    GroceryItemDTO item2;
    GroceryItemDTO item3;
    GroceryItemDTO item4;
    GroceryItemDTO item5;
    GroceryItemDTO item6;

    MenuHandler objMenuHandler;
    GroceryListController objGroceryListController;

    public PrintOutputTest() {
        objGroceryListController = new GroceryListController();
        objMenuHandler = new MenuHandler(objGroceryListController);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUpStream() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStream() {
        outContent = null;
        System.setOut(originalSysOut);
    }

    @Before
    public void setUp() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date purchasebyDate = formatter.parse(formatter.format(new Date()));

        item1 = new GroceryItemDTO(1, "Chocochip cookies", "2 packets", purchasebyDate, ItemCategory.EDIBLE.toString(), ItemStatus.RUNNING_LOW.toString());
        item2 = new GroceryItemDTO(2, "Shampoo", "2 bottles", purchasebyDate, ItemCategory.INEDIBLE.toString(), ItemStatus.NEED_TO_BUY.toString());
        item3 = new GroceryItemDTO(3, "Oranges", "12 pieces", purchasebyDate, ItemCategory.EDIBLE.toString(), ItemStatus.BROUGHT.toString());
        item4 = new GroceryItemDTO(4, "Hand Wash Liquid", "3 bottles", purchasebyDate, ItemCategory.INEDIBLE.toString(), ItemStatus.NEED_TO_BUY.toString());
        item5 = new GroceryItemDTO(5, "Banana", "1 dozen", purchasebyDate, ItemCategory.EDIBLE.toString(), ItemStatus.RUNNING_LOW.toString());
        item6 = new GroceryItemDTO(6, "Crayons", "1 pack", purchasebyDate, ItemCategory.INEDIBLE.toString(), ItemStatus.BROUGHT.toString());
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of printWelcomeMessage method, of class PrintOutput. Count is 0.
     */
    @Test
    public void testPrintWelcomeMessageCountZero() {
        int countRunningLow = objMenuHandler.getCount(ItemStatus.RUNNING_LOW.toString());
        int countNeedToBuy = objMenuHandler.getCount(ItemStatus.NEED_TO_BUY.toString());
        PrintOutput instance = new PrintOutput();
        instance.printWelcomeMessage(countRunningLow, countNeedToBuy);
        String result = outContent.toString();
        StringBuilder expResult = new StringBuilder();
        expResult.append("***********************\n");
        expResult.append("* Welcome to Stock It *\n");
        expResult.append("***********************\n");
        expResult.append(String.format("* %d items " + ItemStatus.RUNNING_LOW.toString() + " *\n", countRunningLow));
        expResult.append(String.format("* %d items " + ItemStatus.NEED_TO_BUY.toString() + " *\n", countNeedToBuy));
        expResult.append("***********************\n");
        assertEquals(expResult.toString(), result);
    }

    /**
     * Test of printWelcomeMessage method, of class PrintOutput. Count is
     * positive.
     */
    @Test
    public void testPrintWelcomeMessageCountPositive() {
        objGroceryListController.addItemtoGroceryList(item1);
        objGroceryListController.addItemtoGroceryList(item2);
        objGroceryListController.addItemtoGroceryList(item3);
        objGroceryListController.addItemtoGroceryList(item4);
        objGroceryListController.addItemtoGroceryList(item5);
        objGroceryListController.addItemtoGroceryList(item6);

        int expectedCountRunningLow = objGroceryListController.getGroceryListDTOByStatus(ItemStatus.RUNNING_LOW.toString()).size();
        int expectedcountNeedToBuy = objGroceryListController.getGroceryListDTOByStatus(ItemStatus.NEED_TO_BUY.toString()).size();

        int countRunningLow = objMenuHandler.getCount(ItemStatus.RUNNING_LOW.toString());
        int countNeedToBuy = objMenuHandler.getCount(ItemStatus.NEED_TO_BUY.toString());

        PrintOutput instance = new PrintOutput();
        instance.printWelcomeMessage(countRunningLow, countNeedToBuy);
        String result = outContent.toString();

        StringBuilder expResult = new StringBuilder();
        expResult.append("***********************\n");
        expResult.append("* Welcome to Stock It *\n");
        expResult.append("***********************\n");
        expResult.append(String.format("* %d items " + ItemStatus.RUNNING_LOW.toString() + " *\n", countRunningLow));
        expResult.append(String.format("* %d items " + ItemStatus.NEED_TO_BUY.toString() + " *\n", countNeedToBuy));
        expResult.append("***********************\n");

        assertEquals(expectedCountRunningLow, countRunningLow);
        assertEquals(expectedcountNeedToBuy, countNeedToBuy);
        assertEquals(expResult.toString(), result);
    }

    /**
     * Test of printMenu method, of class PrintOutput.
     */
    @Test
    public void testPrintMenu() {
        PrintOutput instance = new PrintOutput();
        instance.printMenu();
        String result = outContent.toString();
        StringBuilder expResult = new StringBuilder();
        expResult.append("\n");
        expResult.append("~~~~~~~~ Pick an Option ~~~~~~~~\n");
        expResult.append("1. Show Grocery List by Status\n");
        expResult.append("2. Add a Grocery Item\n");
        expResult.append("3. Edit a Grocery Item\n");
        expResult.append("4. Remove a Grocery Item\n");
        expResult.append("5. Show Grocery List for Today\n");
        expResult.append("6. Save and Quit\n");
        expResult.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        expResult.append(">> ");
        assertEquals(expResult.toString(), result);
    }

    /**
     * Test of printlnMessage method, of class PrintOutput.
     */
    @Test
    public void testPrintlnMessage() {
        String message = "printlnMessage";
        PrintOutput instance = new PrintOutput();
        instance.printlnMessage(message);
        String result = outContent.toString();
        String expResult = "printlnMessage\n";
        assertEquals(expResult, result);
    }

    /**
     * Test of printMessage method, of class PrintOutput.
     */
    @Test
    public void testPrintMessage() {
        String message = "printMessage";
        PrintOutput instance = new PrintOutput();
        instance.printMessage(message);
        String result = outContent.toString();
        String expResult = "printMessage";
        assertEquals(expResult, result);
    }

    /**
     * Test of printList method, of class PrintOutput. When list is empty
     */
    @Test
    public void testPrintListEmpty() throws Exception {
        ArrayList<GroceryItemDTO> groceryListDTO = objGroceryListController.getGroceryListDTO();
        String operation = "listAll";
        outContent.reset();
        PrintOutput instance = new PrintOutput();
        instance.printList(groceryListDTO, operation);
        String resultListAll = outContent.toString();
        String expResultListAll = "\n";
        assertTrue("List is not Empty", groceryListDTO.isEmpty());
        assertEquals(expResultListAll, resultListAll);

        ArrayList<GroceryItemDTO> groceryListDTOByStatus = objGroceryListController.getGroceryListDTOByStatus(ItemStatus.RUNNING_LOW.toString());
        operation = "listByStatus";
        outContent.reset();
        instance = new PrintOutput();
        instance.printList(groceryListDTOByStatus, operation);
        String resultListByStatus = outContent.toString();
        String expResultListByStatus = "\n";
        assertTrue("List is not Empty", groceryListDTOByStatus.isEmpty());
        assertEquals(expResultListByStatus, resultListByStatus);

        groceryListDTOByStatus = objGroceryListController.getGroceryListDTOByStatus(ItemStatus.NEED_TO_BUY.toString());
        operation = "listByStatus";
        outContent.reset();
        instance = new PrintOutput();
        instance.printList(groceryListDTOByStatus, operation);
        resultListByStatus = outContent.toString();
        expResultListByStatus = "\n";
        assertTrue("List is not Empty", groceryListDTOByStatus.isEmpty());
        assertEquals(expResultListByStatus, resultListByStatus);

        groceryListDTOByStatus = objGroceryListController.getGroceryListDTOByStatus(ItemStatus.BROUGHT.toString());
        operation = "listByStatus";
        outContent.reset();
        instance = new PrintOutput();
        instance.printList(groceryListDTOByStatus, operation);
        resultListByStatus = outContent.toString();
        expResultListByStatus = "\n";
        assertTrue("List is not Empty", groceryListDTOByStatus.isEmpty());
        assertEquals(expResultListByStatus, resultListByStatus);

        ArrayList<GroceryItemDTO> groceryListDTOByDate = objGroceryListController.getGroceryListDTOByDate();
        operation = "listByDate";
        outContent.reset();
        instance = new PrintOutput();
        instance.printList(groceryListDTOByDate, operation);
        String resultListByDate = outContent.toString();
        String expResultListByDate = "\n";
        assertTrue("List is not Empty", groceryListDTOByDate.isEmpty());
        assertEquals(expResultListByDate, resultListByDate);
    }

    /**
     * Test of printList method, of class PrintOutput. When list has data
     */
    @Test
    public void testPrintListData() throws Exception {
        objGroceryListController.addItemtoGroceryList(item1);
        objGroceryListController.addItemtoGroceryList(item2);
        objGroceryListController.addItemtoGroceryList(item3);
        objGroceryListController.addItemtoGroceryList(item4);
        objGroceryListController.addItemtoGroceryList(item5);
        objGroceryListController.addItemtoGroceryList(item6);

        ArrayList<GroceryItemDTO> groceryListDTO = objGroceryListController.getGroceryListDTO();
        String operation = "listAll";
        outContent.reset();
        PrintOutput instance = new PrintOutput();
        instance.printList(groceryListDTO, operation);
        String resultListAll = outContent.toString();
        StringBuilder expResultListAll = new StringBuilder();
        for (GroceryItemDTO item : groceryListDTO) {
            expResultListAll.append(instance.formatStringOutput(item, operation));
            expResultListAll.append("\n");
        }
        expResultListAll.append("\n");
        assertFalse("List is Empty", groceryListDTO.isEmpty());
        assertEquals(expResultListAll.toString(), resultListAll);

        ArrayList<GroceryItemDTO> groceryListDTOByStatus = objGroceryListController.getGroceryListDTOByStatus(ItemStatus.RUNNING_LOW.toString());
        operation = "listByStatus";
        outContent.reset();
        instance = new PrintOutput();
        instance.printList(groceryListDTOByStatus, operation);
        String resultListByStatus = outContent.toString();
        StringBuilder expResultListByStatus = new StringBuilder();
        for (GroceryItemDTO item : groceryListDTOByStatus) {
            expResultListByStatus.append(instance.formatStringOutput(item, operation));
            expResultListByStatus.append("\n");
        }
        expResultListByStatus.append("\n");
        assertFalse("List is Empty", groceryListDTOByStatus.isEmpty());
        assertEquals(expResultListByStatus.toString(), resultListByStatus);

        groceryListDTOByStatus = objGroceryListController.getGroceryListDTOByStatus(ItemStatus.NEED_TO_BUY.toString());
        operation = "listByStatus";
        outContent.reset();
        instance = new PrintOutput();
        instance.printList(groceryListDTOByStatus, operation);
        resultListByStatus = outContent.toString();
        expResultListByStatus.setLength(0);
        for (GroceryItemDTO item : groceryListDTOByStatus) {
            expResultListByStatus.append(instance.formatStringOutput(item, operation));
            expResultListByStatus.append("\n");
        }
        expResultListByStatus.append("\n");
        assertFalse("List is Empty", groceryListDTOByStatus.isEmpty());
        assertEquals(expResultListByStatus.toString(), resultListByStatus);

        groceryListDTOByStatus = objGroceryListController.getGroceryListDTOByStatus(ItemStatus.BROUGHT.toString());
        operation = "listByStatus";
        outContent.reset();
        instance = new PrintOutput();
        instance.printList(groceryListDTOByStatus, operation);
        resultListByStatus = outContent.toString();
        expResultListByStatus.setLength(0);
        for (GroceryItemDTO item : groceryListDTOByStatus) {
            expResultListByStatus.append(instance.formatStringOutput(item, operation));
            expResultListByStatus.append("\n");
        }
        expResultListByStatus.append("\n");
        assertFalse("List is not Empty", groceryListDTOByStatus.isEmpty());
        assertEquals(expResultListByStatus.toString(), resultListByStatus);

        ArrayList<GroceryItemDTO> groceryListDTOByDate = objGroceryListController.getGroceryListDTOByDate();
        operation = "listByDate";
        outContent.reset();
        instance = new PrintOutput();
        instance.printList(groceryListDTOByDate, operation);
        String resultListByDate = outContent.toString();
        StringBuilder expResultListByDate = new StringBuilder();
        for (GroceryItemDTO item : groceryListDTOByDate) {
            expResultListByDate.append(instance.formatStringOutput(item, operation));
            expResultListByDate.append("\n");
        }
        expResultListByDate.append("\n");
        assertFalse("List is not Empty", groceryListDTOByDate.isEmpty());
        assertEquals(expResultListByDate.toString(), resultListByDate);
    }

    /**
     * Test of formatStringOutput method, of class PrintOutput.
     */
    @Test
    public void testFormatStringOutput() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        
        String operation = "listAll";
        PrintOutput instance = new PrintOutput();
        StringBuilder expResultAll = new StringBuilder();
        expResultAll.append(String.format("%-5s ", Integer.toString(item1.getItemIndex()) + ". "));
        expResultAll.append(String.format("%-20s ", item1.getItemName()));
        expResultAll.append(String.format("%-20s ", item1.getQuantity()));
        expResultAll.append(String.format("%-20s ", formatter.format(item1.getPurchaseByDate())));
        expResultAll.append(String.format("%-20s ", item1.getCategory()));
        expResultAll.append(String.format("%-20s ", item1.getStatus()));
        String result = instance.formatStringOutput(item1, operation);
        assertEquals(expResultAll.toString(), result);

        operation = "listByStatus";
        StringBuilder expResultStatus = new StringBuilder();
        expResultStatus.append(String.format("%-5s ", Integer.toString(item2.getItemIndex()) + ". "));
        expResultStatus.append(String.format("%-20s ", item2.getItemName()));
        expResultStatus.append(String.format("%-20s ", item2.getQuantity()));
        expResultStatus.append(String.format("%-20s ", formatter.format(item2.getPurchaseByDate())));
        expResultStatus.append(String.format("%-20s ", item2.getCategory()));
        result = instance.formatStringOutput(item2, operation);
        assertEquals(expResultStatus.toString(), result);

        operation = "listByDate";
        StringBuilder expResultDate = new StringBuilder();
        expResultDate.append(String.format("%-5s ", Integer.toString(item3.getItemIndex()) + ". "));
        expResultDate.append(String.format("%-20s ", item3.getItemName()));
        expResultDate.append(String.format("%-20s ", item3.getQuantity()));
        expResultDate.append(String.format("%-20s ", item3.getStatus()));
        result = instance.formatStringOutput(item3, operation);
        assertEquals(expResultDate.toString(), result);
    }
}
