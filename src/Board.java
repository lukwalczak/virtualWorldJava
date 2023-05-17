import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Board extends JFrame {
    private JPanel boardPanel;
    private JButton saveButton;
    private JButton exitButton;
    private JButton useAbility;
    private JButton nextTurn;
    private JTextArea logs;
    private JPanel board;
    private int currentTurn;
    private int worldWidth;
    private int worldHeight;
    private Vector<String> logsVector;
    private Vector<Organism> organismsVector;
    private Human human;

    public Board(int turn, int width, int height) {
        this.setContentPane(boardPanel);
        this.setSize(1200, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.logsVector = new Vector<String>();
        this.organismsVector = new Vector<Organism>();
        this.human = new Human(Board.this);
        organismsVector.add(this.human);
        nextTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        useAbility.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
