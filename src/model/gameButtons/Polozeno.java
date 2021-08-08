package model.gameButtons;

import controller.MyActionListener1;

import java.awt.*;

public class Polozeno extends Dugme{
    public Polozeno(String name) {
        super(name);
        setBackground(Color.LIGHT_GRAY);
        this.addActionListener(new MyActionListener1());
        this.setPreferredSize(new Dimension(40, 8));
    }
}
