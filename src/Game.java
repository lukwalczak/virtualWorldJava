final public class Game {
    private World world;
    private int currentTurn;
    private boolean nextTurn;
    private boolean continueGame;
    private int worldWidth;
    private int worldHeight;

    public Game(){
        this.continueGame = true;
        this.currentTurn = 1;
        this.worldWidth = 20;
        this.worldHeight = 20;
        this.world = new World(this.currentTurn, this.worldWidth, this.worldHeight);
    }

    public void drawInterface(){

    }

    public void drawLogs(){

    }
    public void saveGame(){}
    public void loadGame(){}
    public void menu(){

    }
    public void drawMenu(int cursorPosition){}
    public void getPlayerMove(){}
    public void drawSettings(){}
    public void drawMapBorders(){}
    public void drawEndGame(){}
    public void settings(){}
    public void printSettings(){}

}
