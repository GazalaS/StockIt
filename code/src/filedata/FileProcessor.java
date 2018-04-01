/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedata;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Generic Class File Processor to read and save Generic objects.
 * @author GazalaS gazalafshaikh@gmail.com
 * @param <T> Generic object
 */
public class FileProcessor<T extends Serializable> {

    /**
     * Reads Objects from File and returns an ArrayList 
     * @param fileName contains the filename from which we would read the objects
     * @return tList ArrayList of Objects read from the file 
     * @throws FileNotFoundException if we failed to find file represented by <code>fileName</code>
     * @throws IOException if we failed to read from file
     * @throws ClassNotFoundException if we failed to read Object from the file
     */
    public ArrayList<T> readFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<T> tList = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                // Read objects
                T t = (T) objectInputStream.readObject();
                tList.add(t);
            }
        } catch (EOFException ex) {
            //All objects are read when control is here
            return tList;
        }
    }

    /**
     * Saves Objects from ArrayList into File
     * @param fileName contains the filename to which we would save the objects
     * @param tList ArrayList of Objects save into the file 
     * @throws FileNotFoundException if we failed to find file represented by <code>fileName</code>
     * @throws IOException if we failed to read Object from the file
     */
    public void saveToFile(String fileName, ArrayList<T> tList) throws FileNotFoundException, IOException {
        File file = new File(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (T t : tList) {
            objectOutputStream.writeObject(t);
        }
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
