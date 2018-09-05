package ch.bbbaden.casinoroyale.model;

import ch.bbbaden.casinoroyale.controller.RouletteHauptScreenController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yanick Sclatter
 */
public class Roulette {

    private int chips;
    private int placedChips;
    private int radAusgabe;
    Random randomNo = new Random();
    private int gewinn;
    private int winCounter;

    private final ArrayList<RoulettePlacedChips> placementWon = new ArrayList();

    private final ArrayList<Integer> twoToOneTop = new ArrayList();
    private final ArrayList<Integer> twoToOneMid = new ArrayList();
    private final ArrayList<Integer> twoToOneBot = new ArrayList();
    private final ArrayList<Integer> first12 = new ArrayList();
    private final ArrayList<Integer> second12 = new ArrayList();
    private final ArrayList<Integer> third12 = new ArrayList();
    private final ArrayList<Integer> oneTo18 = new ArrayList();
    private final ArrayList<Integer> even = new ArrayList();
    private final ArrayList<Integer> red = new ArrayList();
    private final ArrayList<Integer> black = new ArrayList();
    private final ArrayList<Integer> odd = new ArrayList();
    private final ArrayList<Integer> nineteenTo36 = new ArrayList();
    Integer chipsSql;
    Actions actions = Actions.getInstance();
    Integer winUpdate;
    
    //ArrayLists mit mehreren Zahlen füllen für eine einfache Abfrage

    public void fillArayLists() {
        for (int i = 3; i <= 36; i++) {
            if (i % 3 == 0) {
                twoToOneTop.add(i);
            }

        }

        for (int i = 2; i <= 36; i++) {
            if (i % 3 == 2) {
                twoToOneMid.add(i);
            }

        }

        for (int i = 1; i <= 36; i++) {
            if (i % 3 == 1) {
                twoToOneBot.add(i);
            }

        }

        for (int i = 1; i <= 12; i++) {
            first12.add(i);
        }

        for (int i = 13; i <= 24; i++) {
            second12.add(i);
        }

        for (int i = 25; i <= 36; i++) {
            third12.add(i);
        }

        for (int i = 1; i <= 18; i++) {
            oneTo18.add(i);
        }

        for (int i = 1; i <= 18; i++) {
            oneTo18.add(i);
        }

        for (int i = 19; i <= 36; i++) {
            nineteenTo36.add(i);
        }

        for (int i = 2; i <= 36; i++) {
            if (i % 2 == 0) {
                even.add(i);
            }

        }

        for (int i = 1; i <= 36; i++) {
            if (i % 2 == 1) {
                odd.add(i);
            }

        }

        red.add(1);
        red.add(3);
        red.add(5);
        red.add(7);
        red.add(9);
        red.add(12);
        red.add(14);
        red.add(16);
        red.add(18);
        red.add(19);
        red.add(21);
        red.add(23);
        red.add(25);
        red.add(27);
        red.add(30);
        red.add(32);
        red.add(34);
        red.add(36);

        black.add(2);
        black.add(4);
        black.add(6);
        black.add(8);
        black.add(10);
        black.add(11);
        black.add(13);
        black.add(15);
        black.add(17);
        black.add(20);
        black.add(22);
        black.add(24);
        black.add(26);
        black.add(28);
        black.add(29);
        black.add(31);
        black.add(33);
        black.add(35);
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    //gesetzte Chips erhalten und setzten
    public int getPlacedChips() {
        return placedChips;
    }

    public void setPlacedChips(int placedChips) {
        this.placedChips = placedChips;
    }
    
    //auswertung wenn der Spieler auf eine richtige Zahl/Gruppe gesetzt hat 

    public void auswertung(int magicnumber, ArrayList<RoulettePlacedChips> placedChips) throws SQLException {
        System.out.println("\n***********\n" + magicnumber + "\n***********\n");
        gewinn = 0;
        placementWon.clear();

        for (RoulettePlacedChips rc : placedChips) {
            switch (rc.getChipName()) {

//                    
//              Straight Up Bets
//                    
                case "0":
                    if (magicnumber == 0) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }//todo
                    break;
                case "1":
                    if (magicnumber == 1) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "2":
                    if (magicnumber == 2) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "3":
                    if (magicnumber == 3) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "4":
                    if (magicnumber == 4) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "5":
                    if (magicnumber == 5) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "6":
                    if (magicnumber == 6) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "7":
                    if (magicnumber == 7) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "8":
                    if (magicnumber == 8) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "9":
                    if (magicnumber == 9) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "10":
                    if (magicnumber == 10) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "11":
                    if (magicnumber == 11) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "12":
                    if (magicnumber == 12) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "13":
                    if (magicnumber == 13) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "14":
                    if (magicnumber == 14) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "15":
                    if (magicnumber == 15) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "16":
                    if (magicnumber == 16) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "17":
                    if (magicnumber == 17) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "18":
                    if (magicnumber == 18) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "19":
                    if (magicnumber == 19) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "20":
                    if (magicnumber == 20) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "21":
                    if (magicnumber == 21) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "22":
                    if (magicnumber == 22) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "23":
                    if (magicnumber == 23) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "24":
                    if (magicnumber == 24) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "25":
                    if (magicnumber == 25) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "26":
                    if (magicnumber == 26) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "27":
                    if (magicnumber == 27) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "28":
                    if (magicnumber == 28) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "29":
                    if (magicnumber == 29) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "30":
                    if (magicnumber == 30) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "31":
                    if (magicnumber == 31) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "34":
                    if (magicnumber == 34) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "35":
                    if (magicnumber == 35) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "36":
                    if (magicnumber == 36) {
                        gewinn += rc.getAmount() * 35;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 35));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;

//                    
//              Gameboard Bets
//                    
                case "2to1top":
                    if (twoToOneTop.contains(magicnumber)) {
                        gewinn += rc.getAmount() * 2;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 2));
                        winCounter++;
                        System.out.println("Won on TOP.");
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;

                case "2to1center":
                    if (twoToOneMid.contains(magicnumber)) {
                        gewinn += rc.getAmount() * 2;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 2));
                        winCounter++;
                        System.out.println("Won on MID.");
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;

