/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.model;

import ch.bbbaden.casinoroyale.controller.BingoGameController;
import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Yannick
 */
public class Bingo {

    BingoGameController bingo = new BingoGameController();
    Integer starttime = 120;
    Integer seconds = starttime;
    Boolean timer = true;
    String botNameOne;
    static Bingo instance;

    public static Bingo getInstance() {
        if (instance == null) {
            instance = new Bingo();
        }
        return instance;
    }

    public Integer durationBotNumber() {
        return 30;
    }

    public void startGame(Event event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Bingo/BingoBuyCard.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void gameSelection(Event event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/GameSelection.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void cardBought(Event event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Bingo/BingoGame.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

}
