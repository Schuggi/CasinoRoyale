/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import ch.bbbaden.casinoroyale.model.Actions;
import ch.bbbaden.casinoroyale.model.Baccara;
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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Joel
 */
public class BaccaraGameScreenController implements Initializable {

    Baccara baccara = new Baccara();
    //---Start---cardsPlayer---
    @FXML
    private ImageView imgView;
    @FXML
    private ImageView imgView2;
    @FXML
    private ImageView imgView3;
    @FXML
    private ImageView imgView4;
    @FXML
    private ImageView imgView5;
    //---Start---cardsCroupier---
    @FXML
    private ImageView imgView6;
    @FXML
    private ImageView imgView7;
    @FXML
    private ImageView imgView8;
    @FXML
    private ImageView imgView10;
    //---end-----cards----------
    @FXML
    private Label lblPointsPlayer;
    @FXML
    private Label lblPointsCroupier;
    @FXML
    private Button loadImg;
    @FXML
    private Button btnStay;
    @FXML
    private Button btnPull;
    @FXML
    private Label lblChips;
    @FXML
    private JFXDrawer JFXMenu;
    @FXML
    private JFXHamburger JFXMenuButton;
    @FXML
    private AnchorPane ApBaccara;
    @FXML
    private Button btnRestart;
    @FXML
    private Label lblWhatDo;
    @FXML
    private Label lblActiveUser;
    @FXML
    private Label lblChipsSet;
    @FXML
    private ImageView imgvWL;
    @FXML
    private Button btnOK;
    @FXML
    private Label lblWinChip;
    public static AnchorPane rootP;
    Actions actions = Actions.getInstance();
    BaccaraStartScreenController baccaraStartScreen = BaccaraStartScreenController.getInstance();
    Integer winChip;
    Integer gewinn;
    Integer verlust;
    Integer draw;
    Integer baccaraPlayed;
    //---Attributes------------------

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lblChipsSet.setText("" + baccaraStartScreen.passAmount);
        rootP = ApBaccara;
        lblActiveUser.setText(actions.getUsername());
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
            Statement myStmt = myConn.createStatement();
            ResultSet rs = myStmt.executeQuery("select baccaragames from loggames;");
            while (rs.next()) {
                baccaraPlayed = rs.getInt(1);
            }
            lblChips.setText(String.valueOf(actions.getChipsRoulette()));
        } catch (SQLException ex) {
            Logger.getLogger(BaccaraGameScreenController.class.getName()).log(Level.SEVERE, null, ex);
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
    }

    @FXML
    private void loadImg(ActionEvent event) throws IOException, SQLException {

        updateBaccaraGames();

//        baccara.getCard1();
//        Image a = new Image(baccara.dice.get(0));
//        Image b = new Image(baccara.dice.get(1));
//        Image c = new Image(baccara.dice.get(2));
//        Image d = new Image(baccara.dice.get(3));
//        Image e = new Image(baccara.dice.get(4));
//
//        imgView.setImage(a);
//        imgView2.setImage(b);
//        imgView6.setImage(c);
//        imgView7.setImage(d);
//
//        baccara.dice.clear();
        //-----Karten setzen------------//
        imgView.setImage(baccara.getCardPlayer1());
        imgView2.setImage(baccara.getCardPlayer2());

        imgView6.setImage(baccara.getCardCroupier1());
        imgView7.setImage(baccara.getCardCroupier2());

        //-----Kartenpunkte anzeigen-----//
        lblPointsPlayer.setText("" + baccara.getPointsP());
        lblPointsCroupier.setText("" + baccara.getPointsC());
        loadImg.setDisable(true);

        switch (baccara.getPointsP()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                lblWhatDo.setText("Pull a Card!");
                btnPull.setVisible(true);
                break;
            case 6:
            case 7:
                lblWhatDo.setText("Pass");
                if (baccara.pointsC2 <= 6) {
                    do {
                        imgView8.setImage(baccara.getCardCroupier3());   //Karte ziehen oder nicht?
                        lblPointsCroupier.setText("" + baccara.getPointsC2());
                    } while (baccara.getPointsC2() <= 5);
                }
                break;
            case 8:
            case 9:
                lblWhatDo.setText("Stay");
                if (baccara.pointsC2 <= 6) {
                    do {
                        imgView8.setImage(baccara.getCardCroupier3());   //Karte ziehen oder nicht?
                        lblPointsCroupier.setText("" + baccara.getPointsC2());
                    } while (baccara.getPointsC2() <= 5);
                }
                break;
        }

        if (baccara.getPointsP2() > 5) {
            btnOK.setVisible(true);
        }
    }

    @FXML
    private void btnPull(ActionEvent event) throws IOException {

        do {
            imgView3.setImage(baccara.getCardPlayer3());
            lblPointsPlayer.setText("" + baccara.getPointsP2());
        } while (baccara.getPointsP2() <= 5);

        btnStay.setVisible(true);
        btnPull.setVisible(false);
        //unbedingt noch betrag abziehen/hinzufüegen in Datenbank
    }

    @FXML
    private void btnStay(ActionEvent event) throws SQLException {
        if (baccara.pointsC2 <= 6) {
            do {
                imgView8.setImage(baccara.getCardCroupier3());   //--
                lblPointsCroupier.setText("" + baccara.getPointsC2());
            } while (baccara.getPointsC2() <= 5);
        }
        btnStay.setVisible(false);
        btnRestart.setVisible(true);

        if (baccara.getPointsP2() - baccara.getPointsC2() > 0) {
            //win
            imgvWL.setImage(new Image("/Images/win.jpg"));
            System.out.println("Win");
            updateChipAmount();
            updateChipBaccaraWin();
            lblChips.setText(String.valueOf(actions.getChipsRoulette()));

        } else if (baccara.getPointsP2() - baccara.getPointsC2() == 0) {
            //draw
            imgvWL.setImage(new Image("/Images/draw.jpg"));
            System.out.println("Draw");
            updateChipBaccaraDraw();
            lblChips.setText(String.valueOf(actions.getChipsRoulette()));
        } else {
            //lose
            imgvWL.setImage(new Image("/Images/lose.jpg"));
            System.out.println("Lose");
            updateChipBaccaraLoss();
        }
    }

    @FXML
    private void btnOK(ActionEvent event) throws SQLException {

        if (baccara.getPointsP2() - baccara.getPointsC2() > 0) {
            //win
            imgvWL.setImage(new Image("/Images/win.jpg"));
            System.out.println("Win");
            updateChipAmount();
            updateChipBaccaraWin();
            lblChips.setText(String.valueOf(actions.getChipsRoulette()));
        } else if (baccara.getPointsP2() - baccara.getPointsC2() == 0) {
            //draw
            imgvWL.setImage(new Image("/Images/draw.jpg"));
            System.out.println("Draw");
            updateChipBaccaraDraw();
            lblChips.setText(String.valueOf(actions.getChipsRoulette()));
        } else {
            //lose
            imgvWL.setImage(new Image("/Images/lose.jpg"));
            System.out.println("Lose");
            updateChipBaccaraLoss();
        }

        lblWinChip.setText("" + baccaraStartScreen.passAmount * 2);
        btnOK.setVisible(false);
        btnRestart.setVisible(true);
    }

    @FXML
    private void btnRestart(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Baccara/BaccaraStartScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    private void updateChipAmount() throws SQLException {
        winChip = actions.getChipsRoulette() + (baccaraStartScreen.passAmount * 2);
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        try (PreparedStatement ps = connection.prepareStatement(
                "update users set chips = ? where email like " + actions.getEmail())) {
            ps.setInt(1, winChip);
            ps.executeUpdate();
        }
    }

    private void updateChipBaccaraWin() throws SQLException {
        gewinn = actions.getWinBaccara() + baccaraStartScreen.passAmount;
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        try (PreparedStatement ps = connection.prepareStatement(
                "update logbaccara set gewinn = ? where user like " + actions.getEmail())) {
            ps.setInt(1, gewinn);
            ps.executeUpdate();
        }
    }

    private void updateChipBaccaraLoss() throws SQLException {
        verlust = actions.getLossBaccara() + baccaraStartScreen.passAmount;
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        try (PreparedStatement ps = connection.prepareStatement(
                "update logbaccara set verlust = ? where user like " + actions.getEmail())) {
            ps.setInt(1, verlust);
            ps.executeUpdate();
        }
    }

    private void updateChipBaccaraDraw() throws SQLException {
        draw = actions.getChipsRoulette() + baccaraStartScreen.passAmount;
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        try (PreparedStatement ps = connection.prepareStatement(
                "update users set chips = ? where email like " + actions.getEmail())) {
            ps.setInt(1, draw);
            ps.executeUpdate();
        }
    }

    private void updateBaccaraGames() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        try (PreparedStatement ps = connection.prepareStatement(
                "update loggames set baccaragames = ? where id like '1'")) {
            ps.setInt(1, baccaraPlayed + 1);
            ps.executeUpdate();
        }
    }
}
