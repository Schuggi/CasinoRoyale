/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.model;

import java.util.Random;
import javafx.fxml.FXML;

/**
 *
 * @author Rafael Meier
 */
public class YatzyRoller {

    public static int[] dice = new int[5];
    public static boolean[] selectedDice = new boolean[5];
    private static int rollNum = 0;

    @FXML

    public static void rollDices(){
            rollNum++;
            Random randomGenerator = new Random();
            //Generiet random number und speichert diese in einem array
            for (int i = 0; i < dice.length; i++) {
                if (!selectedDice[i]) {
                    int randomInt = randomGenerator.nextInt(6) + 1;
                    dice[i] = randomInt;
                }

    
        }
    }

    public static int getRollNum() {
        return rollNum;
    }

    public static void resetRollNum() {
        rollNum = 0;
    }
}
