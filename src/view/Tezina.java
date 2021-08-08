package view;

import controller.jButtons.Button_EasyListener;
import controller.jButtons.Button_HardListener;
import pictures.ImageResizer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Tezina extends JFrame {
    private static Tezina instance;
    JButton easy;
    JButton hard;

    public static Tezina getInstance() {
        if (instance == null) {
            instance = new Tezina();
            instance.start();
        }

        return instance;
    }

    private Tezina() {
    }

    public void start() {
        this.setSize(400, 400);
        this.setTitle("Square");
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
        this.easy = new JButton("Easy");
        this.easy.addActionListener(new Button_EasyListener());
        this.easy.setActionCommand("Easy");

        this.hard = new JButton("Hard");
        this.hard.addActionListener(new Button_HardListener());
        this.hard.setActionCommand("Hard");

        easy.setBackground(Color.WHITE);
        hard.setBackground(Color.WHITE);
        this.add(this.easy, layout);
        this.add(this.hard, layout);
    }
}