                case "2to1bottom":
                    if (twoToOneBot.contains(magicnumber)) {
                        gewinn += rc.getAmount() * 2;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 2));
                        winCounter++;
                        System.out.println("Won on BOT.");
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "First12":
                    if (first12.contains(magicnumber)) {
                        gewinn += rc.getAmount() * 2;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 2));
                        winCounter++;
                        System.out.println("Won on First12.");
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "Second12":
                    if (second12.contains(magicnumber)) {
                        gewinn += rc.getAmount() * 2;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 2));
                        winCounter++;
                        System.out.println("Won on Second12.");
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "Third12":
                    if (third12.contains(magicnumber)) {
                        gewinn += rc.getAmount() * 2;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 2));
                        winCounter++;
                        System.out.println("Won on Third12.");
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "1to18":
                    if (oneTo18.contains(magicnumber)) {
                        gewinn += rc.getAmount();

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount()));
                        winCounter++;
                        System.out.println("Won on 1to18.");
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "Even":
                    if (even.contains(magicnumber)) {
                        gewinn += rc.getAmount();

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount()));
                        winCounter++;
                        System.out.println("Won on Even.");
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "Red":
                    if (red.contains(magicnumber)) {
                        gewinn += rc.getAmount();

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount()));
                        winCounter++;
                        System.out.println("Won on Red.");
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "Black":
                    if (black.contains(magicnumber)) {
                        gewinn += rc.getAmount();

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount()));
                        winCounter++;
                        System.out.println("Won on Black.");
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "Odd":
                    if (odd.contains(magicnumber)) {
                        gewinn += rc.getAmount();

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount()));
                        winCounter++;
                        System.out.println("Won on Odd.");
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "19to36":
                    if (nineteenTo36.contains(magicnumber)) {
                        gewinn += rc.getAmount();

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount()));
                        winCounter++;
                        System.out.println("Won on 19to36.");
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }

