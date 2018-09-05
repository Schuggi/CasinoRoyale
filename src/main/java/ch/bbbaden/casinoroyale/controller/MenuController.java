/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import com.jfoenix.controls.JFXButton;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yanick Schlatter
 */
public class MenuController implements Initializable {

    @FXML
    private VBox vBoxMenu;
    @FXML
    private JFXButton jfxBtnQuit;
    @FXML
    private JFXButton jfxBtnHelp;
    @FXML
    private JFXButton jfxBtnLogOut;
    @FXML
    private JFXButton jfxBtnExit;
    @FXML
    private JFXButton jfxBtnQuit1;
    private RouletteHauptScreenController c;

    public void setC(RouletteHauptScreenController c) {
        this.c = c;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Help(ActionEvent event) throws URISyntaxException, IOException {
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("https://support.google.com/?hl=de"));

    }

    @FXML
    private void LogOut(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/WelcomeScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    @FXML
    private void Exit(ActionEvent event) {
        System.exit(0);
    }

    //go to GameSelection
    @FXML
    private void Quit(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/GameSelection.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    @FXML
    private void Shop(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/fxml/Shop.fxml"));
        Stage stage = new Stage();
//        ShopController sc= new ShopController(c);
        stage.setTitle("Shop");
        stage.setScene(new Scene(root));
        stage.show();
        javafx.geometry.Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    }

}
