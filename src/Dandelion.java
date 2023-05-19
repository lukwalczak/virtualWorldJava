public class Dandelion extends Plant {
    public Dandelion(int strength, int posX, int posY, String organismChar, String fullOrganismName, Board board) {
        super(strength, 0, posX, posY, organismChar, fullOrganismName, board);
    }

    @Override
    void action() {
        for (int i = 0; i < 3; i++) {
            super.action();
        }
    }
}
