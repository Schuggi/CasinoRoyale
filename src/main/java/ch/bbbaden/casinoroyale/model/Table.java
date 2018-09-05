/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.model;

/**
 *
 * @author Yannick
 */
public class Table {

    String user;
    String gewinn, verlust, rounds;

    // Nimmt die Werte aus dem Controller entgegen
    public Table(String user, String win, String loss, String rounds) {
        this.user = user;
        this.gewinn = win;
        this.verlust = loss;
        this.rounds = rounds;
    }

    // Gibt die Wert zurück, ohne die wird in der TableView nichts zu sehen sein
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getGewinn() {
        return gewinn;
    }

    public void setGewinn(String gewinn) {
        this.gewinn = gewinn;
    }

    public String getVerlust() {
        return verlust;
    }

    public void setVerlust(String verlust) {
        this.verlust = verlust;
    }

    public String getRounds() {
        return rounds;
    }

    public void setRounds(String rounds) {
        this.rounds = rounds;
    }

}
