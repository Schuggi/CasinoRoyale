/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import static ch.bbbaden.casinoroyale.controller.RouletteHauptScreenController.rootP;
import ch.bbbaden.casinoroyale.model.YatzyRoller;

import ch.bbbaden.casinoroyale.model.Actions;

import ch.bbbaden.casinoroyale.model.ScorePlayer;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Rafael Meier
 */
public class YatzyController implements Initializable {

    @FXML
    Actions actions = Actions.getInstance();

    public Image imageOne = new Image("/Images/dice1.png");
    public Image imageTwo = new Image("/Images/dice2.png");
    public Image imageThree = new Image("/Images/dice3.png");
    public Image imageFour = new Image("/Images/dice4.png");
    public Image imageFive = new Image("/Images/dice5.png");
    public Image imageSix = new Image("/Images/dice6.png");
    public Image imageRollingDices = new Image("/Images/diceanimation.gif");

    @FXML
    public Label display1Ones;
    @FXML
    public Label display1Twos;
    @FXML
    public Label display1Threes;
    @FXML
    public Label display1Fours;
    @FXML
    public Label display1Fives;
    @FXML
    public Label display1Sixes;
    @FXML
    public Label display1Sum;
    @FXML
    public Label display1Bonus;
    @FXML
    public Label display1Pair;
    @FXML
    public Label display1TwoPairs;
    @FXML
    public Label display1ThreeOfaKind;
    @FXML
    public Label display1FourOfaKind;
    @FXML
    public Label display1SmallStraight;
    @FXML
    public Label display1LargeStraight;
    @FXML
    public Label display1FullHouse;
    @FXML
    public Label display1Chance;
    @FXML
    public Label display1Yatzy;
    @FXML
    public Label display1Total;

    @FXML
    public Label display2Ones;
    @FXML
    public Label display2Twos;
    @FXML
    public Label display2Threes;
    @FXML
    public Label display2Fours;
    @FXML
    public Label display2Fives;
    @FXML
    public Label display2Sixes;
    @FXML
    public Label display2Sum;
    @FXML
    public Label display2Bonus;
    @FXML
    public Label display2Pair;
    @FXML
    public Label display2TwoPairs;
    @FXML
    public Label display2ThreeOfaKind;
    @FXML
    public Label display2FourOfaKind;
    @FXML
    public Label display2SmallStraight;
    @FXML
    public Label display2LargeStraight;
    @FXML
    public Label display2FullHouse;
    @FXML
    public Label display2Chance;
    @FXML
    public Label display2Yatzy;
    @FXML
    public Label display2Total;

    @FXML
    public Rectangle rectangle1Ones;
    @FXML
    public Rectangle rectangle1Twos;
    @FXML
    public Rectangle rectangle1Threes;
    @FXML
    public Rectangle rectangle1Fours;
    @FXML
    public Rectangle rectangle1Fives;
    @FXML
    public Rectangle rectangle1Sixes;
    @FXML
    public Rectangle rectangle1Sum;
    @FXML
    public Rectangle rectangle1Bonus;
    @FXML
    public Rectangle rectangle1Pair;
    @FXML
    public Rectangle rectangle1TwoPairs;
    @FXML
    public Rectangle rectangle1ThreeOfaKind;
    @FXML
    public Rectangle rectangle1FourOfaKind;
    @FXML
    public Rectangle rectangle1SmallStraight;
    @FXML
    public Rectangle rectangle1LargeStraight;
    @FXML
    public Rectangle rectangle1FullHouse;
    @FXML
    public Rectangle rectangle1Chance;
    @FXML
    public Rectangle rectangle1Yatzy;
    @FXML
    public Rectangle rectangle1Total;

    @FXML
    public Rectangle rectangle2Ones;
    @FXML
    public Rectangle rectangle2Twos;
    @FXML
    public Rectangle rectangle2Threes;
    @FXML
    public Rectangle rectangle2Fours;
    @FXML
    public Rectangle rectangle2Fives;
    @FXML
    public Rectangle rectangle2Sixes;
    @FXML
    public Rectangle rectangle2Sum;
    @FXML
    public Rectangle rectangle2Bonus;
    @FXML
    public Rectangle rectangle2Pair;
    @FXML
    public Rectangle rectangle2TwoPairs;
    @FXML
    public Rectangle rectangle2ThreeOfaKind;
    @FXML
    public Rectangle rectangle2FourOfaKind;
    @FXML
    public Rectangle rectangle2SmallStraight;
    @FXML
    public Rectangle rectangle2LargeStraight;
    @FXML
    public Rectangle rectangle2FullHouse;
    @FXML
    public Rectangle rectangle2Chance;
    @FXML
    public Rectangle rectangle2Yatzy;
    @FXML
    public Rectangle rectangle2Total;

    @FXML
    public Label displayPlayerOneName;

    @FXML
    public Label remainingRolls;

    @FXML
    public ImageView mainMenuButton;

    @FXML
    public ImageView diceZero;
    @FXML
    public ImageView diceOne;
    @FXML
    public ImageView diceTwo;
    @FXML
    public ImageView diceThree;
    @FXML
    public ImageView diceFour;
    @FXML
    private ImageView clickedDiceZero;
    @FXML
    private ImageView clickedDiceOne;
    @FXML
    private ImageView clickedDiceTwo;
    @FXML
    private ImageView clickedDiceThree;
    @FXML
    private ImageView clickedDiceFour;

    @FXML
    private Button rollButton;

    public int themeChar = 1;

    public boolean playerOneTurn = false;
    public boolean playerTwoTurn = false;
    public int totalResultOne;
    public int totalResultTwo;
    public int sumOne;
    public int sumTwo;
    public int bonusOne;
    public int bonusTwo;
    String winnerPlayer;
    String drawPlayer;

    Integer gewinn;
    Integer verlustVerlust;
    Integer gewinnGewinn;

    public int numTurns = 0;
    YatzyStartScreenController yatzyStart = YatzyStartScreenController.getInstance();

    @FXML
    private Rectangle rollsRectangle;

    public ScorePlayer playerOne;
    public ScorePlayer playerTwo;
   

    @FXML
    private JFXDrawer JFXMenu;
    @FXML
    private JFXHamburger JFXMenuButton;
    @FXML
    private AnchorPane ApYatzy;

    @FXML
    private Label lblActiveUser;
    @FXML
    private Label lblChips;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootP = ApYatzy;

        lblActiveUser.setText(actions.getUsername());
        try {
            lblChips.setText(String.valueOf(actions.getChipsRoulette()));
        } catch (SQLException ex) {
            Logger.getLogger(YatzyController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            VBox box = FXMLLoader.load(getClass().getResource("/fxml/Menu/Menu.fxml"));
            JFXMenu.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(RouletteHauptScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(JFXMenuButton);
        transition.setRate(-1);
        JFXMenuButton.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            if (JFXMenu.isShown()) {
                JFXMenu.close();
            } else {
                JFXMenu.open();
            }

        });
        //Namensanzeige auf dem Scoresheet
        playerOne = new ScorePlayer(actions.getUsername());
        playerTwo = new ScorePlayer("bot1");

        DropShadow ds = new DropShadow();
        ds.setOffsetY(2.0);
        ds.setOffsetX(2.0);
        ds.setColor(Color.GRAY);

        resetRollsRectanglesDices();
        
//Alles wird zurückgesetz am Anfang
        rollButton.setEffect(ds);
        resetEverything();
        ScorePlayer.setResultsZero(playerOne);
        ScorePlayer.setResultsZero(playerTwo);
        ScorePlayer.resetSelections(playerOne);
        ScorePlayer.resetSelections(playerTwo);

        displayPlayerOneName.setText(actions.getUsername());

    }

    @FXML
    private void btnroll(ActionEvent event) throws IOException {
        Roll();
        stopRollingDices();
    }

    public void Roll() {
        setRemainingRolls();
        YatzyRoller.rollDices();
        showCurrentPlayerResults();
        if (YatzyRoller.getRollNum() < 3) {
            startRollingDices();
        } else if (YatzyRoller.getRollNum() == 3) {
            disableRollButon();
            startRollingDices();
        } else {
            rollButton.setDisable(true);
        }
    }

