/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedata;


import integration.GroceryItemDTO;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Read and Save <code>{@Link GroceryItemDTO}</code> 
 * @author GazalaS gazalafshaikh@gmail.com
 */
public class FileHandler {

    private static final String GROCERY_LIST_FILE = "grocerylist.ser";

  /**
   * Read List of <code>{@link GroceryItemDTO}</code> from the file
   * passes it to the controller.
   * Read the objects stored into file <code>{@link filedata.FileProcessor#readFromFile(filename)}</code>
   * @return objGroceryItemDTOList Populated list of <code>{@link GroceryItemDTO}</code>
   * @throws IOException if failed to read from file
   * @throws ClassNotFoundException if failed to read Object
   */
    public ArrayList<GroceryItemDTO> readFromFile() throws IOException, ClassNotFoundException {
        FileProcessor<GroceryItemDTO> objFP = new FileProcessor<>();
        ArrayList<GroceryItemDTO> objGroceryItemDTOList = objFP.readFromFile(GROCERY_LIST_FILE);
        return objGroceryItemDTOList;
    }
    
    /**
     * Save List of <code>{@link GroceryItemDTO}</code> into the file.
     * saves the ArrayList passed into file <code>{@link filedata.FileProcessor#saveToFile(filename,groceryListDTO)}</code>
     * @param groceryListDTO List of <code>{@link GroceryItemDTO}</code> to save to file
     * @throws IOException if we failed to write into file
     */
    public void saveToFile(ArrayList<GroceryItemDTO> groceryListDTO) throws IOException {
        FileProcessor<GroceryItemDTO> objFP = new FileProcessor<>();
        objFP.saveToFile(GROCERY_LIST_FILE, groceryListDTO);
    }
    
}
