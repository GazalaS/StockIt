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
   
    private static final String GROCERY_LIST_FILE = "grocerylist.txt";
    
    /**
     * @return 
     * @throws java.text.ParseException 
     */
    public ArrayList<GroceryItemDTO> readFromFile() throws ParseException, IOException
    {    
        ArrayList<GroceryItemDTO> groceryListDTO = new ArrayList<>();
        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get(GROCERY_LIST_FILE);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        
        if (Files.exists(path, new LinkOption[]{ LinkOption.NOFOLLOW_LINKS}))
        {
            BufferedReader reader = Files.newBufferedReader(path, charset);
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
        return groceryListDTO;
    }    
    
    public void saveToFile(ArrayList<GroceryItemDTO> groceryListDTO) throws IOException{
       SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
       Path resultsFile = Paths.get(GROCERY_LIST_FILE).toAbsolutePath();
        FileWriter writer = new FileWriter(resultsFile.toString());
        for (GroceryItemDTO groceryItemDTO : groceryListDTO) {
            writer.write(groceryItemDTO.getItemName()+","+groceryItemDTO.getQuantity()+","+formatter.format(groceryItemDTO.getPurchaseByDate())+","+groceryItemDTO.getCategory()+","+groceryItemDTO.getStatus());
            writer.write('\n');
        }
        writer.close();
    }
}
