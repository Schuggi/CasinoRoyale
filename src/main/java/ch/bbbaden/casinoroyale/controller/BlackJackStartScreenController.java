package ch.bbbaden.casinoroyale.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ch.bbbaden.casinoroyale.model.Actions;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sharu
 */
public class BlackJackStartScreenController implements Initializable {

    @FXML
    private ImageView ImageView;
    @FXML
    private ImageView lblBlackjack;
    @FXML
    private Label lblChips;
    @FXML
    private Label lblinstruction;
    @FXML
    private Button btnBlackjack;
    @FXML
    private Hyperlink lblRules;
    @FXML
    private Button btnBack;
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
            lblChips.setText(String.valueOf(actions.getChipsRoulette()));
        } catch (SQLException ex) {
            Logger.getLogger(BlackJackStartScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openBrowser(ActionEvent event) throws URISyntaxException, IOException {
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("https://www.google.com"));
    }

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/GameSelection.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    public void startBlackjack(ActionEvent event) throws IOException, SQLException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/BlackJack/Blackjack.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }
}
