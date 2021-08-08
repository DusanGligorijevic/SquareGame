package model.gameButtons;

import controller.MyActionListener1;

import java.awt.*;

public class Uspravno extends Dugme{
    public Uspravno(String name) {
        super(name);
        setBackground(Color.LIGHT_GRAY);
        this.setPreferredSize(new Dimension(8, 40));
        this.addActionListener(new MyActionListener1());
    }
}
