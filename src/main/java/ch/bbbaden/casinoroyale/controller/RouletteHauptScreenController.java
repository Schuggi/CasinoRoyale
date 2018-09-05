package ch.bbbaden.casinoroyale.controller;

import ch.bbbaden.casinoroyale.model.Actions;
import ch.bbbaden.casinoroyale.model.Roulette;
import ch.bbbaden.casinoroyale.model.RouletteChips;
import ch.bbbaden.casinoroyale.model.RoulettePlacedChips;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.FileNotFoundException;
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
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yanick Schlatter
 */
public class RouletteHauptScreenController implements Initializable {

    Roulette roulette = new Roulette();
    private ArrayList<RouletteChips> chips = new ArrayList();
    private ArrayList<RoulettePlacedChips> placedChips = new ArrayList();

    private ArrayList<String> roundWins = new ArrayList();

    private int totalBetRound = 0;

    @FXML
    private ImageView ImageViewHintergrund;
    @FXML
    private Button btnDrehen;
    @FXML
    private JFXDrawer JFXMenu;
    @FXML
    private JFXHamburger JFXMenuButton;
    @FXML
    private AnchorPane ApRoulette;

    public static AnchorPane rootP;

    private int countdownGameInt = 5;
    @FXML
    private ImageView ImageViewRouletteRad;
    @FXML
    private ImageView ImageViewChip;
    @FXML
    private ImageView ImageView1;
    @FXML
    private TextField txtChipAmount;
    @FXML
    private Slider sliderChips;
    @FXML
    private ImageView ImageView2;
    @FXML
    private ImageView ImageView3;
    @FXML
    private ImageView ImageView4;
    @FXML
    private ImageView ImageView5;
    @FXML
    private ImageView ImageView6;
    @FXML
    private ImageView ImageView7;
    @FXML
    private ImageView ImageView8;
    @FXML
    private ImageView ImageView9;
    @FXML
    private ImageView ImageView10;
    @FXML
    private ImageView ImageView11;
    @FXML
    private ImageView ImageView12;
    @FXML
    private ImageView ImageView13;
    @FXML
    private ImageView ImageView14;
    @FXML
    private ImageView ImageView15;
    @FXML
    private ImageView ImageView16;
    @FXML
    private ImageView ImageView17;
    @FXML
    private ImageView ImageView18;
    @FXML
    private ImageView ImageView19;
    @FXML
    private ImageView ImageView20;
    @FXML
    private ImageView ImageView21;
    @FXML
    private ImageView ImageView22;
    @FXML
    private ImageView ImageView23;
    @FXML
    private ImageView ImageView24;
    @FXML
    private ImageView ImageView26;
    @FXML
    private ImageView ImageView27;
    @FXML
    private ImageView ImageView28;
    @FXML
    private ImageView ImageView29;
    @FXML
    private ImageView ImageView30;
    @FXML
    private ImageView ImageView31;
    @FXML
    private ImageView ImageView32;
    @FXML
    private ImageView ImageView33;
    @FXML
    private ImageView ImageView34;
    @FXML
    private ImageView ImageView35;
    @FXML
    private ImageView ImageView36;
    @FXML
    private ImageView ImageView2to1bottom;
    @FXML
    private ImageView ImageView2to1center;
    @FXML
    private ImageView ImageView2to1top;
    @FXML
    private ImageView ImageView25;
    private ImageView ImageView1245;
    private ImageView ImageView2356;
    @FXML
    private ImageView ImageView0;
    @FXML
    private ImageView ImageViewFirst12;
    @FXML
    private ImageView ImageViewSecond12;
    @FXML
    private ImageView ImageViewThird12;
    @FXML
    private ImageView ImageView1to18;
    @FXML
    private ImageView ImageViewEven;
    @FXML
    private ImageView ImageViewRed;
    @FXML
    private ImageView ImageViewBlack;
    @FXML
    private ImageView ImageViewOdd;
    @FXML
    private ImageView ImageView19to36;
    @FXML
    private ImageView ImageView1_2_4_5;
    @FXML
    private ImageView ImageView2_3_5_6;
    @FXML
    private ImageView ImageView5_6_8_9;
    @FXML
    private ImageView ImageView4_5_7_8;
    @FXML
    private ImageView ImageView7_8_10_11;
    @FXML
    private ImageView ImageView8_9_11_12;
    @FXML
    private ImageView ImageView10_11_13_14;
    @FXML
    private ImageView ImageView11_12_14_15;
    @FXML
    private ImageView ImageView13_14_16_17;
    @FXML
    private ImageView ImageView14_15_17_18;
    @FXML
    private ImageView ImageView17_18_20_21;
    @FXML
    private ImageView ImageView16_17_19_20;
    @FXML
    private ImageView ImageView19_20_22_23;
    @FXML
    private ImageView ImageView20_21_23_24;
    @FXML
    private ImageView ImageView22_23_25_26;
    @FXML
    private ImageView ImageView23_24_26_27;
    @FXML
    private ImageView ImageView26_27_29_30;
    @FXML
    private ImageView ImageView25_26_28_29;
    @FXML
    private ImageView ImageView28_29_31_32;
    @FXML
    private ImageView ImageView29_30_32_33;
    @FXML
    private ImageView ImageView31_32_34_35;
    @FXML
    private ImageView ImageView32_33_35_36;
    @FXML
    private ImageView ImageView3_6;
    @FXML
    private ImageView ImageView6_9;
    @FXML
    private ImageView ImageView9_12;
    @FXML
    private ImageView ImageView12_15;
    @FXML
    private ImageView ImageView15_18;
    @FXML
    private ImageView ImageView18_21;
    @FXML
    private ImageView ImageView21_24;
    @FXML
    private ImageView ImageView24_27;
    @FXML
    private ImageView ImageView27_30;
    @FXML
    private ImageView ImageView30_33;
    @FXML
    private ImageView ImageView33_36;
    @FXML
    private ImageView ImageView0_3;
    @FXML
    private ImageView ImageView0_2;
    @FXML
    private ImageView ImageView0_1;
    @FXML
    private ImageView ImageView2_5;
    @FXML
    private ImageView ImageView5_8;
    @FXML
    private ImageView ImageView8_11;
    @FXML
    private ImageView ImageView11_14;
    @FXML
    private ImageView ImageView14_17;
    @FXML
    private ImageView ImageView17_20;
    @FXML
    private ImageView ImageView20_23;
    @FXML
    private ImageView ImageView23_26;
    @FXML
    private ImageView ImageView26_29;
    @FXML
    private ImageView ImageView29_32;
    @FXML
    private ImageView ImageView32_35;
    @FXML
    private ImageView ImageView1_4;
    @FXML
    private ImageView ImageView4_7;
    @FXML
    private ImageView ImageView7_10;
    @FXML
    private ImageView ImageView10_13;
    @FXML
    private ImageView ImageView13_16;
    @FXML
    private ImageView ImageView16_19;
    @FXML
    private ImageView ImageView19_22;
    @FXML
    private ImageView ImageView22_25;
    @FXML
    private ImageView ImageView25_28;
    @FXML
    private ImageView ImageView28_31;
    @FXML
    private ImageView ImageView31_34;
    @FXML
    private ImageView ImageView1_456;
    @FXML
    private ImageView ImageView4_789;
    @FXML
    private ImageView ImageView7_101112;
    @FXML
    private ImageView ImageView10_131415;
    @FXML
    private ImageView ImageView13_161718;
    @FXML
    private ImageView ImageView16_192021;
    @FXML
    private ImageView ImageView19_222324;
    @FXML
    private ImageView ImageView22_252627;
    @FXML
    private ImageView ImageView25_282930;
    @FXML
    private ImageView ImageView28_313233;
    @FXML
    private ImageView ImageView31_343536;
    @FXML
    private ImageView ImageView0_123;
    @FXML
    private ImageView ImageView1_2_3;
    @FXML
    private ImageView ImageView4_5_6;
    @FXML
    private ImageView ImageView7_8_9;
    @FXML
    private ImageView ImageView10_11_12;
    @FXML
    private ImageView ImageView13_14_15;
    @FXML
    private ImageView ImageView16_17_18;
    @FXML
    private ImageView ImageView19_20_21;
    @FXML
    private ImageView ImageView22_23_24;
    @FXML
    private ImageView ImageView25_26_27;
    @FXML
    private ImageView ImageView28_29_30;
    @FXML
    private ImageView ImageView31_32_33;
    @FXML
    private ImageView ImageView34_35_36;
    @FXML
    private ImageView ImageView1_2;
    @FXML
    private ImageView ImageView4_5;
    @FXML
    private ImageView ImageView7_8;
    @FXML
    private ImageView ImageView10_11;
    @FXML
    private ImageView ImageView13_14;
    @FXML
    private ImageView ImageView16_17;
    @FXML
    private ImageView ImageView19_20;
    @FXML
    private ImageView ImageView22_23;
    @FXML
    private ImageView ImageView25_26;
    @FXML
    private ImageView ImageView28_29;
    @FXML
    private ImageView ImageView31_32;
    @FXML
    private ImageView ImageView34_35;
    @FXML
    private ImageView ImageView2_3;
    @FXML
    private ImageView ImageView5_6;
    @FXML
    private ImageView ImageView8_9;
    @FXML
    private ImageView ImageView11_12;
    @FXML
    private ImageView ImageView17_18;
    @FXML
    private ImageView ImageView20_21;
    @FXML
    private ImageView ImageView23_24;
    @FXML
    private ImageView ImageView26_27;
    @FXML
    private ImageView ImageView29_30;
    @FXML
    private ImageView ImageView32_33;
    @FXML
    private ImageView ImageView35_36;
    @FXML
    private ImageView ImageView0_2_3;
    @FXML
    private ImageView ImageView0_1_2;
    @FXML
    private Pane pane;
    @FXML
    private Label lblActiveUser;
    @FXML
    private Label lblChips;
    @FXML
    private ImageView ImageView14_15;
    @FXML
    private Button test;
    @FXML
    private Label lblGewinnZahl;
    Integer updatedChip;
    int amount;
    Integer chipsSql;
    Integer chipPass;
    Actions actions = Actions.getInstance();
    static RouletteHauptScreenController instance;
    Integer rouletteRounds;
    Integer chipsUser;
    Integer roulettePlayed;
    @FXML
    private Button btnConfirm;
    @FXML
    private Label lblChip;
    private VBox vBoxWin;
//    ShopController shopcontroller = ShopController.getInstance();
    @FXML
    private VBox VBoxRoundWin;
    @FXML
    private VBox VBoxTotalWin;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance = this;
        roulette.fillArayLists();
        rootP = ApRoulette;
        lblActiveUser.setText(actions.getUsername());
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
            Statement myStmt = myConn.createStatement();
            ResultSet rs = myStmt.executeQuery("select roulettegames from loggames;");
            while (rs.next()) {
                roulettePlayed = rs.getInt(1);
            }
            rouletteRounds = actions.updateRoundsRoulette();
            lblChips.setText(String.valueOf(actions.getChipsRoulette()));
        } catch (SQLException ex) {
            Logger.getLogger(BaccaraGameScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Code für das Menuband

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

        ImageView1.imageProperty().set(null);

        addChips();
    }

    public static RouletteHauptScreenController getInstance() {
        if (instance == null) {
            instance = new RouletteHauptScreenController();
        }
        return instance;
    }

    public Integer chipAmount() throws SQLException {
        return chipPass;
    }
    
    // Chips in ArrayListe einfügen

    private void addChips() {

        for (Object o : pane.getChildren()) {
            ImageView imgView = (ImageView) o;
            String name = imgView.getId();
            chips.add(new RouletteChips(imgView.getImage(), name.substring(9)));
        }

        for (RouletteChips rc : chips) {
            System.out.println(rc.getChipName() + " " + rc.getChip());
        }
    }
    
    @FXML
    private void HandleButtonActionDrehen(ActionEvent event) throws IOException, SQLException {
        System.out.println("\nTotal Bet: " + totalBetRound + "\n");
        totalBetRound = 0;
        ImageViewChip.setVisible(false);
        lblChip.setVisible(false);
        txtChipAmount.setDisable(false);
        sliderChips.setDisable(false);
        btnConfirm.setDisable(false);
        VBoxRoundWin.getChildren().clear();

        for (int i = 0; i < roundWins.size(); i++) {
            Label label = new Label();
            label.setTextFill(Color.WHITE);
            label.setText(roundWins.get(i));
            VBoxTotalWin.getChildren().add(label);
        }

        roundWins.clear();

        for (RoulettePlacedChips rc : placedChips) {
            System.out.println("You placed " + rc.getAmount() + " on " + rc.getChipName());
        }

        for (RouletteChips rc : chips) {
            rc.setChip(null);
        }

        for (Object o : pane.getChildren()) {
            ImageView imgView = (ImageView) o;
            imgView.setImage(null);
        }

//        RotateTransition rT = new RotateTransition(Duration.INDEFINITE, ImageViewRouletteRad);
////        rT.setFromAngle(0);
//        rT.setByAngle(360);
//        rT.setRate(3);
////        rT.setAutoReverse(true);
//        rT.setCycleCount(2);
//        rT.play();
        ImageViewRouletteRad.setImage(new Image("/Images/RouletteRad.gif"));
        final Timeline time = new Timeline();
        KeyFrame frame = new KeyFrame(javafx.util.Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                countdownGameInt--;
                System.out.println(countdownGameInt);
                if (countdownGameInt == 0) {
//                    rT.stop();
                    time.stop();
                    ImageViewRouletteRad.setImage(new Image("/Images/RouletteRad.png"));
                    countdownGameInt = 5;
                    lblGewinnZahl.setText(Integer.toString(roulette.getRandom36()));
                    try {
                        roulette.auswertung(Integer.valueOf(lblGewinnZahl.getText()), placedChips);
                    } catch (SQLException ex) {
                        Logger.getLogger(RouletteHauptScreenController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    placedChips.clear();

                    for (RoulettePlacedChips rc : roulette.getPlacementWon()) {
                        Label label = new Label();
                        label.setTextFill(Color.WHITE);
                        label.setText("You won " + rc.getAmount() + " Chips on " + rc.getChipName());
                        roundWins.add(label.getText());
                        VBoxRoundWin.getChildren().add(label);
                        try {
                            lblChips.setText(String.valueOf(actions.getChipsRoulette()));
                        } catch (SQLException ex) {
                            Logger.getLogger(RouletteHauptScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    btnConfirm.setDisable(false);
                    txtChipAmount.setDisable(false);
                    sliderChips.setDisable(false);
                }

            }
        });
        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(frame);
        time.play();
    }
    
    //Methoden für das Drag and Drop

    @FXML
    private void HancleDragDetection(MouseEvent event) {
        Dragboard db = ImageViewChip.startDragAndDrop(TransferMode.ANY);

        ClipboardContent content = new ClipboardContent();
        content.putImage(ImageViewChip.getImage());
        db.setContent(content);

        event.consume();
    }

    @FXML
    private void handleDragOver(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
        event.consume();
    }

    @FXML
    private void handleDragDropped(DragEvent event) throws FileNotFoundException, SQLException {
        lblGewinnZahl.setText("");
        updateRoueletteGames();
        updateRouletteRounds();
        updateChipAmount();
        updatesetChips();
        lblChips.setText(String.valueOf(chipsSql));
        String name = ((ImageView) event.getTarget()).getId();
        Image image = event.getDragboard().getImage();
        ((ImageView) event.getSource()).setImage(image);
        roulette.setPlacedChips(amount);
        placedChips.add(new RoulettePlacedChips(name.substring(9), amount));
        System.out.println("\nYou have placed " + amount + " on " + name.substring(9));
        event.consume();
        ImageViewChip.setVisible(false);
        lblChip.setVisible(false);
        txtChipAmount.setDisable(false);
        sliderChips.setDisable(false);
        btnConfirm.setDisable(false);
        getUserChips();
    }

    @FXML
    private void GetAmountSlider(MouseEvent event) {
        int toInt = (int) sliderChips.getValue();
        txtChipAmount.setText(Integer.toString(toInt));
    }

    public ArrayList<RouletteChips> get36ChipsPosition() {
        ArrayList<RouletteChips> positions = new ArrayList();

        for (int i = 0; i < 36; i++) {
            RouletteChips position = chips.get(i);
            String name = position.getChipName();
            System.out.println(name + " " + position.getChip());
        }

        return positions;
    }

    public ArrayList<RoulettePlacedChips> getPlacedChips() {
        return placedChips;
    }

    @FXML
    private void ButtonActionTest(ActionEvent event) throws SQLException {
        VBoxRoundWin.getChildren().clear();
    }

    private void updateChipAmount() throws SQLException {
        chipsSql = actions.getChipsRoulette() - amount;
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        PreparedStatement ps = connection.prepareStatement(
                "update users set chips = ? where email like " + actions.getEmail());
        ps.setInt(1, chipsSql);
        ps.executeUpdate();
        ps.close();
    }

    private void updatesetChips() throws SQLException {
        Integer amountSql = actions.getSetChips() + Integer.valueOf(txtChipAmount.getText());
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        PreparedStatement ps = connection.prepareStatement(
                "update logroulette set gesetzechips = ? where user like " + actions.getEmail());
        ps.setInt(1, amountSql);
        ps.executeUpdate();
        ps.close();
    }

    @FXML
    private void HandleButtonActionConfirm(ActionEvent event) throws SQLException {
        String regex = "[0-9]+";

        if (txtChipAmount.getText().matches(regex)) {
            amount = Integer.parseInt(txtChipAmount.getText());
            chipPass = amount;
            totalBetRound += amount;
            if (actions.getChipsRoulette() < 0) {
                JOptionPane.showMessageDialog(null, "You can't bet more than you have.", "Error", JOptionPane.ERROR_MESSAGE);
                totalBetRound -= amount;
                ImageViewChip.setVisible(false);
                lblChip.setVisible(false);
                txtChipAmount.setDisable(false);
                sliderChips.setDisable(false);
                btnConfirm.setDisable(false);
            } else if (amount < 10) {
                JOptionPane.showMessageDialog(null, "Minimum Amount is 10 Chips", "Error", JOptionPane.ERROR_MESSAGE);
                totalBetRound -= amount;
                ImageViewChip.setVisible(false);
                lblChip.setVisible(false);
                txtChipAmount.setDisable(false);
                sliderChips.setDisable(false);
                btnConfirm.setDisable(false);
            } else if (amount > actions.getChipsRoulette()) {
                JOptionPane.showMessageDialog(null, "You do not posses enough Chips", "Error", JOptionPane.ERROR_MESSAGE);
                totalBetRound -= amount;
                ImageViewChip.setVisible(false);
                lblChip.setVisible(false);
                txtChipAmount.setDisable(false);
                sliderChips.setDisable(false);
                btnConfirm.setDisable(false);
            } else {
                ImageViewChip.setVisible(true);
                lblChip.setVisible(true);
                txtChipAmount.setDisable(true);
                sliderChips.setDisable(true);
                btnConfirm.setDisable(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Only Numbers are allowed.", "Not accepted", JOptionPane.OK_CANCEL_OPTION);
        }
    }

    private void updateRouletteRounds() throws SQLException {
        newUpdate();
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        PreparedStatement ps = connection.prepareStatement(
                "update logroulette set rounds = ? where user like " + actions.getEmail());
        ps.setInt(1, rouletteRounds + 1);
        ps.executeUpdate();
        ps.close();
    }

    public Integer getUserChips() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmtYatzy = connection.createStatement();
        String roundsYatzy = "select chips from users where email like " + actions.getEmail();
        ResultSet rs = myStmtYatzy.executeQuery(roundsYatzy);
        while (rs.next()) {
            chipsUser = rs.getInt(1);
        }
        return chipsUser;
    }

    private void newUpdate() throws SQLException {
        rouletteRounds = actions.updateRoundsRoulette();
    }

    private void updateRoueletteGames() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        PreparedStatement ps = connection.prepareStatement(
                "update loggames set roulettegames = ? where id like '1'");
        ps.setInt(1, roulettePlayed + 1);
        ps.executeUpdate();
        ps.close();
    }

//    public void setLblChips(String amount) throws SQLException {
//        ShopController sc = new ShopController(this);
//        lblChips.setText(sc.txtPayment());
//    }
}
