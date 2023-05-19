public class Pineborsch extends Plant {
    public Pineborsch(int strength, int posX, int posY, String organismChar, String fullOrganismName, Board board) {
        super(strength, 0, posX, posY, organismChar, fullOrganismName, board);
    }

    @Override
    public boolean collision(Organism collidingOrganism) {
        this.board.removeOrganism(collidingOrganism);
        this.board.removeOrganism(this);
        return false;
    }

    @Override
    void action() {
        for (int i = -1; i <= 1; i += 2) {
            Organism o = this.board.getOrganismAtXY(this.posX + i, this.posY);
            if (o != null) {
                this.board.removeOrganism(o);
            }
        }
        for (int i = -1; i <= 1; i += 2) {
            Organism o = this.board.getOrganismAtXY(this.posX, this.posY + i);
            if (o != null) {
                this.board.removeOrganism(o);
            }
        }
    }
}
