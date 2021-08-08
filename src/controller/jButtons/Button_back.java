package controller.jButtons;

import view.ChooseFrame;
import view.StartFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_back implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.contentEquals("Back")) {
            ChooseFrame.getInstance().setVisible(false);
            StartFrame.getInstance().setVisible(true);
        }
    }
}
