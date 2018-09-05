/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import ch.bbbaden.casinoroyale.model.Actions;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class GameSelectionController implements Initializable {

    String firstName;
    String abschneiden;
    String save;

    @FXML
    private ImageView ImageViewBlackJack;
    @FXML
    private ImageView ImageViewYatzi;
    @FXML
    private ImageView ImageViewRoulette;
    @FXML
    private ImageView ImageViewBingo;
    @FXML
    private ImageView ImageViewBaccara;
    @FXML
    private ImageView ImageViewLogout;
    @FXML
    private Button btnChips;
    @FXML
    private Label lblActiveUser;
    @FXML
    private Label lblChipss;
    Actions actions = Actions.getInstance();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            lblChipss.setText(String.valueOf(actions.getChipsRoulette()));
        } catch (SQLException ex) {
            Logger.getLogger(HomescreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblActiveUser.setText(actions.getUsername());
    }

    @FXML
    private void btnBlackJack(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/BlackJack/BlackJackStartScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    @FXML
    private void btnYatzi(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Yatzy/YatzyStartScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    @FXML
    private void btnRoulette(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Roulette/RouletteStartScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    @FXML
    private void btnBingo(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Bingo/BingoStartScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    @FXML
    private void btnBaccara(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Baccara/BaccaraStartScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    @FXML
    private void btnBack(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/WelcomeScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    @FXML
    private void btnChips(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/fxml/Shop.fxml"));
        Stage stage = new Stage();
//        ShopController sc= new ShopController();
        stage.setTitle("Shop");
        stage.setScene(new Scene(root));
        stage.show();
        javafx.geometry.Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    }
}
