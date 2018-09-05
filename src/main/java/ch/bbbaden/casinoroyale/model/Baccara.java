/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.image.Image;

/**
 *
 * @author Joel
 */
public class Baccara {

    public List<String> dice = new ArrayList();
    //Random Zahlen
    private int randomNum;
    private int randomNum1;
    private int randomNum2;
    private int randomNum3;
    private int randomNum4;
    private int randomNum5;
    private int randomNum6;
    private int randomNum7;
    private int randomNum8;
    private int randomNum9;
    private int randomNumtest;
    //Punkte Total Player & Croupier
    private int pointsP;
    public int pointsP2;
    private int pointsC;
    public int pointsC2;

    public Image getCard() {
        //---Karte erstellen
        Random randtest = new Random();
        randomNumtest = randtest.nextInt((52 - 1) + 1) + 1;
        Image ptest = new Image("/Images/cards/card" + randomNumtest + ".png");

        return ptest;
    }

    public Image getCardPlayer1() {
        //---erste Karte des Spielers anzeigen---------------------------------------------------------------------------
        Random rand = new Random();
        randomNum = rand.nextInt((52 - 1) + 1) + 1;
        Image p1 = new Image("/Images/cards/Card" + randomNum + ".png");
        return p1;
    }

    public Image getCardPlayer2() {
        //---zweite Karte des Spielers anzeigen--------------------------------------------------------------------------
        Random rand1 = new Random();
        randomNum1 = rand1.nextInt((52 - 1) + 1) + 1;
        Image p2 = new Image("/Images/cards/Card" + randomNum1 + ".png");
        return p2;
    }

    public Image getCardPlayer3() {
        //---dritte Karte des Spielers anzeigen--------------------------------------------------------------------------
        Random rand5 = new Random();
        randomNum5 = rand5.nextInt((52 - 1) + 1) + 1;
        Image p3 = new Image("/Images/cards/Card" + randomNum5 + ".png");
        return p3;
    }

    public Image getCardCroupier1() {
        //---erste Karte des Croupiers anzeigen--------------------------------------------------------------------------
        Random rand2 = new Random();
        randomNum2 = rand2.nextInt((52 - 1) + 1) + 1;
        Image c1 = new Image("/Images/cards/Card" + randomNum2 + ".png");
        return c1;
    }

    public Image getCardCroupier2() {
        //---zweite Karte des Croupiers anzeigen-------------------------------------------------------------------------
        Random rand3 = new Random();
        randomNum3 = rand3.nextInt((52 - 1) + 1) + 1;
        Image c2 = new Image("/Images/cards/Card" + randomNum3 + ".png");
        return c2;
    }

    public Image getCardCroupier3() {
        //---dritte Karte des Croupiers anzeigen-------------------------------------------------------------------------
        Random rand9 = new Random();
        randomNum9 = rand9.nextInt((52 - 1) + 1) + 1;
        Image c3 = new Image("/Images/cards/Card" + randomNum9 + ".png");
        return c3;
    }

    public int getPointsPlayer() {
        int i = 0;
        //Erste Karte des Spielers Punkte zählen
        switch (randomNum) {
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 49:
            case 50:
            case 51:
            case 52:
                //kartenpunkte = 0
                i += 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                //punkte = 1
                i += 1;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                //punkte = 2
                i += 2;
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                //punkte = 3
                i += 3;
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                //punkte = 4
                i += 4;
                break;
            case 17:
            case 18:
            case 19:
            case 20:
                //punkte = 5
                i += 5;
                break;
            case 33:
            case 34:
            case 35:
            case 36:
                //punkte = 6
                i += 6;
                break;
            case 37:
            case 38:
            case 39:
            case 40:
                //punkte = 7
                i += 7;
                break;
            case 41:
            case 42:
            case 43:
            case 44:
                //punkte = 8
                i += 8;
                break;
            case 45:
            case 46:
            case 47:
            case 48:
                //punkte = 9
                i += 9;
                break;
            default:
                //alle rausnehmen nur für Testzweck
                System.out.println("Es ist ein Fehler aufgetreten!");
                break;
        }
        return i;
    }

    public int getPointsPlayer2() {
        int f = 0;
        //zweite Karte des Spielers Punkte zählen
        //----------------------------------------------------------------------------------------
        switch (randomNum1) {
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 49:
            case 50:
            case 51:
            case 52:
                //kartenpunkte = 0
                f += 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                //punkte = 1
                f += 1;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                //punkte = 2
                f += 2;
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                //punkte = 3
                f += 3;
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                //punkte = 4
                f += 4;
                break;
            case 17:
            case 18:
            case 19:
            case 20:
                //punkte = 5
                f += 5;
                break;
            case 33:
            case 34:
            case 35:
            case 36:
                //punkte = 6
                f += 6;
                break;
            case 37:
            case 38:
            case 39:
            case 40:
                //punkte = 7
                f += 7;
                break;
            case 41:
            case 42:
            case 43:
            case 44:
                //punkte = 8
                f += 8;
                break;
            case 45:
            case 46:
            case 47:
            case 48:
                //punkte = 9
                f += 9;
                break;
            default:
                System.out.println("Es ist ein Fehler aufgetreten!");
                break;
        }
        return f;
    }

