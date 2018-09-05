/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.model;

import java.util.Arrays;

/**
 *
 * @author Rafael Meier
 */
public class ScorePlayer {

    private final String name;

    private int resultOnes;
    private int resultTwos;
    private int resultThrees;
    private int resultFours;
    private int resultFives;
    private int resultSixes;
    private int resultPair;
    private int resultTwoPairs;
    private int resultThreeOfaKind;
    private int resultFourOfaKind;
    private int resultSmallStraight;
    private int resultLargeStraight;
    private int resultFullHouse;
    private int resultChance;
    private int resultYatzy;

    public boolean isSelectedOnes,
            isSelectedTwos,
            isSelectedThrees,
            isSelectedFours,
            isSelectedFives,
            isSelectedSixes,
            isSelectedPair,
            isSelectedTwoPairs,
            isSelectedThreeOfaKind,
            isSelectedFourOfaKind,
            isSelectedSmallStraight,
            isSelectedLargeStraight,
            isSelectedFullHouse,
            isSelectedChance,
            isSelectedYatzy;

    public boolean isBot;

    public ScorePlayer(String playerName) {
        this.name = playerName;

    }

    public String getName() {
        return name;
    }

    public int getResultOnes() {
        return resultOnes;
    }

    public int getResultTwos() {
        return resultTwos;
    }

    public int getResultThrees() {
        return resultThrees;
    }

    public int getResultFours() {
        return resultFours;
    }

    public int getResultFives() {
        return resultFives;
    }

    public int getResultSixes() {
        return resultSixes;
    }

    public int getResultPair() {
        return resultPair;
    }

    public int getResultTwoPairs() {
        return resultTwoPairs;
    }

    public int getResultThreeOfaKind() {
        return resultThreeOfaKind;
    }

    public int getResultFourOfaKind() {
        return resultFourOfaKind;
    }

    public int getResultSmallStraight() {
        return resultSmallStraight;
    }

    public int getResultLargeStraight() {
        return resultLargeStraight;
    }

    public int getResultFullHouse() {
        return resultFullHouse;
    }

    public int getResultChance() {
        return resultChance;
    }

    public int getResultYatzy() {
        return resultYatzy;
    }

    /**
     * Setters *
     */
    public void setResultOnes(int result) {
        this.resultOnes = result;
    }

    public void setResultTwos(int result) {
        this.resultTwos = result;
    }

    public void setResultThrees(int result) {
        this.resultThrees = result;
    }

    public void setResultFours(int result) {
        this.resultFours = result;
    }

    public void setResultFives(int result) {
        this.resultFives = result;
    }

    public void setResultSixes(int result) {
        this.resultSixes = result;
    }

    public void setResultPair(int result) {
        this.resultPair = result;
    }

    public void setResultTwoPairs(int result) {
        this.resultTwoPairs = result;
    }

    public void setResultThreeOfaKind(int result) {
        this.resultThreeOfaKind = result;
    }

    public void setResultFourOfaKind(int result) {
        this.resultFourOfaKind = result;
    }

    public void setResultSmallStraight(int result) {
        this.resultSmallStraight = result;
    }

    public void setResultLargeStraight(int result) {
        this.resultLargeStraight = result;
    }

    public void setResultFullHouse(int result) {
        this.resultFullHouse = result;
    }

    public void setResultChance(int result) {
        this.resultChance = result;
    }

    public void setResultYatzy(int result) {
        this.resultYatzy = result;
    }

    public static void setResultsZero(ScorePlayer player) {
        player.resultOnes = 0;
        player.resultTwos = 0;
        player.resultThrees = 0;
        player.resultFours = 0;
        player.resultFives = 0;
        player.resultSixes = 0;
        player.resultPair = 0;
        player.resultTwoPairs = 0;
        player.resultThreeOfaKind = 0;
        player.resultFourOfaKind = 0;
        player.resultSmallStraight = 0;
        player.resultLargeStraight = 0;
        player.resultFullHouse = 0;
        player.resultChance = 0;
        player.resultYatzy = 0;
    }

    public static void resetSelections(ScorePlayer player) {
        player.isSelectedOnes = false;
        player.isSelectedTwos = false;
        player.isSelectedThrees = false;
        player.isSelectedFours = false;
        player.isSelectedFives = false;
        player.isSelectedSixes = false;
        player.isSelectedPair = false;
        player.isSelectedTwoPairs = false;
        player.isSelectedThreeOfaKind = false;
        player.isSelectedFourOfaKind = false;
        player.isSelectedSmallStraight = false;
        player.isSelectedLargeStraight = false;
        player.isSelectedFullHouse = false;
        player.isSelectedChance = false;
        player.isSelectedYatzy = false;
    }


