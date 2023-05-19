import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    private JTextField widthText;
    private JTextField heightText;
    private JButton applyButton;
    private JPanel settingsPanel;
    private JTextField boardHeightSettings;
    private JTextField boardWidthSettings;
    private Menu menu;

    public Settings(Menu menu) {
        this.setContentPane(settingsPanel);
        this.setVisible(true);
        this.setSize(450, 300);
        this.menu = menu;
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSettings();
                Settings.this.dispose();
            }
        });
    }

    private void changeSettings() {
        int width, height, bHeight, bWidth;
        try {
            width = Integer.parseInt(widthText.getText());
        } catch (Exception e) {
            width = 800;
        }
        try {
            height = Integer.parseInt(heightText.getText());
        } catch (Exception e) {
            height = 1200;
        }
        try {
            bWidth = Integer.parseInt(boardWidthSettings.getText());
        } catch (Exception e) {
            bWidth = 20;
        }
        try {
            bHeight = Integer.parseInt(boardHeightSettings.getText());
        } catch (Exception e) {
            bHeight = 20;
        }
        menu.setSize(width, height);
        menu.setGameSize(bHeight, bWidth);
    }
}
