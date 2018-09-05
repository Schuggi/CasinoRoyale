/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class StatsController implements Initializable {

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
    Stage stage = new Stage();
    Stage stage2 = new Stage();
    Stage stage3 = new Stage();
    Stage stage4 = new Stage();
    Stage stage5 = new Stage();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb //
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/fxml/StatsBaccara.fxml"));
            stage = new Stage();
            stage.setTitle("Stats Baccara");
            stage.setScene(new Scene(root));
            Parent root2;
            root2 = FXMLLoader.load(getClass().getResource("/fxml/Stats1.fxml"));
            stage2 = new Stage();
            stage2.setTitle("Stats BlackJack");
            stage2.setScene(new Scene(root2));
            Parent root3;
            root3 = FXMLLoader.load(getClass().getResource("/fxml/Stats2.fxml"));
            stage3 = new Stage();
            stage3.setTitle("Stats Yatzy");
            stage3.setScene(new Scene(root3));
            Parent root4;
            root4 = FXMLLoader.load(getClass().getResource("/fxml/Stats3.fxml"));
            stage4 = new Stage();
            stage4.setTitle("Stats Roulette");
            stage4.setScene(new Scene(root4));
            Parent root5;
            root5 = FXMLLoader.load(getClass().getResource("/fxml/Stats4.fxml"));
            stage5 = new Stage();
            stage5.setTitle("Stats Bingo");
            stage5.setScene(new Scene(root5));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void btnBlackJack(MouseEvent event) {
        stage.hide();
        stage2.show();
        stage3.hide();
        stage4.hide();
        stage5.hide();
    }

    @FXML
    private void btnYatzi(MouseEvent event) {
        stage.hide();
        stage2.hide();
        stage3.show();
        stage4.hide();
        stage5.hide();
    }

    @FXML
    private void btnRoulette(MouseEvent event) {
        stage.hide();
        stage2.hide();
        stage3.hide();
        stage4.show();
        stage5.hide();
    }

    @FXML
    private void btnBingo(MouseEvent event) {
        stage.hide();
        stage2.hide();
        stage3.hide();
        stage4.hide();
        stage5.show();
    }

    @FXML
    private void btnBaccara(MouseEvent event) {
        stage.show();
        stage2.hide();
        stage3.hide();
        stage4.hide();
        stage5.hide();
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

}
