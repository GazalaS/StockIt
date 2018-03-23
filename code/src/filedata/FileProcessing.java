/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author "GazalaS <gazalafshaikh@gmail.com>"
 */
public class FileProcessing<T> {

    public List<T> readFromFile(String fileName) throws IOException, ClassNotFoundException {
        List<T> tList = new ArrayList<>();

        // Make sure the file can be found.
        URL resource = getClass().getResource(fileName);
        if (resource == null) {
            throw new FileNotFoundException(fileName);
        }
        try {
            File source = new File(resource.toURI());
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream(source));
            T t = (T) is.readObject();
            tList.add(t);
            is.close();
        } catch (URISyntaxException e) {
            throw new IOException("Unable to make a valid filename for "
                    + fileName);
        }
    
    return tList ;
}

public void savetoFile(String fileName, List<T> tList) throws IOException {
        Path path = Paths.get(fileName).toAbsolutePath();
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path.toString()));
        for(T t : tList){
            os.writeObject(t);
        }
        os.close();
    }           
    
}
