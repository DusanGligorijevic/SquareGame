package controller.jButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_exit implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.contentEquals("Exit")) {
            System.exit(0);
        }
    }
}
