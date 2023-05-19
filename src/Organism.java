import java.io.Serializable;

abstract public class Organism implements Comparable<Organism>, Serializable {
    final int breedCooldownTime = 10;
    protected int strength, initiative, posX, posY, age, breedCooldown;
    final protected String organismChar;
    final protected String fullOrganismName;
    protected Board board;

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

    @Override
    public int compareTo(Organism other) {
        if (this.initiative > other.getInitiative()) {
            return -1;
        } else if (this.initiative < other.getInitiative()) {
            return 1;
        } else if (this.age >= other.getAge()) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return this.fullOrganismName + " (" + this.initiative + ")";
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

    public void setBreedCooldown(int breedCooldown) {
        this.breedCooldown = this.breedCooldownTime;
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

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean collision(Organism collidingOrganism) {

        return false;
    }

    abstract void action();

    void draw() {
        this.board.getBoardButtons()[posY][posX].setText(this.organismChar);
    }

    boolean checkMove(int dx, int dy) {
        if (this.board.getOrganismAtXY(dx, dy) == null && (((this.posY + dy) >= 0) && (this.posY < this.board.getWorldHeight() - 1)) && (this.posX + dx >= 0 && this.posX < this.board.getWorldWidth() - 1))
            return true;
        return false;
    }

    boolean checkAdjacentFreeSpaces() {
        return true;
    }

}
