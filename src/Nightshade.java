public class Nightshade extends Plant {
    public Nightshade(int strength, int posX, int posY, String organismChar, String fullOrganismName, Board board) {
        super(strength, 0, posX, posY, organismChar, fullOrganismName, board);
    }

    @Override
    public boolean collision(Organism collidingOrganism) {
        this.board.removeOrganism(collidingOrganism);
        this.board.removeOrganism(this);
        return false;
    }
}