    public int remainingRolls() {
        int rolls = 2;
        return rolls - YatzyRoller.getRollNum();
    }

    public void setRemainingRolls() {
        remainingRolls.setText(String.valueOf(remainingRolls()));
    }

    public void startRollingDices() {
        diceZero.setEffect(null);
        diceOne.setEffect(null);
        diceTwo.setEffect(null);
        diceThree.setEffect(null);
        diceFour.setEffect(null);

        if (!YatzyRoller.selectedDice[0]) {
            diceZero.setImage(imageRollingDices);
        }

        if (!YatzyRoller.selectedDice[1]) {
            diceOne.setImage(imageRollingDices);
        }

        if (!YatzyRoller.selectedDice[2]) {
            diceTwo.setImage(imageRollingDices);
        }

        if (!YatzyRoller.selectedDice[3]) {
            diceThree.setImage(imageRollingDices);
        }

        if (!YatzyRoller.selectedDice[4]) {
            diceFour.setImage(imageRollingDices);
        }
    }

    public void stopRollingDices() {

        PauseTransition delay0 = new PauseTransition(Duration.seconds(0.5));
        delay0.setOnFinished(event -> setDice0Image());

        PauseTransition delay1 = new PauseTransition(Duration.seconds(0.53));
        delay1.setOnFinished(event -> setDice1Image());

        PauseTransition delay2 = new PauseTransition(Duration.seconds(0.56));
        delay2.setOnFinished(event -> setDice2Image());

        PauseTransition delay3 = new PauseTransition(Duration.seconds(0.59));
        delay3.setOnFinished(event -> setDice3Image());

        PauseTransition delay4 = new PauseTransition(Duration.seconds(0.62));
        delay4.setOnFinished(event -> setDice4Image());

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                delay0,
                delay1,
                delay2,
                delay3,
                delay4
        );
        parallelTransition.setCycleCount(1);
        parallelTransition.play();
    }
//Alle enable und disable
    public void enableRollButon() {
        rollButton.setDisable(false);

    }

    public void disableRollButon() {
        rollButton.setDisable(true);

    }

    ;
     public void enableDisplayOne() {
        display1Ones.setDisable(false);
        display1Twos.setDisable(false);
        display1Threes.setDisable(false);
        display1Fours.setDisable(false);
        display1Fives.setDisable(false);
        display1Sixes.setDisable(false);
        display1Pair.setDisable(false);
        display1TwoPairs.setDisable(false);
        display1ThreeOfaKind.setDisable(false);
        display1FourOfaKind.setDisable(false);
        display1SmallStraight.setDisable(false);
        display1LargeStraight.setDisable(false);
        display1FullHouse.setDisable(false);
        display1Chance.setDisable(false);
        display1Yatzy.setDisable(false);

    }

    public void disableDisplayOne() {
        display1Ones.setDisable(true);
        display1Twos.setDisable(true);
        display1Threes.setDisable(true);
        display1Fours.setDisable(true);
        display1Fives.setDisable(true);
        display1Sixes.setDisable(true);
        display1Pair.setDisable(true);
        display1TwoPairs.setDisable(true);
        display1ThreeOfaKind.setDisable(true);
        display1FourOfaKind.setDisable(true);
        display1SmallStraight.setDisable(true);
        display1LargeStraight.setDisable(true);
        display1FullHouse.setDisable(true);
        display1Chance.setDisable(true);
        display1Yatzy.setDisable(true);
    }

    public void enableDisplayTwo() {
        display2Ones.setDisable(false);
        display2Twos.setDisable(false);
        display2Threes.setDisable(false);
        display2Fours.setDisable(false);
        display2Fives.setDisable(false);
        display2Sixes.setDisable(false);
        display2Pair.setDisable(false);
        display2TwoPairs.setDisable(false);
        display2ThreeOfaKind.setDisable(false);
        display2FourOfaKind.setDisable(false);
        display2SmallStraight.setDisable(false);
        display2LargeStraight.setDisable(false);
        display2FullHouse.setDisable(false);
        display2Chance.setDisable(false);
        display2Yatzy.setDisable(false);
    }

    public void disableDisplayTwo() {
        display2Ones.setDisable(true);
        display2Twos.setDisable(true);
        display2Threes.setDisable(true);
        display2Fours.setDisable(true);
        display2Fives.setDisable(true);
        display2Sixes.setDisable(true);
        display2Pair.setDisable(true);
        display2TwoPairs.setDisable(true);
        display2ThreeOfaKind.setDisable(true);
        display2FourOfaKind.setDisable(true);
        display2SmallStraight.setDisable(true);
        display2LargeStraight.setDisable(true);
        display2FullHouse.setDisable(true);
        display2Chance.setDisable(true);
        display2Yatzy.setDisable(true);
    }
