/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import ch.bbbaden.casinoroyale.model.Table;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class Stats4Controller implements Initializable {

    @FXML
    private Label lblGames;
    @FXML
    private Label lblWin;
    @FXML
    private Label lblLoss;
    @FXML
    private Label lblChips;
    Integer baccaraPlayed;
    Integer win;
    Integer loss;
    Integer chips;
    @FXML
    private TableView<Table> table;
    @FXML
    private TableColumn<Table, String> colUser;
    @FXML
    private TableColumn<Table, String> colWin;
    @FXML
    private TableColumn<Table, String> colLoss;
    @FXML
    private TableColumn<Table, String> colRounds;

    ObservableList<Table> oblist = FXCollections.observableArrayList();
    FilteredList filter = new FilteredList(oblist, e -> true);
    @FXML
    private TextField txtSearch;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {

            Connection myConn = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
            Statement myStmt = myConn.createStatement();
            ResultSet rs = myStmt.executeQuery("select user, gewinn, verlust, rounds from logbingo");
            while (rs.next()) {
                oblist.add(new Table(rs.getString("user"), rs.getString("gewinn"), rs.getString("verlust"), rs.getString("rounds")));
            }

            colUser.setCellValueFactory(new PropertyValueFactory<>("user"));
            colWin.setCellValueFactory(new PropertyValueFactory<>("gewinn"));
            colLoss.setCellValueFactory(new PropertyValueFactory<>("verlust"));
            colRounds.setCellValueFactory(new PropertyValueFactory<>("rounds"));

            table.setItems(oblist);

            // TODO
            Connection myCon = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
            Statement myStm = myCon.createStatement();
            ResultSet rss = myStm.executeQuery("select bingogames from loggames");
            while (rss.next()) {
                baccaraPlayed = rss.getInt(1);
            }
            ResultSet rsWin = myStm.executeQuery("select MAX(gewinn) from logbingo");
            while (rsWin.next()) {
                win = rsWin.getInt("MAX(gewinn)");
            }
            ResultSet rsLoss = myStm.executeQuery("select MAX(verlust) from logbingo");
            while (rsLoss.next()) {
                loss = rsLoss.getInt("MAX(verlust)");
            }
            ResultSet rsChips = myStm.executeQuery("select MAX(gekauftechips) from logbingo");
            while (rsChips.next()) {
                chips = rsChips.getInt("MAX(gekauftechips)");
            }
            lblGames.setText(String.valueOf(baccaraPlayed));
            lblWin.setText(String.valueOf(win));
            lblLoss.setText(String.valueOf(loss));
            lblChips.setText(String.valueOf(chips));
        } catch (SQLException ex) {
            Logger.getLogger(StatsBaccaraController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void search(KeyEvent event) {

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {

            filter.setPredicate((Predicate<? super Table>) (Table table) -> {

                if (newValue.isEmpty() || newValue == null) {

                } else if (table.getUser().contains(newValue)) {
                    return true;
                }

                return false;

            });

        });

        SortedList sort = new SortedList(filter);
        sort.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sort);

    }

}
