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
        int width = Integer.parseInt(widthText.getText());
        int height = Integer.parseInt(heightText.getText());
        int bWidth = Integer.parseInt(boardWidthSettings.getText());
        int bHeight = Integer.parseInt(boardHeightSettings.getText());
        if (bHeight <= 0 || bWidth <= 0 || height <= 0 || width <= 0)
            return;
        menu.setSize(width, height);
        menu.setGameSize(bHeight, bWidth);
    }
}
