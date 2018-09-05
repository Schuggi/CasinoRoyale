/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import static ch.bbbaden.casinoroyale.controller.RouletteHauptScreenController.rootP;
import ch.bbbaden.casinoroyale.model.Actions;
import ch.bbbaden.casinoroyale.model.TestJoelModel;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Joel
 */
public class TestJoelController implements Initializable {

    TestJoelModel tjm = new TestJoelModel();
    Actions actions = Actions.getInstance();
    @FXML
    private Label lblActiveUser;
    @FXML
    private Label lblChips;
    @FXML
    private JFXDrawer JFXMenu;
    @FXML
    private JFXHamburger JFXMenuButton;
    @FXML
    private AnchorPane ApYatzy;
    @FXML
    private ImageView imgView1;
    @FXML
    private ImageView imgView2;
    @FXML
    private ImageView imgView3;
    @FXML
    private ImageView imgView4;
    @FXML
    private ImageView imgView5;
    @FXML
    private Button btnOK1;
    @FXML
    private Button btnOK2;
    @FXML
    private Button btnOK3;
    @FXML
    private Button btnOK4;
    @FXML
    private Button btnOK5;
    @FXML
    private Button btnOK6;
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf4;
    @FXML
    private TextField tf5;
    @FXML
    private TextField tf6;
    @FXML
    private Button btnShowDice;

    @FXML
    private void btnShowDice(ActionEvent event) throws IOException {

        tjm.getDiceNR();

        Image a = new Image(tjm.dice.get(0));
        Image b = new Image(tjm.dice.get(1));
        Image c = new Image(tjm.dice.get(2));
        Image d = new Image(tjm.dice.get(3));
        Image e = new Image(tjm.dice.get(4));

        imgView1.setImage(a);
        imgView2.setImage(b);
        imgView3.setImage(c);
        imgView4.setImage(d);
        imgView5.setImage(e);

        tjm.dice.clear();
        btnOK1.setVisible(true);
        btnOK2.setVisible(true);
        btnOK3.setVisible(true);
        btnOK4.setVisible(true);
        btnOK5.setVisible(true);
        btnOK6.setVisible(true);
        btnShowDice.setVisible(false);
    }

    @FXML
    private void btnOK1() {

        btnOK1.setVisible(false);
        if (tf1.getText() != null) {
            tf1.setDisable(true);
        }
        btnShowDice.setVisible(true);
    }

    @FXML
    private void btnOK2() {
        btnOK2.setVisible(false);
        if (tf2.getText() != null) {
            tf2.setDisable(true);
        } else {
            tf2.setDisable(false);
        }
        btnShowDice.setVisible(true);
    }

    @FXML
    private void btnOK3() {
        btnOK3.setVisible(false);
        if (tf3.getText() != null) {
            tf3.setDisable(true);
        } else {
            tf3.setDisable(false);
        }
        btnShowDice.setVisible(true);
    }

    @FXML
    private void btnOK4() {
        btnOK4.setVisible(false);
        if (tf4.getText() != null) {
            tf4.setDisable(true);
        } else {
            tf4.setDisable(false);
        }
        btnShowDice.setVisible(true);
    }

    @FXML
    private void btnOK5() {
        btnOK5.setVisible(false);
        if (tf5.getText() != null) {
            tf5.setDisable(true);
        } else {
            tf5.setDisable(false);
        }
        btnShowDice.setVisible(true);
    }

    @FXML
    private void btnOK6() {
        btnOK6.setVisible(false);
        if (tf6.getText() != null) {
            tf6.setDisable(true);
        } else {
            tf6.setDisable(false);
        }
        btnShowDice.setVisible(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
    }
}
