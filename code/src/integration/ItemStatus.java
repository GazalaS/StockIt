/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public enum ItemStatus {
    RUNNING_LOW("Running Low"), NEED_TO_BUY("Need to Buy"), BROUGHT("Brought");
    private final String status;
    
    /**
     * This constructor Instantiates a new <code>{@link ItemStatus}</code>
     * @param status 
     */
    ItemStatus(String status) {
        this.status = status;
    }

    /**
     * This method returns the Status
     * @return status The current value of the status
     */
    @Override
    public String toString() {
        return status;
    }
}
