public class Animal extends Organism {
    public Animal(int strength, int initiative, int posX, int posY, String organismChar, String fullOrganismName, Board board) {
        super(strength, initiative, posX, posY, organismChar, fullOrganismName, board);
    }

    @Override
    void action() {
        boolean moved = false;
        int dx = 0;
        int dy = 0;
        int returnCounter = 0;
        this.age++;
        if (!this.checkAdjacentFreeSpaces()) {
            return;
        }
        if (this.breedCooldown > 0) {
            this.breedCooldown--;
        }
        while (!moved) {

            int direction = (int) Math.round(Math.random());

            if (direction == 0 && (((this.posY - 1) >= 1) || (this.posY + 1 < this.board.getWorldHeight()))) {
                direction = (int) Math.round(Math.random());
                // 1 go up 0 go down
                if (direction == 0 && this.posY - 1 >= 1) {
                    dy--;
                    moved = true;
                } else if (direction == 1 && this.posY + 1 < this.board.getWorldHeight()) {
                    dy++;
                    moved = true;
                }
            }

            if (direction == 1 && (this.posX - 1 >= 1 || this.posX + 1 < this.board.getWorldWidth())) {
                //1 go left 0 go right
                direction = (int) Math.round(Math.random());
                if (direction == 1 && this.posX - 1 >= 1) {
                    dx--;
                    moved = true;
                } else if (direction == 0 && this.posX + 1 < this.board.getWorldWidth()) {
                    dx++;
                    moved = true;
                }

            }

            if (returnCounter == 4)
                return;
            returnCounter++;


        }

        Organism collidingOrganism = this.board.getOrganismAtXY(this.posX + dx, this.posY + dy);
        if (collidingOrganism == null) {
            this.move(dx, dy);
        } else if (this.collision(collidingOrganism)) {
            this.move(dx, dy);
        }
        return;
    }

    @Override
    public boolean collision(Organism collidingOrganism) {
        if (this.organismChar == collidingOrganism.organismChar) {
            if (this.breedCooldown == 0 && collidingOrganism.getBreedCooldown() == 0) {
                this.setBreedCooldown(10);
                collidingOrganism.setBreedCooldown(10);
                this.breed();
            }
            return false;
        }
        if (this.fight(collidingOrganism)) {
            return true;
        }
        return false;
    }

    public void breed() {
        for (int i = -1; i <= 1; i++) {
            if (this.checkMove(this.posX + i, this.posY)) {
                Organism o = OrganismFactory.createOrganism(this.getFullOrganismName(), this.posX + i, this.posY, this.board);
                o.setBreedCooldown(10);
                this.board.addOrganism(o);
                this.addBreedingLog();
                return;
            }
        }
        for (int i = -1; i <= 1; i++) {
            if (this.checkMove(this.posX, this.posY + i)) {
                Organism o = OrganismFactory.createOrganism(this.getFullOrganismName(), this.posX, this.posY + i, this.board);
                o.setBreedCooldown(10);
                this.board.addOrganism(o);
                this.addBreedingLog();
                return;
            }
        }
    }

    public boolean fight(Organism collidingOrganism) {
        if (this.strength >= collidingOrganism.getStrength()) {
            if (collidingOrganism instanceof Human) {
                if (((Human) collidingOrganism).getAbilityLastTime() > 0) {
                    this.addReflectionLog(collidingOrganism);
                    return false;
                }
            }
            if (collidingOrganism instanceof Animal && ((Animal) collidingOrganism).didReflect(this)) {
                return false;
            }
            if (collidingOrganism instanceof Plant) {
                collidingOrganism.collision(this);
            }
            this.addFightLog(collidingOrganism, true);
            this.board.removeOrganism(collidingOrganism);
            return true;
        } else {
            this.addFightLog(collidingOrganism, false);
            this.board.removeOrganism(this);
            return false;
        }
    }

    public void increaseStrenght() {
        this.strength += 3;
    }

    public boolean didReflect(Organism collidingOrganism) {
        return false;
    }

    public void move(int dx, int dy) {
        this.posX += dx;
        this.posY += dy;
        this.addMoveLog(dx, dy);
    }

    public void addMoveLog(int dx, int dy) {
        String log = this.fullOrganismName + "moved to " + (this.posX + dx) + "," + (this.posY + dy);
        this.board.addLog(log);
    }

    public void addFightLog(Organism collidingOrganism, boolean won) {
        String log;
        if (won) {
            log = this.fullOrganismName + "killed " + collidingOrganism.getFullOrganismName();
        } else {
            log = this.fullOrganismName + "was killed " + collidingOrganism.getFullOrganismName();
        }
        this.board.addLog(log);

    }

    public void addBreedingLog() {
        String log = "New " + this.getFullOrganismName() + "has been born";
        this.board.addLog(log);
    }

    public void addReflectionLog(Organism collidingOrganism) {
        String log = collidingOrganism.getFullOrganismName() + "reflected " + this.fullOrganismName + "attack";
        this.board.addLog(log);
    }
}