    /** Berechnungsmethoden **/

    public  int calculateOnes(int[] dice) {

   
    
    

        int Ones = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 1) {
                Ones = Ones + dice[i];
            }
        }
        return Ones;
    }

    public int calculateTwos(int[] dice) {
        int Twos = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 2) {
                Twos = Twos + dice[i];
            }
        }
        return Twos;
    }

    public int calculateThrees(int[] dice) {
        int Threes = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 3) {
                Threes = Threes + dice[i];
            }
        }
        return Threes;
    }

    public int calculateFours(int[] dice) {
        int Fours = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 4) {
                Fours = Fours + dice[i];
            }
        }
        return Fours;
    }

    public int calculateFives(int[] dice) {
        int Fives = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 5) {
                Fives = Fives + dice[i];
            }
        }
        return Fives;
    }

    public int calculateSixes(int[] dice) {
        int Sixes = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 6) {
                Sixes = Sixes + dice[i];
            }
        }
        return Sixes;
    }

    public int calculatePair(int[] dice) {

        boolean value = false;
        int[] diceCopy = dice.clone();
        Arrays.sort(diceCopy);
        int prev = 0;
        int resultFirstPair = 0;
        int resultSecondPair = 0;

        for (int i = 0; i < diceCopy.length; i++) {
            int current = diceCopy[i];
            if (current == prev) {
                if (resultFirstPair == 0) {
                    resultFirstPair = current * 2;
                    prev = 0;
                } else {
                    resultSecondPair = current * 2;
                }
            } else {
                prev = current;
            }
        }
        if (resultSecondPair > 0) {
            return resultSecondPair;
        } else {
            return resultFirstPair;
        }
    }

    public int calculateTwoPairs(int[] dice) {
        int[] diceCopy = dice.clone();
        Arrays.sort(diceCopy);
        int prev = 0;
        int result = 0;
        int pairs = 0;
        checkingBlock:
        {
            if (!isFourOfaKind(dice) && (!isYatzy(dice))) {
                for (int i = 0; i < diceCopy.length; i++) {
                    int current = diceCopy[i];
                    if (current == prev) {
                        result += current * 2;
                        pairs++;
                        prev = 0;
                    } else {
                        prev = current;
                    }
                }
                if (pairs == 2) {
                    return result;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    }

    public int calculateThreeOfaKind(int[] dice) {
        int[] diceCopy = dice.clone();
        Arrays.sort(diceCopy);

        int sum = 0;
        int sumFinal = 0;
        //Das ist der Block für berechnungen
        calculation:
        {
            for (int i = 0; i < diceCopy.length; i++) {
                int counter = 0;
                for (int f = 0; f < diceCopy.length; f++) {
                    if (diceCopy[i] == diceCopy[f]) {
                        counter++;
                        sum = sum + diceCopy[f];
                        if (counter == 3) {
                            sumFinal = sum;
                            break calculation;
                        }
                    } else {
                        sum = 0;
                        counter = 0;
                    }
                }
            }
        }
        return sumFinal;
    }

    public int calculateFourOfaKind(int[] dice) {
        int[] diceCopy = dice.clone();
        Arrays.sort(diceCopy);
        int sum = 0;
        int sumFinal = 0;

        calculation:
        {
            for (int i = 0; i < diceCopy.length; i++) {
                int counter = 0;
                for (int f = 0; f < diceCopy.length; f++) {
                    if (diceCopy[i] == diceCopy[f]) {
                        counter++;
                        sum = sum + diceCopy[f];
                        if (counter == 4) {
                            sumFinal = sum;
                            break calculation;
                        }
                    } else {
                        sum = 0;
                        counter = 0;
                    }
                }
            }
        }
        return sumFinal;
    }

    public int calculateSmallStraight(int[] dice) {
        if (isSmallStraight(dice)) {
            return 15;
        } else {
            return 0;
        }
    }

    public int calculateLargeStraight(int[] dice) {
        if (isLargeStraight(dice)) {
            return 20;
        } else {
            return 0;
        }
    }

    public int calculateFullHouse(int[] dice) {
        if (isFullHouse(dice)) {
            //sum von allen Würfeln
            int sum = 0;
            for (int i = 0; i < dice.length; i++) {
                sum += dice[i];
            }
            return sum;
        } else {
            return 0;
        }



       


    }

    public int calculateChance(int[] dice) {
        int chanceSum = 0;
        for (int i = 0; i < dice.length; i++) {
            chanceSum += dice[i];
        }
        return chanceSum;
    }

    public int calculateYatzy(int[] dice) {
        int[] diceCopy = dice.clone();
        Arrays.sort(diceCopy);
        int sumFinal = 0;
        calculation:
        {
            for (int i = 0; i < diceCopy.length; i++) {
                int counter = 0;
                for (int f = 0; f < diceCopy.length; f++) {
                    if (diceCopy[i] == diceCopy[f]) {
                        counter++;
                        if ((counter == 5) && (diceCopy[i] != 0)) {
                            sumFinal = 50;
                            break calculation;
                        }
                    } else {
                        break calculation;
                    }
                }
            }
        }
        return sumFinal;
    }


    




    /*      isCheck condition Methods   */

    public static boolean isPair(int[] dice) {
        int[] diceCopy = dice.clone();
        Arrays.sort(diceCopy);
        int prev = 0;
        int pairs = 0;

        for (int i = 0; i < diceCopy.length; i++) {
            int current = diceCopy[i];
            if (current == prev) {
                pairs++;
                prev = 0;
            } else {
                prev = current;
            }
        }

        if (pairs > 0) {
            return true;
        } else {
            return false;
        }
    }


    public  static boolean isTwoPairs(int[] dice) {
        if ((!isFourOfaKind(dice)) && (!isYatzy(dice))) {     //wenn kein Yatzy oder 4oK

   

            int[] diceCopy = dice.clone();
            Arrays.sort(diceCopy);
            int prev = 0;
            int pairs = 0;

            for (int i = 0; i < diceCopy.length; i++) {
                int current = diceCopy[i];
                if (current == prev) {
                    pairs++;
                    prev = 0;
                } else {
                    prev = current;
                }
            }
            if (pairs == 2) {
                return true;
            } else {
                return false;
            }

        }
        else{
            return false;   //4oK oder Yatzy - unmöglich 2 pairs zu haben

        

        }
    }

    public static boolean isThreeOfaKind(int[] dice) {
        int[] diceCopy = dice.clone();
        Arrays.sort(diceCopy);
        boolean value = false;
        checkingBlock:
        {
            for (int i = 0; i < diceCopy.length; i++) {
                int counter = 0;
                for (int f = 0; f < diceCopy.length; f++) {
                    if (diceCopy[i] == diceCopy[f]) {
                        counter++;
                        if (counter == 3) {
                            value = true;
                        }
                        if (counter == 4) {
                            value = false;
                        }
                        if (counter == 5) {
                            value = false;
                            break checkingBlock;
                        }
                    }
                }
            }
        }
        return value;
    }

    public static boolean isFourOfaKind(int[] dice) {
        int[] diceCopy = dice.clone();
        Arrays.sort(diceCopy);

        boolean value = false;
        checkingBlock:
        {
            for (int i = 0; i < diceCopy.length; i++) {
                int counter = 0;
                for (int f = 0; f < diceCopy.length; f++) {
                    if (diceCopy[i] == diceCopy[f]) {
                        counter++;
                        if (counter == 4) {
                            value = true;
                        }
                        if (counter == 5) {
                            value = false;
                            break checkingBlock;
                        }
                    }
                }
            }
        }
        return value;
    }

    public static boolean isSmallStraight(int[] dice) {
        int[] diceCopy = dice.clone();
        Arrays.sort(diceCopy);
        boolean condition = false;

        checkingBlock:
        {
            if (diceCopy[0] == 1) {
                for (int i = 0; i < diceCopy.length - 1; i++) {
                    if (diceCopy[i + 1] == diceCopy[i] + 1) {
                        condition = true;
                    } else {
                        condition = false;
                        break checkingBlock;
                    }
                }
            } else {
                return condition;
            }
        }
        return condition;
    }

    public static boolean isLargeStraight(int[] dice) {
        int[] diceCopy = dice.clone();
        Arrays.sort(diceCopy);
        boolean condition = false;

        checkingBlock:
        {
            if (diceCopy[0] == 2) {
                for (int i = 0; i < diceCopy.length - 1; i++) {
                    if (diceCopy[i + 1] == diceCopy[i] + 1) {
                        condition = true;
                    } else {
                        condition = false;
                        break checkingBlock;
                    }
                }
            } else {
                condition = false;
                break checkingBlock;
            }
        }
        return condition;
    }

    public static boolean isFullHouse(int[] dice) {
        if ((isThreeOfaKind(dice)) && (isTwoPairs(dice))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isYatzy(int[] dice) {
        int[] diceCopy = dice.clone();
        Arrays.sort(diceCopy);

        boolean value = false;
        checkingBlock:
        {
            for (int i = 0; i < diceCopy.length; i++) {
                int counter = 0;
                for (int f = 0; f < diceCopy.length; f++) {
                    if (diceCopy[i] == diceCopy[f]) {
                        counter++;
                        if (counter == 5) {
                            value = true;
                            break checkingBlock;
                        }
                    }
                }
            }
        }

        return value;
    }
}
