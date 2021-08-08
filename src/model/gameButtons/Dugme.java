package model.gameButtons;

import javax.swing.*;

public class Dugme extends JButton {
    private String name = "Dugme";

    public Dugme(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
