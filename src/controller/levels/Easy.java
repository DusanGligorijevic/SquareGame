package controller.levels;


import controller.MyActionListener1;
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
import java.util.Random;

public class Easy implements ActionListener {
    ArrayList<Dugme> buttons = new ArrayList();
    ArrayList<Dugme> polozena = new ArrayList();
    ArrayList<Dugme> uspravna = new ArrayList();
    ArrayList<Dugme> polja = new ArrayList();
    Color boja;
    Dugme polje1;
    Dugme polje2;
    static Dugme selektovano;
    int index;
    private boolean changed = false;
    private boolean computer = ChooseFrame.getComputer();
    String pobednik;
    static int poeni1 = 0;
    static int poeni2 = 0;
    static int potez = 1;
    static int naPotezu;
    Color color1;
    Color color2;
    Color color3;
    Color color4;
    Color color5;
    Color color6;

    public Easy() {
    }

    public void actionPerformed(ActionEvent arg0) {
        String action = arg0.getActionCommand();
        this.changed = false;
        this.raspodeli(action);
        this.check();
        this.reset();
        this.checkWinner();
    }

    public void raspodeli(String action) {
        potez = MyActionListener1.getPotez();
        ArrayList<Dugme> dostupna = new ArrayList();
        this.buttons = GameFrame.getButtons();
        System.out.println("Broj dugmica: " + this.buttons.size());
        Iterator var4 = this.buttons.iterator();

        Dugme d;
        while(var4.hasNext()) {
            d = (Dugme)var4.next();
            if (d.isEnabled()) {
                System.out.println(d.getName());
                dostupna.add(d);
            } else {
                System.out.println("-");
            }
        }

        System.out.println("Dostupna d : " + dostupna.size());
        var4 = this.buttons.iterator();

        while(var4.hasNext()) {
            d = (Dugme)var4.next();
            System.out.println(d.getName() + " " + d.isEnabled());
            if (d instanceof Polozeno) {
                this.polozena.add(d);
            } else if (d instanceof Uspravno) {
                this.uspravna.add(d);
            } else if (d instanceof Polje) {
                this.polja.add(d);
            }
        }

        System.out.println("Broj dostupnih: " + dostupna.size());
        Random r = new Random();
        int x = r.nextInt(dostupna.size());
        selektovano = (Dugme)dostupna.get(x);
        this.boja = Color.BLUE;
        selektovano.setBackground(this.boja);
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
                            TableInfoFrame.setPointsEasy();
                            this.changed = true;
                            System.out.println("Treba da oboji.");
                        } else {
                            ((Dugme)this.polja.get(this.index - 1)).setBackground(ChooseFrame.getColor2());
                            ++poeni2;
                            TableInfoFrame.setPointsEasy();
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
                            TableInfoFrame.setPointsEasy();
                            this.changed = true;
                        } else {
                            ((Dugme)this.polja.get(this.index)).setBackground(ChooseFrame.getColor2());
                            ++poeni2;
                            TableInfoFrame.setPointsEasy();
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
                            TableInfoFrame.setPointsEasy();
                            this.changed = true;
                        } else {
                            ((Dugme)this.polja.get(this.index - 10)).setBackground(ChooseFrame.getColor2());
                            ++poeni2;
                            TableInfoFrame.setPointsEasy();
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
                            TableInfoFrame.setPointsEasy();
                            this.changed = true;
                        } else {
                            ((Dugme)this.polja.get(this.index)).setBackground(ChooseFrame.getColor2());
                            ++poeni2;
                            TableInfoFrame.setPointsEasy();
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
            TableInfoFrame.setNaPotezuEasy();
            TableInfoEasy.getInstance().setEnabled(false);
            GameFrame.getInstance().setEnabled(true);
        }

        Iterator var2 = this.buttons.iterator();

        while(var2.hasNext()) {
            Dugme d = (Dugme)var2.next();
            if (d.getBackground().equals(Color.BLUE)) {
                d.setBackground(Color.BLACK);
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
        Easy.selektovano = selektovano;
    }

    public static int getPoeni1() {
        return poeni1;
    }

    public static void setPoeni1(int poeni1) {
        Easy.poeni1 = poeni1;
    }

    public static int getPoeni2() {
        return poeni2;
    }

    public static void setPoeni2(int poeni2) {
        Easy.poeni2 = poeni2;
    }
}
