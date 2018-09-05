/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import ch.bbbaden.casinoroyale.model.Actions;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yanick Schlatter
 */
public class RouletteStartScreenController implements Initializable {

    @FXML
    private ImageView ImageViewHintergrund;
    @FXML
    private Label lblTitel;
    @FXML
    private Label lblText;
    @FXML
    private Button btnBack1;
    @FXML
    private Button btnWeiter1;
    @FXML
    private Button btnRules;
    @FXML
    private Label lblText1;
    Actions actions = Actions.getInstance();
    @FXML
    private Label lblChips;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
            Statement myStmt = myConn.createStatement();
            ResultSet rs = myStmt.executeQuery("select roulettegames from loggames;");
            lblChips.setText(String.valueOf(actions.getChipsRoulette()));
        } catch (SQLException ex) {
            Logger.getLogger(BaccaraGameScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void HandleButtonActionBack1(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/GameSelection.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    @FXML
    private void HandleButtonActionWeiter1(ActionEvent event) throws IOException, SQLException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Roulette/RouletteHauptScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();

    }

    @FXML
    private void HandleButtonActionRules(ActionEvent event) throws URISyntaxException, IOException {
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://www.rouletteonline.net/how-to-play-roulette/"));
    }
}
