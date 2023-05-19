public class Antelope extends Animal {
    public Antelope(int strength, int initiative, int posX, int posY, String organismChar, String fullOrganismName, Board board) {
        super(strength, initiative, posX, posY, organismChar, fullOrganismName, board);
    }

    @Override
    public boolean didReflect(Organism collidingOrganism) {
        int r = (int) (Math.random() * 4);
        if (r == 0) {
            return false;
        }
        return true;
    }
}
