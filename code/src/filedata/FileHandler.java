/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedata;

/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
import integration.GroceryItemDTO;
import java.util.ArrayList;
import java.io.*;

public class FileHandler {

    private static final String GROCERY_LIST_FILE = "grocerylist.txt";

    /**
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    public ArrayList<GroceryItemDTO> readFromFile() throws IOException, ClassNotFoundException {
        FileProcessing<GroceryItemDTO> objFP = new FileProcessing<>();
        ArrayList<GroceryItemDTO> objGroceryItemDTOList = objFP.readFromFile(GROCERY_LIST_FILE);
        return objGroceryItemDTOList;
    }

    public void saveToFile(ArrayList<GroceryItemDTO> groceryListDTO) throws IOException {
        FileProcessing<GroceryItemDTO> objFP = new FileProcessing<>();        
        objFP.saveToFile(GROCERY_LIST_FILE, groceryListDTO);
    }
}
