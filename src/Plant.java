public class Plant extends Organism {
    public Plant(int strength, int initiative, int posX, int posY, String organismChar, String fullOrganismName, Board board) {
        super(strength, initiative, posX, posY, organismChar, fullOrganismName, board);
    }

    @Override
    void action() {
        int breedChance = (int) (Math.random() * 20);
        if (breedChance == 0) {
            for (int i = -1; i <= 1; i++) {
                if (this.board.getOrganismAtXY(this.posX + i, this.posY) == null && this.checkMove(i, 0)) {
                    Organism o = OrganismFactory.createOrganism(this.fullOrganismName, this.posX + i, posY, this.board);
                    this.board.addOrganism(o);
                    return;
                }
                if (this.board.getOrganismAtXY(this.posX, this.posY + i) == null && this.checkMove(0, i)) {
                    Organism o = OrganismFactory.createOrganism(this.fullOrganismName, this.posX, posY + i, this.board);
                    this.board.addOrganism(o);
                    return;
                }
            }
        }
    }


}
