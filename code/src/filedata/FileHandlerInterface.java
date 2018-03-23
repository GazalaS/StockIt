/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedata;

import java.util.ArrayList;

/**
 *
 * @author "GazalaS <gazalafshaikh@gmail.com>"
 */
interface FileHandlerInterface<T> {

    ArrayList<T> readFromFile();

    void saveToFile(ArrayList<T> t);

}
