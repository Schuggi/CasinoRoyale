/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.casinoroyale.model;

import javafx.scene.image.Image;

/**
 *
 * @author Yanick Schlatter
 */
public class RouletteChips {

    private Image chip;
    private final String chipName;

    public RouletteChips(Image chip, String chipName) {
        this.chip = chip;
        this.chipName = chipName;
    }

    public Image getChip() {
        return chip;
    }

    public String getChipName() {
        return chipName;
    }

    public void setChip(Image chip) {
        this.chip = chip;
    }

}
