/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import ch.bbbaden.casinoroyale.model.Actions;
import ch.bbbaden.casinoroyale.model.Blackjack;
import ch.bbbaden.casinoroyale.model.Card;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author sharu
 */
public class BlackjackController implements Initializable {

    private int index;
    private int indexComp = 0;
    @FXML
    private ImageView card1;
    @FXML
    private ImageView card2;
    @FXML
    private ImageView card3;
    @FXML
    private ImageView card4;
    @FXML
    private ImageView card5;
    @FXML
    private ImageView card6;

    private Blackjack blackjack;

    private ArrayList<ImageView> cardViews;
    @FXML
    private Button btnhit;
    @FXML
    private Button btnstand;

    @FXML
    private Label lblPointsGamer;
    @FXML
    private Label lblPointsComputer;
    @FXML
    private JFXDrawer JFXMenu;
    @FXML
    private JFXHamburger JFXMenuButton;

    public static AnchorPane rootP;
    @FXML
    private AnchorPane ApBlackJack;
    @FXML
    private ImageView cardC1;
    @FXML
    private ImageView cardC2;
    @FXML
    private ImageView cardC3;
    @FXML
    private ImageView cardC4;
    @FXML
    private ImageView cardC5;
    @FXML
    private Label lblResult;
    @FXML
    private ImageView Coin;
    @FXML
    private Button Confirm;

    @FXML
    private TextField txtChipAmount;
    @FXML
    private Button btnReset;

    private ArrayList<ImageView> cardViewsComputerZus = new ArrayList<>();
    Actions actions = Actions.getInstance();

