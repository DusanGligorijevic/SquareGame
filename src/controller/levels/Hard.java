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

public class Hard implements ActionListener {
    int brojac = 0;
    int temp2 = 0;
    int temp = 0;
    Dugme d;
    Dugme cilj;
    ArrayList<Dugme> neobojene = new ArrayList();
    Polje dugme;
    ArrayList<Polje> trojke = new ArrayList();
    ArrayList<Polje> dvojke = new ArrayList();
    ArrayList<Polje> jedinice = new ArrayList();
    ArrayList<Polje> nule = new ArrayList();
    ArrayList<Dugme> buttons = new ArrayList();
    ArrayList<Dugme> polozena = new ArrayList();
    ArrayList<Dugme> uspravna = new ArrayList();
    static ArrayList<Dugme> polja = new ArrayList();
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

    public Hard() {
    }

    public void actionPerformed(ActionEvent arg0) {
        this.changed = false;
        System.out.println("system");
        this.raspodeli(arg0.getActionCommand());
        this.proveri();
        this.check();
        this.checking();
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
                polja.add(d);
                this.dugme = (Polje)d;
            }
        }

    }

    public void proveri() {
        System.out.println("Broj polja: " + polja.size());
        System.out.println("Broj polozenih: " + this.polozena.size());
        System.out.println("Broj uspravnih: " + this.uspravna.size());

        for(Iterator var2 = polja.iterator(); var2.hasNext(); this.brojac = 0) {
            Dugme p = (Dugme)var2.next();
            this.index = polja.indexOf(p);
            System.out.println("ne zaboravi da resetujes brojac");
            if (((Dugme)this.uspravna.get(this.index)).getBackground().equals(Color.BLACK)) {
                ++this.brojac;
            }

            if (this.index < 99) {
                if (((Dugme)this.uspravna.get(this.index + 1)).getBackground().equals(Color.BLACK)) {
                    ++this.brojac;
                }
            } else {
                ++this.brojac;
            }

            if (((Dugme)this.polozena.get(this.index)).getBackground().equals(Color.BLACK)) {
                ++this.brojac;
            }

            if (this.index < 90) {
                if (((Dugme)this.polozena.get(this.index + 10)).getBackground().equals(Color.BLACK)) {
                    ++this.brojac;
                }
            } else {
                ++this.brojac;
            }

            System.out.println("brojac: " + this.brojac);
            if (this.brojac == 3) {
                this.trojke.add((Polje)p);
            } else if (this.brojac == 1) {
                this.jedinice.add((Polje)p);
            } else if (this.brojac == 0) {
                this.nule.add((Polje)p);
            } else if (this.brojac == 2) {
                this.dvojke.add((Polje)p);
            }
        }

        System.out.println("broj trojki:" + this.trojke.size());
        System.out.println("Broj dvojki: " + this.dvojke.size());
        System.out.println("Broj jedinica: " + this.jedinice.size());
        System.out.println("Broj nula" + this.nule.size());
        Random r = new Random();
        if (!this.trojke.isEmpty()) {
            this.d = (Dugme)this.trojke.get(r.nextInt(this.trojke.size()));
        } else if (!this.jedinice.isEmpty()) {
            this.d = (Dugme)this.jedinice.get(r.nextInt(this.jedinice.size()));
        } else if (!this.nule.isEmpty()) {
            this.d = (Dugme)this.nule.get(r.nextInt(this.nule.size()));
        } else if (!this.dvojke.isEmpty()) {
            this.d = (Dugme)this.dvojke.get(r.nextInt(this.dvojke.size()));
        } else {
            JOptionPane.showMessageDialog((Component)null, "Greška.");
        }

        this.index = polja.indexOf(this.d);
        this.d.setText("Pez");
        if (!((Dugme)this.uspravna.get(this.index)).getBackground().equals(Color.BLACK)) {
            this.neobojene.add((Dugme)this.uspravna.get(this.index));
        }

        if (this.index < 99 && !((Dugme)this.uspravna.get(this.index + 1)).getBackground().equals(Color.BLACK)) {
            this.neobojene.add((Dugme)this.uspravna.get(this.index + 1));
        }

        if (!((Dugme)this.polozena.get(this.index)).getBackground().equals(Color.BLACK)) {
            this.neobojene.add((Dugme)this.polozena.get(this.index));
        }

        if (this.index < 90 && !((Dugme)this.polozena.get(this.index + 10)).getBackground().equals(Color.BLACK)) {
            this.neobojene.add((Dugme)this.polozena.get(this.index + 10));
        }

        System.out.println("Broj mogucih polja: " + this.neobojene.size());
        Random m = new Random();
        int x = m.nextInt(this.neobojene.size());
        this.cilj = (Dugme)this.neobojene.get(x);
        this.cilj.setBackground(Color.BLACK);
    }

    public void check() {
    }

    public void checking() {
        selektovano = this.cilj;
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

                    if (this.color1.equals(Color.BLACK) && this.color2.equals(Color.BLACK) && this.color3.equals(Color.BLACK) && selektovano.getBackground().equals(Color.BLACK)) {
                        if (TableInfoFrame.getIme1().contains(ChooseFrame.getPlayer1name())) {
                            ((Dugme)polja.get(this.index - 1)).setBackground(ChooseFrame.getColor1());
                            ++poeni1;
                            TableInfoFrame.setPointsHard();
                            this.changed = true;
                            System.out.println("Treba da oboji.");
                            System.out.println(poeni1);
                        } else {
                            ((Dugme)polja.get(this.index - 1)).setBackground(ChooseFrame.getColor2());
                            ++poeni2;
                            TableInfoFrame.setPointsHard();
                            this.changed = true;
                            System.out.println("Treba da oboji.");
                            System.out.println(poeni2);
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

                    if (this.color4.equals(Color.BLACK) && this.color5.equals(Color.BLACK) && this.color6.equals(Color.BLACK) && selektovano.getBackground().equals(Color.BLACK)) {
                        if (TableInfoFrame.getIme1().contains(ChooseFrame.getPlayer1name())) {
                            ((Dugme)polja.get(this.index)).setBackground(ChooseFrame.getColor1());
                            ++poeni1;
                            TableInfoFrame.setPointsHard();
                            System.out.println(poeni1);
                            this.changed = true;
                        } else {
                            ((Dugme)polja.get(this.index)).setBackground(ChooseFrame.getColor2());
                            ++poeni2;
                            TableInfoFrame.setPointsHard();
                            System.out.println(poeni2);
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

                    if (this.color1.equals(Color.BLACK) && this.color2.equals(Color.BLACK) && this.color3.equals(Color.BLACK) && selektovano.getBackground().equals(Color.BLACK) && this.index > 9) {
                        if (TableInfoFrame.getIme1().contains(ChooseFrame.getPlayer1name())) {
                            ((Dugme)polja.get(this.index - 10)).setBackground(ChooseFrame.getColor1());
                            ++poeni1;
                            TableInfoFrame.setPointsHard();
                            this.changed = true;
                        } else {
                            ((Dugme)polja.get(this.index - 10)).setBackground(ChooseFrame.getColor2());
                            ++poeni2;
                            TableInfoFrame.setPointsHard();
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

                    if (this.color4.equals(Color.BLACK) && this.color5.equals(Color.BLACK) && this.color6.equals(Color.BLACK) && selektovano.getBackground().equals(Color.BLACK)) {
                        if (TableInfoFrame.getIme1().contains(ChooseFrame.getPlayer1name())) {
                            ((Dugme)polja.get(this.index)).setBackground(ChooseFrame.getColor1());
                            ++poeni1;
                            TableInfoFrame.setPointsHard();
                            this.changed = true;
                        } else {
                            ((Dugme)polja.get(this.index)).setBackground(ChooseFrame.getColor2());
                            ++poeni2;
                            TableInfoFrame.setPointsHard();
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
        polja.clear();
        this.uspravna.clear();
        this.polozena.clear();
        this.trojke.clear();
        this.dvojke.clear();
        this.jedinice.clear();
        this.nule.clear();
        this.neobojene.clear();
        if (!this.changed) {
            potez *= -1;
            TableInfoFrame.setNaPotezuHard();
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

    public int getBrojac() {
        return this.brojac;
    }

    public void setBrojac(int brojac) {
        this.brojac = brojac;
    }

    public int getTemp2() {
        return this.temp2;
    }

    public void setTemp2(int temp2) {
        this.temp2 = temp2;
    }

    public int getTemp() {
        return this.temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public Dugme getD() {
        return this.d;
    }

    public void setD(Dugme d) {
        this.d = d;
    }

    public Dugme getCilj() {
        return this.cilj;
    }

    public void setCilj(Dugme cilj) {
        this.cilj = cilj;
    }

    public ArrayList<Dugme> getNeobojene() {
        return this.neobojene;
    }

    public void setNeobojene(ArrayList<Dugme> neobojene) {
        this.neobojene = neobojene;
    }

    public Polje getDugme() {
        return this.dugme;
    }

    public void setDugme(Polje dugme) {
        this.dugme = dugme;
    }

    public ArrayList<Polje> getTrojke() {
        return this.trojke;
    }

    public void setTrojke(ArrayList<Polje> trojke) {
        this.trojke = trojke;
    }

    public ArrayList<Polje> getDvojke() {
        return this.dvojke;
    }

    public void setDvojke(ArrayList<Polje> dvojke) {
        this.dvojke = dvojke;
    }

    public ArrayList<Polje> getJedinice() {
        return this.jedinice;
    }

    public void setJedinice(ArrayList<Polje> jedinice) {
        this.jedinice = jedinice;
    }

    public ArrayList<Polje> getNule() {
        return this.nule;
    }

    public void setNule(ArrayList<Polje> nule) {
        this.nule = nule;
    }

    public ArrayList<Dugme> getButtons() {
        return this.buttons;
    }

    public void setButtons(ArrayList<Dugme> buttons) {
        this.buttons = buttons;
    }

    public ArrayList<Dugme> getPolozena() {
        return this.polozena;
    }

    public void setPolozena(ArrayList<Dugme> polozena) {
        this.polozena = polozena;
    }

    public ArrayList<Dugme> getUspravna() {
        return this.uspravna;
    }

    public void setUspravna(ArrayList<Dugme> uspravna) {
        this.uspravna = uspravna;
    }

    public static ArrayList<Dugme> getPolja() {
        return polja;
    }

    public static void setPolja(ArrayList<Dugme> polja) {
        Hard.polja = polja;
    }

    public Color getBoja() {
        return this.boja;
    }

    public void setBoja(Color boja) {
        this.boja = boja;
    }

    public Dugme getPolje1() {
        return this.polje1;
    }

    public void setPolje1(Dugme polje1) {
        this.polje1 = polje1;
    }

    public Dugme getPolje2() {
        return this.polje2;
    }

    public void setPolje2(Dugme polje2) {
        this.polje2 = polje2;
    }

    public static Dugme getSelektovano() {
        return selektovano;
    }

    public static void setSelektovano(Dugme selektovano) {
        Hard.selektovano = selektovano;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isChanged() {
        return this.changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public boolean isComputer() {
        return this.computer;
    }

    public void setComputer(boolean computer) {
        this.computer = computer;
    }

    public String getPobednik() {
        return this.pobednik;
    }

    public void setPobednik(String pobednik) {
        this.pobednik = pobednik;
    }

    public static int getPoeni1() {
        return poeni1;
    }

    public static void setPoeni1(int poeni1) {
        Hard.poeni1 = poeni1;
    }

    public static int getPoeni2() {
        return poeni2;
    }

    public static void setPoeni2(int poeni2) {
        Hard.poeni2 = poeni2;
    }

    public static int getPotez() {
        return potez;
    }

    public static void setPotez(int potez) {
        Hard.potez = potez;
    }

    public static int getNaPotezu() {
        return naPotezu;
    }

    public static void setNaPotezu(int naPotezu) {
        Hard.naPotezu = naPotezu;
    }

    public Color getColor1() {
        return this.color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return this.color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public Color getColor3() {
        return this.color3;
    }

    public void setColor3(Color color3) {
        this.color3 = color3;
    }

    public Color getColor4() {
        return this.color4;
    }

    public void setColor4(Color color4) {
        this.color4 = color4;
    }

    public Color getColor5() {
        return this.color5;
    }

    public void setColor5(Color color5) {
        this.color5 = color5;
    }

    public Color getColor6() {
        return this.color6;
    }

    public void setColor6(Color color6) {
        this.color6 = color6;
    }
}