//              Cross Bets      
//                    
//                    
                    break;
                case "1_2_4_5":
                    if (magicnumber == 1 || magicnumber == 2 || magicnumber == 4 || magicnumber == 5) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "2_3_5_6":
                    if (magicnumber == 2 || magicnumber == 3 || magicnumber == 5 || magicnumber == 6) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "5_6_8_9":
                    if (magicnumber == 5 || magicnumber == 6 || magicnumber == 8 || magicnumber == 9) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "4_5_7_8":
                    if (magicnumber == 4 || magicnumber == 5 || magicnumber == 7 || magicnumber == 8) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "7_8_10_11":
                    if (magicnumber == 7 || magicnumber == 8 || magicnumber == 10 || magicnumber == 11) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "8_9_11_12":
                    if (magicnumber == 8 || magicnumber == 9 || magicnumber == 11 || magicnumber == 12) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "10_11_13_14":
                    if (magicnumber == 10 || magicnumber == 11 || magicnumber == 13 || magicnumber == 14) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "11_12_14_15":
                    if (magicnumber == 11 || magicnumber == 12 || magicnumber == 14 || magicnumber == 15) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "13_14_16_17":
                    if (magicnumber == 13 || magicnumber == 14 || magicnumber == 16 || magicnumber == 17) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "14_15_17_18":
                    if (magicnumber == 14 || magicnumber == 15 || magicnumber == 17 || magicnumber == 18) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "17_18_20_21":
                    if (magicnumber == 17 || magicnumber == 18 || magicnumber == 20 || magicnumber == 21) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "16_17_19_20":
                    if (magicnumber == 16 || magicnumber == 17 || magicnumber == 19 || magicnumber == 20) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "19_20_22_23":
                    if (magicnumber == 19 || magicnumber == 20 || magicnumber == 22 || magicnumber == 23) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "20_21_23_24":
                    if (magicnumber == 20 || magicnumber == 21 || magicnumber == 23 || magicnumber == 24) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "22_23_25_26":
                    if (magicnumber == 22 || magicnumber == 23 || magicnumber == 25 || magicnumber == 26) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "23_24_26_27":
                    if (magicnumber == 23 || magicnumber == 24 || magicnumber == 26 || magicnumber == 27) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "26_27_29_30":
                    if (magicnumber == 26 || magicnumber == 27 || magicnumber == 29 || magicnumber == 30) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "25_26_28_29":
                    if (magicnumber == 1 || magicnumber == 2 || magicnumber == 4 || magicnumber == 5) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "28_29_31_32":
                    if (magicnumber == 28 || magicnumber == 29 || magicnumber == 31 || magicnumber == 32) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "29_30_32_33":
                    if (magicnumber == 29 || magicnumber == 30 || magicnumber == 32 || magicnumber == 33) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "31_32_34_35":
                    if (magicnumber == 31 || magicnumber == 32 || magicnumber == 34 || magicnumber == 35) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "32_33_35_36":
                    if (magicnumber == 32 || magicnumber == 33 || magicnumber == 35 || magicnumber == 36) {
                        gewinn += rc.getAmount() * 8;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 8));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;

//                    
//                    Split Bets vertical
//                    
                case "3_6":
                    if (magicnumber == 3 || magicnumber == 6) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "6_9":
                    if (magicnumber == 6 || magicnumber == 9) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "9_12":
                    if (magicnumber == 9 || magicnumber == 12) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "12_15":
                    if (magicnumber == 12 || magicnumber == 15) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "15_18":
                    if (magicnumber == 15 || magicnumber == 18) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                    }
                    break;
                case "18_21":
                    if (magicnumber == 18 || magicnumber == 21) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "21_24":
                    if (magicnumber == 21 || magicnumber == 24) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "24_27":
                    if (magicnumber == 24 || magicnumber == 27) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "27_30":
                    if (magicnumber == 27 || magicnumber == 30) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "30_33":
                    if (magicnumber == 30 || magicnumber == 33) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "33_36":
                    if (magicnumber == 3 || magicnumber == 6) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "0_3":
                    if (magicnumber == 0 || magicnumber == 3) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "0_2":
                    if (magicnumber == 0 || magicnumber == 2) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "0_1":
                    if (magicnumber == 0 || magicnumber == 1) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "2_5":
                    if (magicnumber == 2 || magicnumber == 5) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "5_8":
                    if (magicnumber == 5 || magicnumber == 8) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "8_11":
                    if (magicnumber == 8 || magicnumber == 118) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "11_14":
                    if (magicnumber == 11 || magicnumber == 14) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "14_17":
                    if (magicnumber == 14 || magicnumber == 17) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "17_20":
                    if (magicnumber == 17 || magicnumber == 20) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "20_23":
                    if (magicnumber == 20 || magicnumber == 23) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "23_26":
                    if (magicnumber == 23 || magicnumber == 26) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "26_29":
                    if (magicnumber == 26 || magicnumber == 29) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "29_32":
                    if (magicnumber == 29 || magicnumber == 32) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "32_35":
                    if (magicnumber == 32 || magicnumber == 35) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "1_4":
                    if (magicnumber == 1 || magicnumber == 4) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "4_7":
                    if (magicnumber == 5 || magicnumber == 8) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "7_10":
                    if (magicnumber == 7 || magicnumber == 10) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "10_13":
                    if (magicnumber == 10 || magicnumber == 13) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "13_16":
                    if (magicnumber == 13 || magicnumber == 16) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "16_19":
                    if (magicnumber == 16 || magicnumber == 19) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "19_22":
                    if (magicnumber == 19 || magicnumber == 22) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "22_25":
                    if (magicnumber == 22 || magicnumber == 25) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "25_28":
                    if (magicnumber == 25 || magicnumber == 28) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "28_31":
                    if (magicnumber == 28 || magicnumber == 31) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "31_34":
                    if (magicnumber == 31 || magicnumber == 34) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;

