/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import ch.bbbaden.casinoroyale.model.Actions;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class BingoBuyCardController implements Initializable {

    @FXML
    private Button btnStartGame;
    @FXML
    private Button btnBack;
    Actions actions = Actions.getInstance();
    Integer chipsInt;
    Integer updatedChip;
    Integer bingoPlayed;
    Integer bingoRounds;
    Integer allRounds;
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
        // Liest die Anzahl der Bingospiele aus
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
            Statement myStmt = myConn.createStatement();
            ResultSet rs = myStmt.executeQuery("select bingogames from loggames;");
            while (rs.next()) {
                bingoPlayed = rs.getInt(1);
            }
            bingoRounds = actions.updateRoundsBingo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Schreibt den Username rechts oben hin
        lblActiveUser.setText(actions.getUsername());
        try {
            // Schreib die Anzahl Chips des Benutzers rechts oben hin
            lblChips.setText(String.valueOf(actions.getChipsRoulette()));
        } catch (SQLException ex) {
            Logger.getLogger(BingoBuyCardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void btnStartGame(ActionEvent event) throws IOException, SQLException {
        // Bingo Runden und Games +1
        updateBingoGames();
        updateBingoRounds();
        // Liest die Anzahl Chips aus der Datenbank aus
        String chips = String.valueOf(actions.getChipsRoulette());
        chipsInt = Integer.valueOf(chips);

        // Überprüft ob man genug Chips hat
        if (chipsInt >= 50) {
            updatedChip = chipsInt - 50;
            updateChipAmount();
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Bingo/BingoGame.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.setResizable(false);
            window.show();
        } else {
            JOptionPane.showMessageDialog(null, "You don't have enough chips, sorry!", "Buy New Chips", JOptionPane.OK_CANCEL_OPTION);
        }
    }

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Bingo/BingoStartScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    // Schreibt den neuen Betrag für die Chips in die Datenbank
    private void updateChipAmount() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        PreparedStatement ps = connection.prepareStatement(
                "update users set chips = ? where email like " + actions.getEmail());
        ps.setInt(1, updatedChip);
        ps.executeUpdate();
        ps.close();
    }

    // Schreibt die Anzahl Spiele in die Datenbank
    private void updateBingoGames() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        PreparedStatement ps = connection.prepareStatement(
                "update loggames set bingogames = ? where id like '1'");
        ps.setInt(1, bingoPlayed + 1);
        ps.executeUpdate();
        ps.close();
    }

    // Schreibt die Anzahl Runden in die Datenbank
    private void updateBingoRounds() throws SQLException {
        newUpdate();
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        PreparedStatement ps = connection.prepareStatement(
                "update logbingo set rounds = ? where user like " + actions.getEmail());
        ps.setInt(1, bingoRounds + 1);
        ps.executeUpdate();
        ps.close();
    }

    // Liest die aktuellen Bingorunden aus
    private void newUpdate() throws SQLException {
        bingoRounds = actions.updateRoundsBingo();
    }

}
