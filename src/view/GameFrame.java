package view;

import model.gameButtons.Dugme;
import model.gameButtons.Polje;
import model.gameButtons.Polozeno;
import model.gameButtons.Uspravno;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameFrame extends JFrame {
    private static ArrayList<Dugme> buttons = new ArrayList();
    private Dugme polozeno;
    private Dugme uspravno;
    private Dugme polje;
    private static GameFrame instance;

    public static GameFrame getInstance() {
        if (instance == null) {
            instance = new GameFrame();
            instance.game();
        }

        return instance;
    }

    private GameFrame() {
    }
    // playground
    private void game() {
        this.setTitle("Square");
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.setSize(420, 530);
        this.setResizable(false);
        this.setLayout(new FlowLayout(1, 0, 0));
        this.napraviDugmice();
    }

    private void napraviDugmice() {
        int p = 0;

        for(int i = 1; i <= 10; ++i) {
            int j;
            for(j = 1; j <= 10; ++j) {
                this.polozeno = new Polozeno("p" + this.getName() + i + p);
                this.polozeno.setActionCommand("p" + this.getName() + i + p);
                this.add(this.polozeno);
                buttons.add(this.polozeno);
                ++p;
                if (i == 1) {
                    this.setDefaultColor(this.polozeno);
                    this.polozeno.setEnabled(false);
                }
            }

            for(j = 1; j <= 11; ++j) {
                if (j == 11) {
                    this.uspravno = new Uspravno("u" + this.getName() + i + p);
                    this.uspravno.setActionCommand("u" + this.getName() + i + p);
                    this.add(this.uspravno);
                    this.setDefaultColor(this.uspravno);
                    this.uspravno.setEnabled(false);
                    ++p;
                    break;
                }

                this.uspravno = new Uspravno("u" + this.getName() + i + p);
                this.uspravno.setActionCommand("u" + this.getName() + i + p);
                ++p;
                this.add(this.uspravno);
                buttons.add(this.uspravno);
                this.polje = new Polje("f" + this.getName() + i + p);
                this.polje.setActionCommand("f" + this.getName() + i + p);
                ++p;
                if (j == 1) {
                    this.setDefaultColor(this.uspravno);
                    this.uspravno.setEnabled(false);
                }

                buttons.add(this.polje);
                this.add(this.polje);
            }

            if (i == 10) {
                for(j = 1; j <= 10; ++j) {
                    this.polozeno = new Polozeno("p" + this.getName() + i + p);
                    this.polozeno.setActionCommand("p" + this.getName() + i + p);
                    ++p;
                    this.add(this.polozeno);
                    this.setDefaultColor(this.polozeno);
                    this.polozeno.setEnabled(false);
                }
            }
        }

    }

    public void setDefaultColor(Dugme d) {
        d.setBackground(Color.BLACK);
    }

    public void getBackground(Dugme d) {
        d.getBackground();
    }

    public static ArrayList<Dugme> getButtons() {
        return buttons;
    }

    public void setButtons(ArrayList<Dugme> buttons) {
        GameFrame.buttons = buttons;
    }

    public Dugme getPolozeno() {
        return this.polozeno;
    }

    public void setPolozeno(Dugme polozeno) {
        this.polozeno = polozeno;
    }

    public Dugme getUspravno() {
        return this.uspravno;
    }

    public void setUspravno(Dugme uspravno) {
        this.uspravno = uspravno;
    }

    public Dugme getPolje() {
        return this.polje;
    }

    public void setPolje(Dugme polje) {
        this.polje = polje;
    }

}
