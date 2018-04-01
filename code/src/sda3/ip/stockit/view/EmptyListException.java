/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sda3.ip.stockit.view;

/**
 * Thrown when the List is empty while performing an operation when the list is empty.
 * The message might contain more information about the error condition.
 * @author "GazalaS gazalafshaikh@gmail.com"
 */
public class EmptyListException extends Exception {
    
    /**
     * This constructor Instantiates a new <code>{@link EmptyListException}</code>
     * representing the condition described in the specified message.
     * @param message A message that describes what went wrong
     */
    public EmptyListException(String message) {
        super(message);
    }
}
