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
    private String status;

    ItemStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return status;
    }
}
