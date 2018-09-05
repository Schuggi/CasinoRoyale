/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import ch.bbbaden.casinoroyale.model.Actions;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class BingoGameController implements Initializable {

    @FXML
    private Button btnNumber11;
    @FXML
    private Button btnNumber12;
    @FXML
    private Button btnNumber13;
    @FXML
    private Button btnNumber14;
    @FXML
    private ImageView img11;
    @FXML
    private ImageView img12;
    @FXML
    private ImageView img13;
    @FXML
    private ImageView img14;
    @FXML
    private ImageView img15;
    @FXML
    private Button btnNumber21;
    @FXML
    private Button btnNumber22;
    @FXML
    private Button btnNumber23;
    @FXML
    private Button btnNumber24;
    @FXML
    private Button btnNumber25;
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
    private Button btnNumber31;
    @FXML
    private Button btnNumber32;
    @FXML
    private Button btnNumber34;
    @FXML
    private Button btnNumber35;
    @FXML
    private ImageView img31;
    @FXML
    private ImageView img32;
    @FXML
    private ImageView img34;
    @FXML
    private ImageView img35;
    @FXML
    private Button btnNumber41;
    @FXML
    private Button btnNumber42;
    @FXML
    private Button btnNumber43;
    @FXML
    private Button btnNumber44;
    @FXML
    private Button btnNumber45;
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
    private Button btnNumber51;
    @FXML
    private Button btnNumber52;
    @FXML
    private Button btnNumber53;
    @FXML
    private Button btnNumber54;
    @FXML
    private Button btnNumber55;
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
    private Button btnNumber15;
    Integer starttime = 30;
    Integer seconds = starttime;
    Integer starttimeDuration = 30;
    Integer secondsDuration = starttimeDuration;
    Integer countdownWinner = 5;
    Integer winnerCount = countdownWinner;
    Integer countdownInt = 10;
    Integer countdownGameInt = countdownInt;
    private boolean bimg11 = false;
    private boolean bimg12 = false;
    private boolean bimg13 = false;
    private boolean bimg14 = false;
    private boolean bimg15 = false;
    private boolean bimg21 = false;
    private boolean bimg22 = false;
    private boolean bimg23 = false;
    private boolean bimg24 = false;
    private boolean bimg25 = false;
    private boolean bimg31 = false;
    private boolean bimg32 = false;
    private boolean bimg34 = false;
    private boolean bimg35 = false;
    private boolean bimg41 = false;
    private boolean bimg42 = false;
    private boolean bimg43 = false;
    private boolean bimg44 = false;
    private boolean bimg45 = false;
    private boolean bimg51 = false;
    private boolean bimg52 = false;
    private boolean bimg53 = false;
    private boolean bimg54 = false;
    private boolean bimg55 = false;
    int counter = 0;
    @FXML
    private Label lblRandomNumber;
    @FXML
    private Button btnBingo;
    @FXML
    private Label lblTimer;
    @FXML
    private Label lblNextNumber;
    @FXML
    private Label lblGameStarts;
    @FXML
    private Label lblCountdown;
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl3;
    @FXML
    private Label lbl4;
    @FXML
    private Label lbl5;
    @FXML
    private Label lbl6;
    @FXML
    private Label lbl7;
    @FXML
    private Label lbl8;
    @FXML
    private Label lbl15;
    @FXML
    private Label lbl22;
    @FXML
    private Label lbl9;
    @FXML
    private Label lbl16;
    @FXML
    private Label lbl23;
    @FXML
    private Label lbl10;
    @FXML
    private Label lbl17;
    @FXML
    private Label lbl24;
    @FXML
    private Label lbl11;
    @FXML
    private Label lbl18;
    @FXML
    private Label lbl25;
    @FXML
    private Label lbl12;
    @FXML
    private Label lbl19;
    @FXML
    private Label lbl26;
    @FXML
    private Label lbl13;
    @FXML
    private Label lbl20;
    @FXML
    private Label lbl28;
    @FXML
    private Label lbl14;
    @FXML
    private Label lbl21;
    @FXML
    private Label lbl27;
    @FXML
    private Label lblZ5;
    @FXML
    private Label lblZ4;
    @FXML
    private Label lblZ3;
    @FXML
    private Label lblZ2;
    @FXML
    private Label lblZ1;
    @FXML
    private Label lblZ10;
    @FXML
    private Label lblZ9;
    @FXML
    private Label lblZ8;
    @FXML
    private Label lblZ7;
    @FXML
    private Label lblZ6;
    @FXML
    private Label lblZ14;
    @FXML
    private Label lblZ13;
    @FXML
    private Label lblZ12;
    @FXML
    private Label lblZ11;
    @FXML
    private Label lblZ19;
    @FXML
    private Label lblZ18;
    @FXML
    private Label lblZ17;
    @FXML
    private Label lblZ16;
    @FXML
    private Label lblZ15;
    @FXML
    private Label lblZ24;
    @FXML
    private Label lblZ23;
    @FXML
    private Label lblZ22;
    @FXML
    private Label lblZ21;
    @FXML
    private Label lblZ20;
    private Label[] labels;
    private Label[] labelZahlen;
    private Label[] labelBots;
    @FXML
    private AnchorPane ApBingo;
    @FXML
    private JFXDrawer JFXMenu;
    @FXML
    private JFXHamburger JFXMenuButton;
    public static AnchorPane rootP;
    ArrayList<Integer> arr15 = new ArrayList();
    ArrayList<Integer> arr30 = new ArrayList();
    ArrayList<Integer> arr45 = new ArrayList();
    ArrayList<Integer> arr60 = new ArrayList();
    ArrayList<Integer> arr75 = new ArrayList();
    ArrayList<Integer> fullArray = new ArrayList();
    ArrayList<Integer> fullArrayPulledNumbers = new ArrayList();
    ArrayList<Integer> checkIfNumberPulled = new ArrayList();
    boolean bingoCall;
    boolean onlyOneCall = true;
    final Timeline timeForNextNumber = new Timeline();
    final Timeline timeWinner = new Timeline();
    final Timeline countdown = new Timeline();
    Boolean winner;
    Integer fullArrayR;
    Actions actions = Actions.getInstance();
    Integer winChip;
    String botName;
    Integer counterBot = 1;
    Stage stage = new Stage();
    Stage stage2 = new Stage();
    Stage stage3 = new Stage();
    Stage stage4 = new Stage();
    Stage stage5 = new Stage();
    static BingoGameController instance;
    @FXML
    private Label lbl29;
    @FXML
    private Label lbl30;
    @FXML
    private Label lbl31;
    @FXML
    private Label lbl32;
    @FXML
    private Label lbl33;
    @FXML
    private Label lbl34;
    @FXML
    private Label lbl35;
    @FXML
    private Label lbl36;
    @FXML
    private Label lbl37;
    @FXML
    private Label lbl38;
    @FXML
    private Label lbl39;
    @FXML
    private Label lbl40;
    @FXML
    private Label lbl41;
    @FXML
    private Label lbl42;
    @FXML
    private Label lbl43;
    @FXML
    private Label lbl44;
    @FXML
    private Label lbl45;
    @FXML
    private Label lbl46;
    @FXML
    private Label lbl47;
    @FXML
    private Label lbl48;
    @FXML
    private Label lbl49;
    @FXML
    private Label lblGameOver;
    @FXML
    private Label lblTheWinner;
    @FXML
    private Label lblWinnerName;
    @FXML
    private Label lblActiveUser;
    @FXML
    private Label lblBotOne;
    @FXML
    private Label lblBotTwo;
    @FXML
    private Label lblBotThree;
    @FXML
    private Label lblBotFour;
    @FXML
    private Label lblBotFive;
    @FXML
    private Button btnRestart;
    @FXML
    private Label lblChips;
    @FXML
    private Button btnBots;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        instance = this;

        try {
            // Erstellt die Screens für die Bots
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/fxml/Bingo/Bot1.fxml"));
            stage = new Stage();
            stage.setTitle("Bot 1");
            stage.setScene(new Scene(root));
            javafx.geometry.Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            //set Stage boundaries to the lower right corner of the visible bounds of the main screen
            stage.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - 400);
            stage.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - 380);
            stage.setWidth(400);
            stage.setHeight(380);
            Parent root2;
            root2 = FXMLLoader.load(getClass().getResource("/fxml/Bingo/Bot2.fxml"));
            stage2 = new Stage();
            stage2.setTitle("Bot 2");
            stage2.setScene(new Scene(root2));
            stage2.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - 400);
            stage2.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - 720);
            stage2.setWidth(400);
            stage2.setHeight(380);
            Parent root3;
            root3 = FXMLLoader.load(getClass().getResource("/fxml/Bingo/Bot3.fxml"));
            stage3 = new Stage();
            stage3.setTitle("Bot 3");
            stage3.setScene(new Scene(root3));
            stage3.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - 400);
            stage3.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - 1060);
            stage3.setWidth(400);
            stage3.setHeight(380);
            Parent root4;
            root4 = FXMLLoader.load(getClass().getResource("/fxml/Bingo/Bot4.fxml"));
            stage4 = new Stage();
            stage4.setTitle("Bot 4");
            stage4.setScene(new Scene(root4));
            stage4.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - 1920);
            stage4.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - 380);
            stage4.setWidth(400);
            stage4.setHeight(380);
            Parent root5;
            root5 = FXMLLoader.load(getClass().getResource("/fxml/Bingo/Bot5.fxml"));
            stage5 = new Stage();
            stage5.setTitle("Bot 5");
            stage5.setScene(new Scene(root5));
            stage5.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - 1920);
            stage5.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - 1060);
            stage5.setWidth(400);
            stage5.setHeight(380);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        // Generiert die 5 Zufälligen Namen für die Bots
        botNameOne();

        // Schreibt den Username rechts oben hin
        lblActiveUser.setText(actions.getUsername());
        try {
            // Schreib die Anzahl Chips des Benutzers rechts oben hin
            lblChips.setText(String.valueOf(actions.getChipsRoulette()));
        } catch (SQLException ex) {
            Logger.getLogger(BingoGameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
        // Füllt die ArrayLists mit den jeweiligen Zahlenwerten 
        for (int i = 1;
                i < 16; i++) {
            arr15.add(i);
        }
        for (int i = 16;
                i < 31; i++) {
            arr30.add(i);
        }
        for (int i = 31;
                i < 46; i++) {
            arr45.add(i);
        }
        for (int i = 46;
                i < 61; i++) {
            arr60.add(i);
        }
        for (int i = 61;
                i < 76; i++) {
            arr75.add(i);
        }
        for (int i = 1;
                i < 76; i++) {
            fullArray.add(i);
        }
        for (int i = 1;
                i < 76; i++) {
            fullArrayPulledNumbers.add(i);
        }
        // Labels wurden in Arrays geschrieben
        Label[] temp = {lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10, lbl11, lbl12, lbl13, lbl14, lbl15, lbl16, lbl17, lbl18, lbl19, lbl20, lbl21, lbl22, lbl23, lbl24, lbl25, lbl26, lbl27, lbl28, lbl29, lbl30, lbl31, lbl32, lbl33, lbl34, lbl35, lbl36, lbl37, lbl38, lbl39, lbl40, lbl41, lbl42, lbl43, lbl44, lbl45, lbl46, lbl47, lbl48, lbl49};
        labels = temp;
        Label[] zahlen115 = {lblZ1, lblZ2, lblZ3, lblZ4, lblZ5, lblZ6, lblZ7, lblZ8, lblZ9, lblZ9, lblZ10, lblZ11, lblZ12, lblZ13, lblZ14, lblZ15, lblZ16, lblZ17, lblZ18, lblZ19, lblZ20, lblZ21, lblZ22, lblZ23, lblZ24};
        labelZahlen = zahlen115;
        // RandomNumber Lotto 1 - 15
        for (int i = 0;
                i < 5; i++) {
            Random rnd = new Random();
            Integer array15 = arr15.get(rnd.nextInt(arr15.size()));
            labelZahlen[i].setText(String.valueOf(array15));
            arr15.remove(array15);
            fullArray.remove(array15);
        }
        // RandomNumber Lotto 16 - 30
        for (int i = 5;
                i < 11; i++) {
            Random rnd = new Random();
            Integer array30 = arr30.get(rnd.nextInt(arr30.size()));
            labelZahlen[i].setText(String.valueOf(array30));
            arr30.remove(array30);
            fullArray.remove(array30);
        }
        // RandomNumber Lotto 31 - 45
        for (int i = 11;
                i < 15; i++) {
            Random rnd = new Random();
            Integer array45 = arr45.get(rnd.nextInt(arr45.size()));
            labelZahlen[i].setText(String.valueOf(array45));
            arr45.remove(array45);
            fullArray.remove(array45);
        }
        // RandomNumber Lotto 46 - 60
        for (int i = 15;
                i < 20; i++) {
            Random rnd = new Random();
            Integer array60 = arr60.get(rnd.nextInt(arr60.size()));
            labelZahlen[i].setText(String.valueOf(array60));
            arr60.remove(array60);
            fullArray.remove(array60);
        }
        // RandomNumber Lotto 61 - 75
        for (int i = 20;
                i < 25; i++) {
            Random rnd = new Random();
            Integer array75 = arr75.get(rnd.nextInt(arr75.size()));
            labelZahlen[i].setText(String.valueOf(array75));
            arr75.remove(array75);
            fullArray.remove(array75);
        }
        // Timer CountDown
        KeyFrame countdownGame = new KeyFrame(javafx.util.Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                countdownGameInt--;
                String countdownGameStr = String.valueOf(countdownGameInt);
                lblCountdown.setText(countdownGameInt.toString());
                if (countdownGameInt == 0) {
                    fullArrayR = ThreadLocalRandom.current().nextInt(1, 75 + 1);
                    String parsee = String.valueOf(fullArrayR);
                    lblRandomNumber.setText(parsee);
                    lbl1.setText(parsee);
                    lbl1.setVisible(true);
                    lblGameStarts.setVisible(false);
                    lblCountdown.setVisible(false);
                    lblNextNumber.setVisible(true);
                    lblTimer.setVisible(true);
                    checkIfNumberPulled.add(fullArrayR);
                    // Timer for Random Number every 30 Seconds
                    // Timer for Duration for next number
                    KeyFrame frameDuration = new KeyFrame(javafx.util.Duration.seconds(1), new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            secondsDuration--;
                            lblTimer.setText(secondsDuration.toString());
                            if (!fullArrayPulledNumbers.isEmpty()) {
                                if ((secondsDuration % 30) == 0) {
                                    counter++;
                                    Random rnd = new Random();
                                    fullArrayR = fullArrayPulledNumbers.get(rnd.nextInt(fullArrayPulledNumbers.size()));
                                    if (counter < labels.length) {
                                        labels[counter].setVisible(true);
                                        labels[counter].setText(String.valueOf(fullArrayR));
                                    }
                                    lblRandomNumber.setText(String.valueOf(fullArrayR));
                                    fullArrayPulledNumbers.remove(fullArrayR);
                                    checkIfNumberPulled.add(fullArrayR);
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

        // Hamburger Menu
        rootP = ApBingo;
        try {
            VBox box = FXMLLoader.load(getClass().getResource("/fxml/Menu/Menu.fxml"));
            JFXMenu.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(RouletteHauptScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(JFXMenuButton);
        transition.setRate(
                -1);
        JFXMenuButton.addEventHandler(MouseEvent.MOUSE_PRESSED,
                (e) -> {
                    transition.setRate(transition.getRate() * -1);
                    transition.play();

                    if (JFXMenu.isShown()) {
                        JFXMenu.close();
                    } else {
                        JFXMenu.open();
                    }
                }
        );
    }

    // Erstellt eine Instanz, damit andere Klassen Werte von diesem Controller übernehmen können
    public static BingoGameController getInstance() {
        if (instance == null) {
            instance = new BingoGameController();
        }
        return instance;
    }

    // Schreibt die neue Anzahl Chips und den Gewinn in die Datenbank
    private void updateChipAmount() throws SQLException {
        winChip = actions.getChipsRoulette() + (50 * 5);
        Integer win = actions.getWin() + 250;
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        PreparedStatement ps = connection.prepareStatement(
                "update users set chips = ? where email like " + actions.getEmail());
        ps.setInt(1, winChip);
        ps.executeUpdate();
        ps.close();
        PreparedStatement psBingo = connection.prepareStatement(
                "update logbingo set gewinn = ? where user like " + actions.getEmail());
        psBingo.setInt(1, win);
        psBingo.executeUpdate();
        psBingo.close();
    }

    // Schreibt den Verlust in die Datenbank
    private void updateChipAmountLoss() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Integer loss = actions.getLoss() + 50;
        PreparedStatement psBingo = connection.prepareStatement(
                "update logbingo set verlust = ? where user like " + actions.getEmail());
        psBingo.setInt(1, loss);
        psBingo.executeUpdate();
        psBingo.close();
    }

    // Übergibt die Random Zahl an die Bots
    public Integer randomBot() {
        return fullArrayR;
    }

    // Zeigt die Bots an oder lässt sie verschwinden
    @FXML
    private void btnBots(ActionEvent event) {
        counterBot++;
        if (counterBot == 2) {

        }
        if (counterBot % 2 == 0) {
            stage.show();
            stage2.show();
            stage3.show();
            stage4.show();
            stage5.show();
            btnBots.setText("Hide Bots");
        } else {
            stage.hide();
            stage2.hide();
            stage3.hide();
            stage4.hide();
            stage5.hide();
            btnBots.setText("Show Bots");
        }
    }

    @FXML
    private void btnRestart(ActionEvent event) throws IOException {
        BingoStartScreenController bingostartscreen = new BingoStartScreenController();
        bingostartscreen.btnStartGame(event);
    }

    // Lässt das ImageView entweder anzeigen oder verschwinden
    @FXML
    public void btnNumber11(ActionEvent event) {
        if (bimg11) {
            bimg11 = false;
        } else {
            bimg11 = true;
        }
        img11.setVisible(bimg11);
    }

    @FXML
    private void btnNumber12(ActionEvent event) {
        if (bimg12) {
            bimg12 = false;
        } else {
            bimg12 = true;
        }
        img12.setVisible(bimg12);
    }

    @FXML
    private void btnNumber13(ActionEvent event) {
        if (bimg13) {
            bimg13 = false;
        } else {
            bimg13 = true;
        }
        img13.setVisible(bimg13);
    }

    @FXML
    private void btnNumber14(ActionEvent event) {
        if (bimg14) {
            bimg14 = false;
        } else {
            bimg14 = true;
        }
        img14.setVisible(bimg14);
    }

    @FXML
    private void btnNumber15(ActionEvent event) {
        if (bimg15) {
            bimg15 = false;
        } else {
            bimg15 = true;
        }
        img15.setVisible(bimg15);
    }

    @FXML
    private void btnNumber21(ActionEvent event) {
        if (bimg21) {
            bimg21 = false;
        } else {
            bimg21 = true;
        }
        img21.setVisible(bimg21);
    }

    @FXML
    private void btnNumber22(ActionEvent event) {
        if (bimg22) {
            bimg22 = false;
        } else {
            bimg22 = true;
        }
        img22.setVisible(bimg22);
    }

    @FXML
    private void btnNumber23(ActionEvent event) {
        if (bimg23) {
            bimg23 = false;
        } else {
            bimg23 = true;
        }
        img23.setVisible(bimg23);
    }

    @FXML
    private void btnNumber24(ActionEvent event) {
        if (bimg24) {
            bimg24 = false;
        } else {
            bimg24 = true;
        }
        img24.setVisible(bimg24);
    }

    @FXML
    private void btnNumber25(ActionEvent event) {
        if (bimg25) {
            bimg25 = false;
        } else {
            bimg25 = true;
        }
        img25.setVisible(bimg25);
    }

    @FXML
    private void btnNumber31(ActionEvent event) {
        if (bimg31) {
            bimg31 = false;
        } else {
            bimg31 = true;
        }
        img31.setVisible(bimg31);
    }

    @FXML
    private void btnNumber32(ActionEvent event) {
        if (bimg32) {
            bimg32 = false;
        } else {
            bimg32 = true;
        }
        img32.setVisible(bimg32);
    }

    @FXML
    private void btnNumber34(ActionEvent event) {
        if (bimg34) {
            bimg34 = false;
        } else {
            bimg34 = true;
        }
        img34.setVisible(bimg34);
    }

    @FXML
    private void btnNumber35(ActionEvent event) {
        if (bimg35) {
            bimg35 = false;
        } else {
            bimg35 = true;
        }
        img35.setVisible(bimg35);
    }

    @FXML
    private void btnNumber41(ActionEvent event) {
        if (bimg41) {
            bimg41 = false;
        } else {
            bimg41 = true;
        }
        img41.setVisible(bimg41);
    }

    @FXML
    private void btnNumber42(ActionEvent event) {
        if (bimg42) {
            bimg42 = false;
        } else {
            bimg42 = true;
        }
        img42.setVisible(bimg42);
    }

    @FXML
    private void btnNumber43(ActionEvent event) {
        if (bimg43) {
            bimg43 = false;
        } else {
            bimg43 = true;
        }
        img43.setVisible(bimg43);
    }

    @FXML
    private void btnNumber44(ActionEvent event) {
        if (bimg44) {
            bimg44 = false;
        } else {
            bimg44 = true;
        }
        img44.setVisible(bimg44);
    }

    @FXML
    private void btnNumber45(ActionEvent event) {
        if (bimg45) {
            bimg45 = false;
        } else {
            bimg45 = true;
        }
        img45.setVisible(bimg45);
    }

    @FXML
    private void btnNumber51(ActionEvent event) {
        if (bimg51) {
            bimg51 = false;
        } else {
            bimg51 = true;
        }
        img51.setVisible(bimg51);
    }

    @FXML
    private void btnNumber52(ActionEvent event) {
        if (bimg52) {
            bimg52 = false;
        } else {
            bimg52 = true;
        }
        img52.setVisible(bimg52);
    }

    @FXML
    private void btnNumber53(ActionEvent event) {
        if (bimg53) {
            bimg53 = false;
        } else {
            bimg53 = true;
        }
        img53.setVisible(bimg53);
    }

    @FXML
    private void btnNumber54(ActionEvent event) {
        if (bimg54) {
            bimg54 = false;
        } else {
            bimg54 = true;
        }
        img54.setVisible(bimg54);
    }

    @FXML
    private void btnNumber55(ActionEvent event) {
        if (bimg55) {
            bimg55 = false;
        } else {
            bimg55 = true;
        }
        img55.setVisible(bimg55);
    }

    @FXML
    private void btnBingo(ActionEvent event) throws SQLException {
        checkAll();
        if (bingoCall == false) {
            JOptionPane.showMessageDialog(null, "Your Bingo-Call Was Wrong!", "Wrong", JOptionPane.OK_CANCEL_OPTION);
        } else {
            updateChipAmount();
            lblChips.setText(String.valueOf(winChip));
            winner("You");
        }
    }

    // Überprüft ob 5 Zahlen in einer Reihe vorkommen und diese angekreuzt sind
    public void checkIfCrossedVertical1() throws SQLException {
        if (img11.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ1.getText())) && img12.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ2.getText())) && img13.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ3.getText())) && img14.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ4.getText())) && img15.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ5.getText()))) {
            if (onlyOneCall == true) {
                JOptionPane.showMessageDialog(null, "Congratulation, You Won!", "Bingo", JOptionPane.OK_CANCEL_OPTION);
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
                lblGameStarts.setVisible(false);
                lblCountdown.setVisible(false);
                lblGameOver.setVisible(true);
                lblTheWinner.setVisible(true);
                lblWinnerName.setText("You");
                lblWinnerName.setVisible(true);
                lblNextNumber.setVisible(false);
                lblTimer.setVisible(false);
            }
        }
    }

    public void checkIfCrossedVertical2() throws SQLException {
        if (img21.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ6.getText())) && img22.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ7.getText())) && img23.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ8.getText())) && img24.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ9.getText())) && img25.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ10.getText()))) {
            if (onlyOneCall == true) {
                JOptionPane.showMessageDialog(null, "Congratulation, You Won!", "Bingo", JOptionPane.OK_CANCEL_OPTION);
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
                lblGameStarts.setVisible(false);
                lblCountdown.setVisible(false);
                lblGameOver.setVisible(true);
                lblTheWinner.setVisible(true);
                lblWinnerName.setText("You");
                lblWinnerName.setVisible(true);
                lblNextNumber.setVisible(false);
                lblTimer.setVisible(false);
            }
        }
    }

    public void checkIfCrossedVertical3() throws SQLException {
        if (img31.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ11.getText())) && img32.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ12.getText())) && img34.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ13.getText())) && img35.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ14.getText()))) {
            if (onlyOneCall == true) {
                JOptionPane.showMessageDialog(null, "Congratulation, You Won!", "Bingo", JOptionPane.OK_CANCEL_OPTION);
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
                lblGameStarts.setVisible(false);
                lblCountdown.setVisible(false);
                lblGameOver.setVisible(true);
                lblTheWinner.setVisible(true);
                lblWinnerName.setText("You");
                lblWinnerName.setVisible(true);
                lblNextNumber.setVisible(false);
                lblTimer.setVisible(false);
            }
        }
    }

    public void checkIfCrossedVertical4() throws SQLException {
        if (img41.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ15.getText())) && img42.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ16.getText())) && img43.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ17.getText())) && img44.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ18.getText())) && img45.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ19.getText()))) {
            if (onlyOneCall == true) {
                JOptionPane.showMessageDialog(null, "Congratulation, You Won!", "Bingo", JOptionPane.OK_CANCEL_OPTION);
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
                lblGameStarts.setVisible(false);
                lblCountdown.setVisible(false);
                lblGameOver.setVisible(true);
                lblTheWinner.setVisible(true);
                lblWinnerName.setText("You");
                lblWinnerName.setVisible(true);
                lblNextNumber.setVisible(false);
                lblTimer.setVisible(false);
            }
        }
    }

    public void checkIfCrossedVertical5() throws SQLException {
        if (img51.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ20.getText())) && img52.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ21.getText())) && img53.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ22.getText())) && img54.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ23.getText())) && img55.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ24.getText()))) {
            if (onlyOneCall == true) {
                JOptionPane.showMessageDialog(null, "Congratulation, You Won!", "Bingo", JOptionPane.OK_CANCEL_OPTION);
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
                lblGameStarts.setVisible(false);
                lblCountdown.setVisible(false);
                lblGameOver.setVisible(true);
                lblTheWinner.setVisible(true);
                lblWinnerName.setText("You");
                lblWinnerName.setVisible(true);
                lblNextNumber.setVisible(false);
                lblTimer.setVisible(false);
            }
        }
    }

    public void checkIfCrossedHorizontal1() throws SQLException {
        if (img11.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ1.getText())) && img21.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ6.getText())) && img31.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ11.getText())) && img41.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ15.getText())) && img51.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ20.getText()))) {
            if (onlyOneCall == true) {
                JOptionPane.showMessageDialog(null, "Congratulation, You Won!", "Bingo", JOptionPane.OK_CANCEL_OPTION);
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
                lblGameStarts.setVisible(false);
                lblCountdown.setVisible(false);
                lblGameOver.setVisible(true);
                lblTheWinner.setVisible(true);
                lblWinnerName.setText("You");
                lblWinnerName.setVisible(true);
                lblNextNumber.setVisible(false);
                lblTimer.setVisible(false);
            }
        }
    }

    public void checkIfCrossedHorizontal2() throws SQLException {
        if (img12.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ2.getText())) && img22.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ7.getText())) && img32.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ12.getText())) && img42.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ16.getText())) && img52.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ21.getText()))) {
            if (onlyOneCall == true) {
                JOptionPane.showMessageDialog(null, "Congratulation, You Won!", "Bingo", JOptionPane.OK_CANCEL_OPTION);
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
                lblGameStarts.setVisible(false);
                lblCountdown.setVisible(false);
                lblGameOver.setVisible(true);
                lblTheWinner.setVisible(true);
                lblWinnerName.setText("You");
                lblWinnerName.setVisible(true);
                lblNextNumber.setVisible(false);
                lblTimer.setVisible(false);
            }
        }
    }

    public void checkIfCrossedHorizontal3() throws SQLException {
        if (img13.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ3.getText())) && img23.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ8.getText())) && img43.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ17.getText())) && img53.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ22.getText()))) {
            if (onlyOneCall == true) {
                JOptionPane.showMessageDialog(null, "Congratulation, You Won!", "Bingo", JOptionPane.OK_CANCEL_OPTION);
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
                lblGameStarts.setVisible(false);
                lblCountdown.setVisible(false);
                lblGameOver.setVisible(true);
                lblTheWinner.setVisible(true);
                lblWinnerName.setText("You");
                lblWinnerName.setVisible(true);
                lblNextNumber.setVisible(false);
                lblTimer.setVisible(false);
            }
        }
    }

    public void checkIfCrossedHorizontal4() throws SQLException {
        if (img14.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ4.getText())) && img24.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ9.getText())) && img34.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ13.getText())) && img44.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ18.getText())) && img54.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ23.getText()))) {
            if (onlyOneCall == true) {
                JOptionPane.showMessageDialog(null, "Congratulation, You Won!", "Bingo", JOptionPane.OK_CANCEL_OPTION);
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
                lblGameStarts.setVisible(false);
                lblCountdown.setVisible(false);
                lblGameOver.setVisible(true);
                lblTheWinner.setVisible(true);
                lblWinnerName.setText("You");
                lblWinnerName.setVisible(true);
                lblNextNumber.setVisible(false);
                lblTimer.setVisible(false);
            }
        }
    }

    public void checkIfCrossedHorizontal5() throws SQLException {
        if (img15.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ5.getText())) && img25.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ10.getText())) && img35.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ14.getText())) && img45.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ19.getText())) && img55.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ24.getText()))) {
            if (onlyOneCall == true) {
                JOptionPane.showMessageDialog(null, "Congratulation, You Won!", "Bingo", JOptionPane.OK_CANCEL_OPTION);
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
                lblGameStarts.setVisible(false);
                lblCountdown.setVisible(false);
                lblGameOver.setVisible(true);
                lblTheWinner.setVisible(true);
                lblWinnerName.setText("You");
                lblWinnerName.setVisible(true);
                lblNextNumber.setVisible(false);
                lblTimer.setVisible(false);
            }
        }
    }

    public void checkIfDiagonal1() throws SQLException {
        if (img15.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ5.getText())) && img24.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ9.getText())) && img42.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ16.getText())) && img51.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ20.getText()))) {
            if (onlyOneCall == true) {
                JOptionPane.showMessageDialog(null, "Congratulation, You Won!", "Bingo", JOptionPane.OK_CANCEL_OPTION);
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
                lblGameStarts.setVisible(false);
                lblCountdown.setVisible(false);
                lblGameOver.setVisible(true);
                lblTheWinner.setVisible(true);
                lblWinnerName.setText("You");
                lblWinnerName.setVisible(true);
                lblNextNumber.setVisible(false);
                lblTimer.setVisible(false);
            }
        }
    }

    public void checkIfDiagonal2() throws SQLException {
        if (img55.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ24.getText())) && img44.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ18.getText())) && img22.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ7.getText())) && img11.isVisible() == true && checkIfNumberPulled.contains(Integer.valueOf(lblZ1.getText()))) {
            if (onlyOneCall == true) {
                JOptionPane.showMessageDialog(null, "Congratulation, You Won!", "Bingo", JOptionPane.OK_CANCEL_OPTION);
                bingoCall = true;
                onlyOneCall = false;
                timeForNextNumber.stop();
                lblGameStarts.setVisible(false);
                lblCountdown.setVisible(false);
                lblGameOver.setVisible(true);
                lblTheWinner.setVisible(true);
                lblWinnerName.setText("You");
                lblWinnerName.setVisible(true);
                lblNextNumber.setVisible(false);
                lblTimer.setVisible(false);
            }
        }
    }

    public void checkAll() throws SQLException {
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

    public void winner(String bot) throws SQLException {
        this.botName = bot;
        timeForNextNumber.stop();
        btnBingo.setVisible(false);
        btnRestart.setVisible(true);
        lblWinnerName.setVisible(true);
        lblTheWinner.setVisible(true);
        lblGameOver.setVisible(true);
        lblWinnerName.setText(botName);
        lblNextNumber.setVisible(false);
        lblTimer.setVisible(false);
        btnBots.setVisible(false);
        switch (botName) {
            case "Bot 1":
                stage2.close();
                stage3.close();
                stage4.close();
                stage5.close();
                updateChipAmountLoss();
                break;
            case "Bot 2":
                stage.close();
                stage3.close();
                stage4.close();
                stage5.close();
                updateChipAmountLoss();
                break;
            case "Bot 3":
                stage.close();
                stage2.close();
                stage4.close();
                stage5.close();
                updateChipAmountLoss();
                break;
            case "Bot 4":
                stage.close();
                stage2.close();
                stage3.close();
                stage5.close();
                updateChipAmountLoss();
                break;
            case "Bot 5":
                stage.close();
                stage2.close();
                stage3.close();
                stage4.close();
                updateChipAmountLoss();
                break;
            default:
                break;
        }

        KeyFrame frameDuration = new KeyFrame(javafx.util.Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                winnerCount--;
                if (winnerCount == 0) {
                    stage.close();
                    stage2.close();
                    stage3.close();
                    stage4.close();
                    stage5.close();
                }
            }
        });
        timeWinner.setCycleCount(Timeline.INDEFINITE);
        timeWinner.getKeyFrames().add(frameDuration);
        timeWinner.play();
    }

    // Für die Random Names zuständig
    public void botNameOne() {
        Label[] bots = {lblBotOne, lblBotTwo, lblBotThree, lblBotFour, lblBotFive};
        labelBots = bots;

        for (int i = 0; i < 5; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 15 + 1);
            switch (randomNum) {
                case 1:
                    labelBots[i].setText("Vennie");
                    break;
                case 2:
                    labelBots[i].setText("Mona");
                    break;
                case 3:
                    labelBots[i].setText("Lajuana");
                    break;
                case 4:
                    labelBots[i].setText("Viviana");
                    break;
                case 5:
                    labelBots[i].setText("Tyesha");
                    break;
                case 6:
                    labelBots[i].setText("Bennett");
                    break;
                case 7:
                    labelBots[i].setText("Tesha");
                    break;
                case 8:
                    labelBots[i].setText("Nicol");
                    break;
                case 9:
                    labelBots[i].setText("Sasha");
                    break;
                case 10:
                    labelBots[i].setText("Annamaria");
                    break;
                case 11:
                    labelBots[i].setText("Zula");
                    break;
                case 12:
                    labelBots[i].setText("Jonas");
                    break;
                case 13:
                    labelBots[i].setText("Peter");
                    break;
                case 14:
                    labelBots[i].setText("Julian");
                    break;
                case 15:
                    labelBots[i].setText("Emma");
                    break;
            }
        }
    }
}
