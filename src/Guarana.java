public class Guarana extends Plant {
    public Guarana(int strength, int posX, int posY, String organismChar, String fullOrganismName, Board board) {
        super(strength, 0, posX, posY, organismChar, fullOrganismName, board);
    }

    @Override
    public boolean collision(Organism collidingOrganism) {
        if (collidingOrganism instanceof Animal) {
            ((Animal) collidingOrganism).increaseStrenght();
        }
        return false;
    }
}
