package controller.jButtons;

import view.ChooseFrame;
import view.VsFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_PlayGame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.contentEquals("2Players")) {
            VsFrame.getInstance().setVisible(false);
            ChooseFrame.getInstance().setVisible(true);
        }
    }
}