//                    
//                    Split Bets vertical
//                    
                case "1_2":
                    if (magicnumber == 1 || magicnumber == 2) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "4_5":
                    if (magicnumber == 4 || magicnumber == 5) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "7_8":
                    if (magicnumber == 7 || magicnumber == 8) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "10_11":
                    if (magicnumber == 10 || magicnumber == 11) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "13_14":
                    if (magicnumber == 13 || magicnumber == 14) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "16_17":
                    if (magicnumber == 16 || magicnumber == 17) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "19_20":
                    if (magicnumber == 19 || magicnumber == 20) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "22_23":
                    if (magicnumber == 22 || magicnumber == 23) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "25_26":
                    if (magicnumber == 25 || magicnumber == 26) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "28_29":
                    if (magicnumber == 28 || magicnumber == 29) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "31_32":
                    if (magicnumber == 31 || magicnumber == 32) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "2_3":
                    if (magicnumber == 2 || magicnumber == 3) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "5_6":
                    if (magicnumber == 5 || magicnumber == 6) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "8_9":
                    if (magicnumber == 8 || magicnumber == 9) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "11_12":
                    if (magicnumber == 11 || magicnumber == 12) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "14_15":
                    if (magicnumber == 14 || magicnumber == 15) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "17_18":
                    if (magicnumber == 17 || magicnumber == 18) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "20_21":
                    if (magicnumber == 20 || magicnumber == 21) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "23_24":
                    if (magicnumber == 23 || magicnumber == 24) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "26_27":
                    if (magicnumber == 26 || magicnumber == 27) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "29_30":
                    if (magicnumber == 29 || magicnumber == 30) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "32_33":
                    if (magicnumber == 32 || magicnumber == 33) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "35_36":
                    if (magicnumber == 35 || magicnumber == 36) {
                        gewinn += rc.getAmount() * 17;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 17));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;

//                    
//              Five Number Bets      
//                    
                case "1_456":
                    if (magicnumber == 1 || magicnumber == 4 || magicnumber == 5 || magicnumber == 6) {
                        gewinn += rc.getAmount() * 6;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 6));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "4_789":
                    if (magicnumber == 4 || magicnumber == 7 || magicnumber == 8 || magicnumber == 9) {
                        gewinn += rc.getAmount() * 6;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 6));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "7_101112":
                    if (magicnumber == 7 || magicnumber == 10 || magicnumber == 11 || magicnumber == 12) {
                        gewinn += rc.getAmount() * 6;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 6));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "10_131415":
                    if (magicnumber == 10 || magicnumber == 13 || magicnumber == 14 || magicnumber == 15) {
                        gewinn += rc.getAmount() * 6;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 6));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "13_161718":
                    if (magicnumber == 13 || magicnumber == 16 || magicnumber == 17 || magicnumber == 18) {
                        gewinn += rc.getAmount() * 6;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 6));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "16_192021":
                    if (magicnumber == 16 || magicnumber == 19 || magicnumber == 20 || magicnumber == 21) {
                        gewinn += rc.getAmount() * 6;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 6));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "19_222324":
                    if (magicnumber == 19 || magicnumber == 22 || magicnumber == 23 || magicnumber == 24) {
                        gewinn += rc.getAmount() * 6;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 6));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "22_252627":
                    if (magicnumber == 22 || magicnumber == 25 || magicnumber == 26 || magicnumber == 27) {
                        gewinn += rc.getAmount() * 6;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 6));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "25_282930":
                    if (magicnumber == 25 || magicnumber == 28 || magicnumber == 29 || magicnumber == 30) {
                        gewinn += rc.getAmount() * 6;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 6));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "28_313233":
                    if (magicnumber == 28 || magicnumber == 31 || magicnumber == 32 || magicnumber == 33) {
                        gewinn += rc.getAmount() * 6;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 6));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "31_343536":
                    if (magicnumber == 31 || magicnumber == 34 || magicnumber == 35 || magicnumber == 36) {
                        gewinn += rc.getAmount() * 6;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 6));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "0_123":
                    if (magicnumber == 0 || magicnumber == 1 || magicnumber == 2 || magicnumber == 3) {
                        gewinn += rc.getAmount() * 6;

                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 6));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;

