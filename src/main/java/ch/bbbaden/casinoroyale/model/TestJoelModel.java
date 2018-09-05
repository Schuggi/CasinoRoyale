/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Joel
 */
public class TestJoelModel {

    public List<String> dice = new ArrayList();

    public void getDiceNR() {

        Random rand = new Random();
        Random rand2 = new Random();
        Random rand3 = new Random();
        Random rand4 = new Random();
        Random rand5 = new Random();

        int randomNum = rand.nextInt((6 - 1) + 1) + 1;
        int randomNum2 = rand.nextInt((6 - 1) + 1) + 1;
        int randomNum3 = rand.nextInt((6 - 1) + 1) + 1;
        int randomNum4 = rand.nextInt((6 - 1) + 1) + 1;
        int randomNum5 = rand.nextInt((6 - 1) + 1) + 1;

        getDice(randomNum, randomNum2, randomNum3, randomNum4, randomNum5);
    }

    public List getDice(int a, int b, int c, int d, int e) {

        dice.add("/Images/dice" + a + ".png");
        dice.add("/Images/dice" + b + ".png");
        dice.add("/Images/dice" + c + ".png");
        dice.add("/Images/dice" + d + ".png");
        dice.add("/Images/dice" + e + ".png");

        return dice;
    }
}
