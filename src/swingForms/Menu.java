package swingForms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JButton newGameButton;
    private JButton exitButton;
    private JButton optionsButton;
    private JButton loadGameButton;
    private JPanel mainPanel;
    public Menu(int width, int height) {
        this.setContentPane(mainPanel);
        this.setTitle("Łukasz Walczak 193530");
        this.setSize(width, height);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    newGameButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Menu.this.setVisible(false);

        }
    });
    loadGameButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    optionsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Settings settings = new Settings(Menu.this);

        }
    });
    exitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Menu.super.dispose();
        }
    });
}
}
