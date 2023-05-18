public class Human extends Animal {
    private static final int initialStrenght = 5;
    private final int initialInitiative = 5;
    private final int initialposX = 5;
    private final int initialposY = 5;
    private final String initialOrganismChar = "H";
    private final String initialOrganismFullName = "Human";
    private boolean alive;

    public Human(Board board) {
        super(5, 5, 5, 5, "H", "Human", board);
        this.alive = true;
    }

    public boolean getAlive() {
        return this.alive;
    }
}