//                    
//                  Street Bets  
//                    
                case "1_2_3":
                    if (magicnumber == 1 || magicnumber == 2 || magicnumber == 3) {
                        gewinn += rc.getAmount() * 11;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 11));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "4_5_6":
                    if (magicnumber == 4 || magicnumber == 5 || magicnumber == 6) {
                        gewinn += rc.getAmount() * 11;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 11));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "7_8_9":
                    if (magicnumber == 7 || magicnumber == 8 || magicnumber == 9) {
                        gewinn += rc.getAmount() * 11;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 11));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "10_11_12":
                    if (magicnumber == 10 || magicnumber == 11 || magicnumber == 12) {
                        gewinn += rc.getAmount() * 11;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 11));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "13_14_15":
                    if (magicnumber == 13 || magicnumber == 14 || magicnumber == 15) {
                        gewinn += rc.getAmount() * 11;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 11));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "16_17_18":
                    if (magicnumber == 16 || magicnumber == 17 || magicnumber == 18) {
                        gewinn += rc.getAmount() * 11;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 11));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "19_20_21":
                    if (magicnumber == 19 || magicnumber == 20 || magicnumber == 21) {
                        gewinn += rc.getAmount() * 11;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 11));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "22_23_24":
                    if (magicnumber == 22 || magicnumber == 23 || magicnumber == 24) {
                        gewinn += rc.getAmount() * 11;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 11));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "25_26_27":
                    if (magicnumber == 25 || magicnumber == 26 || magicnumber == 27) {
                        gewinn += rc.getAmount() * 11;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 11));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "28_29_30":
                    if (magicnumber == 28 || magicnumber == 29 || magicnumber == 30) {
                        gewinn += rc.getAmount() * 11;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 11));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "31_32_33":
                    if (magicnumber == 31 || magicnumber == 32 || magicnumber == 33) {
                        gewinn += rc.getAmount() * 11;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 11));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "34_35_36":
                    if (magicnumber == 1 || magicnumber == 2 || magicnumber == 3) {
                        gewinn += rc.getAmount() * 11;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 11));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "0_2_3":
                    if (magicnumber == 0 || magicnumber == 2 || magicnumber == 3) {
                        gewinn += rc.getAmount() * 11;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 11));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;
                case "0_1_2":
                    if (magicnumber == 0 || magicnumber == 1 || magicnumber == 2) {
                        gewinn += rc.getAmount() * 11;
                        placementWon.add(new RoulettePlacedChips(rc.getChipName(), rc.getAmount() * 11));
                        winCounter++;
                        updateWin();
                        winUpdate = actions.getWinRoulette() + gewinn;
                        updateGewinn();
                        winUpdate = 0;
                    }
                    break;

                default:
                    System.out.println("Better Luck next Time on " + rc.getChipName());
                    System.out.println(actions.getChips);
            }
//            Datenbank

        }
        System.out.println("\n\n\n**************************\n" + gewinn + "\n**************************\n");
    }
    
    //Random Zahl für Das Rad
    
    public int getRandom36() {
        return randomNo.nextInt(37) - 1;
    }
    
    //Übergabe der gewonnen Chips

    public ArrayList<RoulettePlacedChips> getPlacementWon() {
        return placementWon;
    }

    //Datenbank Methoden
    public void updateWin() throws SQLException {
        RouletteHauptScreenController rouletteHauptScreen = RouletteHauptScreenController.getInstance();
        chipsSql = rouletteHauptScreen.chipAmount();
        Integer chipAmount = actions.getChipsRoulette();
        rouletteHauptScreen.chipAmount();
        Integer sum = chipAmount + gewinn + chipsSql;
        System.out.println("ChipAmount " + chipAmount);
        System.out.println("Gewinn " + gewinn);
        System.out.println("chipsSql " + chipsSql);
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        try (PreparedStatement ps = connection.prepareStatement(
                "update users set chips = ? where email like " + actions.getEmail())) {
            ps.setInt(1, sum);
            ps.executeUpdate();
        }
    }

    private void updateGewinn() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        try (PreparedStatement psBingo = connection.prepareStatement(
                "update logroulette set gewinn = ? where user like " + actions.getEmail())) {
            psBingo.setInt(1, winUpdate);
            psBingo.executeUpdate();
        }
    }

}
