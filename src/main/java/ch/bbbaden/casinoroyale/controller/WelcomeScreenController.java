/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import ch.bbbaden.casinoroyale.model.Actions;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class WelcomeScreenController implements Initializable {

    @FXML
    private Button btnSignUp;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Label btnProblem;
    Actions actions = Actions.getInstance();
    ArrayList<String> arr = new ArrayList();
    ArrayList<String> arrSignUp = new ArrayList();
    Integer counter = 0;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void btnLogin(ActionEvent event) throws IOException, SQLException {

        // Überprüft ob Eingabe Admin Admin ist
        if (txtEmail.getText().equals("Admin") && txtPassword.getText().equals("Admin")) {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Stats.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
            // Überprüft ob Benutzer mit Passwort in Datenbank vorkommt
        } else {
            actions.getUserData(arr);
            actions.setMail(txtEmail.getText());
            actions.setPassword(txtPassword.getText());
            actions.checkCorrectData(event);
        }
    }

    @FXML
    private void btnSignUp(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/SignUp.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    private void btnWeiter(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Homescreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    @FXML
    private void clickedForgotPassword(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/fxml/ForgotPassword.fxml"));
        stage = new Stage();
        stage.setTitle("Forgot Password");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
