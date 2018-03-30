/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startup;

import controller.GroceryListController;
import java.io.IOException;
import java.text.ParseException;
import view.MenuHandler;

/**
 * Starts the application
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class Main {

    /**
     * This is the main method of the entire application.
     * @param args the command line arguments [not provided]
     */
    public static void main(String[] args) {
        GroceryListController objGroceryListController = new GroceryListController();
        MenuHandler objMenuHandler = new MenuHandler(objGroceryListController);
        try {
            objMenuHandler.processMenu();
        } catch (IOException | ClassNotFoundException | ParseException ex) {
            System.out.println("Error :" + ex.getMessage());
        }
    }
}
