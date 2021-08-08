package controller;

import controller.levels.Easy;
import controller.levels.Hard;
import model.gameButtons.Dugme;
import model.gameButtons.Polje;
import model.gameButtons.Polozeno;
import model.gameButtons.Uspravno;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class MyActionListener1 implements ActionListener {
    ArrayList<Dugme> buttons = new ArrayList();
    ArrayList<Dugme> dostupna = new ArrayList();
    ArrayList<Dugme> polozena = new ArrayList();
    ArrayList<Dugme> uspravna = new ArrayList();
    ArrayList<Dugme> polja = new ArrayList();
    Color boja;
    static Dugme selektovano;
    int index;
    private boolean changed = false;
    private boolean computer = ChooseFrame.getComputer();
    String pobednik;
    static int poeni1 = 0;
    static int poeni2 = 0;
    static int potez = 1;
    Color color1;
    Color color2;
    Color color3;
    Color color4;
    Color color5;
    Color color6;

    public MyActionListener1() {
    }

    public void actionPerformed(ActionEvent arg0) {
        this.changed = false;
        String action = arg0.getActionCommand();
        this.raspodeli(action);
        this.check();
        this.reset();
        this.checkWinner();
    }

    public void raspodeli(String action) {
        if (ChooseFrame.getComputer()) {
            potez = Easy.getPotez();
        }

        if (ChooseFrame.getComputerHard()) {
            potez = Hard.getPotez();
        }

        this.buttons = GameFrame.getButtons();
        System.out.println("Broj dugmica: " + this.buttons.size());
        Iterator var3 = this.buttons.iterator();

        Dugme d;
        while(var3.hasNext()) {
            d = (Dugme)var3.next();
            if (d.getName().equals(action)) {
                this.boja = Color.BLACK;
                d.setBackground(this.boja);
                selektovano = d;
                d.setEnabled(false);
            }
        }

        var3 = this.buttons.iterator();

        while(var3.hasNext()) {
            d = (Dugme)var3.next();
            if (d.isEnabled()) {
                this.dostupna.add(d);
            }

            if (d instanceof Polozeno) {
                this.polozena.add(d);
            } else if (d instanceof Uspravno) {
                this.uspravna.add(d);
            } else if (d instanceof Polje) {
                this.polja.add(d);
            }
        }

        System.out.println("BRoj dostupnih: " + this.dostupna.size());
    }

    public void check() {
        Dugme p;
        Iterator var2;
        if (selektovano instanceof Uspravno) {
            var2 = this.uspravna.iterator();

            while(var2.hasNext()) {
                p = (Dugme)var2.next();
                if (selektovano.getName().contentEquals(p.getName())) {
                    this.index = this.uspravna.indexOf(p);
                    this.color1 = ((Dugme)this.uspravna.get(this.index - 1)).getBackground();
                    this.color2 = ((Dugme)this.polozena.get(this.index - 1)).getBackground();
                    if (this.index < 90) {
                        this.color3 = ((Dugme)this.polozena.get(this.index + 9)).getBackground();
                    } else {
                        this.color3 = Color.BLACK;
                    }

                    if (this.color1.equals(Color.BLACK) && this.color2.equals(Color.BLACK) && this.color3.equals(Color.BLACK) && selektovano.getBackground().equals(this.boja)) {
                        if (TableInfoFrame.getIme1().contains(ChooseFrame.getPlayer1name())) {
                            ((Dugme)this.polja.get(this.index - 1)).setBackground(ChooseFrame.getColor1());
                            ++poeni1;
                            TableInfoFrame.setPoints();
                            if (ChooseFrame.getComputer()) {
                                TableInfoFrame.setPointsEasy();
                            }

                            if (ChooseFrame.getComputerHard()) {
                                TableInfoFrame.setPointsHard();
                            }

                            this.changed = true;
                            System.out.println("Treba da oboji.");
                        } else {
                            ((Dugme)this.polja.get(this.index - 1)).setBackground(ChooseFrame.getColor2());
                            ++poeni2;
                            TableInfoFrame.setPoints();
                            if (ChooseFrame.getComputer()) {
                                TableInfoFrame.setPointsEasy();
                            }

                            if (ChooseFrame.getComputerHard()) {
                                TableInfoFrame.setPointsHard();
                            }

                            this.changed = true;
                            System.out.println("Treba da oboji.");
                        }
                    }

                    if (this.index >= 99) {
                        this.color4 = Color.BLACK;
                    } else {
                        this.color4 = ((Dugme)this.uspravna.get(this.index + 1)).getBackground();
                    }

                    this.color5 = ((Dugme)this.polozena.get(this.index)).getBackground();
                    if (this.index < 90) {
                        this.color6 = ((Dugme)this.polozena.get(this.index + 10)).getBackground();
                    } else {
                        this.color6 = Color.BLACK;
                    }

                    if (this.color4.equals(Color.BLACK) && this.color5.equals(Color.BLACK) && this.color6.equals(Color.BLACK) && selektovano.getBackground().equals(this.boja)) {
                        if (TableInfoFrame.getIme1().contains(ChooseFrame.getPlayer1name())) {
                            ((Dugme)this.polja.get(this.index)).setBackground(ChooseFrame.getColor1());
                            ++poeni1;
                            TableInfoFrame.setPoints();
                            if (ChooseFrame.getComputer()) {
                                TableInfoFrame.setPointsEasy();
                            }

                            if (ChooseFrame.getComputerHard()) {
                                TableInfoFrame.setPointsHard();
                            }

                            this.changed = true;
                        } else {
                            ((Dugme)this.polja.get(this.index)).setBackground(ChooseFrame.getColor2());
                            ++poeni2;
                            TableInfoFrame.setPoints();
                            if (ChooseFrame.getComputer()) {
                                TableInfoFrame.setPointsEasy();
                            }

                            if (ChooseFrame.getComputerHard()) {
                                TableInfoFrame.setPointsHard();
                            }

                            this.changed = true;
                        }
                    }
                }
            }
        } else if (selektovano instanceof Polozeno) {
            var2 = this.polozena.iterator();

            while(var2.hasNext()) {
                p = (Dugme)var2.next();
                if (selektovano.getName().contentEquals(p.getName())) {
                    this.index = this.polozena.indexOf(p);
                    if (this.index >= 10) {
                        this.color1 = ((Dugme)this.uspravna.get(this.index - 10)).getBackground();
                        this.color2 = ((Dugme)this.polozena.get(this.index - 10)).getBackground();
                        this.color3 = ((Dugme)this.uspravna.get(this.index - 9)).getBackground();
                    } else {
                        this.color1 = Color.BLACK;
                        this.color2 = Color.BLACK;
                        this.color3 = Color.BLACK;
                    }

                    if (this.color1.equals(Color.BLACK) && this.color2.equals(Color.BLACK) && this.color3.equals(Color.BLACK) && selektovano.getBackground().equals(this.boja) && this.index > 9) {
                        if (TableInfoFrame.getIme1().contains(ChooseFrame.getPlayer1name())) {
                            ((Dugme)this.polja.get(this.index - 10)).setBackground(ChooseFrame.getColor1());
                            ++poeni1;
                            TableInfoFrame.setPoints();
                            if (ChooseFrame.getComputer()) {
                                TableInfoFrame.setPointsEasy();
                            }

                            if (ChooseFrame.getComputerHard()) {
                                TableInfoFrame.setPointsHard();
                            }

                            this.changed = true;
                        } else {
                            ((Dugme)this.polja.get(this.index - 10)).setBackground(ChooseFrame.getColor2());
                            ++poeni2;
                            TableInfoFrame.setPoints();
                            if (ChooseFrame.getComputer()) {
                                TableInfoFrame.setPointsEasy();
                            }

                            if (ChooseFrame.getComputerHard()) {
                                TableInfoFrame.setPointsHard();
                            }

                            this.changed = true;
                        }
                    }

                    if (this.index >= 99) {
                        this.color4 = Color.BLACK;
                    } else {
                        this.color4 = ((Dugme)this.uspravna.get(this.index + 1)).getBackground();
                    }

                    this.color5 = ((Dugme)this.uspravna.get(this.index)).getBackground();
                    if (this.index < 90) {
                        this.color6 = ((Dugme)this.polozena.get(this.index + 10)).getBackground();
                    } else {
                        this.color6 = Color.BLACK;
                    }

                    if (this.color4.equals(Color.BLACK) && this.color5.equals(Color.BLACK) && this.color6.equals(Color.BLACK) && selektovano.getBackground().equals(this.boja)) {
                        if (TableInfoFrame.getIme1().contains(ChooseFrame.getPlayer1name())) {
                            ((Dugme)this.polja.get(this.index)).setBackground(ChooseFrame.getColor1());
                            ++poeni1;
                            TableInfoFrame.setPoints();
                            if (ChooseFrame.getComputer()) {
                                TableInfoFrame.setPointsEasy();
                            }

                            if (ChooseFrame.getComputerHard()) {
                                TableInfoFrame.setPointsHard();
                            }

                            this.changed = true;
                        } else {
                            ((Dugme)this.polja.get(this.index)).setBackground(ChooseFrame.getColor2());
                            ++poeni2;
                            TableInfoFrame.setPoints();
                            if (ChooseFrame.getComputer()) {
                                TableInfoFrame.setPointsEasy();
                            }

                            if (ChooseFrame.getComputerHard()) {
                                TableInfoFrame.setPointsHard();
                            }

                            this.changed = true;
                        }
                    }
                }
            }
        }

        selektovano.setEnabled(false);
    }

    public void checkWinner() {
        if (poeni1 + poeni2 == 100) {
            if (poeni1 < poeni2) {
                this.pobednik = ChooseFrame.getPlayer2name();
            } else if (poeni1 == poeni2) {
                JOptionPane.showMessageDialog((Component)null, "it's 50:50 :)");
            } else {
                this.pobednik = ChooseFrame.getPlayer1name();
                JOptionPane.showMessageDialog((Component)null, "Winner is " + this.pobednik);
            }

            GameFrame.getInstance().setVisible(false);
            TableInfoFrame.getInstance().setVisible(false);
            StartFrame.getInstance().setVisible(true);
        }
    }

    public void reset() {
        this.polja.clear();
        this.uspravna.clear();
        this.polozena.clear();
        if (!this.changed) {
            potez *= -1;
            TableInfoFrame.setNaPotezu();
            if (this.computer || ChooseFrame.getComputerHard()) {
                GameFrame.getInstance().setEnabled(false);
                TableInfoEasy.getInstance().setEnabled(true);
            }
        }

    }

    public static int getPotez() {
        return potez;
    }

    public boolean isComputer() {
        return this.computer;
    }

    public void setComputer(boolean computer) {
        this.computer = computer;
    }

    public static Dugme getSelektovano() {
        return selektovano;
    }

    public static void setSelektovano(Dugme selektovano) {
        MyActionListener1.selektovano = selektovano;
    }

    public static int getPoeni1() {
        return poeni1;
    }

    public static void setPoeni1(int poeni1) {
        MyActionListener1.poeni1 = poeni1;
    }

    public static int getPoeni2() {
        return poeni2;
    }

    public static void setPoeni2(int poeni2) {
        MyActionListener1.poeni2 = poeni2;
    }

}
