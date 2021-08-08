package model.gameButtons;

import controller.MyActionListener1;

import java.awt.*;

public class Polje extends Dugme{
    int brojac = 0;

    public Polje(String name) {
        super(name);
        this.addActionListener(new MyActionListener1());
        this.setPreferredSize(new Dimension(31, 37));
        this.setBackground(Color.WHITE);
        this.setEnabled(false);
    }

    public int getBrojac() {
        return this.brojac;
    }

    public void setBrojac(int brojac) {
        this.brojac = brojac;
    }
}
