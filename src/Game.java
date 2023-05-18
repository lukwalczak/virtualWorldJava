final public class Game {
    private int currentTurn;
    private boolean nextTurn;
    private boolean continueGame;
    private int worldWidth;
    private int worldHeight;
    private Board board;
    private boolean playerTurn;

    public Game(Board board) {
        this.continueGame = true;
        this.currentTurn = 1;
        this.worldWidth = 20;
        this.worldHeight = 20;
        this.board = board;
        this.playerTurn = false;
    }

    public void drawInterface() {

    }

    public void drawLogs() {

    }

    public void saveGame() {
    }

    public void loadGame() {
    }

    public void menu() {

    }

    public void startGame() {
        
        System.out.println("This is a message printed to the console.");
        //}

    }

    public void drawMenu(int cursorPosition) {
    }

    public void drawSettings() {
    }

    public void drawMapBorders() {
    }

    public void drawEndGame() {
    }

    public void settings() {
    }

    public void printSettings() {
    }

}
