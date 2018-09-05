package ch.bbbaden.casinoroyale.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Rafael Meier
 */
public class YatzyStartScreenController implements Initializable {

    static YatzyStartScreenController instance;
    Integer passAmount;
    Actions actions = Actions.getInstance();
    Integer updatedChip;
    Integer chipsInt;
    Integer yatzyRounds;
    Integer yatzyPlayed;
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
            Connection myConn = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
            Statement myStmt = myConn.createStatement();
            ResultSet rs = myStmt.executeQuery("select yatzygames from loggames;");
            while (rs.next()) {
                yatzyPlayed = rs.getInt(1);
            }
            yatzyRounds = actions.updateRoundsBingo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO
        instance = this;
        try {
            lblChips.setText(String.valueOf(actions.getChipsRoulette()));
        } catch (SQLException ex) {
            Logger.getLogger(YatzyStartScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static YatzyStartScreenController getInstance() {
        if (instance == null) {
            instance = new YatzyStartScreenController();
        }
        return instance;
    }

    public Integer passAmount() {
        return passAmount;
    }

    private void updateChipAmount() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        PreparedStatement ps = connection.prepareStatement(
                "update users set chips = ? where email like " + actions.getEmail());
        ps.setInt(1, updatedChip);
        ps.executeUpdate();
        ps.close();
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
        if (txtChipAmount.getText().matches(regex)) {
            if (Integer.valueOf(txtChipAmount.getText()) >= 10 && Integer.valueOf(txtChipAmount.getText()) < chipsInt) {
                updateYatzyRounds();
                updateYatzyGames();
                updatedChip = chipsInt - Integer.valueOf(txtChipAmount.getText());
                updateChipAmount();
                passAmount = Integer.valueOf(txtChipAmount.getText());
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Yatzy/Yatzy.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.setResizable(false);
                window.show();
            } else if (Integer.valueOf(txtChipAmount.getText()) % 2 != 0) {
                JOptionPane.showMessageDialog(null, "Your number must divide by 2!");
            } else if (Integer.valueOf(txtChipAmount.getText()) < 10) {
                JOptionPane.showMessageDialog(null, "You have to bet at least 10 chips!", "Bet more Chips or buy more", JOptionPane.OK_CANCEL_OPTION);
            } else if (Integer.valueOf(txtChipAmount.getText()) > chipsInt) {
                JOptionPane.showMessageDialog(null, "You don't have enough chips!", "Buy More Chips", JOptionPane.OK_CANCEL_OPTION);
            } else {
                updateYatzyRounds();
                updatedChip = chipsInt - Integer.valueOf(txtChipAmount.getText());
                updateChipAmount();
                passAmount = Integer.valueOf(txtChipAmount.getText());
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Yatzy/Yatzy.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.setResizable(false);
                window.show();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Only Numbers Are Allowed!", "Fail", JOptionPane.OK_CANCEL_OPTION);
        }
    }

    @FXML
    private void btnHelp(ActionEvent event) throws URISyntaxException, IOException {

        Desktop d = Desktop.getDesktop();
        d.browse(new URI("https://www.gamevelvet.com/yatzy-online/rules"));
    }

    @FXML
    private void getAmountSlider(MouseEvent event) {
        int i = (int) SliderChips.getValue();
        txtChipAmount.setText(Integer.toString(i));
    }

    private void updateYatzyRounds() throws SQLException {
        newUpdate();
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        PreparedStatement ps = connection.prepareStatement(
                "update logyatzy set rounds = ? where user like " + actions.getEmail());
        ps.setInt(1, yatzyRounds + 1);
        ps.executeUpdate();
        ps.close();
    }

    private void newUpdate() throws SQLException {
        yatzyRounds = actions.updateRoundsYatzy();
    }

    private void updateYatzyGames() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        PreparedStatement ps = connection.prepareStatement(
                "update loggames set yatzygames = ? where id like '1'");
        ps.setInt(1, yatzyPlayed + 1);
        ps.executeUpdate();
        ps.close();
    }

}
