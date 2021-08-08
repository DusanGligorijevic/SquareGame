package controller.jButtons;

import view.StartFrame;
import view.VsFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_Vs implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.contentEquals("Vs")) {
            StartFrame.getInstance().setVisible(false);
            VsFrame.getInstance().setVisible(true);
        }
    }
}