    private ArrayList<Card> cardsGamer = new ArrayList<>();
    private ArrayList<Card> cardsComputer = new ArrayList<>();
    Integer chipsInt;
    Integer updatedChip;
    Integer winChip;
    Integer chipBJ;
    Integer amountBet;
    @FXML
    private Label lblActiveUser;
    @FXML
    private Label lblChips;
    @FXML
    private ImageView card7;
    @FXML
    private ImageView card8;
    @FXML
    private ImageView card9;
    @FXML
    private Label lblCoin;
    @FXML
    private ImageView Coin3;
    @FXML
    private ImageView Coin2;
    @FXML
    private ImageView Coin1;
    @FXML
    private Label lblCoinRed;
    @FXML
    private Label lblCoinGreen;
    @FXML
    private Label lblCoinBlack;
    @FXML
    private Button btnInsurance;
    @FXML
    private ImageView btnnewStart;
    @FXML
    private Button btnDouble;
    @FXML
    public Label lblWin;
    Integer blackjackRounds;
    Integer blackJackPlayed;
    @FXML
    private TextField txtInsuranceAmount;
    @FXML
    private ImageView ImageViewInsurance;
    @FXML
    private ImageView ImageViewDouble;
    @FXML
    private Label lblInsurance;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblActiveUser.setText(actions.getUsername());
        /*Verbindung zur Datenbank-Statistiken*/
        try {
            blackjackRounds = actions.updateRoundsBlackJack();
            lblChips.setText(String.valueOf(actions.getChipsRoulette()));
            Connection myConn = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
            Statement myStmt = myConn.createStatement();
            ResultSet rs = myStmt.executeQuery("select blackjackgames from loggames;");
            while (rs.next()) {
                blackJackPlayed = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BlackjackController.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*ImagesViews werden dem ArrayList zugeteilt.*/
        cardViewsComputerZus.add(cardC1);
        cardViewsComputerZus.add(cardC2);
        cardViewsComputerZus.add(cardC3);
        cardViewsComputerZus.add(cardC4);
        cardViewsComputerZus.add(cardC5);

        blackjack = new Blackjack();
        cardViews = new ArrayList<>();

        cardViews.add(card1);
        cardViews.add(card2);
        cardViews.add(card3);
        cardViews.add(card4);
        cardViews.add(card5);
        cardViews.add(card6);
        cardViews.add(card7);
        cardViews.add(card8);
        cardViews.add(card9);

        rootP = ApBlackJack;

        /*Menu-Bar*/
        try {
            VBox box = FXMLLoader.load(getClass().getResource("/fxml/Menu/Menu.fxml"));
            JFXMenu.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(RouletteHauptScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(JFXMenuButton);
        transition.setRate(-1);
        JFXMenuButton.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            if (JFXMenu.isShown()) {
                JFXMenu.close();
            } else {
                JFXMenu.open();
            }
        });
    }

    @FXML
    public void showCard() throws SQLException {

        /*Es wird dem gezogenen Karte ein Variabel gesetzt, damit es einfacher ist mit dem weiter zu arbeiten.*/
        Card card = blackjack.foldCard();
        /*Hier werden die Bilder auf der Spieloberfläche angezeigt*/
        cardViews.get(index).setImage(new Image("Images/cards1/" + card.getName() + card.getType() + ".png"));

        /*Die erstellten Karten werden dem Spieler im Array zugteilt.*/
        cardsGamer.add(card);

        /*Punkte von Gamer werden zusammen gezählt.*/
        lblPointsGamer.setText(Integer.toString(Blackjack.getValue(cardsGamer)));
        /*Die nächste ImageView wird ausgewählt.*/
        index++;

        /*Falls die Werte der gezogenen Karte von Spieler 21 überschreiten, ist der Spieler gebusted.*/
        if (Blackjack.getValue(cardsGamer) > 21) {
            updateChipAmountLoss();
            lblResult.setText("You are busted!");
            /*Dem gezogenen random Karte wird eine Variabel gesetzt.*/
            card = blackjack.foldCard();
            cardViewsComputerZus.get(indexComp).setImage(new Image("Images/cards1/" + card.getName() + card.getType() + ".png"));
            cardsComputer.add(card);
            lblPointsComputer.setText(Integer.toString(Blackjack.getValue(cardsComputer)));
            indexComp++;
            /*Die nicht benötigten Buttons werden transparent und nicht mehr funktionierbar.*/
            btnhit.setDisable(true);
            btnstand.setDisable(true);
        } else if (Blackjack.getValue(cardsGamer) == 21) {
            lblResult.setText("Blackjack!");
            /*Das gewonnene Betrag wird in einem Label angezeigt.*/
            int a = Integer.parseInt(txtChipAmount.getText());
            double b = a * 1.5;
            lblWin.setText("You won: " + (int) b + " Chips.");
            try {
                win(1.5);
            } catch (SQLException ex) {
            }
            /*Die nicht benötigten Buttons werden transparent und nicht mehr funktionierbar.*/
            btnhit.setDisable(true);
            btnstand.setDisable(true);
        }
    }

    @FXML
    private void btnstand() {

        while (Blackjack.getValue(cardsComputer) < 18 && Blackjack.getValue(cardsComputer) < Blackjack.getValue(cardsGamer) && Blackjack.getValue(cardsGamer) != 21) {
            /*Dem Computer wird eine Random Karte gezogen*/
            Card card = blackjack.foldCard();
            cardViewsComputerZus.get(indexComp).setImage(new Image("Images/cards1/" + card.getName() + card.getType() + ".png"));
            cardsComputer.add(card);
            lblPointsComputer.setText(Integer.toString(Blackjack.getValue(cardsComputer)));
            indexComp++;
        }

        btnhit.setDisable(true);
        btnstand.setDisable(true);

        /*Es wird überprüft ob man gewonnen hat oder nicht.*/
        String[] result = Blackjack.compareCard(cardsComputer, cardsGamer);

        try {
            /*String [] output wird in einen Double umgewandelt.*/
            win(Double.parseDouble(result[0]));
        } catch (SQLException ex) {

        }
        /*Im lblResult wird das dazugehörige Text angezeigt.*/
        lblResult.setText(result[1]);
        if (result[1].equals("You have won") || result[1].equals("Dealer is busted!")) {
            int d = Integer.parseInt(txtChipAmount.getText());
            double r = d * 2;
            lblWin.setText("You won: " + (int) r + " Chips.");
        } else if (result[1].equals("You have Blackjack!")) {
            int e = Integer.parseInt(txtChipAmount.getText());
            double f = e * 1.5;
            lblWin.setText("You won: " + (int) f + " Chips.");
        }
    }

    @FXML
    private void ClickedonConfirm(ActionEvent event) throws SQLException {
        updateBlackJackRounds();
        updateBlackJackGames();

        String regex = "[0-9]+";
        String chips = String.valueOf(actions.getChipsRoulette());
        chipsInt = Integer.valueOf(chips);

        /*Es muss einen Einsatz haben. Der Einsatz muss kleiner als der Kontostand sein, es muss durch zwei teilbar sein und der Mindesteinsatz ist 10.*/
        if (txtChipAmount.getText().matches(regex) && Integer.valueOf(txtChipAmount.getText()) % 2 == 0 && Integer.valueOf(txtChipAmount.getText()) >= 10) {
            if (Integer.valueOf(txtChipAmount.getText()) > 0 && Integer.valueOf(txtChipAmount.getText()) <= chipsInt) {
                updatedChip = chipsInt - Integer.valueOf(txtChipAmount.getText());
                amountBet = Integer.valueOf(txtChipAmount.getText());
                updateChipAmount();
                lblChips.setText(String.valueOf(actions.getChipsRoulette()));

                index = 0;
                /*Die gezogene random Karte wird in dem Array vom Spieler abgespeichert.*/
                Card card = blackjack.foldCard();
                cardsGamer.add(card);
                /*Die gezogene random Karte wird in dem Array vom Computer abgespeichert.*/
                Card card3 = blackjack.foldCard();
                cardsComputer.add(card3);

                /*Die gezogene random Karte wird als erste Karte vom Spieler aufgedeckt.*/
                cardViews.get(index).setImage(new Image("Images/cards1/" + card.getName() + card.getType() + ".png"));
                index++;

                /*Diese Methode deckt die zweite Karte von dem Spieler auf*/
                showCard();

                /*Die gezogene random Karte wird als erste Karte vom Computer aufgedeckt.*/
                cardViews.get(index).setImage(new Image("Images/cards1/" + card3.getName() + card3.getType() + ".png"));
                index++;

                /*Die zweite Karte vom Computer bleibt gedeckt.*/
                cardC1.setImage(new Image("Images/cards1/blue_back.png"));

                /*Die Werte der Karten vom Spieler und Dealer werden in einem Label ausgegeben.*/
                lblPointsGamer.setText(Integer.toString(Blackjack.getValue(cardsGamer)));
                lblPointsComputer.setText(Integer.toString(Blackjack.getValue(cardsComputer)));

                /*Wenn der Spieler den Wert 21 direkt hat, wird die Methode btnstand ausgeführt.*/
                if (Blackjack.getValue(cardsGamer) == 21) {
                    btnstand();
                    int r = Integer.parseInt(txtChipAmount.getText());
                    double d = r * 1.5;
                    lblWin.setText("You won: " + (int) d + " Chips.");
                } else {
                    btnhit.setDisable(false);
                    btnstand.setDisable(false);
                }
                /*Alle Buttons werden transparend und nicht mehr funktinostüchtig.*/
                Confirm.setDisable(true);
                txtChipAmount.setDisable(true);
                Coin.setDisable(true);
                Coin1.setDisable(true);
                Coin2.setDisable(true);
                Coin3.setDisable(true);
                lblCoin.setDisable(true);
                lblCoinRed.setDisable(true);
                lblCoinGreen.setDisable(true);
                lblCoinBlack.setDisable(true);
                btnReset.setDisable(true);
            }

            /*Wenn die Werte der Karten von Spieler zwischen 8 und 12 ist, wird der Button Double hervorgerufen.*/
            if (Blackjack.getValue(cardsGamer) > 8 && Blackjack.getValue(cardsGamer) < 12) {
                btnDouble.setVisible(true);
                ImageViewDouble.setVisible(true);
            }
            /*Wenn es die erste Karte vom Computer ist und es einen Wert von 11 hat, wird der Button Insurance hervorgerufen.*/
            if (cardsComputer.size() == 1 && Blackjack.getValue(cardsComputer) == 11) {
                btnInsurance.setVisible(true);
                ImageViewInsurance.setVisible(true);
                lblInsurance.setVisible(true);
                txtInsuranceAmount.setVisible(true);
            }

            /*Hier werden die Fehler abgefangen.*/
        } else {
            try {
                int intChipAmount = Integer.valueOf(txtChipAmount.getText());
                if (intChipAmount < 10) {
                    JOptionPane.showMessageDialog(null, "The minimum bet is 10 chips!", "Buy More Chips", JOptionPane.OK_CANCEL_OPTION);
                } else if (intChipAmount % 2 != 0) {
                    JOptionPane.showMessageDialog(null, "Your number must divide by 2!", "Buy More Chips", JOptionPane.OK_CANCEL_OPTION);
                } else if (intChipAmount > chipsInt) {
                    JOptionPane.showMessageDialog(null, "You don't have enough chips!", "Buy More Chips", JOptionPane.OK_CANCEL_OPTION);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Only Numbers!");
            }
        }
    }

    @FXML
    /*Der Einsatz wird wieder auf den Mindesteinsatz zurückgesetzt.*/
    private void ClickedonReset(ActionEvent event) {
        txtChipAmount.setText("10");
    }

    /*Das gewonnene Betrag wird im Kontostand aktualisiert.*/
    private void updateChipAmount() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        PreparedStatement ps = connection.prepareStatement("update users set chips = ? where email like " + actions.getEmail());
        ps.setInt(1, updatedChip);
        ps.executeUpdate();
        ps.close();
    }

    /*Das verlorene Betrag wird im Kontostand aktualisiert.*/
    private void updateChipAmountLoss() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Integer loss = actions.getLossBlackJack() + Integer.valueOf(txtChipAmount.getText());
        PreparedStatement psBingo = connection.prepareStatement("update logblackjack set verlust = ? where user like " + actions.getEmail());
        psBingo.setInt(1, loss);
        psBingo.executeUpdate();
        psBingo.close();
    }

