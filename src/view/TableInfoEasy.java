package view;

import pictures.ImageResizer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TableInfoEasy extends JFrame {
    private JButton b;
    JLabel l;
    private static TableInfoEasy instance;

    public static TableInfoEasy getInstance() {
        if (instance == null) {
            instance = new TableInfoEasy();
            instance.game();
        }

        return instance;
    }

    private TableInfoEasy() {
    }

    public void game() {
        this.setTitle("Computer's table");
        this.setSize(new Dimension(250, 250));
        this.setLayout(new FlowLayout());
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
        this.b = new JButton("Computer moves");
        this.add(this.b);
        this.l = new JLabel();
        this.add(this.l);
    }

    public JButton getB() {
        return this.b;
    }

    public void setB(JButton b) {
        this.b = b;
    }

    public JLabel getL() {
        return this.l;
    }

    public void setL(JLabel l) {
        this.l = l;
    }

    public static void setInstance(TableInfoEasy instance) {
        TableInfoEasy.instance = instance;
    }

}
