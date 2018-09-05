/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.model;

/**
 *
 * @author Yanick Schlatter
 */
public class RoulettePlacedChips {

    private final String chipName;
    private final int amount;

    public RoulettePlacedChips(String chipName, int amount) {
        this.chipName = chipName;
        this.amount = amount;
    }

    public String getChipName() {
        return chipName;
    }

    public int getAmount() {
        return amount;
    }

}
