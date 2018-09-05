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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class SignUpController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtFirstName;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private JFXPasswordField txtConfirmPassword;
    @FXML
    private Button btnSignUp;
    Actions actions = new Actions();
    ArrayList<String> arrSignUp = new ArrayList();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void toStartScreen(ActionEvent event) throws IOException {
        actions.toStartScreen(event);
    }

    // Ruft die Methoden von Actions auf, falls Eingabe muss man dann seine Mail registrieren
    @FXML
    private void btnSignUp(ActionEvent event) throws SQLException, IOException {
        actions.getUserDataSignUp(arrSignUp);
        actions.setMailSignUp(txtEmail.getText());
        actions.setNameSignUp(txtName.getText());
        actions.setFirstNameSignUp(txtFirstName.getText());
        actions.setPasswordSignuUp(txtPassword.getText());
        actions.setConfirmPasswordSignUp(txtConfirmPassword.getText());
        actions.sender(event);
    }

}
