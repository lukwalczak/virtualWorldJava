public class OrganismFactory {
    public static Organism createOrganism(String name, int randX, int randY, Board board) {
        Organism o = null;
        if (name.equals("WOLF")) {
            o = new Wolf(9, 5, randX, randY, "W", "WOLF", board);
        }

        if (name.equals("SHEEP")) {
            o = new Sheep(4, 4, randX, randY, "S", "SHEEP", board);
        }

        if (name.equals("HUMAN")) {
            o = new Human(board);
        }

        if (name.equals("ANTELOPE")) {
            o = new Antelope(4, 5, randX, randY, "A", "ANTELOPE", board);
        }

        if (name.equals("TURTLE")) {
            o = new Turtle(2, 1, randX, randY, "T", "TURTLE", board);
        }

        if (name.equals("FOX")) {
            o = new Fox(3, 7, randX, randY, "F", "FOX", board);
        }

        if (name.equals("GRASS")) {
            o = new Grass(0, randX, randY, ".", "GRASS", board);
        }

        if (name.equals("NIGHTSHADE")) {
            o = new Nightshade(99, randX, randY, "N", "NIGHTSHADE", board);
        }

        if (name.equals("PINEBORSCH")) {
            o = new Pineborsch(10, randX, randY, "P", "PINEBORSCH", board);
        }

        if (name.equals("GUARANA")) {
            o = new Guarana(0, randX, randY, "G", "GUARANA", board);
        }

        if (name.equals("DANDELION")) {
            o = new Dandelion(0, randX, randY, "D", "DANDELION", board);
        }
        return o;

    }
}
