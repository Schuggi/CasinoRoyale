/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import ch.bbbaden.casinoroyale.model.Actions;
import ch.bbbaden.casinoroyale.model.Bingo;
import java.io.IOException;
import java.net.URL;
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
public class BingoStartScreenController implements Initializable {

    Bingo bingo = new Bingo();
    Actions actions = Actions.getInstance();
    @FXML
    private Button btnStartGame;
    @FXML
    private Button btnBack;

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
    public void btnStartGame(ActionEvent event) throws IOException {
        bingo.startGame(event);
    }

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        bingo.gameSelection(event);
    }

}
