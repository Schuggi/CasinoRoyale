/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import ch.bbbaden.casinoroyale.model.Actions;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ShopController implements Initializable {

    @FXML
    private JFXSlider sliderChips;
    @FXML
    private JFXTextField txtPayment;
    @FXML
    private Button btnBuy;
    @FXML
    private Label lblChips;
    @FXML
    private Label lblActiveUser;
    @FXML
    private Label lblChipss;

    Actions actions = Actions.getInstance();
    @FXML
    private Button btnBack;
    Stage stage = new Stage();
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
            Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        instance = this;
        try {
            // TODO
            lblChipss.setText(String.valueOf(actions.getChipsRoulette()));
        } catch (SQLException ex) {
            Logger.getLogger(HomescreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblActiveUser.setText(actions.getUsername());
    }

    @FXML
    private void GetAmountSlider(MouseEvent event) {
        int toInt = (int) sliderChips.getValue();
        txtPayment.setText(Integer.toString(toInt));
        lblChips.setText(Integer.toString(toInt));
    }

    @FXML
    private void updateTextField() {
        lblChips.setText(txtPayment.getText());
    }

    public String txtPayment() {
        return txtPayment.getText();
    }

    @FXML
    private void ButtonActionBuy(ActionEvent event) throws SQLException {
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
            try (PreparedStatement ps = connection.prepareStatement(
                    "update users set chips = ? where email like " + actions.getEmail())) {
                ps.setInt(1, winChip);
                ps.executeUpdate();
            }
            try (PreparedStatement psBingo = connection.prepareStatement(
                    "update logbingo set gekauftechips = ? where user like " + actions.getEmail())) {
                psBingo.setInt(1, inputTextFieldTest);
                psBingo.executeUpdate();
            }
            try (PreparedStatement psBaccara = connection.prepareStatement(
                    "update logbaccara set gekauftechips = ? where user like " + actions.getEmail())) {
                psBaccara.setInt(1, inputTextFieldTest);
                psBaccara.executeUpdate();
            }
            PreparedStatement psBlackJack = connection.prepareStatement(
                    "update logbaccara set gekauftechips = ? where user like " + actions.getEmail());
            psBlackJack.setInt(1, inputTextFieldTest);
            psBlackJack.executeUpdate();
            psBlackJack.close();
            PreparedStatement psYatzy = connection.prepareStatement(
                    "update logbaccara set gekauftechips = ? where user like " + actions.getEmail());
            psYatzy.setInt(1, inputTextFieldTest);
            psYatzy.executeUpdate();
            psYatzy.close();
            psBlackJack.close();
            PreparedStatement psRoulette = connection.prepareStatement(
                    "update logbaccara set gekauftechips = ? where user like " + actions.getEmail());
            psRoulette.setInt(1, inputTextFieldTest);
            psRoulette.executeUpdate();
            psRoulette.close();
            lblChipss.setText(String.valueOf(winChip));

            JOptionPane.showMessageDialog(null, "Your selected Amount has been added to your account. It won't be displayed, until you load a new Game.", "Payment request",
                    JOptionPane.INFORMATION_MESSAGE);

//            RouletteHauptScreenController rhsc = new RouletteHauptScreenController();
//                RouletteHauptScreenController roulettescreen = RouletteHauptScreenController.getInstance();
//            c.setLblChips(txtPayment());
            ((Node) (event.getSource())).getScene().getWindow().hide();
        }
    }

    @FXML
    private void ButtonActionBack(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
