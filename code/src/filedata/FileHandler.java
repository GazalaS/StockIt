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
import java.util.ArrayList;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Scanner;

public class FileHandler{
        // Default responses to use if we don't recognise a word.
    private ArrayList<String> items;
    // The name of the file containing the default responses.
    private static final String GROCERY_LIST_FILE = "grocerylist.txt";
     /**
     * Build up a list of default responses from which we can pick
     * if we don't know what else to say.
     * @return 
     */
    
    public FileHandler(){
        items = new ArrayList<>();
    }
    
            
     public ArrayList readFromFile()
    {
        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get(GROCERY_LIST_FILE);
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            reader.readLine();
            String line;
            while((line = reader.readLine()) != null) {
                String[] sections = line.split(",");
            }
        }
        catch(FileNotFoundException e) {
            System.err.println("Unable to open " + GROCERY_LIST_FILE);
        }
        catch(IOException e) {
            System.err.println("A problem was encountered reading " +
                               GROCERY_LIST_FILE);
        }
        return items;
    }    
     
}
