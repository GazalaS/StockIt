/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class WelcomeMessage {
    
    public void printWelcomeMessage(int countRunningLow, int countNeedToBuy){
        System.out.println("***********************");
        System.out.println("* Welcome to Stock It *");
        System.out.println("***********************");
        System.out.format(" %d items Running Low \n", countRunningLow);  //go back here!
        System.out.format(" %d items Need to Buy \n", countNeedToBuy); 
        System.out.println("***********************");
    }
}
