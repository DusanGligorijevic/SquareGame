package view;

import controller.jButtons.Button_exit;
import controller.jButtons.Button_Vs;
import pictures.ImageResizer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class StartFrame extends JFrame {
    private static StartFrame instance;

    JButton play, exit;

    public static StartFrame getInstance() {
        if (instance == null) {
            instance = new StartFrame();
            instance.start();
        }

        return instance;
    }
    // singleton pattern
    private StartFrame() {

    }

    public void start() {
        this.setTitle("Square");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String inputImagePath = "src/pictures/square.png";
        String outputImagePath1 = "src/pictures/squarefixed.png";
        try {
            // resize to a fixed width (not proportional)
            int scaledWidth = this.getWidth();
            int scaledHeight = this.getHeight();
            ImageResizer.resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);

        } catch (IOException ex) {
            System.out.println("Error resizing the image.");
            ex.printStackTrace();
        }

        setContentPane(new JLabel(new ImageIcon("src/pictures/squarefixed.png")));
        GridBagConstraints layout = new GridBagConstraints();
        layout.gridwidth = 0;
        layout.fill = 3;
        this.setLayout(new GridBagLayout());
        layout.gridheight = -1;
        layout.ipadx = 50;
        layout.ipady = 10;
        layout.gridx = 50;

        this.play = new JButton("Play");
        this.exit = new JButton("Exit");

        play.setBackground(Color.WHITE);
        exit.setBackground(Color.WHITE);

        this.exit.addActionListener(new Button_exit());
        this.exit.setActionCommand("Exit");

        this.play.addActionListener(new Button_Vs());
        this.play.setActionCommand("Vs");

        add(this.play, layout);
        add(this.exit, layout);
    }

    public void setVisible() {
        this.setVisible(false);
    }
}
