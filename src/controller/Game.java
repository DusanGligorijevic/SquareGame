package controller;

import view.ChooseFrame;
import view.GameFrame;
import view.TableInfoEasy;
import view.TableInfoFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {
    public Game() {
    }

    public void actionPerformed(ActionEvent arg0) {
        String action = arg0.getActionCommand();
        if (action.equals("PlayGame")) {
            ChooseFrame.getInstance();
            if (ChooseFrame.getPlayer1name().length() == 0) {
                JOptionPane.showMessageDialog((Component)null, "Name of player 1 is empty");
                return;
            }

            ChooseFrame.getInstance();
            if (ChooseFrame.getPlayer2name().length() == 0) {
                JOptionPane.showMessageDialog((Component)null, "Name of player 2 is empty");
                return;
            }

            GameFrame.getInstance().setVisible(true);
            TableInfoFrame.getInstance().setVisible(true);
            ChooseFrame.getInstance().setVisible(false);
            ChooseFrame.getInstance();
            if (ChooseFrame.getComputer()) {
                TableInfoEasy.getInstance().setVisible(true);
            }

            ChooseFrame.getInstance();
            if (ChooseFrame.getComputerHard()) {
                TableInfoEasy.getInstance().setVisible(true);
            }
        }

    }
}
