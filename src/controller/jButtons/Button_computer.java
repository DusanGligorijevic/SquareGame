package controller.jButtons;

import view.Tezina;
import view.VsFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_computer implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.contentEquals("1Player")) {
            VsFrame.getInstance().setVisible(false);
            Tezina.getInstance().setVisible(true);
        }
    }
}
