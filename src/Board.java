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
    private JButton boardButtons[][];
    private JPanel utility;

    public int currentTurn = 1;
    private int worldWidth;
    private int worldHeight;
    private Vector<String> logsVector;
    private Vector<Organism> organismsVector;
    private Human human;
    private boolean continueGame = true;

    public JPanel getBoard() {
        return board;
    }

    public Board(int turn, int width, int height) {
        this.worldHeight = height;
        this.worldWidth = width;
        int buttonSize = 30;
        boardPanel = new JPanel();
        board = new JPanel(new GridLayout(height, width));
        utility = new JPanel(new GridLayout(5, 1));
        boardPanel.add(board, BorderLayout.CENTER);
        boardPanel.add(utility, BorderLayout.EAST);
        InputListener inputListener = new InputListener(this);
        board.addKeyListener(inputListener);
        this.setFocusable(true);
        JScrollPane scrollPane = new JScrollPane(board);
        boardPanel.add(scrollPane, BorderLayout.CENTER);
        this.boardButtons = new JButton[height][width];
        logs = new JTextArea();
        logs.setSize(new Dimension(100, 500));
        logs.setEditable(false);
        JScrollPane scroll = new JScrollPane();
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        logs.add(scroll);
        saveButton = new JButton("Save");
        saveButton.setPreferredSize(new Dimension(80, 40));
        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(80, 40));
        useAbility = new JButton("Use Ability");
        useAbility.setPreferredSize(new Dimension(80, 40));
        nextTurn = new JButton("Next Turn");
        nextTurn.setPreferredSize(new Dimension(80, 40));

        utility.add(saveButton, BorderLayout.NORTH);
        utility.add(exitButton, BorderLayout.SOUTH);
        utility.add(useAbility, BorderLayout.EAST);
        utility.add(nextTurn, BorderLayout.WEST);
        utility.add(logs, BorderLayout.CENTER);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                JButton o = new JButton("");
                this.boardButtons[i][j] = o;
                o.setPreferredSize(new Dimension(buttonSize, buttonSize));
                o.setMargin(new Insets(0, 0, 0, 0));
                o.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        board.requestFocusInWindow();
                    }
                });
                this.board.add(o, BorderLayout.CENTER);
            }
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
                board.requestFocusInWindow();
            }
        });
        useAbility.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.requestFocusInWindow();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.requestFocusInWindow();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.requestFocusInWindow();
            }
        });
        this.generateNewWorld();
        this.draw();
        this.board.requestFocusInWindow();
    }

    public void draw() {
        for (int y = 0; y < this.worldHeight; y++) {
            for (int x = 0; x < this.worldWidth; x++) {
                this.boardButtons[y][x].setText("");
            }
        }
        for (Organism o : organismsVector) {
            o.draw();
        }
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    public JButton[][] getBoardButtons() {
        return this.boardButtons;
    }

    public void turn() {
        for (Organism o : this.organismsVector) {
            if (!(o instanceof Human)) {
                if (o.getInitiative() <= this.human.getInitiative() || (o.getInitiative() == this.human.getInitiative() && o.getAge() <= this.human.getAge())) {
                    o.action();
                }
            }
        }
    }

    public void firstTurn() {
        for (Organism o : this.organismsVector) {
            if (!(o instanceof Human)) {
                if (o.getInitiative() > this.human.getInitiative() || (o.getInitiative() == this.human.getInitiative() && o.getAge() > this.human.getAge())) {
                    o.action();
                }
            }
        }
    }

    public void playerMove(int keyCode) {
        switch (keyCode) {
            case 40 -> human.action(0, 1);
            case 38 -> human.action(0, -1);
            case 37 -> human.action(-1, 0);
            case 39 -> human.action(1, 0);
            default -> {
            }
        }
    }

    public boolean isHumanAlive() {
        return human.getAlive();
    }

    public void clearWorld() {
        this.organismsVector.clear();
    }

    public void generateNewWorld() {
        this.clearWorld();
        this.human = new Human(this);
        this.organismsVector.add(this.human);
        this.generateOrganisms();
    }

    public void generateOrganism(String animalName) {
        int randX = (int) (Math.random() * this.worldWidth);
        int randY = (int) (Math.random() * this.worldHeight);
        while (this.getOrganismAtXY(randX, randY) != null) {
            randX = (int) (Math.random() * this.worldWidth);
            randY = (int) (Math.random() * this.worldHeight);
        }
        Organism o = OrganismFactory.createOrganism(animalName, randX, randY, this);
        this.addOrganism(o);
    }

    public void addOrganism(Organism o) {
        if (o != null) {
            this.organismsVector.add(o);
        }
    }

    public void removeOrganism(Organism o) {
        if (o != null) {
            this.organismsVector.remove(o);
        }
    }

    private void generateOrganisms() {
        for (int i = 0; i < 3; i++) {
            this.generateOrganism("WOLF");
        }
        for (int i = 0; i < 3; i++) {
            this.generateOrganism("ANTELOPE");
        }
        for (int i = 0; i < 3; i++) {
            this.generateOrganism("FOX");
        }
        for (int i = 0; i < 3; i++) {
            this.generateOrganism("SHEEP");
        }
        for (int i = 0; i < 3; i++) {
            this.generateOrganism("TURTLE");
        }
        for (int i = 0; i < 3; i++) {
            this.generateOrganism("GRASS");
        }
        for (int i = 0; i < 3; i++) {
            this.generateOrganism("DANDELION");
        }
        for (int i = 0; i < 3; i++) {
            this.generateOrganism("GUARANA");
        }
        for (int i = 0; i < 3; i++) {
            this.generateOrganism("NIGHTSHADE");
        }
        for (int i = 0; i < 3; i++) {
            this.generateOrganism("PINEBORSCH");
        }

    }

    public Organism getOrganismAtXY(int x, int y) {
        for (Organism o : this.organismsVector) {
            if (o.getPosX() == x && o.getPosY() == y) {
                return o;
            }
        }
        return null;
    }

    public void endTurn() {
        this.currentTurn += 1;
        this.requestFocusInWindow();
    }

    public void addLog(String log) {
        this.logs.setText(log + "\n" + logs.getText());
        this.logsVector.add(log);
    }
}
