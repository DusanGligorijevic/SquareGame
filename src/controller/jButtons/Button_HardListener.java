package controller.jButtons;

import controller.levels.Hard;
import view.ChooseFrame;
import view.StartFrame;
import view.TableInfoEasy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_HardListener implements ActionListener {
    public Button_HardListener() {
    }

    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getActionCommand().equals("Hard")) {
            StartFrame.getInstance().setVisible(false);
            ChooseFrame.getInstance().setVisible(true);
            ChooseFrame.getInstance().getPlayer2().setText("Computer's name:");
            ChooseFrame.getInstance();
            ChooseFrame.setComputerHard(true);
            TableInfoEasy.getInstance().getB().addActionListener(new Hard());
            System.out.println("Ulazi u listener");
        }

    }
}
