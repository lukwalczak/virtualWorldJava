public class Human extends Animal {
    private static final int initialStrenght = 5;
    private final int initialInitiative = 5;
    private final int initialposX = 5;
    private final int initialposY = 5;
    private final String initialOrganismChar = "H";
    private final String initialOrganismFullName = "Human";
    private boolean alive;
    private int keycode;

    public Human(Board board) {
        super(5, 5, 5, 5, "H", "Human", board);
        this.alive = true;
    }

    public boolean getAlive() {
        return this.alive;
    }

    public void action(int dx, int dy) {
        this.posY += dy;
        this.posX += dx;
        System.out.println(this.posX);
        System.out.println(this.posY);
    }
}
