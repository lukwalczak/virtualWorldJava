import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame{
    private JTextField widthText;
    private JTextField heightText;
    private JButton applyButton;
    private JPanel settingsPanel;
    private Menu menu;

    public Settings(Menu menu){
        this.setContentPane(settingsPanel);
        this.setVisible(true);
        this.setSize(450,300);
        this.menu = menu;
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSettings();
                Settings.this.dispose();
            }
        });
    }

    private void changeSettings(){
        int width = Integer.parseInt(widthText.getText());
        int height = Integer.parseInt(heightText.getText());
        menu.setSize(width,height);
    }
}
