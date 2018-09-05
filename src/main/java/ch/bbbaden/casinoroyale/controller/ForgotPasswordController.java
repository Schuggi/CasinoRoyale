/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.controller;

import ch.bbbaden.casinoroyale.model.Actions;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yannick
 */
public class ForgotPasswordController implements Initializable {

    private final String dbAdress = "jdbc:mysql://yannickhuggler.com:3306/";
    private final String dbName = "gruppe2";
    private final String dbUserName = "gruppe2";
    private final String dbPassword = "NQ7sZEZq";
    private PreparedStatement test;
    private Connection con;
    private ResultSet result;
    private static Properties mailServerProperties;
    private static Session mailSess;
    private static MimeMessage mailMessage;
    private static final String SENDERS_GMAIL = "autonetbeans@gmail.com";
    private static final String SENDERS_PASSWORD = "&Papagei11";
    static Transport transport;
    String RECIEVERS_EMAIL = "autonetbeans@gmail.com";
    static Transport transportt;
    String password;

    @FXML
    private JFXTextField txtEmail;
    @FXML
    private Button btnResend;

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
    private void resend(ActionEvent event) throws SQLException, IOException {
        Actions actions = Actions.getInstance();
        // Check If Email exists
        if (checkExistUser() == true) {
            forgotPasswordMail();
            senderForgotPassword(event);
            JOptionPane.showMessageDialog(null, "Your Password was sent to " + txtEmail.getText(), "Success", JOptionPane.OK_CANCEL_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "Sorry, this email doesn't exist!", "Sorry", JOptionPane.OK_CANCEL_OPTION);
        }

    }

    // Überprüft ob die Mail in der Datenbank vorkommt
    public boolean checkExistUser() {
        try {
            con = DriverManager.getConnection(dbAdress + dbName, dbUserName, dbPassword);
            String str = "select email from users where email = ?";
            test = con.prepareStatement(str);
            test.setString(1, txtEmail.getText());
            result = test.executeQuery();

            if (!result.next()) {
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            return true;
        }

    }

    public String forgotPasswordMail() {
        return txtEmail.getText();
    }

    // Sendet eine Mail mit dem Passwort aus der Datenbank
    private void senderForgotPassword(Event event) throws SQLException, IOException {
        try {
            mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "587");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");
            mailSess = Session.getDefaultInstance(mailServerProperties);
            mailMessage = new MimeMessage(mailSess);
            //Empfänger-Addressen
            RECIEVERS_EMAIL = txtEmail.getText();
            mailMessage.addRecipient(Message.RecipientType.BCC, new InternetAddress(RECIEVERS_EMAIL));
            //Betreff
            mailMessage.setSubject("Password Reset");
            mailMessage.setContent("Your Password Is: " + getCurrentPassword(), "text/html");
            transport = mailSess.getTransport("smtp");
            transport.connect("smtp.gmail.com", SENDERS_GMAIL, SENDERS_PASSWORD);
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
            transport.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    // Liest das Passwort aus der Datenbank aus
    private String getCurrentPassword() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://yannickhuggler.com:3306/gruppe2", "gruppe2", "NQ7sZEZq");
        Statement myStmt = connection.createStatement();
        String getPassword = "select password from users where email like " + "'" + txtEmail.getText() + "'";
        ResultSet rs = myStmt.executeQuery(getPassword);
        while (rs.next()) {
            password = rs.getString("password");
        }
        return password;
    }

}
