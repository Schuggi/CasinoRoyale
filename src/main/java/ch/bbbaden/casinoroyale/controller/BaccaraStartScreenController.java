/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

//import ch.bbbaden.casinoroyale.model.Baccara;
import ch.bbbaden.casinoroyale.model.Actions;
import com.jfoenix.controls.JFXSlider;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Joel
 */
public class BaccaraStartScreenController implements Initializable {

    static BaccaraStartScreenController instance;
    Integer chipsInt;
    Integer updatedChip;
    Integer passAmount;
    Integer baccaraPlayed = 0;
    Integer baccaraRounds;
    Actions actions = Actions.getInstance();
    @FXML
    private JFXSlider SliderChips;
    @FXML
    private TextField txtChipAmount;
    @FXML
    private ImageView Coin;
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
        try {
            baccaraRounds = actions.updateRoundsBaccara();
        } catch (Exception e) {
            e.printStackTrace();
        }
        instance = this;
        try {
            // TODO
            lblChips.setText(String.valueOf(actions.getChipsRoulette()));
        } catch (SQLException ex) {
            Logger.getLogger(BaccaraStartScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static BaccaraStartScreenController getInstance() {
        if (instance == null) {
            instance = new BaccaraStartScreenController();
        }
        return instance;
    }

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/GameSelection.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    @FXML
    private void btnStart(ActionEvent event) throws IOException, SQLException {
        String regex = "[0-9]+";
        String chips = String.valueOf(actions.getChipsRoulette());
        chipsInt = Integer.valueOf(chips);
        if (txtChipAmount.getText().matches(regex) && Integer.valueOf(txtChipAmount.getText()) % 2 == 0) {
            if (Integer.valueOf(txtChipAmount.getText()) > 0 && Integer.valueOf(txtChipAmount.getText()) <= chipsInt) {
                updateBaccaraRounds();
                updatedChip = chipsInt - Integer.valueOf(txtChipAmount.getText());
                updateChipAmount();
                passAmount = Integer.valueOf(txtChipAmount.getText());
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Baccara/BaccaraGameScreen.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.setResizable(false);
                window.show();
            } else if (Integer.valueOf(txtChipAmount.getText()) > chipsInt) {
                JOptionPane.showMessageDialog(null, "You don't have enough chips!", "Buy More Chips", JOptionPane.OK_CANCEL_OPTION);
            } else if (Integer.valueOf(txtChipAmount.getText()) <= 10) {
                JOptionPane.showMessageDialog(null, "You have to bet at least 10 chips!", "Bet more Chips or buy more", JOptionPane.OK_CANCEL_OPTION);
            } else if (Integer.valueOf(txtChipAmount.getText()) % 2 != 0) {
                JOptionPane.showMessageDialog(null, "Your number must divide by 2!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Only Numbers!");
        }

    }

    public Integer passAmount() {
        return passAmount;
    }

    @FXML
    private void btnHelp(ActionEvent event) throws URISyntaxException, IOException {
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("https://www.casino.com.de/baccara/regeln"));
    }

    @FXML
    private void getAmountSlider(MouseEvent event) {
        int i = (int) SliderChips.getValue();
        txtChipAmount.setText(Integer.toString(i));
    }

    private void updateChipAmount() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        try (PreparedStatement ps = connection.prepareStatement(
                "update users set chips = ? where email like " + actions.getEmail())) {
            ps.setInt(1, updatedChip);
            ps.executeUpdate();
        }
    }

    private void updateBaccaraRounds() throws SQLException {
        newUpdate();
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        try (PreparedStatement ps = connection.prepareStatement(
                "update logbaccara set rounds = ? where user like " + actions.getEmail())) {
            ps.setInt(1, baccaraRounds + 1);
            ps.executeUpdate();
        }
    }

    private void newUpdate() throws SQLException {
        baccaraRounds = actions.updateRoundsBaccara();
    }

}
