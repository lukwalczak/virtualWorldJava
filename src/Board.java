import javax.swing.*;
import java.awt.*;
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
    private JPanel utility;

    private int currentTurn;
    private int worldWidth;
    private int worldHeight;
    private Vector<String> logsVector;
    private Vector<Organism> organismsVector;
    private Human human;

    public Board(int turn, int width, int height) {
        int buttonSize = 30;
        boardPanel = new JPanel();
        board = new JPanel(new GridLayout(height, width));
        utility = new JPanel(new GridLayout(5, 1));
        boardPanel.add(board, BorderLayout.CENTER);
        boardPanel.add(utility, BorderLayout.EAST);
        JScrollPane scrollPane = new JScrollPane(board);
        boardPanel.add(scrollPane, BorderLayout.CENTER);

        logs = new JTextArea();
        logs.setPreferredSize(new Dimension(100, 300));
        logs.setEditable(false);
        saveButton = new JButton("Save");
        exitButton = new JButton("Exit");
        useAbility = new JButton("Use Ability");
        nextTurn = new JButton("Next Turn");

        utility.add(saveButton, BorderLayout.NORTH);
        utility.add(exitButton, BorderLayout.SOUTH);
        utility.add(useAbility, BorderLayout.EAST);
        utility.add(nextTurn, BorderLayout.WEST);
        utility.add(logs, BorderLayout.CENTER);
        for (int i = 0; i < height * width; i++) {
            JButton o = new JButton("");
            o.setPreferredSize(new Dimension(buttonSize, buttonSize));
            o.setMargin(new Insets(0, 0, 0, 0));
            this.board.add(o, BorderLayout.CENTER);
        }

        int boardWidth = (int) (width * buttonSize * 0.75);
        int utilityWidth = (int) (height * buttonSize * 0.25);

        board.setPreferredSize(new Dimension(boardWidth, height * buttonSize));
        utility.setPreferredSize(new Dimension(utilityWidth, height * buttonSize));

        this.setContentPane(boardPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setVisible(true);

        logsVector = new Vector<>();
        organismsVector = new Vector<>();
        human = new Human(Board.this);
        organismsVector.add(human);

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

    void draw() {
        for (Organism o : organismsVector) {
            o.draw();
        }
    }
}