    /*Das gewonnene Betrag wird im Kontostand aktualisiert.*/
    private void win(double multiplier) throws SQLException {
        if (multiplier > 0) {
            winChip = actions.getChipsRoulette() + (int) (Double.valueOf(amountBet) * multiplier);
            Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
            PreparedStatement ps = connection.prepareStatement("update users set chips = ? where email like " + actions.getEmail());
            ps.setInt(1, winChip);
            ps.executeUpdate();
            ps.close();
            lblChips.setText(String.valueOf(actions.getChipsRoulette()));
        }
    }

    /*Das gewonnene Betrag mit der Versicherung wird im Kontostand aktualisiert.*/
    private void winInsurance() throws SQLException {
        int insuranceChip = actions.getChipsRoulette() + (int) (Double.valueOf(txtInsuranceAmount.getText()) * 2);
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        PreparedStatement ps = connection.prepareStatement("update users set chips = ? where email like " + actions.getEmail());
        ps.setInt(1, insuranceChip);
        ps.executeUpdate();
        ps.close();
        lblChips.setText(String.valueOf(actions.getChipsRoulette()));

    }

    @FXML
    /*Wenn man auf dem blauen Chip klickt mit der Wert 2 soll der Einsatz +2 gerechnet werden.*/
    private void AddTwo(MouseEvent event) {
        int a = Integer.valueOf(txtChipAmount.getText());
        txtChipAmount.setText(String.valueOf(a + 2));
    }

