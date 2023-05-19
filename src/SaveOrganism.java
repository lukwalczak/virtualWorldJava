import java.io.Serializable;

public class SaveOrganism implements Serializable {
    private int breedCooldownTime = 10;
    private int strength, initiative, posX, posY, age, breedCooldown;
    private String organismChar;
    private String fullOrganismName;

    public SaveOrganism(int strength, int initiative, int posX, int posY, int breedCooldown, String organismChar, String fullOrganismName) {
        this.strength = strength;
        this.initiative = initiative;
        this.posX = posX;
        this.posY = posY;
        this.breedCooldown = breedCooldown;
        this.organismChar = organismChar;
        this.fullOrganismName = fullOrganismName;
    }

    public int getBreedCooldownTime() {
        return breedCooldownTime;
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
}
