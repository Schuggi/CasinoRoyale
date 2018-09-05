/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Yannick
 */
public class Actions {

    static Actions instance;
    ArrayList<String> arr = new ArrayList();
    ArrayList<String> arrSignUp = new ArrayList();
    String mail;
    String mailSignUp;
    String sqlMail;
    String sqlMailSignUp;
    String password;
    String passwordSignUp;
    String confirmPasswordSignUp;
    String name;
    String nameSingUp;
    String firstName;
    Integer chips;
    String getChips;
    String firstNameSignUp;
    String possibleTries;
    String verifyCode;
    Boolean wrongVerification = true;
    String random;
    String globiglobi = "";
    boolean wrongPassword = true;
    Integer verificationTries = 5;
    Integer chipsTest;
    Connection con;
    Statement stTries;
    ResultSet rsTries;
    Statement stVerify;
    ResultSet rsVerify;
    private static Properties mailServerProperties;
    private static Session mailSess;
    private static MimeMessage mailMessage;
    private static final String SENDERS_GMAIL = "autonetbeans@gmail.com";
    private static final String SENDERS_PASSWORD = "&Papagei11";
    private Statement st;
    private ResultSet rs;
    private Connection conn;
    static Transport transport;
    String RECIEVERS_EMAIL = "autonetbeans@gmail.com";
    static Transport transportt;
    String getUsername;
    String getEmail;
    Integer gekaufteChips;
    Integer allRoundsBingo;
    Integer allRoundsBaccara;
    Integer allRoundsBlackJack;
    Integer allRoundsYatzy;
    Integer allRoundsRoulette;

    // Für die Übergabe von Werten zu anderen Klassen zuständig
    public static Actions getInstance() {
        if (instance == null) {
            instance = new Actions();
        }
        return instance;
    }

