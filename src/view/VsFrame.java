package view;

import controller.jButtons.Button_computer;
import controller.jButtons.Button_PlayGame;
import pictures.ImageResizer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class VsFrame extends JFrame {
    private static VsFrame instance;
    JButton vsComputer, vsPlayer;

    public static VsFrame getInstance() {
        if (instance == null) {
            instance = new VsFrame();
            instance.start();
        }

        return instance;
    }

    public VsFrame() {
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
        this.vsComputer = new JButton("1 Player");
        this.vsComputer.addActionListener(new Button_computer());
        this.vsComputer.setActionCommand("1Player");


        this.vsPlayer = new JButton("2 Players");
        this.vsPlayer.addActionListener(new Button_PlayGame());
        this.vsPlayer.setActionCommand("2Players");

        vsComputer.setBackground(Color.WHITE);
        vsPlayer.setBackground(Color.WHITE);
        vsComputer.setPreferredSize(vsPlayer.getPreferredSize());
        this.add(this.vsComputer, layout);
        this.add(this.vsPlayer, layout);
    }
}
