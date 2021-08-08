package view;

import controller.jButtons.Button_back;
import controller.Game;

import javax.swing.*;
import java.awt.*;

public class ChooseFrame extends JFrame {
    JLabel player1;
    JLabel ColorPlayer1;
    JLabel ColorPlayer2;
    JLabel naPotezu;
    static Boolean computer = false;
    static Boolean computerHard = false;
    static JLabel player2;
    static JTextField player1name;
    static JTextField player2name;
    static JColorChooser Color1;
    static JColorChooser Color2;
    JButton playGame;
    JButton back;
    JPanel panel1;
    JPanel panel2;
    private static ChooseFrame instance;

    public static ChooseFrame getInstance() {
        if (instance == null) {
            instance = new ChooseFrame();
            instance.frame();
        }

        return instance;
    }

    private ChooseFrame() {
    }

    public void frame() {
        this.setTitle("Square");
        this.setSize(1050, 800);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.WHITE);
        this.setLayout(new GridLayout(1, 2));

        this.panel1 = new JPanel();
        FlowLayout flow1 = new FlowLayout(1, 20, 40);
        this.panel1.setLayout(flow1);

        this.player1 = new JLabel("Name of player 1: ");
        player1name = new JTextField();
        player1name.setBackground(Color.LIGHT_GRAY);
        player1name.setPreferredSize(new Dimension(250, 20));

        this.ColorPlayer1 = new JLabel("Choose your color: ");
        Color1 = new JColorChooser();
        Color1.setColor(Color.RED);
        Color1.setPreferredSize(new Dimension(500, 500));

        this.panel1.add(this.player1);
        this.panel1.add(player1name);
        this.panel1.add(this.ColorPlayer1);
        this.panel1.add(Color1);

        this.back = new JButton("Back");
        back.setBackground(Color.WHITE);
        this.back.addActionListener(new Button_back());
        this.back.setActionCommand("Back");

        this.panel1.add(this.back);
        panel1.setBackground(Color.WHITE);
        this.add(this.panel1);
        this.panel2 = new JPanel();
        FlowLayout flow2 = new FlowLayout(1, 20, 40);
        this.panel2.setLayout(flow2);

        player2 = new JLabel("Name of player 2: ");
        player2name = new JTextField();
        player2name.setBackground(Color.LIGHT_GRAY);
        player2name.setPreferredSize(new Dimension(250, 20));
        this.ColorPlayer2 = new JLabel("Choose your color: ");
        this.ColorPlayer2.setBackground(Color.RED);
        Color2 = new JColorChooser();
        Color2.setColor(Color.BLUE);
        Color2.setPreferredSize(new Dimension(500, 500));

        this.panel2.add(player2);
        this.panel2.add(player2name);
        this.panel2.add(this.ColorPlayer2);
        this.panel2.add(Color2);

        this.playGame = new JButton("PlayGame");
        playGame.setBackground(Color.WHITE);
        this.panel2.add(this.playGame);
        panel2.setBackground(Color.WHITE);
        this.playGame.addActionListener(new Game());
        this.playGame.setActionCommand("PlayGame");
        this.add(this.panel2);
    }

    public JLabel getPlayer2() {
        return player2;
    }

    public static String getPlayer1name() {
        return player1name.getText();
    }

    public static String getPlayer2name() {
        return player2name.getText();
    }

    public static Color getColor1() {
        return Color1.getColor();
    }

    public static Color getColor2() {
        return Color2.getColor();
    }

    public final void setVisible() {
        this.setVisible(false);
    }

    public static Boolean getComputer() {
        return computer;
    }

    public static void setComputer(Boolean computer) {
        ChooseFrame.computer = computer;
    }

    public static Boolean getComputerHard() {
        return computerHard;
    }

    public static void setComputerHard(Boolean computerHard) {
        ChooseFrame.computerHard = computerHard;
    }

}
