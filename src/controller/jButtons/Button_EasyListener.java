package controller.jButtons;

import controller.levels.Easy;
import view.ChooseFrame;
import view.StartFrame;
import view.TableInfoEasy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_EasyListener implements ActionListener {
    public Button_EasyListener() {
    }

    public void actionPerformed(ActionEvent arg0) {
        String action = arg0.getActionCommand();
        if (action.contains("Easy")) {
            StartFrame.getInstance().setVisible(false);
            ChooseFrame.getInstance().setVisible(true);
            ChooseFrame.getInstance().getPlayer2().setText("Computer's name:");
            ChooseFrame.getInstance();
            ChooseFrame.setComputer(true);
            TableInfoEasy.getInstance().getB().addActionListener(new Easy());
        }

    }
}
