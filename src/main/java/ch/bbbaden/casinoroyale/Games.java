/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale;

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
public class Games {

    public void startBaccara(Event event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/BaccaraStart/Test.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void startBingo(Event event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/BingoStart/Test.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void startBlackJack(Event event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/BlackJackStart/Test.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void startRoulette(Event event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/RouletteStart/Test.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void startYatzy(Event event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/YatzyStart/Test.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

}