    public int getPointsPlayer3() {
        int f = 0;
        //dritte Karte des Spielers Punkte zählen
        //----------------------------------------------------------------------------------------
        switch (randomNum5) {
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 49:
            case 50:
            case 51:
            case 52:
                //kartenpunkte = 0
                f += 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                //punkte = 1
                f += 1;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                //punkte = 2
                f += 2;
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                //punkte = 3
                f += 3;
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                //punkte = 4
                f += 4;
                break;
            case 17:
            case 18:
            case 19:
            case 20:
                //punkte = 5
                f += 5;
                break;
            case 33:
            case 34:
            case 35:
            case 36:
                //punkte = 6
                f += 6;
                break;
            case 37:
            case 38:
            case 39:
            case 40:
                //punkte = 7
                f += 7;
                break;
            case 41:
            case 42:
            case 43:
            case 44:
                //punkte = 8
                f += 8;
                break;
            case 45:
            case 46:
            case 47:
            case 48:
                //punkte = 9
                f += 9;
                break;
            default:
                System.out.println("Es ist ein Fehler aufgetreten!");
                break;
        }
        return f;
    }

    public int getPointsCroupier() {
        int e = 0;
        //Erste Karte des Croupiers Punkte zählen
        //----------------------------------------------------------------------------------------
        switch (randomNum3) {
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 49:
            case 50:
            case 51:
            case 52:
                //kartenpunkte = 0
                e += 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                //punkte = 1
                e += 1;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                //punkte = 2
                e += 2;
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                //punkte = 3
                e += 3;
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                //punkte = 4
                e += 4;
                break;
            case 17:
            case 18:
            case 19:
            case 20:
                //punkte = 5
                e += 5;
                break;
            case 33:
            case 34:
            case 35:
            case 36:
                //punkte = 6
                e += 6;
                break;
            case 37:
            case 38:
            case 39:
            case 40:
                //punkte = 7
                e += 7;
                break;
            case 41:
            case 42:
            case 43:
            case 44:
                //punkte = 8
                e += 8;
                break;
            case 45:
            case 46:
            case 47:
            case 48:
                //punkte = 9
                e += 9;
                break;
            default:
                System.out.println("Es ist ein Fehler aufgetreten!");
                break;
        }
        return e;
    }

    public int getPointsCroupier2() {
        int g = 0;

        //zweite Karte des Croupiers Punkte zählen
        //----------------------------------------------------------------------------------------
        switch (randomNum2) {
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 49:
            case 50:
            case 51:
            case 52:
                //kartenpunkte = 0
                g += 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                //punkte = 1
                g += 1;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                //punkte = 2
                g += 2;
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                //punkte = 3
                g += 3;
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                //punkte = 4
                g += 4;
                break;
            case 17:
            case 18:
            case 19:
            case 20:
                //punkte = 5
                g += 5;
                break;
            case 33:
            case 34:
            case 35:
            case 36:
                //punkte = 6
                g += 6;
                break;
            case 37:
            case 38:
            case 39:
            case 40:
                //punkte = 7
                g += 7;
                break;
            case 41:
            case 42:
            case 43:
            case 44:
                //punkte = 8
                g += 8;
                break;
            case 45:
            case 46:
            case 47:
            case 48:
                //punkte = 9
                g += 9;
                break;
            default:
                System.out.println("Es ist ein Fehler aufgetreten!");
                break;
        }
        return g;
    }

    public int getPointsCroupier3() {
        int g = 0;

        //dritte Karte des Croupiers Punkte zählen
        //----------------------------------------------------------------------------------------
        switch (randomNum9) {
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 49:
            case 50:
            case 51:
            case 52:
                //kartenpunkte = 0
                g += 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                //punkte = 1
                g += 1;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                //punkte = 2
                g += 2;
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                //punkte = 3
                g += 3;
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                //punkte = 4
                g += 4;
                break;
            case 17:
            case 18:
            case 19:
            case 20:
                //punkte = 5
                g += 5;
                break;
            case 33:
            case 34:
            case 35:
            case 36:
                //punkte = 6
                g += 6;
                break;
            case 37:
            case 38:
            case 39:
            case 40:
                //punkte = 7
                g += 7;
                break;
            case 41:
            case 42:
            case 43:
            case 44:
                //punkte = 8
                g += 8;
                break;
            case 45:
            case 46:
            case 47:
            case 48:
                //punkte = 9
                g += 9;
                break;
            default:
                System.out.println("Es ist ein Fehler aufgetreten!");
                break;
        }
        return g;
    }

    //Punkte von ersten beiden Karten des Spielers
    public int getPointsP() {

        pointsP = getPointsPlayer() + getPointsPlayer2();

        if (pointsP >= 10) {
            pointsP -= 10;
        }
        return pointsP;
    }

    //Punkte von ersten beiden Karten des Croupiers
    public int getPointsP2() {

        pointsP2 = pointsP + getPointsPlayer3();

        if (pointsP2 >= 10) {
            pointsP2 -= 10;
        }
        return pointsP2;
    }

    //Punkte der 2. udn 3. Karte des Spielers
    public int getPointsC() {
        pointsC = getPointsCroupier() + getPointsCroupier2();

        if (pointsC >= 10) {
            pointsC -= 10;
        }

        return pointsC;
    }

    //Punkte der 2. udn 3. Karte des Croupiers
    public int getPointsC2() {
        pointsC2 = pointsC + getPointsCroupier3();

        if (pointsC2 >= 10) {
            pointsC2 -= 10;
        }

        return pointsC2;
    }

}
