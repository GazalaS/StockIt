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
import java.nio.charset.Charset;
import java.nio.file.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileHandler{
   
    private static final String GROCERY_LIST_FILE = "grocerylist.csv";
    
    /**
     * @return 
     * @throws java.text.ParseException 
     */

    public ArrayList<GroceryItemDTO> readFromFile() throws ParseException
    {    
        ArrayList<GroceryItemDTO> groceryListDTO = new ArrayList<>();
        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get(GROCERY_LIST_FILE);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            reader.readLine();
            String line;
            int itemIndex = 1;
            while((line = reader.readLine()) != null) {
                
                String[] sections = line.split(",");
                GroceryItemDTO objGroceryItemDTO = new GroceryItemDTO(
                                                    itemIndex++,
                                                    sections[0],
                                                    sections[1],
                                                    formatter.parse(sections[2]),
                                                    sections[3],
                                                    sections[4]);
                groceryListDTO.add(objGroceryItemDTO);
            }
        }
        catch(FileNotFoundException e) {
            System.err.println("Unable to open " + GROCERY_LIST_FILE);
        }
        catch(IOException e) {
            System.err.println("A problem was encountered reading " +
                               GROCERY_LIST_FILE);
        }
        return groceryListDTO;
    }    
    
    public void saveToFile(ArrayList<GroceryItemDTO> groceryListDTO){
       //yet to implement 
    }
}
