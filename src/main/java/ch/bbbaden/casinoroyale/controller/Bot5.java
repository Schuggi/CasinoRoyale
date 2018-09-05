/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import ch.bbbaden.casinoroyale.model.Bingo;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class Bot5 implements Initializable {

    @FXML
    private Label lblZ1;
    @FXML
    private Label lblZ2;
    @FXML
    private Label lblZ3;
    @FXML
    private ImageView img11;
    @FXML
    private ImageView img12;
    @FXML
    private ImageView img13;
    @FXML
    private ImageView img15;
    @FXML
    private Label lblZ6;
    @FXML
    private Label lblZ7;
    @FXML
    private Label lblZ8;
    @FXML
    private Label lblZ10;
    @FXML
    private Label lblZ9;
    @FXML
    private ImageView img21;
    @FXML
    private ImageView img22;
    @FXML
    private ImageView img23;
    @FXML
    private ImageView img24;
    @FXML
    private ImageView img25;
    @FXML
    private Label lblZ11;
    @FXML
    private Label lblZ12;
    @FXML
    private Label lblZ14;
    @FXML
    private Label lblZ13;
    @FXML
    private ImageView img31;
    @FXML
    private ImageView img32;
    @FXML
    private ImageView img34;
    @FXML
    private ImageView img35;
    @FXML
    private Label lblZ15;
    @FXML
    private Label lblZ16;
    @FXML
    private Label lblZ17;
    @FXML
    private Label lblZ19;
    @FXML
    private Label lblZ18;
    @FXML
    private ImageView img41;
    @FXML
    private ImageView img42;
    @FXML
    private ImageView img43;
    @FXML
    private ImageView img44;
    @FXML
    private ImageView img45;
    @FXML
    private Label lblZ20;
    @FXML
    private Label lblZ21;
    @FXML
    private Label lblZ22;
    @FXML
    private Label lblZ24;
    @FXML
    private Label lblZ23;
    @FXML
    private ImageView img51;
    @FXML
    private ImageView img52;
    @FXML
    private ImageView img53;
    @FXML
    private ImageView img54;
    @FXML
    private ImageView img55;
    @FXML
    private Label lblZ4;
    @FXML
    private ImageView img14;
    ArrayList<Integer> arr15 = new ArrayList();
    ArrayList<Integer> arr30 = new ArrayList();
    ArrayList<Integer> arr45 = new ArrayList();
    ArrayList<Integer> arr60 = new ArrayList();
    ArrayList<Integer> arr75 = new ArrayList();
    ArrayList<Integer> fullArray = new ArrayList();
    ArrayList<Integer> fullArrayPulledNumbers = new ArrayList();
    ArrayList<Integer> checkIfNumberPulled = new ArrayList();
    ArrayList<Integer> cardArray = new ArrayList();
    private Label[] labels;
    private Label[] labelZahlen;
    private Label[] labelBots;
    boolean bingoCall;
    boolean onlyOneCall = true;
    final Timeline timeForNextNumber = new Timeline();
    final Timeline countdown = new Timeline();
    Boolean winner;
    Integer fullArrayR;
    Integer winChip;
    String botName;
    Integer counterBot = 1;
    Integer starttime = 30;
    Integer seconds = starttime;
    Integer starttimeDuration = 30;
    Integer secondsDuration = starttimeDuration;
    Integer countdownInt = 10;
    Integer countdownGameInt = countdownInt;
    int counter = 0;
    String parseArrayR;
    BingoGameController bingoGameController = BingoGameController.getInstance();
    Bingo bingo = Bingo.getInstance();
    @FXML
    private Label lblZ5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for (int i = 1; i < 16; i++) {
            arr15.add(i);
        }
        for (int i = 16; i < 31; i++) {
            arr30.add(i);
        }
        for (int i = 31; i < 46; i++) {
            arr45.add(i);
        }
        for (int i = 46; i < 61; i++) {
            arr60.add(i);
        }
        for (int i = 61; i < 76; i++) {
            arr75.add(i);
        }
        for (int i = 1; i < 76; i++) {
            fullArray.add(i);
        }
        for (int i = 1; i < 76; i++) {
            fullArrayPulledNumbers.add(i);
        }
        Label[] zahlen115 = {lblZ1, lblZ2, lblZ3, lblZ4, lblZ5, lblZ6, lblZ7, lblZ8, lblZ9, lblZ9, lblZ10, lblZ11, lblZ12, lblZ13, lblZ14, lblZ15, lblZ16, lblZ17, lblZ18, lblZ19, lblZ20, lblZ21, lblZ22, lblZ23, lblZ24};
        labelZahlen = zahlen115;
        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            Integer array15 = arr15.get(rnd.nextInt(arr15.size()));
            labelZahlen[i].setText(String.valueOf(array15));
            arr15.remove(array15);
            fullArray.remove(array15);
            cardArray.add(array15);
        }
        for (int i = 5; i < 11; i++) {
            Random rnd = new Random();
            Integer array30 = arr30.get(rnd.nextInt(arr30.size()));
            labelZahlen[i].setText(String.valueOf(array30));
            arr30.remove(array30);
            fullArray.remove(array30);
            cardArray.add(array30);
        }
        for (int i = 11; i < 15; i++) {
            Random rnd = new Random();
            Integer array45 = arr45.get(rnd.nextInt(arr45.size()));
            labelZahlen[i].setText(String.valueOf(array45));
            arr45.remove(array45);
            fullArray.remove(array45);
            cardArray.add(array45);
        }
        for (int i = 15; i < 20; i++) {
            Random rnd = new Random();
            Integer array60 = arr60.get(rnd.nextInt(arr60.size()));
            labelZahlen[i].setText(String.valueOf(array60));
            arr60.remove(array60);
            fullArray.remove(array60);
            cardArray.add(array60);
        }
        for (int i = 20; i < 25; i++) {
            Random rnd = new Random();
            Integer array75 = arr75.get(rnd.nextInt(arr75.size()));
            labelZahlen[i].setText(String.valueOf(array75));
            arr75.remove(array75);
            fullArray.remove(array75);
            cardArray.add(array75);
        }
        // Timer CountDown
        KeyFrame countdownGame = new KeyFrame(javafx.util.Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                countdownGameInt--;
                String countdownGameStr = String.valueOf(countdownGameInt);
                if (countdownGameInt == 0) {
                    countdown.stop();
                    fullArrayR = ThreadLocalRandom.current().nextInt(1, 75 + 1);
                    String parsee = String.valueOf(fullArrayR);
                    checkIfNumberPulled.add(fullArrayR);
                    // Timer for Random Number every 30 Seconds
                    // Timer for Duration for next number
                    KeyFrame frameDuration = new KeyFrame(javafx.util.Duration.seconds(1), new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            secondsDuration--;
                            if (!fullArrayPulledNumbers.isEmpty()) {
                                if ((secondsDuration % bingo.durationBotNumber()) == 0) {
                                    counter++;
                                    Random rnd = new Random();
                                    fullArrayR = bingoGameController.randomBot();
                                    parseArrayR = String.valueOf(fullArrayR);
                                    fullArrayPulledNumbers.remove(fullArrayR);
                                    checkIfNumberPulled.add(fullArrayR);
                                    checkCrossed();
                                    try {
                                        checkAll();
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Bot1.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    try {
                                        bingoGameController.checkAll();
                                    } catch (SQLException ex) {
                                        Logger.getLogger(Bot1.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    secondsDuration = 30;
                                }
                            }
                        }
                    });
                    timeForNextNumber.setCycleCount(Timeline.INDEFINITE);
                    timeForNextNumber.getKeyFrames().add(frameDuration);
                    timeForNextNumber.play();
                }
            }
        });
        countdown.setCycleCount(Timeline.INDEFINITE);
        countdown.getKeyFrames().add(countdownGame);
        countdown.play();
    }

    private void checkCrossed() {
        if (lblZ1.getText().equals(parseArrayR)) {
            img11.setVisible(true);
        } else if (lblZ2.getText().equals(parseArrayR)) {
            img12.setVisible(true);
        } else if (lblZ3.getText().equals(parseArrayR)) {
            img13.setVisible(true);
        } else if (lblZ4.getText().equals(parseArrayR)) {
            img14.setVisible(true);
        } else if (lblZ5.getText().equals(parseArrayR)) {
            img15.setVisible(true);
        } else if (lblZ6.getText().equals(parseArrayR)) {
            img21.setVisible(true);
        } else if (lblZ7.getText().equals(parseArrayR)) {
            img22.setVisible(true);
        } else if (lblZ8.getText().equals(parseArrayR)) {
            img23.setVisible(true);
        } else if (lblZ9.getText().equals(parseArrayR)) {
            img24.setVisible(true);
        } else if (lblZ10.getText().equals(parseArrayR)) {
            img25.setVisible(true);
        } else if (lblZ11.getText().equals(parseArrayR)) {
            img31.setVisible(true);
        } else if (lblZ12.getText().equals(parseArrayR)) {
            img32.setVisible(true);
        } else if (lblZ13.getText().equals(parseArrayR)) {
            img34.setVisible(true);
        } else if (lblZ14.getText().equals(parseArrayR)) {
            img35.setVisible(true);
        } else if (lblZ15.getText().equals(parseArrayR)) {
            img41.setVisible(true);
        } else if (lblZ16.getText().equals(parseArrayR)) {
            img42.setVisible(true);
        } else if (lblZ17.getText().equals(parseArrayR)) {
            img43.setVisible(true);
        } else if (lblZ18.getText().equals(parseArrayR)) {
            img44.setVisible(true);
        } else if (lblZ19.getText().equals(parseArrayR)) {
            img45.setVisible(true);
        } else if (lblZ20.getText().equals(parseArrayR)) {
            img51.setVisible(true);
        } else if (lblZ21.getText().equals(parseArrayR)) {
            img52.setVisible(true);
        } else if (lblZ22.getText().equals(parseArrayR)) {
            img53.setVisible(true);
        } else if (lblZ23.getText().equals(parseArrayR)) {
            img54.setVisible(true);
        } else if (lblZ24.getText().equals(parseArrayR)) {
            img55.setVisible(true);
        }
    }

    private void checkIfCrossedVertical1() throws SQLException {
        if (img11.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ1.getText())) && img12.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ2.getText())) && img13.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ3.getText())) && img14.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ4.getText())) && img15.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ5.getText()))) {
            if (onlyOneCall == true) {
                bingoGameController.winner("Bot 5");
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
            }
        }
    }

    private void checkIfCrossedVertical2() throws SQLException {
        if (img21.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ6.getText())) && img22.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ7.getText())) && img23.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ8.getText())) && img24.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ9.getText())) && img25.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ10.getText()))) {
            if (onlyOneCall == true) {
                bingoGameController.winner("Bot 5");
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
            }
        }
    }

    private void checkIfCrossedVertical3() throws SQLException {
        if (img31.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ11.getText())) && img32.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ12.getText())) && img34.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ13.getText())) && img35.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ14.getText()))) {
            if (onlyOneCall == true) {
                bingoGameController.winner("Bot 5");
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
            }
        }
    }

    private void checkIfCrossedVertical4() throws SQLException {
        if (img41.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ15.getText())) && img42.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ16.getText())) && img43.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ17.getText())) && img44.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ18.getText())) && img45.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ19.getText()))) {
            if (onlyOneCall == true) {
                bingoGameController.winner("Bot 5");
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
            }
        }
    }

    private void checkIfCrossedVertical5() throws SQLException {
        if (img51.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ20.getText())) && img52.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ21.getText())) && img53.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ22.getText())) && img54.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ23.getText())) && img55.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ24.getText()))) {
            if (onlyOneCall == true) {
                bingoGameController.winner("Bot 5");
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
            }
        }
    }

    private void checkIfCrossedHorizontal1() throws SQLException {
        if (img11.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ1.getText())) && img21.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ6.getText())) && img31.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ11.getText())) && img41.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ15.getText())) && img51.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ20.getText()))) {
            if (onlyOneCall == true) {
                bingoGameController.winner("Bot 5");
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
            }
        }
    }

    private void checkIfCrossedHorizontal2() throws SQLException {
        if (img12.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ2.getText())) && img22.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ7.getText())) && img32.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ12.getText())) && img42.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ16.getText())) && img52.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ21.getText()))) {
            if (onlyOneCall == true) {
                bingoGameController.winner("Bot 5");
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
            }
        }
    }

    private void checkIfCrossedHorizontal3() throws SQLException {
        if (img13.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ3.getText())) && img23.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ8.getText())) && img43.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ17.getText())) && img53.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ22.getText()))) {
            if (onlyOneCall == true) {
                bingoGameController.winner("Bot 5");
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
            }
        }
    }

    private void checkIfCrossedHorizontal4() throws SQLException {
        if (img14.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ4.getText())) && img24.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ9.getText())) && img34.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ13.getText())) && img44.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ18.getText())) && img54.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ23.getText()))) {
            if (onlyOneCall == true) {
                bingoGameController.winner("Bot 5");
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
            }
        }
    }

    private void checkIfCrossedHorizontal5() throws SQLException {
        if (img15.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ5.getText())) && img25.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ10.getText())) && img35.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ14.getText())) && img45.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ19.getText())) && img55.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ24.getText()))) {
            if (onlyOneCall == true) {
                bingoGameController.winner("Bot 5");
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
            }
        }
    }

    private void checkIfDiagonal1() throws SQLException {
        if (img15.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ5.getText())) && img24.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ9.getText())) && img42.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ16.getText())) && img51.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ20.getText()))) {
            if (onlyOneCall == true) {
                bingoGameController.winner("Bot 5");
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
            }
        }
    }

    private void checkIfDiagonal2() throws SQLException {
        if (img55.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ24.getText())) && img44.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ18.getText())) && img22.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ7.getText())) && img11.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ1.getText()))) {
            if (onlyOneCall == true) {
                bingoGameController.winner("Bot 5");
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
            }
        }
    }

    private void checkAll() throws SQLException {
        checkIfCrossedVertical1();
        checkIfCrossedVertical2();
        checkIfCrossedVertical3();
        checkIfCrossedVertical4();
        checkIfCrossedVertical5();
        checkIfCrossedHorizontal1();
        checkIfCrossedHorizontal2();
        checkIfCrossedHorizontal3();
        checkIfCrossedHorizontal4();
        checkIfCrossedHorizontal5();
        checkIfDiagonal1();
        checkIfDiagonal2();
    }

}
