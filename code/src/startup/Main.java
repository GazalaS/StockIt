/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startup;
//import filedata.FileHandler;
import controller.GroceryListController;
//import java.util.ArrayList;


/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        GroceryListController objGroceryListController = new GroceryListController();
        objGroceryListController.displayWelcomeMessage();
        objGroceryListController.displayMenu();
        /* FileHandler objFileHandler = new FileHandler();
        try {
            ArrayList<String> items = new ArrayList<>();
            items = objFileHandler.scanToRead();
            items.forEach((item) -> {
                 System.out.println(item);
            });
            //objFileHandler.readFromFile();
            } 
        catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } */          
 }      
    
}