// Alles was auf den Screen kopiert wird
    
    public void printCategoriesResults1() {
        calculateTotalOne();
        calculateSumOne();
        calculateBonusOne();

        if (!playerOne.isSelectedOnes) {
            String score = String.valueOf(playerOne.calculateOnes(YatzyRoller.dice));
            display1Ones.setText(score);
        } else {
            display1Ones.setText(String.valueOf(playerOne.getResultOnes()));
        }
        if (!playerOne.isSelectedTwos) {
            String score = String.valueOf(playerOne.calculateTwos(YatzyRoller.dice));
            display1Twos.setText(score);
        } else {
            display1Twos.setText(String.valueOf(playerOne.getResultTwos()));
        }
        if (!playerOne.isSelectedThrees) {
            String score = String.valueOf(playerOne.calculateThrees(YatzyRoller.dice));
            display1Threes.setText(score);
        } else {
            display1Threes.setText(String.valueOf(playerOne.getResultThrees()));
        }
        if (!playerOne.isSelectedFours) {
            String score = String.valueOf(playerOne.calculateFours(YatzyRoller.dice));
            display1Fours.setText(score);
        } else {
            display1Fours.setText(String.valueOf(playerOne.getResultFours()));
        }
        if (!playerOne.isSelectedFives) {
            String score = String.valueOf(playerOne.calculateFives(YatzyRoller.dice));
            display1Fives.setText(score);
        } else {
            display1Fives.setText(String.valueOf(playerOne.getResultFives()));
        }
        if (!playerOne.isSelectedSixes) {
            String score = String.valueOf(playerOne.calculateSixes(YatzyRoller.dice));
            display1Sixes.setText(score);
        } else {
            display1Sixes.setText(String.valueOf(playerOne.getResultSixes()));
        }
        if (!playerOne.isSelectedPair) {
            String score = String.valueOf(playerOne.calculatePair(YatzyRoller.dice));
            display1Pair.setText(score);
        } else {
            display1Pair.setText(String.valueOf(playerOne.getResultPair()));
        }
        if (!playerOne.isSelectedTwoPairs) {
            String score = String.valueOf(playerOne.calculateTwoPairs(YatzyRoller.dice));
            display1TwoPairs.setText(score);
        } else {
            display1TwoPairs.setText(String.valueOf(playerOne.getResultTwoPairs()));
        }
        if (!playerOne.isSelectedThreeOfaKind) {
            String score = String.valueOf(playerOne.calculateThreeOfaKind(YatzyRoller.dice));
            display1ThreeOfaKind.setText(score);
        } else {
            display1ThreeOfaKind.setText(String.valueOf(playerOne.getResultThreeOfaKind()));
        }
        if (!playerOne.isSelectedFourOfaKind) {
            String score = String.valueOf(playerOne.calculateFourOfaKind(YatzyRoller.dice));
            display1FourOfaKind.setText(score);
        } else {
            display1FourOfaKind.setText(String.valueOf(playerOne.getResultFourOfaKind()));
        }
        if (!playerOne.isSelectedSmallStraight) {
            String score = String.valueOf(playerOne.calculateSmallStraight(YatzyRoller.dice));
            display1SmallStraight.setText(score);
        } else {
            display1SmallStraight.setText(String.valueOf(playerOne.getResultSmallStraight()));
        }
        if (!playerOne.isSelectedLargeStraight) {
            String score = String.valueOf(playerOne.calculateLargeStraight(YatzyRoller.dice));
            display1LargeStraight.setText(score);
        } else {
            display1LargeStraight.setText(String.valueOf(playerOne.getResultLargeStraight()));
        }
        if (!playerOne.isSelectedFullHouse) {
            String score = String.valueOf(playerOne.calculateFullHouse(YatzyRoller.dice));
            display1FullHouse.setText(score);
        } else {
            display1FullHouse.setText(String.valueOf(playerOne.getResultFullHouse()));
        }
        if (!playerOne.isSelectedChance) {
            String score = String.valueOf(playerOne.calculateChance(YatzyRoller.dice));
            display1Chance.setText(score);
        } else {
            display1Chance.setText(String.valueOf(playerOne.getResultChance()));
        }
        if (!playerOne.isSelectedYatzy) {
            String score = String.valueOf(playerOne.calculateYatzy(YatzyRoller.dice));
            display1Yatzy.setText(score);
        } else {
            display1Yatzy.setText(String.valueOf(playerOne.getResultYatzy()));
        }
        display1Sum.setText(String.valueOf(sumOne));
        display1Bonus.setText(String.valueOf(bonusOne));
        display1Total.setText(String.valueOf(totalResultOne));
    }

    public void printCategoriesResults2() {
        calculateTotalTwo();
        calculateSumTwo();
        calculateBonusTwo();

        if (!playerTwo.isSelectedOnes) {
            String score = String.valueOf(playerTwo.calculateOnes(YatzyRoller.dice));
            display2Ones.setText(score);
        } else {
            display2Ones.setText(String.valueOf(playerTwo.getResultOnes()));
        }
        if (!playerTwo.isSelectedTwos) {
            String score = String.valueOf(playerTwo.calculateTwos(YatzyRoller.dice));
            display2Twos.setText(score);
        } else {
            display2Twos.setText(String.valueOf(playerTwo.getResultTwos()));
        }
        if (!playerTwo.isSelectedThrees) {
            String score = String.valueOf(playerTwo.calculateThrees(YatzyRoller.dice));
            display2Threes.setText(score);
        } else {
            display2Threes.setText(String.valueOf(playerTwo.getResultThrees()));
        }
        if (!playerTwo.isSelectedFours) {
            String score = String.valueOf(playerTwo.calculateFours(YatzyRoller.dice));
            display2Fours.setText(score);
        } else {
            display2Fours.setText(String.valueOf(playerTwo.getResultFours()));
        }
        if (!playerTwo.isSelectedFives) {
            String score = String.valueOf(playerTwo.calculateFives(YatzyRoller.dice));
            display2Fives.setText(score);
        } else {
            display2Fives.setText(String.valueOf(playerTwo.getResultFives()));
        }
        if (!playerTwo.isSelectedSixes) {
            String score = String.valueOf(playerTwo.calculateSixes(YatzyRoller.dice));
            display2Sixes.setText(score);
        } else {
            display2Sixes.setText(String.valueOf(playerTwo.getResultSixes()));
        }
        if (!playerTwo.isSelectedPair) {
            String score = String.valueOf(playerTwo.calculatePair(YatzyRoller.dice));
            display2Pair.setText(score);
        } else {
            display2Pair.setText(String.valueOf(playerTwo.getResultPair()));
        }
        if (!playerTwo.isSelectedTwoPairs) {
            String score = String.valueOf(playerTwo.calculateTwoPairs(YatzyRoller.dice));
            display2TwoPairs.setText(score);
        } else {
            display2TwoPairs.setText(String.valueOf(playerTwo.getResultTwoPairs()));
        }
        if (!playerTwo.isSelectedThreeOfaKind) {
            String score = String.valueOf(playerTwo.calculateThreeOfaKind(YatzyRoller.dice));
            display2ThreeOfaKind.setText(score);
        } else {
            display2ThreeOfaKind.setText(String.valueOf(playerTwo.getResultThreeOfaKind()));
        }
        if (!playerTwo.isSelectedFourOfaKind) {
            String score = String.valueOf(playerTwo.calculateFourOfaKind(YatzyRoller.dice));
            display2FourOfaKind.setText(score);
        } else {
            display2FourOfaKind.setText(String.valueOf(playerTwo.getResultFourOfaKind()));
        }
        if (!playerTwo.isSelectedSmallStraight) {
            String score = String.valueOf(playerTwo.calculateSmallStraight(YatzyRoller.dice));
            display2SmallStraight.setText(score);
        } else {
            display2SmallStraight.setText(String.valueOf(playerTwo.getResultSmallStraight()));
        }
        if (!playerTwo.isSelectedLargeStraight) {
            String score = String.valueOf(playerTwo.calculateLargeStraight(YatzyRoller.dice));
            display2LargeStraight.setText(score);
        } else {
            display2LargeStraight.setText(String.valueOf(playerTwo.getResultLargeStraight()));
        }
        if (!playerTwo.isSelectedFullHouse) {
            String score = String.valueOf(playerTwo.calculateFullHouse(YatzyRoller.dice));
            display2FullHouse.setText(score);
        } else {
            display2FullHouse.setText(String.valueOf(playerTwo.getResultFullHouse()));
        }
        if (!playerTwo.isSelectedChance) {
            String score = String.valueOf(playerTwo.calculateChance(YatzyRoller.dice));
            display2Chance.setText(score);
        } else {
            display2Chance.setText(String.valueOf(playerTwo.getResultChance()));
        }
        if (!playerTwo.isSelectedYatzy) {
            String score = String.valueOf(playerTwo.calculateYatzy(YatzyRoller.dice));
            display2Yatzy.setText(score);
        } else {
            display2Yatzy.setText(String.valueOf(playerTwo.getResultYatzy()));
        }
        display2Sum.setText(String.valueOf(sumTwo));
        display2Bonus.setText(String.valueOf(bonusTwo));
        display2Total.setText(String.valueOf(totalResultTwo));
    }

    public void printTotalPoints() {
        calculateTotalOne();
        calculateSumOne();
        calculateBonusOne();
        calculateTotalTwo();
        calculateSumTwo();
        calculateBonusTwo();
        display1Sum.setText(String.valueOf(sumOne));
        display1Bonus.setText(String.valueOf(bonusOne));
        display1Total.setText(String.valueOf(totalResultOne));

        display2Sum.setText(String.valueOf(sumTwo));
        display2Bonus.setText(String.valueOf(bonusTwo));
        display2Total.setText(String.valueOf(totalResultTwo));
    }

    public void printRectangles1() {
        if ((!playerOne.isSelectedOnes) && (playerOne.calculateOnes(YatzyRoller.dice) != 0)) {
            rectangle1Ones.setOpacity(1);
        } else {
            rectangle1Ones.setOpacity(0);
        }
        if ((!playerOne.isSelectedTwos) && (playerOne.calculateTwos(YatzyRoller.dice) != 0)) {
            rectangle1Twos.setOpacity(1);
        } else {
            rectangle1Twos.setOpacity(0);
        }
        if ((!playerOne.isSelectedThrees) && (playerOne.calculateThrees(YatzyRoller.dice) != 0)) {
            rectangle1Threes.setOpacity(1);
        } else {
            rectangle1Threes.setOpacity(0);
        }
        if ((!playerOne.isSelectedFours) && (playerOne.calculateFours(YatzyRoller.dice) != 0)) {
            rectangle1Fours.setOpacity(1);
        } else {
            rectangle1Fours.setOpacity(0);
        }
        if ((!playerOne.isSelectedFives) && (playerOne.calculateFives(YatzyRoller.dice) != 0)) {
            rectangle1Fives.setOpacity(1);
        } else {
            rectangle1Fives.setOpacity(0);
        }
        if ((!playerOne.isSelectedSixes) && (playerOne.calculateSixes(YatzyRoller.dice) != 0)) {
            rectangle1Sixes.setOpacity(1);
        } else {
            rectangle1Sixes.setOpacity(0);
        }
        if ((!playerOne.isSelectedPair) && (playerOne.calculatePair(YatzyRoller.dice) != 0)) {
            rectangle1Pair.setOpacity(1);
        } else {
            rectangle1Pair.setOpacity(0);
        }
        if ((!playerOne.isSelectedTwoPairs) && (playerOne.calculateTwoPairs(YatzyRoller.dice) != 0)) {
            rectangle1TwoPairs.setOpacity(1);
        } else {
            rectangle1TwoPairs.setOpacity(0);
        }
        if ((!playerOne.isSelectedThreeOfaKind) && (playerOne.calculateThreeOfaKind(YatzyRoller.dice) != 0)) {
            rectangle1ThreeOfaKind.setOpacity(1);
        } else {
            rectangle1ThreeOfaKind.setOpacity(0);
        }
        if ((!playerOne.isSelectedFourOfaKind) && (playerOne.calculateFourOfaKind(YatzyRoller.dice) != 0)) {
            rectangle1FourOfaKind.setOpacity(1);
        } else {
            rectangle1FourOfaKind.setOpacity(0);
        }
        if ((!playerOne.isSelectedSmallStraight) && (playerOne.calculateSmallStraight(YatzyRoller.dice) != 0)) {
            rectangle1SmallStraight.setOpacity(1);
        } else {
            rectangle1SmallStraight.setOpacity(0);
        }
        if ((!playerOne.isSelectedLargeStraight) && (playerOne.calculateLargeStraight(YatzyRoller.dice) != 0)) {
            rectangle1LargeStraight.setOpacity(1);
        } else {
            rectangle1LargeStraight.setOpacity(0);
        }
        if ((!playerOne.isSelectedFullHouse) && (playerOne.calculateFullHouse(YatzyRoller.dice) != 0)) {
            rectangle1FullHouse.setOpacity(1);
        } else {
            rectangle1FullHouse.setOpacity(0);
        }
        if ((!playerOne.isSelectedChance) && (playerOne.calculateChance(YatzyRoller.dice) != 0)) {
            rectangle1Chance.setOpacity(1);
        } else {
            rectangle1Chance.setOpacity(0);
        }
        if ((!playerOne.isSelectedYatzy) && (playerOne.calculateYatzy(YatzyRoller.dice) != 0)) {
            rectangle1Yatzy.setOpacity(1);
        } else {
            rectangle1Yatzy.setOpacity(0);
        }
    }

    public void printRectangles2() {
        if ((!playerTwo.isSelectedOnes) && (playerTwo.calculateOnes(YatzyRoller.dice) != 0)) {
            rectangle2Ones.setOpacity(1);
        } else {
            rectangle2Ones.setOpacity(0);
        }
        if ((!playerTwo.isSelectedTwos) && (playerTwo.calculateTwos(YatzyRoller.dice) != 0)) {
            rectangle2Twos.setOpacity(1);
        } else {
            rectangle2Twos.setOpacity(0);
        }
        if ((!playerTwo.isSelectedThrees) && (playerTwo.calculateThrees(YatzyRoller.dice) != 0)) {
            rectangle2Threes.setOpacity(1);
        } else {
            rectangle2Threes.setOpacity(0);
        }
        if ((!playerTwo.isSelectedFours) && (playerTwo.calculateFours(YatzyRoller.dice) != 0)) {
            rectangle2Fours.setOpacity(1);
        } else {
            rectangle2Fours.setOpacity(0);
        }
        if ((!playerTwo.isSelectedFives) && (playerTwo.calculateFives(YatzyRoller.dice) != 0)) {
            rectangle2Fives.setOpacity(1);
        } else {
            rectangle2Fives.setOpacity(0);
        }
        if ((!playerTwo.isSelectedSixes) && (playerTwo.calculateSixes(YatzyRoller.dice) != 0)) {
            rectangle2Sixes.setOpacity(1);
        } else {
            rectangle2Sixes.setOpacity(0);
        }
        if ((!playerTwo.isSelectedPair) && (playerTwo.calculatePair(YatzyRoller.dice) != 0)) {
            rectangle2Pair.setOpacity(1);
        } else {
            rectangle2Pair.setOpacity(0);
        }
        if ((!playerTwo.isSelectedTwoPairs) && (playerTwo.calculateTwoPairs(YatzyRoller.dice) != 0)) {
            rectangle2TwoPairs.setOpacity(1);
        } else {
            rectangle2TwoPairs.setOpacity(0);
        }
        if ((!playerTwo.isSelectedThreeOfaKind) && (playerTwo.calculateThreeOfaKind(YatzyRoller.dice) != 0)) {
            rectangle2ThreeOfaKind.setOpacity(1);
        } else {
            rectangle2ThreeOfaKind.setOpacity(0);
        }
        if ((!playerTwo.isSelectedFourOfaKind) && (playerTwo.calculateFourOfaKind(YatzyRoller.dice) != 0)) {
            rectangle2FourOfaKind.setOpacity(1);
        } else {
            rectangle2FourOfaKind.setOpacity(0);
        }
        if ((!playerTwo.isSelectedSmallStraight) && (playerTwo.calculateSmallStraight(YatzyRoller.dice) != 0)) {
            rectangle2SmallStraight.setOpacity(1);
        } else {
            rectangle2SmallStraight.setOpacity(0);
        }
        if ((!playerTwo.isSelectedLargeStraight) && (playerTwo.calculateLargeStraight(YatzyRoller.dice) != 0)) {
            rectangle2LargeStraight.setOpacity(1);
        } else {
            rectangle2LargeStraight.setOpacity(0);
        }
        if ((!playerTwo.isSelectedFullHouse) && (playerTwo.calculateFullHouse(YatzyRoller.dice) != 0)) {
            rectangle2FullHouse.setOpacity(1);
        } else {
            rectangle2FullHouse.setOpacity(0);
        }
        if ((!playerTwo.isSelectedChance) && (playerTwo.calculateChance(YatzyRoller.dice) != 0)) {
            rectangle2Chance.setOpacity(1);
        } else {
            rectangle2Chance.setOpacity(0);
        }
        if ((!playerTwo.isSelectedYatzy) && (playerTwo.calculateYatzy(YatzyRoller.dice) != 0)) {
            rectangle2Yatzy.setOpacity(1);
        } else {
            rectangle2Yatzy.setOpacity(0);
        }
    }

    public void showCurrentPlayerResults() {

        if (playerOneTurn) {
            PauseTransition delayDisplay1 = new PauseTransition(Duration.seconds(0.6));
            delayDisplay1.setOnFinished(event -> printCategoriesResults1());
            delayDisplay1.play();
            PauseTransition delayRectangle1 = new PauseTransition(Duration.seconds(0.6));
            delayRectangle1.setOnFinished(event -> printRectangles1());
            delayRectangle1.play();
        } else {
            PauseTransition delayDisplay2 = new PauseTransition(Duration.seconds(0.6));
            delayDisplay2.setOnFinished(event -> printCategoriesResults2());
            delayDisplay2.play();
            PauseTransition delayRectangle2 = new PauseTransition(Duration.seconds(0.6));
            delayRectangle2.setOnFinished(event -> printRectangles2());
            delayRectangle2.play();
        }
    }

    public void changePlayer() {

        resetDiceImages();
        if (playerOneTurn) {
//Zweiter spieler ist dran
            playerOneTurn = false;
            playerTwoTurn = true;

        } else {
//Erster spieler ist dran
            numTurns++;
            if (numTurns == 16) {
// ende Spiel
                if (totalResultOne > totalResultTwo) {
                    winnerPlayer = "The Winner Is Player 1";
                } else if (totalResultOne == totalResultTwo) {

                } else {
                    winnerPlayer = "The Winner Is Player 2";
                }
                JOptionPane.showMessageDialog(null, winnerPlayer, "Game Over", JOptionPane.OK_CANCEL_OPTION);
                playerOneTurn = false;
                playerTwoTurn = false;

                rollButton.setOpacity(0);
                rollButton.setOnMouseClicked(null);
                rollsRectangle.setOpacity(0);
                remainingRolls.setOpacity(0);

                if (totalResultOne >= 250 || totalResultTwo >= 250) {

                    gewinn = yatzyStart.passAmount() * 2;
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
                        Integer updateChipYatzy = actions.getChipsRoulette() + gewinn;
                        PreparedStatement ps = connection.prepareStatement(
                                "update users set chips = ? where email like " + actions.getEmail());
                        ps.setInt(1, updateChipYatzy);
                        ps.executeUpdate();
                        ps.close();
                        Statement statementChipsWin;
                        ResultSet resultsetChips;
                        statementChipsWin = connection.createStatement();
                        String verifyChipsWin = "select gewinn from logyatzy where user like " + actions.getEmail();
                        resultsetChips = statementChipsWin.executeQuery(verifyChipsWin);
                        while ((resultsetChips.next())) {
                            gewinnGewinn = Integer.valueOf(resultsetChips.getString("gewinn") + gewinn);
                        }
                        PreparedStatement pss = connection.prepareStatement(
                                "update logyatzy set gewinn = ? where user like " + actions.getEmail());
                        pss.setInt(1, gewinnGewinn);
                        pss.executeUpdate();
                        pss.close();
                        lblChips.setText(String.valueOf(updateChipYatzy));
                    } catch (SQLException ex) {
                        Logger.getLogger(YatzyController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
                        Statement statementChipsWin;
                        ResultSet resultsetChips;
                        statementChipsWin = connection.createStatement();
                        String verifyChipsWin = "select verlust from logyatzy where user like " + actions.getEmail();
                        resultsetChips = statementChipsWin.executeQuery(verifyChipsWin);
                        while ((resultsetChips.next())) {
                            verlustVerlust = Integer.valueOf(resultsetChips.getString("verlust"));
                        }
                        PreparedStatement ps = connection.prepareStatement(
                                "update logyatzy set verlust = ? where user like " + actions.getEmail());
                        ps.setInt(1, verlustVerlust);
                        ps.executeUpdate();
                        ps.close();
                    } catch (NumberFormatException | SQLException ex) {
                        System.out.println(ex);
                    }
                }

            } else {
                playerOneTurn = true;
                playerTwoTurn = false;

            }
        }
    }
