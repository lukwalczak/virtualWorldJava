import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Vector;

public class Menu extends JFrame {
    private JButton newGameButton;
    private JButton exitButton;
    private JButton optionsButton;
    private JButton loadGameButton;
    private JPanel mainPanel;
    private int gameWidth;
    private int gameHeight;

    public Menu(int width, int height) {
        this.setContentPane(mainPanel);
        this.setTitle("Łukasz Walczak 193530");
        this.setSize(width, height);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gameWidth = 20;
        this.gameHeight = 20;
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.this.setVisible(false);
                int game = startGame();
            }
        });
        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.this.loadGame();
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

    private int startGame(int turn, int width, int height, Vector<SaveOrganism> savedOrganisms) {
        Board board = new Board(turn, width, height, this, savedOrganisms);
        return 0;
    }

    private int startGame() {
        Board board = new Board(0, this.gameWidth, this.gameHeight, this);
        return 0;
    }

    public void setGameSize(int height, int width) {
        if (height > 0) {
            this.gameHeight = height;
        }
        if (width > 0) {
            this.gameWidth = width;
        }
    }

    private void loadGame() {
        String filePath = "saveFile";
        Vector<SaveOrganism> saveOrganisms = null;
        int worldWidth, worldHeight, currentTurn;
        Vector<String> logsVector = null;
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            currentTurn = (int) objectIn.readObject();
            worldWidth = (int) objectIn.readObject();
            worldHeight = (int) objectIn.readObject();
            saveOrganisms = (Vector<SaveOrganism>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("This is written to the file successfully.");
            this.startGame(currentTurn, worldWidth, worldHeight, saveOrganisms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
