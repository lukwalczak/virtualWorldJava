abstract public class Organism {
    protected int strength, initiative, posX, posY, age, breedCooldown;
    protected String organismChar;
    protected String fullOrganismName;
    protected Board board;

    final int breedCooldownTime = 10;

    public Organism(int strength, int initiative, int posX, int posY, String organismChar, String fullOrganismName, Board board) {
        this.strength = strength;
        this.initiative = initiative;
        this.posX = posX;
        this.posY = posY;
        this.age = 0;
        this.breedCooldown = 0;
        this.organismChar = organismChar;
        this.fullOrganismName = fullOrganismName;
        this.board = board;
    }

    public int getStrength() {
        return strength;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getAge() {
        return age;
    }

    public int getBreedCooldown() {
        return breedCooldown;
    }

    public String getOrganismChar() {
        return organismChar;
    }

    public String getFullOrganismName() {
        return fullOrganismName;
    }

    public Board getWorld() {
        return board;
    }

    public void setBreedCooldown(int breedCooldown) {
        this.breedCooldown = this.breedCooldownTime;
    }

    boolean collision(Organism collidingOrganism) {

        return false;
    }

    abstract void action();

    void draw() {
        this.board.getBoardButtons()[posY][posX].setText(this.organismChar);
    }

    boolean checkMove(int dx, int dy) {

        return false;
    }

    boolean checkAdjacentFreeSpaces() {
        return true;
    }
}
