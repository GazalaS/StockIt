/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public enum ItemCategory {
    EDIBLE("Edible"), INEDIBLE("Inedible");
    private String category;

    ItemCategory(String category) {
        this.category = category;
    }

    public String toString() {
        return category;
    }
}