// um die nötigen Images anzuzeigen
    public void setDice0Image() {
        DropShadow ds = new DropShadow();
        ds.setOffsetY(2.0);
        ds.setOffsetX(2.0);
        ds.setColor(Color.GRAY);
        diceZero.setEffect(ds);

        switch (YatzyRoller.dice[0]) {
            case 1:
                diceZero.setImage(imageOne);
                break;
            case 2:
                diceZero.setImage(imageTwo);
                break;
            case 3:
                diceZero.setImage(imageThree);
                break;
            case 4:
                diceZero.setImage(imageFour);
                break;
            case 5:
                diceZero.setImage(imageFive);
                break;
            case 6:
                diceZero.setImage(imageSix);
                break;
        }
    }

    public void setDice1Image() {
        DropShadow ds = new DropShadow();
        ds.setOffsetY(2.0);
        ds.setOffsetX(2.0);
        ds.setColor(Color.GRAY);
        diceOne.setEffect(ds);

        switch (YatzyRoller.dice[1]) {
            case 1:
                diceOne.setImage(imageOne);
                break;
            case 2:
                diceOne.setImage(imageTwo);
                break;
            case 3:
                diceOne.setImage(imageThree);
                break;
            case 4:
                diceOne.setImage(imageFour);
                break;
            case 5:
                diceOne.setImage(imageFive);
                break;
            case 6:
                diceOne.setImage(imageSix);
                break;
        }
    }

    public void setDice2Image() {
        DropShadow ds = new DropShadow();
        ds.setOffsetY(2.0);
        ds.setOffsetX(2.0);
        ds.setColor(Color.GRAY);
        diceTwo.setEffect(ds);

        switch (YatzyRoller.dice[2]) {
            case 1:
                diceTwo.setImage(imageOne);
                break;
            case 2:
                diceTwo.setImage(imageTwo);
                break;
            case 3:
                diceTwo.setImage(imageThree);
                break;
            case 4:
                diceTwo.setImage(imageFour);
                break;
            case 5:
                diceTwo.setImage(imageFive);
                break;
            case 6:
                diceTwo.setImage(imageSix);
                break;
        }
    }

    public void setDice3Image() {
        DropShadow ds = new DropShadow();
        ds.setOffsetY(2.0);
        ds.setOffsetX(2.0);
        ds.setColor(Color.GRAY);
        diceThree.setEffect(ds);

        switch (YatzyRoller.dice[3]) {
            case 1:
                diceThree.setImage(imageOne);
                break;
            case 2:
                diceThree.setImage(imageTwo);
                break;
            case 3:
                diceThree.setImage(imageThree);
                break;
            case 4:
                diceThree.setImage(imageFour);
                break;
            case 5:
                diceThree.setImage(imageFive);
                break;
            case 6:
                diceThree.setImage(imageSix);
                break;
        }
    }

    public void setDice4Image() {
        DropShadow ds = new DropShadow();
        ds.setOffsetY(2.0);
        ds.setOffsetX(2.0);
        ds.setColor(Color.GRAY);
        diceFour.setEffect(ds);

        switch (YatzyRoller.dice[4]) {
            case 1:
                diceFour.setImage(imageOne);
                break;
            case 2:
                diceFour.setImage(imageTwo);
                break;
            case 3:
                diceFour.setImage(imageThree);
                break;
            case 4:
                diceFour.setImage(imageFour);
                break;
            case 5:
                diceFour.setImage(imageFive);
                break;
            case 6:
                diceFour.setImage(imageSix);
                break;
        }
    }