    // Verbindet sich mit der Datenbank
    public Connection sqlLogin() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        return connection;
    }

    // Datenbankname
    public String sqlGetTable() {
        String table = "users";
        return table;
    }

    // ----------------------------------------StartController----------------------------------------------
    public void signup(Event event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/SignUp.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    public void toStartScreen(Event event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/WelcomeScreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    // Liest die Daten aus der Datenbank aus und speichert sie in einem Array
    public void getUserData(ArrayList<String> arr) throws SQLException {
        // Get All Users with mail, password, verification and put them in an Array
        Statement statement = sqlLogin().createStatement();
        ResultSet result = statement.executeQuery("select email, password, verification from " + sqlGetTable());

        ResultSetMetaData metadata = result.getMetaData();
        int columnCount = metadata.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
        }
        while (result.next()) {
            String row = "";
            for (int i = 1; i <= columnCount; i++) {
                row += result.getString(i);
                arr.add(row);
                this.arr = arr;
            }
        }
    }

    // Überprüft ob die Daten korrekt im Textfeld eingegeben wurden
    public void checkCorrectData(Event event) throws SQLException, IOException {
        if (arr.contains(mail) && arr.contains(mail + password) && arr.contains(mail + password + "Verified")) {
            JOptionPane.showMessageDialog(null, "You logged in successfully!", "Success", JOptionPane.OK_CANCEL_OPTION);
            loginSuccessful(event);
        } else if (arr.contains(mail) && arr.contains(mail + password) && arr.contains(mail + password + "Locked")) {
            JOptionPane.showMessageDialog(null, "Your account got locked because it seems you're not the owner of " + mail, "Account locked!", JOptionPane.OK_CANCEL_OPTION);
        } else if (arr.contains(mail) && arr.contains(mail + password)) {
            JOptionPane.showMessageDialog(null, "Please verify your email first!", "Verify Email", JOptionPane.OK_CANCEL_OPTION);
            verifyMail();
        } else {
            JOptionPane.showMessageDialog(null, "Email oder Password wrong! If you're new, register first!", "Fail", JOptionPane.OK_CANCEL_OPTION);
        }
    }

    // Falls die Daten korrekt sind, folgen die nächsten Schritte
    private void loginSuccessful(Event event) throws SQLException, IOException {
        //Get Name und Firstname from Database
        Statement statementName;
        Statement statementFirstName;
        Statement statementChips;
        ResultSet resultsetName;
        ResultSet resultsetFirstName;
        ResultSet resultsetChips;
        statementName = sqlLogin().createStatement();
        String verifyName = "select name from users where email like " + sqlMail;
        resultsetName = statementName.executeQuery(verifyName);
        while (resultsetName.next()) {
            name = resultsetName.getString("name");
        }
        statementFirstName = sqlLogin().createStatement();
        String verifyFirstName = "select firstname from users where email like " + sqlMail;
        resultsetFirstName = statementFirstName.executeQuery(verifyFirstName);
        while (resultsetFirstName.next()) {
            firstName = resultsetFirstName.getString("firstname");
        }
        statementChips = sqlLogin().createStatement();
        String verifyChips = "select chips from users where email like " + sqlMail;
        resultsetChips = statementChips.executeQuery(verifyChips);
        while ((resultsetChips.next())) {
            chips = Integer.valueOf(resultsetChips.getString("chips"));
        }
        getChips = String.valueOf(chips);
        //Shorts Strings over 15 Chars
        String loggedInName = name.substring(0, 1).toUpperCase() + name.substring(1);
        String loggedInFirstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        String namePlusFirstName = loggedInFirstName + " " + loggedInName;
        getUsername = namePlusFirstName;
        //Creates new Controller
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Homescreen.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    // Liest die Anzahl Chips aus der Datenbank aus
    private void updateChips() throws SQLException {
        Statement statementChips;
        ResultSet resultsetChips;
        statementChips = sqlLogin().createStatement();
        String verifyChips = "select chips from users where email like " + sqlMail;
        resultsetChips = statementChips.executeQuery(verifyChips);
        while ((resultsetChips.next())) {
            chipsTest = Integer.valueOf(resultsetChips.getString("chips"));
        }
    }

    // Liest die Anzahl gesetzten Chips aus der Datenbank von Roulette aus
    public int getSetChips() throws SQLException {
        Statement statementChips;
        ResultSet resultsetChips;
        statementChips = sqlLogin().createStatement();
        String verifyChips = "select gesetzechips from logroulette where user like " + sqlMail;
        resultsetChips = statementChips.executeQuery(verifyChips);
        while ((resultsetChips.next())) {
            chips = Integer.valueOf(resultsetChips.getString("gesetzechips"));
        }
        getChips = String.valueOf(chips);
        return chips;
    }

    // Gibt den Benutzernamen zurück
    public String getUsername() {
        return getUsername;
    }

    // Gibt den aktuellen Wert der Chips zurück
    public Integer getChipsRoulette() throws SQLException {
        updateChips();
        return chipsTest;
    }

    // Liest den Gewinn von Bingo aus der Datenbank aus
    public Integer getWin() throws SQLException {
        Statement statementChips;
        ResultSet resultsetChips;
        statementChips = sqlLogin().createStatement();
        String verifyChips = "select gewinn from logbingo where user like " + sqlMail;
        resultsetChips = statementChips.executeQuery(verifyChips);
        while ((resultsetChips.next())) {
            chips = Integer.valueOf(resultsetChips.getString("gewinn"));
        }
        return chips;
    }

    // Liest den Gewinn von Roulette aus der Datenbank aus
    public Integer getWinRoulette() throws SQLException {
        Statement statementChips;
        ResultSet resultsetChips;
        statementChips = sqlLogin().createStatement();
        String verifyChips = "select gewinn from logroulette where user like " + sqlMail;
        resultsetChips = statementChips.executeQuery(verifyChips);
        while ((resultsetChips.next())) {
            chips = Integer.valueOf(resultsetChips.getString("gewinn"));
        }
        return chips;
    }

    // Liest den Gewinn von Blackjack aus der Datenbank aus
    public Integer getWinBlackJack() throws SQLException {
        Statement statementChips;
        ResultSet resultsetChips;
        statementChips = sqlLogin().createStatement();
        String verifyChips = "select gewinn from logblackjack where user like " + sqlMail;
        resultsetChips = statementChips.executeQuery(verifyChips);
        while ((resultsetChips.next())) {
            chips = Integer.valueOf(resultsetChips.getString("gewinn"));
        }
        return chips;
    }

    // Liest den Gewinn von Baccara aus der Datenbank aus
    public Integer getWinBaccara() throws SQLException {
        Statement statementChips;
        ResultSet resultsetChips;
        statementChips = sqlLogin().createStatement();
        String verifyChips = "select gewinn from logbaccara where user like " + sqlMail;
        resultsetChips = statementChips.executeQuery(verifyChips);
        while ((resultsetChips.next())) {
            chips = Integer.valueOf(resultsetChips.getString("gewinn"));
        }
        return chips;
    }

    // Liest die Anzahl gekauften Chips aus der Datenbank aus 
    public Integer getGekaufteChips() throws SQLException {
        Statement statementChips;
        ResultSet resultsetChips;
        statementChips = sqlLogin().createStatement();
        String verifyChips = "select gekauftechips from logbaccara where user like " + sqlMail;
        resultsetChips = statementChips.executeQuery(verifyChips);
        while ((resultsetChips.next())) {
            gekaufteChips = Integer.valueOf(resultsetChips.getString("gekauftechips"));
        }
        return gekaufteChips;
    }

    // Liest den Verlust von Baccara aus der Datenbank aus
    public Integer getLossBaccara() throws SQLException {
        Statement statementChips;
        ResultSet resultsetChips;
        statementChips = sqlLogin().createStatement();
        String verifyChips = "select verlust from logbaccara where user like " + sqlMail;
        resultsetChips = statementChips.executeQuery(verifyChips);
        while ((resultsetChips.next())) {
            chips = Integer.valueOf(resultsetChips.getString("verlust"));
        }
        return chips;
    }

    // Liest den Verlust von Bingo aus der Datenbank aus
    public Integer getLoss() throws SQLException {
        Statement statementChips;
        ResultSet resultsetChips;
        statementChips = sqlLogin().createStatement();
        String verifyChips = "select verlust from logbingo where user like " + sqlMail;
        resultsetChips = statementChips.executeQuery(verifyChips);
        while ((resultsetChips.next())) {
            chips = Integer.valueOf(resultsetChips.getString("verlust"));
        }
        return chips;
    }

    // Liest den Verlust von Blackjack aus der Datenbank aus
    public Integer getLossBlackJack() throws SQLException {
        Statement statementChips;
        ResultSet resultsetChips;
        statementChips = sqlLogin().createStatement();
        String verifyChips = "select verlust from logblackjack where user like " + sqlMail;
        resultsetChips = statementChips.executeQuery(verifyChips);
        while ((resultsetChips.next())) {
            chips = Integer.valueOf(resultsetChips.getString("verlust"));
        }
        return chips;
    }

//    public Integer getChipsProfit() throws SQLException {
//        Integer gewinn = 0;
//        Integer verlust = 0;
//        Statement statementChipsWin;
//        ResultSet resultsetChips;
//        statementChipsWin = sqlLogin().createStatement();
//        String verifyChipsWin = "select gewinn from logbingo where user like " + sqlMail;
//        resultsetChips = statementChipsWin.executeQuery(verifyChipsWin);
//        while ((resultsetChips.next())) {
//            gewinn = Integer.valueOf(resultsetChips.getString("gewinn"));
//        }
//        Statement statementChipsLoss;
//        ResultSet resultsetChipsLoss;
//        statementChipsLoss = sqlLogin().createStatement();
//        String verifyChipsLoss = "select verlust from logbingo where user like " + sqlMail;
//        resultsetChipsLoss = statementChipsLoss.executeQuery(verifyChipsLoss);
//        while ((resultsetChips.next())) {
//            verlust = Integer.valueOf(resultsetChips.getString("verlust"));
//        }
//        return gewinn - verlust;
//    }
    // Liest die Anzahl Runden von Bingo aus der Datenbank aus
    public Integer updateRoundsBingo() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmtBingo = connection.createStatement();
        String roundsBingo = "select rounds from logbingo where user like " + sqlMail;
        ResultSet rs = myStmtBingo.executeQuery(roundsBingo);
        while (rs.next()) {
            allRoundsBingo = rs.getInt(1);
        }
        return allRoundsBingo;
    }

    // Liest die Anzahl Runden von Baccara aus der Datenbank aus
    public Integer updateRoundsBaccara() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmtBaccara = connection.createStatement();
        String roundsBaccara = "select rounds from logbaccara where user like " + sqlMail;
        ResultSet rs = myStmtBaccara.executeQuery(roundsBaccara);
        while (rs.next()) {
            allRoundsBaccara = rs.getInt(1);
        }
        return allRoundsBaccara;
    }

    // Liest die Anzahl Runden von Blackjack aus der Datenbank aus
    public Integer updateRoundsBlackJack() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmtBlackJack = connection.createStatement();
        String roundsBlackJack = "select rounds from logblackjack where user like " + sqlMail;
        ResultSet rs = myStmtBlackJack.executeQuery(roundsBlackJack);
        while (rs.next()) {
            allRoundsBlackJack = rs.getInt(1);
        }
        return allRoundsBlackJack;
    }

    // Liest die Anzahl Runden von Yatzy aus der Datenbank aus
    public Integer updateRoundsYatzy() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmtYatzy = connection.createStatement();
        String roundsYatzy = "select rounds from logyatzy where user like " + sqlMail;
        ResultSet rs = myStmtYatzy.executeQuery(roundsYatzy);
        while (rs.next()) {
            allRoundsYatzy = rs.getInt(1);
        }
        return allRoundsYatzy;
    }

    // Liest die Anzahl Runden von Roulette aus der Datenbank aus
    public Integer updateRoundsRoulette() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmtRoulette = connection.createStatement();
        String roundsRoulette = "select rounds from logroulette where user like " + sqlMail;
        ResultSet rs = myStmtRoulette.executeQuery(roundsRoulette);
        while (rs.next()) {
            allRoundsRoulette = rs.getInt(1);
        }
        return allRoundsRoulette;
    }

    // Gibt die aktuelle Email zurück
    public String getEmail() {
        return getEmail;
    }

    // Definiert die Mail für ein sqlstatement
    public void setMail(String mail) {
        this.mail = mail;
        this.sqlMail = "'" + mail + "'";
        getEmail = this.sqlMail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Methode für die Verifizierung der Mail
    private void verifyMail() throws SQLException {
        // Possible tries
        stTries = sqlLogin().createStatement();
        String verifyQuery = "select tries from " + sqlGetTable() + " where email like " + sqlMail;
        rsTries = stTries.executeQuery(verifyQuery);
        while (rsTries.next()) {
            possibleTries = rsTries.getString("tries");
        }
        //VerifyCode
        stVerify = sqlLogin().createStatement();
        String verifyQueryy = "select verification from " + sqlGetTable() + " where email like " + sqlMail;
        rsVerify = stVerify.executeQuery(verifyQueryy);
        while (rsVerify.next()) {
            verifyCode = rsVerify.getString("verification");
        }
        Integer possibleTriesAsInteger = Integer.parseInt(possibleTries);
        while (possibleTriesAsInteger > 0 && wrongVerification == true) {
            JFrame frameWrong = new JFrame("Code was wrong!");
            String wrongCode = JOptionPane.showInputDialog(frameWrong, "Enter Verification Code! You have " + possibleTriesAsInteger + " tries/try left!");
            possibleTriesAsInteger--;
            String convert = String.valueOf(possibleTriesAsInteger);
            PreparedStatement psNew = sqlLogin().prepareStatement(
                    "update " + sqlGetTable() + " set tries = ? where email like " + sqlMail);
            psNew.setString(1, convert);
            psNew.executeUpdate();
            psNew.close();
            if (verifyCode.equals(wrongCode)) {
                wrongVerification = false;
                PreparedStatement ps = sqlLogin().prepareStatement(
                        "update " + sqlGetTable() + " set verification = ?, tries = ? where email like " + sqlMail);
                ps.setString(1, "Verified");
                ps.setString(2, "");
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "Your email got verified. You can log in now!", "Ready To Go", JOptionPane.OK_CANCEL_OPTION);
            }
        }
    }

    // ---------------------------------------SignUpController---------------------------------------------
    // Bereitet die Mail für den Empfänger vor
    public void sender(Event event) throws SQLException, IOException {
        int randomNum = ThreadLocalRandom.current().nextInt(100000, 999999 + 1);
        random = String.valueOf(randomNum);
        try {
            mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "587");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");
            mailSess = Session.getDefaultInstance(mailServerProperties);
            mailMessage = new MimeMessage(mailSess);
            //Empfänger-Addressen
            RECIEVERS_EMAIL = mailSignUp;
            mailMessage.addRecipient(Message.RecipientType.BCC, new InternetAddress(RECIEVERS_EMAIL));
            //Betreff
            mailMessage.setSubject("Verification");
            mailMessage.setContent(random, "text/html");
            transport = mailSess.getTransport("smtp");
            transport.connect("smtp.gmail.com", SENDERS_GMAIL, SENDERS_PASSWORD);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        checkRegistered(event);
    }

    // Get All Users with mail, password  and put them in an Array
    public void getUserDataSignUp(ArrayList<String> arr) throws SQLException {
        Statement statement = sqlLogin().createStatement();
        ResultSet result = statement.executeQuery("select email, password from " + sqlGetTable());
        ResultSetMetaData metadata = result.getMetaData();
        int columnCount = metadata.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
        }
        while (result.next()) {
            String row = "";
            for (int i = 1; i <= columnCount; i++) {
                row += result.getString(i);
                arr.add(row);
                this.arrSignUp = arr;
            }
        }
    }

    // Überprüft ob Benutzer bereits in der Datenbank vorkommt
    private void checkRegistered(Event event) throws SQLException, IOException {
        Boolean emailalreadyVerified = false;
        if (arrSignUp.contains(mailSignUp)) {
            JOptionPane.showMessageDialog(null, "This email is already registered", "Fail", JOptionPane.OK_CANCEL_OPTION);
            emailalreadyVerified = true;
        }

        if (emailalreadyVerified == false) {

            checkValidInput(event);
        }

    }

    // Überprüft ob die Eingabe den Pattern entsprechen
    private void checkValidInput(Event event) throws SQLException, IOException {
        int correctSignUp = 0;
        if (!nameSingUp.matches("^[a-zA-Z]+$") || !firstNameSignUp.matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(null, "Only Letters for Name and Firstname");
        } else if (passwordSignUp.equals(confirmPasswordSignUp)) {
            String email = mailSignUp;
            Pattern pattern = Pattern.compile(
                    "([a-zA-Z0-9_\\-\\.]+)@((\\[a-z]{1,3}\\.[a-z]"
                    + "{1,3}\\.[a-z]{1,3}\\.)|(([a-zA-Z\\-]+\\.)+))"
                    + "([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)",
                    Pattern.MULTILINE
            );
            Matcher m = pattern.matcher(email);
            boolean b = m.matches();
            if (mailSignUp.length() > 0) {
                if (b == true) {
                    if (passwordSignUp.length() >= 8) {
                        correctSignUp = 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Passwords needs at least 8 Chars");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Email");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Passwords don't match!", "Error", JOptionPane.OK_CANCEL_OPTION);
        }
        if (correctSignUp == 1) {
            insertIntoSql(event);
        }
    }

    // Schreibt bei erfolgreicher Registrierung die Daten in die Datenbank
    private void insertIntoSql(Event event) throws SQLException, IOException {
        Statement myStmt = sqlLogin().createStatement();
        String query = " insert into " + sqlGetTable() + " (name, firstname, email, password, verification, tries, chips)"
                + " values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = sqlLogin().prepareStatement(query);
        preparedStmt.setString(1, nameSingUp);
        preparedStmt.setString(2, firstNameSignUp);
        preparedStmt.setString(3, mailSignUp);
        preparedStmt.setString(4, passwordSignUp);
        preparedStmt.setString(5, random);
        preparedStmt.setString(6, "5");
        preparedStmt.setInt(7, 0);
        preparedStmt.execute();
        JOptionPane.showMessageDialog(null, "You signed up successfully, to use your account please verify your email. Code was sent to " + mailSignUp, "Success", JOptionPane.OK_CANCEL_OPTION);
        try {
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
            transport.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String emailVerification = "'" + mailSignUp + "'";
        try {
            con = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
            st = con.createStatement();
            String verifyQuery = "select verification from " + sqlGetTable() + " where email like " + emailVerification;
            rs = st.executeQuery(verifyQuery);
            while (rs.next()) {
                String verifyCode = rs.getString("verification");
                globiglobi = verifyCode;

            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JFrame frame = new JFrame("Email Verification");
        String code = JOptionPane.showInputDialog(frame, "Insert Verification Code here!");
        Integer convertVerifyCode = Integer.parseInt(globiglobi);
        Integer convertCode = Integer.parseInt(code);
        if (convertCode.equals(convertVerifyCode)) {
            try {
                JOptionPane.showMessageDialog(null, "Your email got verified. You can log in now!", "Ready To Go", JOptionPane.OK_CANCEL_OPTION);
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/WelcomeScreen.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
                PreparedStatement psVerify = sqlLogin().prepareStatement(
                        "update " + sqlGetTable() + " set verification = ?, tries = ? where email like " + emailVerification);
                psVerify.setString(1, "Verified");
                psVerify.setString(2, "");
                psVerify.executeUpdate();
                psVerify.close();
                String queryGames = " insert into logbingo (user, gekauftechips, gewinn, verlust, rounds)"
                        + " values (?, ?, ?, ?, ?)";
                PreparedStatement preparedStmtGames = sqlLogin().prepareStatement(queryGames);
                preparedStmtGames.setString(1, mailSignUp);
                preparedStmtGames.setInt(2, 0);
                preparedStmtGames.setInt(3, 0);
                preparedStmtGames.setInt(4, 0);
                preparedStmtGames.setInt(5, 0);
                preparedStmtGames.execute();
                String queryBaccara = " insert into logbaccara (user, gekauftechips, gewinn, verlust, rounds)"
                        + " values (?, ?, ?, ?, ?)";
                PreparedStatement preparedStmtBaccara = sqlLogin().prepareStatement(queryBaccara);
                preparedStmtBaccara.setString(1, mailSignUp);
                preparedStmtBaccara.setInt(2, 0);
                preparedStmtBaccara.setInt(3, 0);
                preparedStmtBaccara.setInt(4, 0);
                preparedStmtBaccara.setInt(5, 0);
                preparedStmtBaccara.execute();
                String queryBlackJack = " insert into logblackjack (user, gekauftechips, gewinn, verlust, rounds)"
                        + " values (?, ?, ?, ?, ?)";
                PreparedStatement preparedStmtBlackJack = sqlLogin().prepareStatement(queryBlackJack);
                preparedStmtBlackJack.setString(1, mailSignUp);
                preparedStmtBlackJack.setInt(2, 0);
                preparedStmtBlackJack.setInt(3, 0);
                preparedStmtBlackJack.setInt(4, 0);
                preparedStmtBlackJack.setInt(5, 0);
                preparedStmtBlackJack.execute();
                String queryRoulette = " insert into logroulette (user, gekauftechips, gewinn, verlust, rounds, gesetzechips)"
                        + " values (?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStmtRoulette = sqlLogin().prepareStatement(queryRoulette);
                preparedStmtRoulette.setString(1, mailSignUp);
                preparedStmtRoulette.setInt(2, 0);
                preparedStmtRoulette.setInt(3, 0);
                preparedStmtRoulette.setInt(4, 0);
                preparedStmtRoulette.setInt(5, 0);
                preparedStmtRoulette.setInt(6, 0);
                preparedStmtRoulette.execute();
                String queryYatzy = " insert into logyatzy (user, gekauftechips, gewinn, verlust, rounds)"
                        + " values (?, ?, ?, ?, ?)";
                PreparedStatement preparedStmtYatzy = sqlLogin().prepareStatement(queryYatzy);
                preparedStmtYatzy.setString(1, mailSignUp);
                preparedStmtYatzy.setInt(2, 0);
                preparedStmtYatzy.setInt(3, 0);
                preparedStmtYatzy.setInt(4, 0);
                preparedStmtYatzy.setInt(5, 0);
                preparedStmtYatzy.execute();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            while (wrongPassword == true && verificationTries > 0) {
                JFrame frameWrong = new JFrame("Code was wrong!");
                String wrongCode = JOptionPane.showInputDialog(frameWrong, "Code was wrong! You have " + verificationTries + " tries/try left!");
                verificationTries--;
                PreparedStatement psTries = sqlLogin().prepareStatement(
                        "update " + sqlGetTable() + " set tries = ? where email like " + emailVerification);
                String convertiere = String.valueOf(verificationTries);
                psTries.setString(1, convertiere);
                psTries.executeUpdate();
                psTries.close();
                if (wrongCode.equals(globiglobi)) {
                    wrongPassword = false;
                    JOptionPane.showMessageDialog(null, "Your email got verified. You can log in now!", "Ready To Go", JOptionPane.OK_CANCEL_OPTION);
                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/WelcomeScreen.fxml"));
                    Scene tableViewScene = new Scene(tableViewParent);
                    //This line gets the Stage information
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(tableViewScene);
                    window.show();
                    PreparedStatement psNew = sqlLogin().prepareStatement(
                            "update " + sqlGetTable() + " set verification = ?, tries = ? where email like " + emailVerification);
                    psNew.setString(1, "Verified");
                    psNew.setString(2, "");
                    psNew.executeUpdate();
                    psNew.close();
                    String queryGames = " insert into logbingo (user, gekauftechips, gewinn, verlust, rounds)"
                            + " values (?, ?, ?, ?, ?)";
                    PreparedStatement preparedStmtGames = sqlLogin().prepareStatement(queryGames);
                    preparedStmtGames.setString(1, mailSignUp);
                    preparedStmtGames.setInt(2, 0);
                    preparedStmtGames.setInt(3, 0);
                    preparedStmtGames.setInt(4, 0);
                    preparedStmtGames.setInt(5, 0);
                    preparedStmtGames.execute();
                    String queryBaccara = " insert into logbaccara (user, gekauftechips, gewinn, verlust, rounds)"
                            + " values (?, ?, ?, ?, ?)";
                    PreparedStatement preparedStmtBaccara = sqlLogin().prepareStatement(queryBaccara);
                    preparedStmtBaccara.setString(1, mailSignUp);
                    preparedStmtBaccara.setInt(2, 0);
                    preparedStmtBaccara.setInt(3, 0);
                    preparedStmtBaccara.setInt(4, 0);
                    preparedStmtBaccara.setInt(5, 0);
                    preparedStmtBaccara.execute();
                    String queryBlackJack = " insert into logblackjack (user, gekauftechips, gewinn, verlust, rounds)"
                            + " values (?, ?, ?, ?, ?)";
                    PreparedStatement preparedStmtBlackJack = sqlLogin().prepareStatement(queryBlackJack);
                    preparedStmtBlackJack.setString(1, mailSignUp);
                    preparedStmtBlackJack.setInt(2, 0);
                    preparedStmtBlackJack.setInt(3, 0);
                    preparedStmtBlackJack.setInt(4, 0);
                    preparedStmtBlackJack.setInt(5, 0);
                    preparedStmtBlackJack.execute();
                    String queryRoulette = " insert into logroulette (user, gekauftechips, gewinn, verlust, rounds, gesetzechips)"
                            + " values (?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStmtRoulette = sqlLogin().prepareStatement(queryRoulette);
                    preparedStmtRoulette.setString(1, mailSignUp);
                    preparedStmtRoulette.setInt(2, 0);
                    preparedStmtRoulette.setInt(3, 0);
                    preparedStmtRoulette.setInt(4, 0);
                    preparedStmtRoulette.setInt(5, 0);
                    preparedStmtRoulette.setInt(6, 0);
                    preparedStmtRoulette.execute();
                    String queryYatzy = " insert into logyatzy (user, gekauftechips, gewinn, verlust, rounds)"
                            + " values (?, ?, ?, ?, ?)";
                    PreparedStatement preparedStmtYatzy = sqlLogin().prepareStatement(queryYatzy);
                    preparedStmtYatzy.setString(1, mailSignUp);
                    preparedStmtYatzy.setInt(2, 0);
                    preparedStmtYatzy.setInt(3, 0);
                    preparedStmtYatzy.setInt(4, 0);
                    preparedStmtYatzy.setInt(5, 0);
                    preparedStmtYatzy.execute();
                }
            }
            if (verificationTries == 0) {
                JOptionPane.showMessageDialog(null, "Your account got locked because it seems you're not the owner of " + mail, "Account locked!", JOptionPane.OK_CANCEL_OPTION);
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/WelcomeScreen.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                //This line gets the Stage information
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
                PreparedStatement psLocked = sqlLogin().prepareStatement(
                        "update " + sqlGetTable() + " set verification = ? where email like " + emailVerification);
                psLocked.setString(1, "Locked");
                psLocked.executeUpdate();
                psLocked.close();
            }
        }
    }

    public void setMailSignUp(String mailSignUp) {
        this.mailSignUp = mailSignUp;
        this.sqlMailSignUp = "'" + mailSignUp + "'";
    }

    public void setNameSignUp(String nameSingUp) {
        this.nameSingUp = nameSingUp;
    }

    public void setFirstNameSignUp(String firstNameSignUp) {
        this.firstNameSignUp = firstNameSignUp;
    }

    public void setPasswordSignuUp(String passwordSignuUp) {
        this.passwordSignUp = passwordSignuUp;
    }

    public void setConfirmPasswordSignUp(String confirmPasswordSignUp) {
        this.confirmPasswordSignUp = confirmPasswordSignUp;
    }

}
