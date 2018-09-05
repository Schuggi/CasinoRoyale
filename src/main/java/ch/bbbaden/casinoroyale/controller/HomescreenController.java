/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import ch.bbbaden.casinoroyale.model.Actions;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author sharu
 */
public class HomescreenController implements Initializable {

    @FXML
    private JFXTextField txtPayment;
    @FXML
    private Button btnBuy;
    @FXML
    private ImageView btnLogout;
    @FXML
    private Label lblChips;
    @FXML
    private Button btnNotBuy;
    Actions actions = Actions.getInstance();
    @FXML
    private Label lblActiveUser;
    @FXML
    private Label lblChipss;
    Integer gekaufteChips;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            gekaufteChips = actions.getGekaufteChips();
        } catch (SQLException ex) {
            Logger.getLogger(HomescreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // TODO
            lblChipss.setText(String.valueOf(actions.getChipsRoulette()));
        } catch (SQLException ex) {
            Logger.getLogger(HomescreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblActiveUser.setText(actions.getUsername());
    }

    @FXML
    private void btnBuy(ActionEvent event) throws IOException, SQLException {
        String regex = "[0-9]+";
        if (!txtPayment.getText().matches(regex)) {
            JOptionPane.showMessageDialog(null, "Only Numbers!");
        } else {
            Integer convert = Integer.valueOf(txtPayment.getText());
            Integer inputTextField = Integer.valueOf(txtPayment.getText());
            Integer inputTextFieldTest = convert + gekaufteChips;
            Integer winChip = actions.getChipsRoulette() + inputTextField;
            Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
            Statement myStmt = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement(
                    "update users set chips = ? where email like " + actions.getEmail());
            ps.setInt(1, winChip);
            ps.executeUpdate();
            ps.close();
            PreparedStatement psBingo = connection.prepareStatement(
                    "update logbingo set gekauftechips = ? where user like " + actions.getEmail());
            psBingo.setInt(1, inputTextFieldTest);
            psBingo.executeUpdate();
            psBingo.close();
            PreparedStatement psBlackJack = connection.prepareStatement(
                    "update logblackjack set gekauftechips = ? where user like " + actions.getEmail());
            psBlackJack.setInt(1, inputTextFieldTest);
            psBlackJack.executeUpdate();
            psBlackJack.close();
            PreparedStatement psRoulette = connection.prepareStatement(
                    "update logroulette set gekauftechips = ? where user like " + actions.getEmail());
            psRoulette.setInt(1, inputTextFieldTest);
            psRoulette.executeUpdate();
            psRoulette.close();
            PreparedStatement psBaccara = connection.prepareStatement(
                    "update logbaccara set gekauftechips = ? where user like " + actions.getEmail());
            psBaccara.setInt(1, inputTextFieldTest);
            psBaccara.executeUpdate();
            psBaccara.close();
            PreparedStatement psYatzy = connection.prepareStatement(
                    "update logyatzy set gekauftechips = ? where user like " + actions.getEmail());
            psYatzy.setInt(1, inputTextFieldTest);
            psYatzy.executeUpdate();
            psYatzy.close();
            lblChipss.setText(String.valueOf(winChip));
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/GameSelection.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.setResizable(false);
            window.show();
        }
    }

    @FXML
    private void btnLogout(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/WelcomeScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    @FXML
    private void btnNotBuy(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/GameSelection.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    @FXML
    private void updateTextField() {
        lblChips.setText(txtPayment.getText());
    }

}
