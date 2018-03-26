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
 *
 * @author "GazalaS <gazalafshaikh@gmail.com>"
 */
public class FileProcessor<T extends Serializable> {

    public ArrayList<T> readFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<T> tList = new ArrayList<>();
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try {
            while (true) {
                // Read objects
                T t = (T) objectInputStream.readObject();
                tList.add(t);
            }
        } catch (EOFException ex) {
            //All objects are read when control is here
            return tList;
        } finally {
            objectInputStream.close();
            fileInputStream.close();
        }
    }

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
