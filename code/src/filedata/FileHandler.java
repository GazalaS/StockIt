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
i


public class FileHandler {

    private static final String GROCERY_LIST_FILE = "grocerylist.txt";

    /**
     * @return @throws java.text.ParseException
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    public ArrayList<GroceryItemDTO> readFromFile() throws IOException, ClassNotFoundException {
        FileProcessing<GroceryItemDTO> objFP = new FileProcessing<>();
        return (ArrayList<GroceryItemDTO>) objFP.readFromFile(GROCERY_LIST_FILE);
    }

    public void saveToFile(ArrayList<GroceryItemDTO> groceryListDTO) throws IOException {
        FileProcessing<GroceryItemDTO> objFP = new FileProcessing<>();
        objFP.savetoFile(GROCERY_LIST_FILE, groceryListDTO);
    }
}
