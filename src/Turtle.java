public class Turtle extends Animal {
    public Turtle(int strength, int initiative, int posX, int posY, String organismChar, String fullOrganismName, Board board) {
        super(strength, initiative, posX, posY, organismChar, fullOrganismName, board);
    }

    @Override
    void action() {
        int r = (int) (Math.random() * 4);
        if (r == 0) {
            super.action();
            return;
        }
        this.age++;
    }

    @Override
    public boolean didReflect(Organism collidingOrganism) {
        if (collidingOrganism.getStrength() >= 5)
            return false;
        this.addReflectionLog(collidingOrganism);
        return true;
    }
}
