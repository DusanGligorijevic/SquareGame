package view;


import controller.levels.Easy;
import controller.levels.Hard;
import controller.MyActionListener1;

import javax.swing.*;
import java.awt.*;

public class TableInfoFrame extends JFrame{
    static JLabel name1;
    static JLabel name2;
    static JLabel poeni1;
    static JLabel poeni2;
    static JLabel points1;
    static JLabel points2;
    static JLabel naPotezu;
    static String ime1;
    private static TableInfoFrame instance;

    public static TableInfoFrame getInstance() {
        if (instance == null) {
            instance = new TableInfoFrame();
            instance.frame();
        }

        return instance;
    }

    private TableInfoFrame() {
    }

    public final void frame() {
        this.setTitle("Info");
        this.setBackground(Color.WHITE);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        GridBagConstraints layout = new GridBagConstraints();
        layout.gridwidth = 0;
        layout.fill = 3;
        this.setLayout(new GridBagLayout());
        String ime1 = ChooseFrame.getPlayer1name();
        System.out.println(ime1);
        name1 = new JLabel();
        name1.setText(ime1);
        name1.setForeground(ChooseFrame.getColor1());
        name1.setSize(new Dimension(100, 100));
        poeni1 = new JLabel();
        points1 = new JLabel();
        points1.setPreferredSize(new Dimension(100, 100));
        this.add(name1, layout);
        this.add(points1, layout);
        naPotezu = new JLabel(ChooseFrame.getPlayer1name() + " is on the move.");
        this.setBackground(Color.WHITE);
        String ime2 = ChooseFrame.getPlayer2name();
        System.out.println(ime2);
        name2 = new JLabel("Points: " + MyActionListener1.getPoeni2());
        name2.setText(ime2);
        name2.setForeground(ChooseFrame.getColor2());
        name2.setSize(new Dimension(100, 100));
        poeni2 = new JLabel();
        points2 = new JLabel();
        points2.setPreferredSize(new Dimension(100, 100));
        this.add(name2, layout);
        this.add(points2, layout);
        this.add(naPotezu, layout);
    }
    public static void setNaPotezuEasy() {
        int potez = Easy.getPotez();
        if (potez == 1) {
            naPotezu.setText(ChooseFrame.getPlayer1name() + " is on the move.");
            ime1 = ChooseFrame.getPlayer1name();
            System.out.println(ime1);
        } else {
            naPotezu.setText(ChooseFrame.getPlayer2name() + " is on the move.");
            ime1 = ChooseFrame.getPlayer2name();
            System.out.println(ime1);
        }

    }

    public static void setNaPotezuHard() {
        int potez = Hard.getPotez();
        if (potez == 1) {
            naPotezu.setText(ChooseFrame.getPlayer1name() + " is on the move.");
            ime1 = ChooseFrame.getPlayer1name();
            System.out.println(ime1);
        } else {
            naPotezu.setText(ChooseFrame.getPlayer2name() + " is on the move.");
            ime1 = ChooseFrame.getPlayer2name();
            System.out.println(ime1);
        }

    }

    public static void setNaPotezu() {
        int potez = MyActionListener1.getPotez();
        if (potez == 1) {
            naPotezu.setText(ChooseFrame.getPlayer1name() + " is on the move.");
            ime1 = ChooseFrame.getPlayer1name();
            System.out.println(ime1);
        } else {
            naPotezu.setText(ChooseFrame.getPlayer2name() + " is on the move.");
            ime1 = ChooseFrame.getPlayer2name();
            System.out.println(ime1);
        }

    }
    public static String getIme1() {
        return ime1;
    }

    public static void setPoints() {
        points1.setText("Points: " + MyActionListener1.getPoeni1());
        if (!ChooseFrame.getComputer()) {
            points2.setText("Points: " + MyActionListener1.getPoeni2());
        }

        if (ChooseFrame.getComputer()) {
            Easy.setPoeni1(MyActionListener1.getPoeni1());
            Hard.setPoeni1(MyActionListener1.getPoeni1());
        }

    }

    public static void setPointsEasy() {
        points2.setText("Points: " + Easy.getPoeni2());
        MyActionListener1.setPoeni2(Easy.getPoeni2());
    }

    public static void setPointsHard() {
        points2.setText("Points: " + Hard.getPoeni2());
        MyActionListener1.setPoeni2(Hard.getPoeni2());
    }
}
