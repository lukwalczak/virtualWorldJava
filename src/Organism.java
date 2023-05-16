abstract public class Organism {
    protected int strength, initiative, posX, posY, age, breedCooldown;
    protected char organismChar;
    protected String fullOrganismName;
    protected World world;

    final int breedCooldownTime = 10;

    public Organism(int strength, int initiative, int posX, int posY, char organismChar, String fullOrganismName, World world){
        this.strength = strength;
        this.initiative = initiative;
        this.posX = posX;
        this.posY = posY;
        this.age = 0;
        this.breedCooldown = 0;
        this.organismChar = organismChar;
        this.fullOrganismName = fullOrganismName;
        this.world = world;
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

    public char getOrganismChar() {
        return organismChar;
    }

    public String getFullOrganismName() {
        return fullOrganismName;
    }

    public World getWorld() {
        return world;
    }

    public void setBreedCooldown(int breedCooldown) {
        this.breedCooldown = this.breedCooldownTime;
    }

    boolean collision(Organism collidingOrganism){

        return false;
    }
    abstract void action();

    void draw(){

    }

    boolean checkMove(int dx, int dy){

        return false;
    }

    boolean checkAdjacentFreeSpaces(){
        return true;
    }



}