    @FXML
    /*Wenn man auf dem roten Chip klickt mit der Wert 10 soll der Einsatz +10 gerechnet werden.*/
    private void AddTen(MouseEvent event) {
        int a = Integer.valueOf(txtChipAmount.getText());
        txtChipAmount.setText(String.valueOf(a + 10));
    }

    @FXML
    /*Wenn man auf dem grünen Chip klickt mit der Wert 50 soll der Einsatz +50 gerechnet werden.*/
    private void AddFifty(MouseEvent event) {
        int a = Integer.valueOf(txtChipAmount.getText());
        txtChipAmount.setText(String.valueOf(a + 50));
    }

    @FXML
    /*Wenn man auf dem schwarzen Chip klickt mit der Wert 100 soll der Einsatz +100 gerechnet werden.*/
    private void AddHunderd(MouseEvent event) {
        int a = Integer.valueOf(txtChipAmount.getText());
        txtChipAmount.setText(String.valueOf(a + 100));

    }

    @FXML
    /*Die Seite wird neu geladen. Welches hier als Neustart benutzt wird.*/
    private void btnnewStart(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/BlackJack/Blackjack.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    @FXML
    /*Wenn die Regeln zulassen, kann man den Double Button betätigen.*/
    private void makeDouble(ActionEvent event) throws SQLException {
        if (Blackjack.getValue(cardsGamer) > 8 && Blackjack.getValue(cardsGamer) < 12) {
            int a = Integer.valueOf(txtChipAmount.getText());
            txtChipAmount.setText(String.valueOf(a * 2));
            showCard();

            updatedChip = chipsInt - Integer.valueOf(txtChipAmount.getText());
            amountBet = Integer.valueOf(txtChipAmount.getText());
            updateChipAmount();
            lblChips.setText(String.valueOf(actions.getChipsRoulette()));

            btnDouble.setDisable(true);
            btnhit.setDisable(true);

        }
    }

    @FXML
    /*Wenn die Regeln zulassen, kann man den Insurance Button betätigen.*/
    private void makeInsurance(ActionEvent event) throws SQLException {

        boolean valid = false;
        try {
            int insuranceAmount = Integer.valueOf(txtInsuranceAmount.getText());

            /*Fehler abfangen für den Einsatz im Versicherung.*/
            if (insuranceAmount % 2 != 0) {
                JOptionPane.showMessageDialog(null, "Your number must divide by 2!", "Buy More Chips", JOptionPane.OK_CANCEL_OPTION);
            } else if (insuranceAmount > chipsInt) {
                JOptionPane.showMessageDialog(null, "You don't have enough chips!", "Buy More Chips", JOptionPane.OK_CANCEL_OPTION);
            } else if (insuranceAmount < 10) {
                JOptionPane.showMessageDialog(null, "The minimum bet is 10 chips!", "Buy More Chips", JOptionPane.OK_CANCEL_OPTION);
            } else {
                valid = true;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Only Numbers!");
        }

        if (valid) {
            /*Wenn der Dealer nur eine Karte in der Hand hat und die Augensumme 11 ist, hat der Dealer kein Blackjack.*/
            if (cardsComputer.size() == 1 && Blackjack.getValue(cardsComputer) == 11) {
                updatedChip = actions.getChipsRoulette() - Integer.valueOf(txtInsuranceAmount.getText());
                updateChipAmount();
                lblChips.setText(String.valueOf(updatedChip));
                lblResult.setText("It isn't a Blackjack!");

                Card card = blackjack.foldCard();
                cardViewsComputerZus.get(indexComp).setImage(new Image("Images/cards1/" + card.getName() + card.getType() + ".png"));
                cardsComputer.add(card);
                lblPointsComputer.setText(Blackjack.getValue(cardsComputer) + "");
                indexComp++;

                /*Wenn der Dealer zwei Karten in der Hand hat und die Augensumme 21 ist, hat der Dealer ein Blackjack.*/
                if (Blackjack.getValue(cardsComputer) == 21 && cardsComputer.size() == 2) {
                    winInsurance();
                    lblChips.setText(String.valueOf(actions.getChipsRoulette()));
                    lblResult.setText("It is a Blackjack!");

                }
            }

        }
    }

    private void updateBlackJackRounds() throws SQLException {
        newUpdate();
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        PreparedStatement ps = connection.prepareStatement("update logblackjack set rounds = ? where user like " + actions.getEmail());
        ps.setInt(1, blackjackRounds + 1);
        ps.executeUpdate();
        ps.close();
    }

    private void newUpdate() throws SQLException {
        blackjackRounds = actions.updateRoundsBlackJack();
    }

    private void updateBlackJackGames() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        PreparedStatement ps = connection.prepareStatement("update loggames set blackjackgames = ? where id like '1'");
        ps.setInt(1, blackJackPlayed + 1);
        ps.executeUpdate();
        ps.close();
    }

    /*Der gewonnene Betrag wird in dem Label hingeschrieben.*/
    public void setLblWin(String a) {
        lblWin.setText(a);
    }

    /*Es nimmt den Wert aus dem Textfeld und konvertiert es in Integer.*/
    public int getTxtChipAmount() {
        return Integer.parseInt(txtChipAmount.getText());
    }

}
