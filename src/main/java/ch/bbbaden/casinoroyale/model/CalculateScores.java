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
public class CalculateScores {

    public static int resultOnes = 0;
    public static int resultTwos = 0;
    public static int resultThrees = 0;
    public static int resultFours = 0;
    public static int resultFives = 0;
    public static int resultSixes = 0;
    public static int resultPair = 0;
    public static int resultTwoPairs = 0;
    public static int resultThreeOfaKind = 0;
    public static int resultFourOfaKind = 0;
    public static int resultSmallStraight = 0;
    public static int resultLargeStraight = 0;
    public static int resultFullHouse = 0;
    public static int resultChance = 0;
    public static int resultYatzy = 0;
    public static int resultSum = 0;
    public static int resultBonus = 0;

    /* Calculations */
    public static int calculateOnes(int[] dice) {
        int Ones = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 1) {
                Ones = Ones + dice[i];
            }
        }
        return Ones;
    }

    public static int calculateTwos(int[] dice) {
        int Twos = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 2) {
                Twos = Twos + dice[i];
            }
        }
        return Twos;
    }

    public static int calculateThrees(int[] dice) {
        int Threes = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 3) {
                Threes = Threes + dice[i];
            }
        }
        return Threes;
    }

    public static int calculateFours(int[] dice) {
        int Fours = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 4) {
                Fours = Fours + dice[i];
            }
        }
        return Fours;
    }

    public static int calculateFives(int[] dice) {
        int Fives = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 5) {
                Fives = Fives + dice[i];
            }
        }
        return Fives;
    }

    public static int calculateSixes(int[] dice) {
        int Sixes = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 6) {
                Sixes = Sixes + dice[i];
            }
        }
        return Sixes;
    }

    public static int calculateSum() {
        int sum = 0;
        sum = resultOnes + resultTwos + resultThrees + resultFours + resultFives + resultSixes;
        resultSum = sum;
        return sum;

    }

    public static int calculateBonus() {
        int currentSum = calculateSum();
        if (currentSum >= 63) {
            resultBonus = 50;
            return 50;
        } else {
            resultBonus = 0;
            return 0;
        }
    }

    public static int calculatePair(int[] dice) {

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

    public static int calculateTwoPairs(int[] dice) {
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

    public static int calculateThreeOfaKind(int[] dice) {
        int[] diceCopy = dice.clone();
        Arrays.sort(diceCopy);

        int sum = 0;
        int sumFinal = 0;
        //block for calculations
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

    public static int calculateFourOfaKind(int[] dice) {
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

    public static int calculateSmallStraight(int[] dice) {
        if (isSmallStraight(dice)) {
            return 15;
        } else {
            return 0;
        }
    }

    public static int calculateLargeStraight(int[] dice) {
        if (isLargeStraight(dice)) {
            return 20;
        } else {
            return 0;
        }
    }

    public static int calculateFullHouse(int[] dice) {
        if (isFourOfaKind(dice) || (isYatzy(dice))) {
            return 0;
        } else if (isThreeOfaKind(dice) && isPair(dice)) {
            //sum of all dices
            int sum = 0;
            for (int i = 0; i < dice.length; i++) {
                sum += dice[i];
            }
            return sum;
        } else {
            return 0;
        }
    }

    public static int calculateChance(int[] dice) {
        int chanceSum = 0;
        for (int i = 0; i < dice.length; i++) {
            chanceSum += dice[i];
        }
        return chanceSum;
    }

    public static int calculateYatzy(int[] dice) {
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
                        if (counter == 5) {
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

    public static int calculateTotal() {
        int totalSum;
        totalSum
                = resultSum + resultBonus + resultPair + resultTwoPairs + resultThreeOfaKind
                + resultFourOfaKind + resultSmallStraight + resultLargeStraight + resultFullHouse
                + resultChance + resultYatzy;
        return totalSum;
    }

    /*      isCheck conditions   */
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

    public static boolean isTwoPairs(int[] dice) {
        if ((!isFourOfaKind(dice)) && (!isYatzy(dice))) {     //if no Yatzy or 4oK
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
        } else {
            return false;   //4oK or Yatzy - impossible to have TwoPairs
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