// click aktionen
    public void clickDice0() {
        if (YatzyRoller.selectedDice[0]) {
            YatzyRoller.selectedDice[0] = false;
            clickedDiceZero.setOpacity(0);

        } else {
            YatzyRoller.selectedDice[0] = true;
            clickedDiceZero.setImage(new Image("/Images/clicked.png"));
            clickedDiceZero.setOpacity(1);

        }
    }

    public void clickDice1() {
        if (YatzyRoller.selectedDice[1]) {
            YatzyRoller.selectedDice[1] = false;
            clickedDiceOne.setOpacity(0);
        } else {
            YatzyRoller.selectedDice[1] = true;
            clickedDiceOne.setImage(new Image("/Images/clicked.png"));
            clickedDiceOne.setOpacity(1);
        }
    }

    public void clickDice2() {
        if (YatzyRoller.selectedDice[2]) {
            YatzyRoller.selectedDice[2] = false;
            clickedDiceTwo.setOpacity(0);
        } else {
            YatzyRoller.selectedDice[2] = true;
            clickedDiceTwo.setImage(new Image("/Images/clicked.png"));
            clickedDiceTwo.setOpacity(1);
        }
    }

    public void clickDice3() {
        if (YatzyRoller.selectedDice[3]) {
            YatzyRoller.selectedDice[3] = false;
            clickedDiceThree.setOpacity(0);
        } else {
            YatzyRoller.selectedDice[3] = true;
            clickedDiceThree.setImage(new Image("/Images/clicked.png"));
            clickedDiceThree.setOpacity(1);
        }
    }

    public void clickDice4() {
        if (YatzyRoller.selectedDice[4]) {
            YatzyRoller.selectedDice[4] = false;
            clickedDiceFour.setOpacity(0);
        } else {
            YatzyRoller.selectedDice[4] = true;
            clickedDiceFour.setImage(new Image("/Images/clicked.png"));
            clickedDiceFour.setOpacity(1);
        }
    }

    @FXML
    public void click1Ones() {

        display1Ones.setOpacity(1);
        display1Ones.setId("");
        display1Ones.setCursor(Cursor.DEFAULT);
        playerOne.isSelectedOnes = true;
        playerOne.setResultOnes(playerOne.calculateOnes(YatzyRoller.dice));
        resetScoreSheet1();

        resetRollsRectanglesDices();
        display1Ones.setOnMouseClicked(null); // label ist nicht Klickbar
    }

    @FXML
    public void click1Twos() {

        display1Twos.setOpacity(1);
        display1Twos.setId("");
        display1Twos.setCursor(Cursor.DEFAULT);
        playerOne.isSelectedTwos = true;
        playerOne.setResultTwos(playerOne.calculateTwos(YatzyRoller.dice));
        resetScoreSheet1();

        resetRollsRectanglesDices();
        display1Twos.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click1Threes() {

        display1Threes.setOpacity(1);
        display1Threes.setId("");
        display1Threes.setCursor(Cursor.DEFAULT);
        playerOne.isSelectedThrees = true;
        playerOne.setResultThrees(playerOne.calculateThrees(YatzyRoller.dice));
        resetScoreSheet1();

        resetRollsRectanglesDices();
        display1Threes.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click1Fours() {

        display1Fours.setOpacity(1);
        display1Fours.setId("");
        display1Fours.setCursor(Cursor.DEFAULT);
        playerOne.isSelectedFours = true;
        playerOne.setResultFours(playerOne.calculateFours(YatzyRoller.dice));
        resetScoreSheet1();

        resetRollsRectanglesDices();
        display1Fours.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click1Fives() {

        display1Fives.setOpacity(1);
        display1Fives.setId("");
        display1Fives.setCursor(Cursor.DEFAULT);
        playerOne.isSelectedFives = true;
        playerOne.setResultFives(playerOne.calculateFives(YatzyRoller.dice));
        resetScoreSheet1();

        resetRollsRectanglesDices();
        display1Fives.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click1Sixes() {

        display1Sixes.setOpacity(1);
        display1Sixes.setId("");
        display1Sixes.setCursor(Cursor.DEFAULT);
        playerOne.isSelectedSixes = true;
        playerOne.setResultSixes(playerOne.calculateSixes(YatzyRoller.dice));
        resetScoreSheet1();

        resetRollsRectanglesDices();
        display1Sixes.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click1Pair() {

        display1Pair.setOpacity(1);
        display1Pair.setId("");
        display1Pair.setCursor(Cursor.DEFAULT);
        playerOne.isSelectedPair = true;
        playerOne.setResultPair(playerOne.calculatePair(YatzyRoller.dice));
        resetScoreSheet1();

        resetRollsRectanglesDices();
        display1Pair.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click1TwoPairs() {

        display1TwoPairs.setOpacity(1);
        display1TwoPairs.setId("");
        display1TwoPairs.setCursor(Cursor.DEFAULT);
        playerOne.isSelectedTwoPairs = true;
        playerOne.setResultTwoPairs(playerOne.calculateTwoPairs(YatzyRoller.dice));
        resetScoreSheet1();

        resetRollsRectanglesDices();
        display1TwoPairs.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click1ThreeOfaKind() {
        display1ThreeOfaKind.setOpacity(1);
        display1ThreeOfaKind.setId("");
        display1ThreeOfaKind.setCursor(Cursor.DEFAULT);
        playerOne.isSelectedThreeOfaKind = true;
        playerOne.setResultThreeOfaKind(playerOne.calculateThreeOfaKind(YatzyRoller.dice));
        resetScoreSheet1();

        resetRollsRectanglesDices();
        display1ThreeOfaKind.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click1FourOfaKind() {

        display1FourOfaKind.setOpacity(1);
        display1FourOfaKind.setId("");
        display1FourOfaKind.setCursor(Cursor.DEFAULT);
        playerOne.isSelectedFourOfaKind = true;
        playerOne.setResultFourOfaKind(playerOne.calculateFourOfaKind(YatzyRoller.dice));
        resetScoreSheet1();

        resetRollsRectanglesDices();
        display1FourOfaKind.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click1SmallStraight() {

        display1SmallStraight.setOpacity(1);
        display1SmallStraight.setId("");
        display1SmallStraight.setCursor(Cursor.DEFAULT);
        playerOne.isSelectedSmallStraight = true;
        playerOne.setResultSmallStraight(playerOne.calculateSmallStraight(YatzyRoller.dice));
        resetScoreSheet1();

        resetRollsRectanglesDices();
        display1SmallStraight.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click1LargeStraight() {

        display1LargeStraight.setOpacity(1);
        display1LargeStraight.setId("");
        display1LargeStraight.setCursor(Cursor.DEFAULT);
        playerOne.isSelectedLargeStraight = true;
        playerOne.setResultLargeStraight(playerOne.calculateLargeStraight(YatzyRoller.dice));
        resetScoreSheet1();

        resetRollsRectanglesDices();

        display1LargeStraight.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click1FullHouse() {

        display1FullHouse.setOpacity(1);
        display1FullHouse.setId("");
        display1FullHouse.setCursor(Cursor.DEFAULT);
        playerOne.isSelectedFullHouse = true;
        playerOne.setResultFullHouse(playerOne.calculateFullHouse(YatzyRoller.dice));
        resetScoreSheet1();

        resetRollsRectanglesDices();
        display1FullHouse.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click1Chance() {

        display1Chance.setOpacity(1);
        display1Chance.setId("");
        display1Chance.setCursor(Cursor.DEFAULT);
        playerOne.isSelectedChance = true;
        playerOne.setResultChance(playerOne.calculateChance(YatzyRoller.dice));
        resetScoreSheet1();

        resetRollsRectanglesDices();
        display1Chance.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click1Yatzy() {
        display1Yatzy.setOpacity(1);
        display1Yatzy.setId("");
        display1Yatzy.setCursor(Cursor.DEFAULT);
        playerOne.isSelectedYatzy = true;
        playerOne.setResultYatzy(playerOne.calculateYatzy(YatzyRoller.dice));
        resetScoreSheet1();

        resetRollsRectanglesDices();


        display1Yatzy.setOnMouseClicked(null);// label ist nicht Klickbar
       

        display1Yatzy.setOnMouseClicked(null);

    }

    @FXML
    public void click2Ones() {

        display2Ones.setOpacity(1);
        display2Ones.setId("");
        display2Ones.setCursor(Cursor.DEFAULT);
        playerTwo.isSelectedOnes = true;
        playerTwo.setResultOnes(playerTwo.calculateOnes(YatzyRoller.dice));
        resetScoreSheet2();

        resetRollsRectanglesDices();
        display2Ones.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click2Twos() {

        display2Twos.setOpacity(1);
        display2Twos.setId("");
        display2Twos.setCursor(Cursor.DEFAULT);
        playerTwo.isSelectedTwos = true;
        playerTwo.setResultTwos(playerTwo.calculateTwos(YatzyRoller.dice));
        resetScoreSheet2();

        resetRollsRectanglesDices();
        display2Twos.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click2Threes() {

        display2Threes.setOpacity(1);
        display2Threes.setId("");
        display2Threes.setCursor(Cursor.DEFAULT);
        playerTwo.isSelectedThrees = true;
        playerTwo.setResultThrees(playerTwo.calculateThrees(YatzyRoller.dice));
        resetScoreSheet2();

        resetRollsRectanglesDices();
        display2Threes.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click2Fours() {

        display2Fours.setOpacity(1);
        display2Fours.setId("");
        display2Fours.setCursor(Cursor.DEFAULT);
        playerTwo.isSelectedFours = true;
        playerTwo.setResultFours(playerTwo.calculateFours(YatzyRoller.dice));
        resetScoreSheet2();

        resetRollsRectanglesDices();
        display2Fours.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click2Fives() {

        display2Fives.setOpacity(1);
        display2Fives.setId("");
        display2Fives.setCursor(Cursor.DEFAULT);
        playerTwo.isSelectedFives = true;
        playerTwo.setResultFives(playerTwo.calculateFives(YatzyRoller.dice));
        resetScoreSheet2();

        resetRollsRectanglesDices();
        display2Fives.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click2Sixes() {

        display2Sixes.setOpacity(1);
        display2Sixes.setId("");
        display2Sixes.setCursor(Cursor.DEFAULT);
        playerTwo.isSelectedSixes = true;
        playerTwo.setResultSixes(playerTwo.calculateSixes(YatzyRoller.dice));
        resetScoreSheet2();

        resetRollsRectanglesDices();
        display2Sixes.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click2Pair() {

        display2Pair.setOpacity(1);
        display2Pair.setId("");
        display2Pair.setCursor(Cursor.DEFAULT);
        playerTwo.isSelectedPair = true;
        playerTwo.setResultPair(playerTwo.calculatePair(YatzyRoller.dice));
        resetScoreSheet2();
        //resetSelectedDices();
        resetRollsRectanglesDices();
        display2Pair.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click2TwoPairs() {

        display2TwoPairs.setOpacity(1);
        display2TwoPairs.setId("");
        display2TwoPairs.setCursor(Cursor.DEFAULT);
        playerTwo.isSelectedTwoPairs = true;
        playerTwo.setResultTwoPairs(playerTwo.calculateTwoPairs(YatzyRoller.dice));
        resetScoreSheet2();

        resetRollsRectanglesDices();
        display2TwoPairs.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click2ThreeOfaKind() {

        display2ThreeOfaKind.setOpacity(1);
        display2ThreeOfaKind.setId("");
        display2ThreeOfaKind.setCursor(Cursor.DEFAULT);
        playerTwo.isSelectedThreeOfaKind = true;
        playerTwo.setResultThreeOfaKind(playerTwo.calculateThreeOfaKind(YatzyRoller.dice));
        resetScoreSheet2();
        
        resetRollsRectanglesDices();
        display2ThreeOfaKind.setOnMouseClicked(null);  // label ist nicht Klickbar
    }

    @FXML
    public void click2FourOfaKind() {

        display2FourOfaKind.setOpacity(1);
        display2FourOfaKind.setId("");
        display2FourOfaKind.setCursor(Cursor.DEFAULT);
        playerTwo.isSelectedFourOfaKind = true;
        playerTwo.setResultFourOfaKind(playerTwo.calculateFourOfaKind(YatzyRoller.dice));
        resetScoreSheet2();

        resetRollsRectanglesDices();
        display2FourOfaKind.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click2SmallStraight() {

        display2SmallStraight.setOpacity(1);
        display2SmallStraight.setId("");
        display2SmallStraight.setCursor(Cursor.DEFAULT);
        playerTwo.isSelectedSmallStraight = true;
        playerTwo.setResultSmallStraight(playerTwo.calculateSmallStraight(YatzyRoller.dice));
        resetScoreSheet2();

        resetRollsRectanglesDices();
        display2SmallStraight.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click2LargeStraight() {

        display2LargeStraight.setOpacity(1);
        display2LargeStraight.setId("");
        display2LargeStraight.setCursor(Cursor.DEFAULT);
        playerTwo.isSelectedLargeStraight = true;
        playerTwo.setResultLargeStraight(playerTwo.calculateLargeStraight(YatzyRoller.dice));
        resetScoreSheet2();

        resetRollsRectanglesDices();
        display2LargeStraight.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click2FullHouse() {

        display2FullHouse.setOpacity(1);
        display2FullHouse.setId("");
        display2FullHouse.setCursor(Cursor.DEFAULT);
        playerTwo.isSelectedFullHouse = true;
        playerTwo.setResultFullHouse(playerTwo.calculateFullHouse(YatzyRoller.dice));
        resetScoreSheet2();

        resetRollsRectanglesDices();
        display2FullHouse.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click2Chance() {

        display2Chance.setOpacity(1);
        display2Chance.setId("");
        display2Chance.setCursor(Cursor.DEFAULT);
        playerTwo.isSelectedChance = true;
        playerTwo.setResultChance(playerTwo.calculateChance(YatzyRoller.dice));
        resetScoreSheet2();

        resetRollsRectanglesDices();
        display2Chance.setOnMouseClicked(null);// label ist nicht Klickbar
    }

    @FXML
    public void click2Yatzy() {

        display2Yatzy.setOpacity(1);
        display2Yatzy.setId("");
        display2Yatzy.setCursor(Cursor.DEFAULT);
        playerTwo.isSelectedYatzy = true;
        playerTwo.setResultYatzy(playerTwo.calculateYatzy(YatzyRoller.dice));
        resetScoreSheet2();

        resetRollsRectanglesDices();

        display2Yatzy.setOnMouseClicked(null);// label ist nicht Klickbar
        

        display2Yatzy.setOnMouseClicked(null);


    }
// alle Berechnungen 
    public void calculateTotalOne() {
        totalResultOne
                = playerOne.getResultOnes() + playerOne.getResultTwos() + playerOne.getResultThrees() + playerOne.getResultFours() + playerOne.getResultFives() + playerOne.getResultSixes() + bonusOne + playerOne.getResultPair() + playerOne.getResultTwoPairs() + playerOne.getResultThreeOfaKind()
                + playerOne.getResultFourOfaKind() + playerOne.getResultSmallStraight() + playerOne.getResultLargeStraight() + playerOne.getResultFullHouse()
                + playerOne.getResultChance() + playerOne.getResultYatzy();
    }

    public void calculateTotalTwo() {
        totalResultTwo
                = playerTwo.getResultOnes() + playerTwo.getResultTwos() + playerTwo.getResultThrees() + playerTwo.getResultFours() + playerTwo.getResultFives() + playerTwo.getResultSixes() + bonusTwo + playerTwo.getResultPair() + playerTwo.getResultTwoPairs() + playerTwo.getResultThreeOfaKind()
                + playerTwo.getResultFourOfaKind() + playerTwo.getResultSmallStraight() + playerTwo.getResultLargeStraight() + playerTwo.getResultFullHouse()
                + playerTwo.getResultChance() + playerTwo.getResultYatzy();
    }

    public void calculateSumOne() {
        sumOne = playerOne.getResultOnes() + playerOne.getResultTwos() + playerOne.getResultThrees() + playerOne.getResultFours() + playerOne.getResultFives() + playerOne.getResultSixes();
    }

    public void calculateSumTwo() {
        sumTwo = playerTwo.getResultOnes() + playerTwo.getResultTwos() + playerTwo.getResultThrees() + playerTwo.getResultFours() + playerTwo.getResultFives() + playerTwo.getResultSixes();
    }

    public void calculateBonusOne() {
        if (sumOne >= 63) {
            bonusOne = 50;
        } else {
            bonusOne = 0;
        }
    }

    public void calculateBonusTwo() {
        if (sumTwo >= 63) {
            bonusTwo = 50;
        } else {
            bonusTwo = 0;
        }
    }
//Reset aktionen
    public void resetScoreSheet1() {
        String defaultValueScores = "0";
        if (!playerOne.isSelectedOnes) {
            display1Ones.setText(defaultValueScores);
        }
        if (!playerOne.isSelectedTwos) {
            display1Twos.setText(defaultValueScores);
        }
        if (!playerOne.isSelectedThrees) {
            display1Threes.setText(defaultValueScores);
        }
        if (!playerOne.isSelectedFours) {
            display1Fours.setText(defaultValueScores);
        }
        if (!playerOne.isSelectedFives) {
            display1Fives.setText(defaultValueScores);
        }
        if (!playerOne.isSelectedSixes) {
            display1Sixes.setText(defaultValueScores);
        }
        if (!playerOne.isSelectedPair) {
            display1Pair.setText(defaultValueScores);
        }
        if (!playerOne.isSelectedTwoPairs) {
            display1TwoPairs.setText(defaultValueScores);
        }
        if (!playerOne.isSelectedThreeOfaKind) {
            display1ThreeOfaKind.setText(defaultValueScores);
        }
        if (!playerOne.isSelectedFourOfaKind) {
            display1FourOfaKind.setText(defaultValueScores);
        }
        if (!playerOne.isSelectedSmallStraight) {
            display1SmallStraight.setText(defaultValueScores);
        }
        if (!playerOne.isSelectedLargeStraight) {
            display1LargeStraight.setText(defaultValueScores);
        }
        if (!playerOne.isSelectedFullHouse) {
            display1FullHouse.setText(defaultValueScores);
        }
        if (!playerOne.isSelectedChance) {
            display1Chance.setText(defaultValueScores);
        }
        if (!playerOne.isSelectedYatzy) {
            display1Yatzy.setText(defaultValueScores);
        }
    }

    public void resetScoreSheet2() {
        String defaultValueScores = "0";
        if (!playerTwo.isSelectedOnes) {
            display2Ones.setText(defaultValueScores);
        }
        if (!playerTwo.isSelectedTwos) {
            display2Twos.setText(defaultValueScores);
        }
        if (!playerTwo.isSelectedThrees) {
            display2Threes.setText(defaultValueScores);
        }
        if (!playerTwo.isSelectedFours) {
            display2Fours.setText(defaultValueScores);
        }
        if (!playerTwo.isSelectedFives) {
            display2Fives.setText(defaultValueScores);
        }
        if (!playerTwo.isSelectedSixes) {
            display2Sixes.setText(defaultValueScores);
        }
        if (!playerTwo.isSelectedPair) {
            display2Pair.setText(defaultValueScores);
        }
        if (!playerTwo.isSelectedTwoPairs) {
            display2TwoPairs.setText(defaultValueScores);
        }
        if (!playerTwo.isSelectedThreeOfaKind) {
            display2ThreeOfaKind.setText(defaultValueScores);
        }
        if (!playerTwo.isSelectedFourOfaKind) {
            display2FourOfaKind.setText(defaultValueScores);
        }
        if (!playerTwo.isSelectedSmallStraight) {
            display2SmallStraight.setText(defaultValueScores);
        }
        if (!playerTwo.isSelectedLargeStraight) {
            display2LargeStraight.setText(defaultValueScores);
        }
        if (!playerTwo.isSelectedFullHouse) {
            display2FullHouse.setText(defaultValueScores);
        }
        if (!playerTwo.isSelectedChance) {
            display2Chance.setText(defaultValueScores);
        }
        if (!playerTwo.isSelectedYatzy) {
            display2Yatzy.setText(defaultValueScores);
        }
    }

    public void resetRollsRectanglesDices() {
        remainingRolls.setText("3");

        enableRollButon();
        resetRectangles();
        resetSelectedDices();
        YatzyRoller.resetRollNum();
        printTotalPoints();
        changePlayer();

    }

    public void resetEverything() {
        remainingRolls.setText("3");

        resetRectangles();
        resetSelectedDices();
        YatzyRoller.resetRollNum();
        printTotalPoints();
        resetDiceImages();
        resetAllResults();

        playerOneTurn = true;

        sumOne = 0;
        sumTwo = 0;
        totalResultOne = 0;
        totalResultTwo = 0;
    }

    public void resetAllResults() {

        playerOne.setResultOnes(playerOne.calculateOnes(YatzyRoller.dice));

        playerOne.setResultTwos(playerOne.calculateTwos(YatzyRoller.dice));

        playerOne.setResultThrees(playerOne.calculateThrees(YatzyRoller.dice));

        playerOne.setResultFours(playerOne.calculateFours(YatzyRoller.dice));

        playerOne.setResultFives(playerOne.calculateFives(YatzyRoller.dice));

        playerOne.setResultSixes(playerOne.calculateSixes(YatzyRoller.dice));

        playerOne.setResultPair(playerOne.calculatePair(YatzyRoller.dice));

        playerOne.setResultTwoPairs(playerOne.calculateTwoPairs(YatzyRoller.dice));

        playerOne.setResultThreeOfaKind(playerOne.calculateThreeOfaKind(YatzyRoller.dice));

        playerOne.setResultFourOfaKind(playerOne.calculateFourOfaKind(YatzyRoller.dice));

        playerOne.setResultSmallStraight(playerOne.calculateSmallStraight(YatzyRoller.dice));

        playerOne.setResultLargeStraight(playerOne.calculateLargeStraight(YatzyRoller.dice));

        playerOne.setResultFullHouse(playerOne.calculateFullHouse(YatzyRoller.dice));

        playerOne.setResultChance(playerOne.calculateChance(YatzyRoller.dice));

        playerOne.setResultYatzy(playerOne.calculateYatzy(YatzyRoller.dice));

        playerTwo.setResultOnes(playerTwo.calculateOnes(YatzyRoller.dice));

        playerTwo.setResultTwos(playerTwo.calculateTwos(YatzyRoller.dice));

        playerTwo.setResultThrees(playerTwo.calculateThrees(YatzyRoller.dice));

        playerTwo.setResultFours(playerTwo.calculateFours(YatzyRoller.dice));

        playerTwo.setResultFives(playerTwo.calculateFives(YatzyRoller.dice));

        playerTwo.setResultSixes(playerTwo.calculateSixes(YatzyRoller.dice));

        playerTwo.setResultPair(playerTwo.calculatePair(YatzyRoller.dice));

        playerTwo.setResultTwoPairs(playerTwo.calculateTwoPairs(YatzyRoller.dice));

        playerTwo.setResultThreeOfaKind(playerTwo.calculateThreeOfaKind(YatzyRoller.dice));

        playerTwo.setResultFourOfaKind(playerTwo.calculateFourOfaKind(YatzyRoller.dice));

        playerTwo.setResultSmallStraight(playerTwo.calculateSmallStraight(YatzyRoller.dice));

        playerTwo.setResultLargeStraight(playerTwo.calculateLargeStraight(YatzyRoller.dice));

        playerTwo.setResultFullHouse(playerTwo.calculateFullHouse(YatzyRoller.dice));

        playerTwo.setResultChance(playerTwo.calculateChance(YatzyRoller.dice));

        playerTwo.setResultYatzy(playerTwo.calculateYatzy(YatzyRoller.dice));

    }

    public void resetDiceImages() {
        diceZero.setEffect(null);
        diceOne.setEffect(null);
        diceTwo.setEffect(null);
        diceThree.setEffect(null);
        diceFour.setEffect(null);

        diceZero.setImage(null);
        diceOne.setImage(null);
        diceTwo.setImage(null);
        diceThree.setImage(null);
        diceFour.setImage(null);
    }

    public void resetSelectedDices() {
        for (int i = 0; i < YatzyRoller.selectedDice.length; i++) {
            YatzyRoller.selectedDice[i] = false;
        }
        clickedDiceZero.setOpacity(0);
        clickedDiceOne.setOpacity(0);
        clickedDiceTwo.setOpacity(0);
        clickedDiceThree.setOpacity(0);
        clickedDiceFour.setOpacity(0);
    }

    public void resetRectangles() {
        rectangle1Ones.setOpacity(0);
        rectangle1Twos.setOpacity(0);
        rectangle1Threes.setOpacity(0);
        rectangle1Fours.setOpacity(0);
        rectangle1Fives.setOpacity(0);
        rectangle1Sixes.setOpacity(0);
        rectangle1Sum.setOpacity(0);
        rectangle1Bonus.setOpacity(0);
        rectangle1Pair.setOpacity(0);
        rectangle1TwoPairs.setOpacity(0);
        rectangle1ThreeOfaKind.setOpacity(0);
        rectangle1FourOfaKind.setOpacity(0);
        rectangle1SmallStraight.setOpacity(0);
        rectangle1LargeStraight.setOpacity(0);
        rectangle1FullHouse.setOpacity(0);
        rectangle1Chance.setOpacity(0);
        rectangle1Yatzy.setOpacity(0);
        rectangle1Total.setOpacity(0);

        rectangle2Ones.setOpacity(0);
        rectangle2Twos.setOpacity(0);
        rectangle2Threes.setOpacity(0);
        rectangle2Fours.setOpacity(0);
        rectangle2Fives.setOpacity(0);
        rectangle2Sixes.setOpacity(0);
        rectangle2Sum.setOpacity(0);
        rectangle2Bonus.setOpacity(0);
        rectangle2Pair.setOpacity(0);
        rectangle2TwoPairs.setOpacity(0);
        rectangle2ThreeOfaKind.setOpacity(0);
        rectangle2FourOfaKind.setOpacity(0);
        rectangle2SmallStraight.setOpacity(0);
        rectangle2LargeStraight.setOpacity(0);
        rectangle2FullHouse.setOpacity(0);
        rectangle2Chance.setOpacity(0);
        rectangle2Yatzy.setOpacity(0);
        rectangle2Total.setOpacity(0);
    }
}
